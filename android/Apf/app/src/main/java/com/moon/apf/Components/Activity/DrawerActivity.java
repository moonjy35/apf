package com.moon.apf.Components.Activity;

import android.os.Bundle;

import com.moon.apf.Components.RelativeView.BaseRelativeComponent;
import com.moon.apf.Components.RelativeView.DefaultRelativeComponent;
import com.moon.apf.Components.Toolbar.BaseToolbar;
import com.moon.apf.Components.Toolbar.DefaultToolbar;
import com.moon.apf.Components.WebView.BaseWebComponent;
import com.moon.apf.Components.WebView.DefaultWebComponent;

/**
 * Created by moon on 2016. 1. 26..
 */
public class DrawerActivity extends BaseActivity{

    public BaseRelativeComponent mContentLayout;
    public BaseToolbar mToolbar;
    public BaseRelativeComponent mContent;
    public BaseWebComponent mWebview;

    public BaseRelativeComponent mMenuLayout;
    public BaseWebComponent mMenuWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContentLayout = new DefaultRelativeComponent(this);
        mToolbar = new DefaultToolbar(this, "애드투페이퍼");
        mContent = new DefaultRelativeComponent(this);
        mContent.setBelow(mToolbar.getToolbarId());
        mWebview = new DefaultWebComponent(this, "http://www.naver.com");

        mContentLayout.addView(mToolbar);
        mContentLayout.addView(mContent.addView(mWebview));

        _ContentLayout.addView(mContentLayout.getView());

        mMenuLayout = new DefaultRelativeComponent(this);
        mMenuWebview = new DefaultWebComponent(this, "http://www.google.com");

        _MenuLayout.addView(mMenuLayout.addView(mMenuWebview).getView());
    }
}
