package com.rain.zhihu_example.util;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.rain.zhihu_example.global.RainApplication;

import java.math.BigDecimal;

/**
 * Created by yangchunyu
 * on 2015/10/9.
 */
public class CommonUtil {
    /**
     * 在主线程执行任务
     * @param r 任务
     */
    public static void runOnUIThread(Runnable r){

        RainApplication.getHandler().post(r);
    }/**
     * 延时在主线程执行任务
     * @param r 任务
     */
    public static void runOnUIThreadDelayed(Runnable r,int delayed){
        RainApplication.getHandler().postDelayed(r,delayed);
    }

    /**
     * 获取resource资源文件
     * @return 资源
     */
    public static Resources getResources(){
        return RainApplication.getContext().getResources();
    }

    /**
     * 获取字符串资源
     * @param id 资源ID
     * @return 字符串
     */
    public static  String getString(int id){
        return getResources().getString(id);
    }

    /**
     * 获取Color资源
     * @param id 资源ID
     * @return 颜色
     */
    public static  int getColor(int id){
        return getResources().getColor(id);
    }

    /**
     * 获取字符数组
     * @param id 资源ID
     * @return 数组
     */
    public static String[] getStringArray(int id){
        return getResources().getStringArray(id);
    }

    /**
     * 获取Drawable资源
     * @param id 资源ID
     * @return 图片
     */
    public static Drawable getDrawable(int id){
        return getResources().getDrawable(id);
    }

    /**
     * 获取dp资源
     * @param id 距离id
     * @return 距离资源
     */
    public static float getDimens(int id){
        return getResources().getDimension(id);
    }

    /**
     * 从父View移除当前View
     * @param child 子View
     */
    public static void removeChildFrameParent(View child){
        if(child !=null){
            ViewParent parent = child.getParent();
            if(parent!=null && parent instanceof ViewGroup){
                ViewGroup group = (ViewGroup) parent;
                group.removeView(child);
            }
        }
    }

    /**
     * 视频播放次数格式化
     */
    public static String formatVideoPlayCount(int playCount) {
        if (playCount > 999999) {
            double midCount = (double) playCount / 10000;
            float lastCount = getRoundFloat(midCount, 1);
            if(lastCount >= 1000){
                return  "1000万";
            }
            return lastCount + "万";
        } else {
            return playCount+"";
        }
    }
    /**
     * 将double类型的数字转换为四舍五入的float型数字
     *
     * @param value 要转换的数字
     * @param limit 要保留小数点的位数
     *
     * @return 格式化后的float型数字
     */
    public static Float getRoundFloat(double value, int limit) {
        // 此处初始化BigDecimal时,使用BigDecimal(String)方法,否则可能会出现精度丢失
        BigDecimal bd = new BigDecimal(String.valueOf(value));
        bd = bd.setScale(limit, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
}
