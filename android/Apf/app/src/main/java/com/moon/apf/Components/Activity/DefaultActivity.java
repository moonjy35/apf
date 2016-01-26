package com.moon.apf.Components.Activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.RelativeLayout;

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
        mToolbar = new DefaultToolbar(this);

        RelativeLayout mLayoutView = mLayout.getView();

        mToolbar.setAsToolbar();
        mToolbar.setTitle("yo!");

        mContent = new DefaultRelativeView(this);
        mContent.setBelow(mToolbar.getToolbarId());

        mWebview = new DefaultWebView(this, "http://www.naver.com");

        WebView webView = mWebview.getView();

        Toolbar mToolbarView = mToolbar.getView();

        RelativeLayout mContentView = mContent.getView();
        mContentView.addView(webView);

        mLayoutView.addView(mToolbarView);
        mLayoutView.addView(mContentView);

        setContentView(mLayoutView);
    }
}
