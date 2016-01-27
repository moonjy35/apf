package com.moon.apf.LayoutInflaters;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.moon.apf.Components.DefaultComponentInterface;
import com.moon.apf.Components.RelativeView.DefaultRelativeComponent;
import com.moon.apf.Components.Toolbar.DefaultToolbar;
import com.moon.apf.Components.WebView.BaseWebViewComponent;

/**
 * Created by moon on 2016. 1. 27..
 */
public class IntentLayoutInflater extends BaseLayoutInflater {

    private Intent mIntent;
    private DefaultComponentInterface mComponent;

    public IntentLayoutInflater(Context activityContext, Intent intent){
        super(activityContext);
        mIntent = intent;
    }

    public DefaultComponentInterface getComponent() {
        String url = mIntent.getExtras().getString("url");
        if(url == null) return null;

        //TODO
        if(url.equals("http://10.10.10.235:6871/test.html"))
        {
            DefaultRelativeComponent layout = new DefaultRelativeComponent(mActivityContext);
            DefaultToolbar toolbar = new DefaultToolbar(mActivityContext, "타이틀");
            DefaultRelativeComponent content = new DefaultRelativeComponent(mActivityContext);
            content.setBelow(toolbar.getToolbarId());

            BaseWebViewComponent webview = new BaseWebViewComponent(mActivityContext, url);

            layout.addView(toolbar);
            layout.addView(content.addView(webview));

            mComponent = layout;
        }

        return mComponent;
    }
}
