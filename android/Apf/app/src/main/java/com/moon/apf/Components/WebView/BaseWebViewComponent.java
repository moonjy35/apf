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

    public Context mContext;
    public BaseWebView mWebView;
    public String mUrl;

    public BaseWebViewComponent(Context context, String url){
        mContext = context;
        mUrl = url;
        mWebView = new BaseWebView(mContext);
        mWebView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mWebView.initWithDefaultOptions();
        mWebView.setWebViewClient(new BaseWebViewClient());
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
