package com.rain.zhihu_example.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * 外部调用setmScrollListener()即可
 * 可以监听滚动事件的WebView
 * Created by yangchunyu
 * 2016/2/5 10:06
 */
public class ScrollWebView extends WebView {
    public ScrollWebView(Context context) {
        super(context);
    }

    public ScrollWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mScrollListener != null) {
            mScrollListener.onScroll(l - oldl, t - oldt,oldl,oldt);
        }
    }

    /***********滚动监听**************/
    private OnScrollChangeListener mScrollListener;

    public void setOnScrollListener(OnScrollChangeListener mScrollListener) {
        this.mScrollListener = mScrollListener;
    }

    public interface OnScrollChangeListener {
        void onScroll(int dx, int dy,int oldLeft ,int oldTop);
    }
}