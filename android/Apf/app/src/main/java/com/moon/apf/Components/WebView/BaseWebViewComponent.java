package com.moon.apf.Components.WebView;

import android.content.Context;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.moon.apf.Components.BaseComponent;
import com.moon.apf.Components.DefaultComponentInterface;
import com.moon.apf.Components.WebView.webview.BaseWebView;
import com.moon.apf.Components.WebView.webview.BaseWebViewClient;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseWebViewComponent extends BaseComponent implements BaseWebViewInterface, DefaultComponentInterface {

    public BaseWebView mWebView;
    public String mUrl;

    public BaseWebViewComponent(String url){
        mUrl = url;
    }
    public BaseWebViewComponent(Context activityContext, String url){
        super(activityContext);
        mUrl = url;
    }

    @Override
    public WebView getView() {
        mWebView = new BaseWebView(_mActivityContext);
        mWebView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mWebView.initWithDefaultOptions();
        mWebView.setWebViewClient(new BaseWebViewClient());
        mWebView.loadUrl(mUrl);

        return mWebView;
    }
}
