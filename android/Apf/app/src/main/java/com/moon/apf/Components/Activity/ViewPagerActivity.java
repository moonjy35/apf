package com.moon.apf.Components.Activity;


import android.os.Bundle;
import com.moon.apf.Components.RelativeView.BaseRelativeComponent;
import com.moon.apf.Components.RelativeView.DefaultRelativeComponent;
import com.moon.apf.Components.Toolbar.BaseToolbar;
import com.moon.apf.Components.Toolbar.DefaultToolbar;
import com.moon.apf.Components.ViewPager.BaseComponentPager;
import com.moon.apf.Components.WebView.BaseWebViewComponent;

/**
 * Created by moon on 2016. 1. 26..
 */
public class ViewPagerActivity extends BaseActivity {

//    http://stackoverflow.com/questions/18710561/can-i-use-view-pager-with-views-not-with-fragments

    public BaseRelativeComponent mLayout;

    public BaseToolbar mToolbar;

    public BaseRelativeComponent mContent;

    public BaseComponentPager mBaseViewPager;

    //TODO 나중에 동적으로 추가하면 됨
    public BaseRelativeComponent mContent1;
    public BaseWebViewComponent mContentWebview1;
    public BaseRelativeComponent mContent2;
    public BaseWebViewComponent mContentWebview2;
    public BaseRelativeComponent mContent3;
    public BaseWebViewComponent mContentWebview3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLayout = new DefaultRelativeComponent(this);

        mToolbar = new DefaultToolbar(this, "뷰 페이저");

        mContent = new DefaultRelativeComponent(this);
        mContent.setBelow(mToolbar.getToolbarId());

        mBaseViewPager = new BaseComponentPager(this);

        mContent1 = new DefaultRelativeComponent(this);
        mContentWebview1 = new BaseWebViewComponent(this, "http://www.daum.net");

        mContent2 = new DefaultRelativeComponent(this);
        mContentWebview2 = new BaseWebViewComponent(this, "http://www.nate.com");

        mContent3 = new DefaultRelativeComponent(this);
        mContentWebview3 = new BaseWebViewComponent(this, "http://www.google.com");

        mBaseViewPager.addView(mContent1.addView(mContentWebview1));
        mBaseViewPager.addView(mContent2.addView(mContentWebview2));
        mBaseViewPager.addView(mContent3.addView(mContentWebview3));

        mLayout.addView(mToolbar);
        mLayout.addView(mContent.addView(mBaseViewPager));

        setContentView(mLayout.getView());
    }
}
