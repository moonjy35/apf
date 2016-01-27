package com.moon.apf.Components.WebView.webview;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

/**
 * Created by moon on 2016. 1. 27..
 */
public class BaseWebView extends WebView{
    private Context mContext;

    public BaseWebView(Context context) {
        super(context);
        mContext = context;
    }

    public BaseWebView(Context context, AttributeSet attrs) { super(context, attrs); }
    public BaseWebView(Context context, AttributeSet attrs, int defStyleAttr) { super(context, attrs, defStyleAttr); }

    //TODO CHECK VERSION
    public BaseWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) { super(context, attrs, defStyleAttr, defStyleRes); }
    public BaseWebView(Context context, AttributeSet attrs, int defStyleAttr, boolean privateBrowsing) { super(context, attrs, defStyleAttr, privateBrowsing); }

    public void requestJS(String javascript){
        String selfExcutableJavascript = "javascript:" + "(function(){ try{ "  + javascript + "}catch(err){} })();";

        Log.d("BASE WEBVIEW", "### WEBVIEW REQUEST JAVASCRIPT : " + selfExcutableJavascript);
        this.loadUrl(selfExcutableJavascript);
    }

    public void blank(){
        this.loadUrl("about:blank");
    }

    public void setDebugMode(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

    public void setZoomMode(){
        this.getSettings().setSupportZoom(true);
        this.getSettings().setBuiltInZoomControls(true);

        this.getSettings().setLoadWithOverviewMode(true);
        this.getSettings().setUseWideViewPort(true);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            try{
                this.getSettings().setDisplayZoomControls(false);
            }catch(Exception e){ }
        }
    }

    public void hideScrollBar(){
        this.setHorizontalScrollBarEnabled(false);
        this.setVerticalScrollBarEnabled(false);
    }

    public void initWithDefaultOptions(){
        this.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        this.setWebChromeClient(new BaseWebChromeClient());
        this.getSettings().setJavaScriptEnabled(true);

        try{
            this.getSettings().setDomStorageEnabled(true);
        }catch (Exception e){

        }

        //mContext는 액티비티의 컨텍스트
        this.addJavascriptInterface(new BaseJavascriptInterface(mContext, this), "WebApp");
    }
}
