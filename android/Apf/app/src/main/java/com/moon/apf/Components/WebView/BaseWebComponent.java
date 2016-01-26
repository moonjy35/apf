package com.moon.apf.Components.WebView;

import android.content.Context;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.moon.apf.Components.DefaultComponentInterface;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseWebComponent implements BaseWebViewInterface, DefaultComponentInterface {

    public Context mContext;
    public WebView mWebView;
    public String mUrl;

    public BaseWebComponent(Context context, String url){
        mContext = context;
        mUrl = url;
        mWebView = new WebView(mContext);
        mWebView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mWebView.setWebViewClient(new WebViewClient());
    }

    public void loadUrl(String url){
        mWebView.loadUrl(url);
    }

    @Override
    public WebView getView() {
        this.loadUrl(mUrl);
        return mWebView;
    }
}
