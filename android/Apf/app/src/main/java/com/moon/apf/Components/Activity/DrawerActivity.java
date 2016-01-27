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

    public BaseRelativeComponent mMenuLayoutLeft;
    public BaseWebComponent mMenuWebviewLeft;

    public BaseRelativeComponent mMenuLayoutRight;
    public BaseWebComponent mMenuWebviewRight;

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

        mMenuLayoutLeft = new DefaultRelativeComponent(this);
        mMenuWebviewLeft = new DefaultWebComponent(this, "http://www.google.com");

        mMenuLayoutRight = new DefaultRelativeComponent(this);
        mMenuWebviewRight = new DefaultWebComponent(this, "http://www.nate.com");

        _ContentLayout.addView(mContentLayout.getView());
        _MenuLayoutLeft.addView(mMenuLayoutLeft.addView(mMenuWebviewLeft).getView());
        _MenuLayoutRight.addView(mMenuLayoutRight.addView(mMenuWebviewRight).getView());
    }
}
