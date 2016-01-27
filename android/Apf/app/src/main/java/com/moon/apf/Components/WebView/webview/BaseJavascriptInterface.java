package com.moon.apf.Components.WebView.webview;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.moon.apf.Components.Activity.IntentActivity;

/**
 * Created by moon on 2016. 1. 27..
 */
public class BaseJavascriptInterface {

    private Context mActicityContext;
    private WebView mWebview;

    public BaseJavascriptInterface(Context activityContext, WebView webview){
        mActicityContext = activityContext;
        mWebview = webview;
    }

    @JavascriptInterface
    public void test(){
        Log.d("FROM JS", "TEST SUCCESS");
    }

    @JavascriptInterface
    public void newActivity(String url, String title){
        Log.d("FROM JS", "TEST SUCCESS");

        Intent intent = new Intent(mActicityContext, IntentActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("title", title);

        mActicityContext.startActivity(intent);
    }
}
