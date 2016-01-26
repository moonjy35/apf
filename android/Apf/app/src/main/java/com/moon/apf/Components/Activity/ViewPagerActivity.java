package com.moon.apf.Components.Activity;


import android.os.Bundle;
import com.moon.apf.Components.RelativeView.BaseRelativeView;
import com.moon.apf.Components.RelativeView.DefaultRelativeView;
import com.moon.apf.Components.Toolbar.BaseToolbar;
import com.moon.apf.Components.Toolbar.DefaultToolbar;
import com.moon.apf.Components.ViewPager.BaseViewPager;
import com.moon.apf.Components.WebView.BaseWebView;

/**
 * Created by moon on 2016. 1. 26..
 */
public class ViewPagerActivity extends BaseActivity {

//    http://stackoverflow.com/questions/18710561/can-i-use-view-pager-with-views-not-with-fragments

    public BaseRelativeView mLayout;

    public BaseToolbar mToolbar;

    public BaseRelativeView mContent;

    public BaseViewPager mBaseViewPager;

    //TODO 나중에 동적으로 추가하면 됨
    public BaseRelativeView mContent1;
    public BaseWebView mContentWebview1;
    public BaseRelativeView mContent2;
    public BaseWebView mContentWebview2;
    public BaseRelativeView mContent3;
    public BaseWebView mContentWebview3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLayout = new DefaultRelativeView(this);

        mToolbar = new DefaultToolbar(this, "뷰 페이저");

        mContent = new DefaultRelativeView(this);
        mContent.setBelow(mToolbar.getToolbarId());

        mBaseViewPager = new BaseViewPager(this);

        mContent1 = new DefaultRelativeView(this);
        mContentWebview1 = new BaseWebView(this, "http://www.daum.net");

        mContent2 = new DefaultRelativeView(this);
        mContentWebview2 = new BaseWebView(this, "http://www.nate.com");

        mContent3 = new DefaultRelativeView(this);
        mContentWebview3 = new BaseWebView(this, "http://www.google.com");

        mBaseViewPager.addView(mContent1.addView(mContentWebview1));
        mBaseViewPager.addView(mContent2.addView(mContentWebview2));
        mBaseViewPager.addView(mContent3.addView(mContentWebview3));

        mLayout.addView(mToolbar);
        mLayout.addView(mContent.addView(mBaseViewPager));

        setContentView(mLayout.getView());
    }
}
