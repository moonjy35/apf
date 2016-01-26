package com.moon.apf.Activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.RelativeLayout;

import com.moon.apf.Ui.ContentView.BaseContentView;
import com.moon.apf.Ui.ContentView.DefaultContentView;
import com.moon.apf.Ui.Toolbar.BaseToolbar;
import com.moon.apf.Ui.Toolbar.DefaultToolbar;
import com.moon.apf.Ui.WebView.BaseWebView;
import com.moon.apf.Ui.WebView.DefaultWebView;

/**
 * Created by moon on 2016. 1. 26..
 */
public class DefaultActivity extends BaseActivity {
    public BaseContentView mLayout;
    public BaseToolbar mToolbar;
    public BaseContentView mContent;
    public BaseWebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLayout = new DefaultContentView(this);
        mToolbar = new DefaultToolbar(this);

        RelativeLayout mLayoutView = mLayout.getView();

        mToolbar.setAsToolbar();
        mToolbar.setTitle("yo!");

        mContent = new DefaultContentView(this);
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
