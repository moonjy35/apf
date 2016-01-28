package com.moon.apf.Components.WebView;

import android.content.Context;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.moon.apf.Components.DefaultComponentInterface;
import com.moon.apf.Components.WebView.webview.BaseWebView;
import com.moon.apf.Components.WebView.webview.BaseWebViewClient;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseWebViewComponent implements BaseWebViewInterface, DefaultComponentInterface {

    public Context mActivityContext;
    public BaseWebView mWebView;
    public String mUrl;

    public BaseWebViewComponent(){}
    public BaseWebViewComponent(String url){
        mUrl = url;
    }
    public BaseWebViewComponent(Context context, String url){
        mActivityContext = context;
        mUrl = url;

    }

    @Override
    public void setContext(Context context) {
        mActivityContext = context;
    }

    @Override
    public WebView getView() {
        mWebView = new BaseWebView(mActivityContext);
        mWebView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mWebView.initWithDefaultOptions();
        mWebView.setWebViewClient(new BaseWebViewClient());
        mWebView.loadUrl(mUrl);

        return mWebView;
    }
}
