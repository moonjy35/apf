package com.moon.apf.Components.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.RelativeLayout;

import com.moon.apf.Components.RelativeView.BaseRelativeView;
import com.moon.apf.Components.RelativeView.DefaultRelativeView;
import com.moon.apf.Components.Toolbar.BaseToolbar;
import com.moon.apf.Components.Toolbar.DefaultToolbar;
import com.moon.apf.Components.ViewPager.BaseViewPager;
import com.moon.apf.Components.ViewPager.BaseViewPagerAdapter;
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
            public BaseRelativeView mContent1;
            public BaseWebView mContentWebview1;
            public BaseRelativeView mContent2;
            public BaseWebView mContentWebview2;

    public ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLayout = new DefaultRelativeView(this);

        RelativeLayout layout = mLayout.getView();

        mToolbar = new DefaultToolbar(this);
        mToolbar.setAsToolbar();
        mToolbar.setTitle("VIEW PAGER");
        Toolbar toolbar = mToolbar.getView();

        layout.addView(toolbar);

        mContent = new DefaultRelativeView(this);
        mContent.setBelow(mToolbar.getToolbarId());

        RelativeLayout pagerWrapper = mContent.getView();
        pagerWrapper.setBackgroundColor(Color.CYAN);

        mBaseViewPager = new BaseViewPager(this);

        mContent1 = new DefaultRelativeView(this);
        mContentWebview1 = new BaseWebView(this, "http://www.daum.net");
        RelativeLayout content1 = mContent1.getView();
        WebView contentWebview1 = mContentWebview1.getView();
        content1.addView(contentWebview1);

        mContent2 = new DefaultRelativeView(this);
        mContentWebview2 = new BaseWebView(this, "http://www.nate.com");
        RelativeLayout content2 = mContent2.getView();
        WebView contentWebview2 = mContentWebview2.getView();
        content2.addView(contentWebview2);

        mPager = mBaseViewPager.getView();
        mPager.addView(content1);
        mPager.addView(content2);
        mPager.setAdapter(new BaseViewPagerAdapter(mPager));

        pagerWrapper.addView(mPager);

        layout.addView(pagerWrapper);

        setContentView(layout);
    }

    //TODO 큐 addView 가 필요함

}
