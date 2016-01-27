package com.moon.apf.Components.WebView.webview;

import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/**
 * Created by moon on 2016. 1. 27..
 */
public class BaseJavascriptInterface {

    private WebView mWebview;

    public BaseJavascriptInterface(WebView webview){
        mWebview = webview;
    }

    @JavascriptInterface
    public void test(){
        Log.d("FROM JS", "TEST SUCCESS");
    }
}
