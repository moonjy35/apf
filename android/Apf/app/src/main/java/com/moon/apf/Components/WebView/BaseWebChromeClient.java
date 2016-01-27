package com.moon.apf.Components.WebView;

import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;

/**
 * Created by moon on 2016. 1. 27..
 */
public class BaseWebChromeClient extends WebChromeClient {

    @Override
    public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
        callback.invoke(origin, true, false);
        super.onGeolocationPermissionsShowPrompt(origin, callback);
    }
}
