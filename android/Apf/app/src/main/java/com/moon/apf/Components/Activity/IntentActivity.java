package com.moon.apf.Components.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.moon.apf.Components.RelativeView.BaseRelativeComponent;
import com.moon.apf.Components.RelativeView.DefaultRelativeComponent;
import com.moon.apf.Components.Toolbar.BaseToolbar;
import com.moon.apf.Components.Toolbar.DefaultToolbar;
import com.moon.apf.Components.WebView.BaseWebViewComponent;

/**
 * Created by moon on 2016. 1. 27..
 */
public class IntentActivity extends BaseActivity {

    private Intent mIntent;

    public BaseRelativeComponent mLayout;
    public BaseToolbar mToolbar;
    public BaseRelativeComponent mContent;
    public BaseWebViewComponent mWebview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mIntent = getIntent();

        String url = mIntent.getExtras().getString("url");
        String title = mIntent.getExtras().getString("title");

        
        mLayout = new DefaultRelativeComponent(this);
        mToolbar = new DefaultToolbar(this, title);
        mContent = new DefaultRelativeComponent(this);
        mContent.setBelow(mToolbar.getToolbarId());

        mWebview = new BaseWebViewComponent(this, url);

        mLayout.addView(mToolbar);
        mLayout.addView(mContent.addView(mWebview));

        _ContentLayout.addView(mLayout.getView());
    }
}
