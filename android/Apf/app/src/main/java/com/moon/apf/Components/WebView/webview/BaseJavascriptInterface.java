package com.moon.apf.Components.WebView.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.moon.apf.Components.Activity.IntentActivity;
import com.moon.apf.LayoutMemorizer.DefaultLayoutMemorizer;

import org.json.JSONObject;


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

    @JavascriptInterface
    public void memorizeLayout(final String jsonStringifiedLayout){
        ((Activity) mActicityContext).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new DefaultLayoutMemorizer().setSource(jsonStringifiedLayout).memorize();
            }
        });
    }
}
