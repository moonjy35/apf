package com.moon.apf.Components.WebView;

import android.content.Context;

/**
 * Created by moon on 2016. 1. 26..
 */
public class DefaultWebViewComponent extends BaseWebViewComponent {

    public DefaultWebViewComponent(String url){
        super(url);
    }
    public DefaultWebViewComponent(Context activityContext, String url){
        super(activityContext, url);
    }
}
