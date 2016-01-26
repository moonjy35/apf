package com.moon.apf.Components.Activity;

import android.os.Bundle;

import com.moon.apf.Components.RelativeView.BaseRelativeView;
import com.moon.apf.Components.RelativeView.DefaultRelativeView;
import com.moon.apf.Components.Toolbar.BaseToolbar;
import com.moon.apf.Components.Toolbar.DefaultToolbar;
import com.moon.apf.Components.WebView.BaseWebView;
import com.moon.apf.Components.WebView.DefaultWebView;

/**
 * Created by moon on 2016. 1. 26..
 */
public class DefaultActivity extends BaseActivity {

    public BaseRelativeView mLayout;
    public BaseToolbar mToolbar;
    public BaseRelativeView mContent;
    public BaseWebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLayout = new DefaultRelativeView(this);

        mToolbar = new DefaultToolbar(this, "애드투페이퍼");

        mContent = new DefaultRelativeView(this);
        mContent.setBelow(mToolbar.getToolbarId());

        mWebview = new DefaultWebView(this, "http://www.naver.com");

        mLayout.addView(mToolbar);
        mLayout.addView(mContent.addView(mWebview));

        setContentView(mLayout.getView());
    }
}
