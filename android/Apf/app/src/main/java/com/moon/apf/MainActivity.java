package com.moon.apf;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.RelativeLayout;

import com.moon.apf.Activity.DefaultActivity;
import com.moon.apf.Ui.ContentView.DefaultContentView;
import com.moon.apf.Ui.Toolbar.DefaultToolbar;
import com.moon.apf.Ui.WebView.DefaultWebView;


public class MainActivity extends DefaultActivity {

    private RelativeLayout mLayout;
    private Toolbar mToolbar;
    private RelativeLayout mContent;
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLayout = new DefaultContentView(this).getView();

        DefaultToolbar defaultToolbar = new DefaultToolbar(this);
        defaultToolbar.setAsToolbar();
        defaultToolbar.setTitle("yo!");

        DefaultContentView defaultContentView = new DefaultContentView(this);
        defaultContentView.setBelow(defaultToolbar.getToolbarId());

        DefaultWebView webview = new DefaultWebView(this, "http://www.naver.com");
        mWebView = webview.getView();

        mToolbar = defaultToolbar.getView();
        mContent = defaultContentView.getView();
        mContent.addView(mWebView);

        mLayout.addView(mToolbar);
        mLayout.addView(mContent);

        setContentView(mLayout);
    }
}
