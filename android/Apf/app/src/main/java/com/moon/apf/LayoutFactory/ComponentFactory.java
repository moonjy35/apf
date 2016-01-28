package com.moon.apf.LayoutFactory;

import android.util.Log;

import com.google.gson.JsonObject;
import com.moon.apf.Components.DefaultComponentInterface;
import com.moon.apf.Components.RelativeView.DefaultRelativeComponent;
import com.moon.apf.Components.Toolbar.DefaultToolbar;
import com.moon.apf.Components.WebView.DefaultWebViewComponent;

import java.util.ArrayList;

/**
 * Created by moon on 2016. 1. 27..
 */
public class ComponentFactory {

    public ComponentFactory(){}

    public DefaultComponentInterface get(JsonObject source){
        DefaultComponentInterface componentInterface = null;

        String component = source.get("component").getAsString();
        String type = source.get("type").getAsString();
        String title = source.get("title").getAsString();

        Log.d("COMPONENT SOURCE", component + "");
        Log.d("COMPONENT SOURCE", type + "");
        Log.d("COMPONENT SOURCE", title + "");

        //TODO 아래를 효과적으로 생성하려면?
        //리플렉션을 사용할 수 있도록 클래스명 등을 수정해볼 것

        if(component.equalsIgnoreCase("relativeLayout")){
            componentInterface = new DefaultRelativeComponent();
        }

        if(component.equalsIgnoreCase("toolbar")){
            componentInterface = new DefaultToolbar();
        }

        if(component.equalsIgnoreCase("webview")){
            componentInterface = new DefaultWebViewComponent(source.get("url").getAsString());
        }

//        01-28 01:50:22.477  20521-20534/com.moon.apf D/COMPONENT SOURCE﹕ relativeLayout
//        01-28 01:50:22.477  20521-20534/com.moon.apf D/COMPONENT SOURCE﹕ default
//        01-28 01:50:22.477  20521-20534/com.moon.apf D/COMPONENT SOURCE﹕ 레이아웃
//        01-28 01:50:22.477  20521-20534/com.moon.apf D/COMPONENT SOURCE﹕ toolbar
//        01-28 01:50:22.477  20521-20534/com.moon.apf D/COMPONENT SOURCE﹕ default
//        01-28 01:50:22.477  20521-20534/com.moon.apf D/COMPONENT SOURCE﹕ 툴바 타이틀
//        01-28 01:50:22.477  20521-20534/com.moon.apf D/COMPONENT SOURCE﹕ webview
//        01-28 01:50:22.477  20521-20534/com.moon.apf D/COMPONENT SOURCE﹕ default
//        01-28 01:50:22.477  20521-20534/com.moon.apf D/COMPONENT SOURCE﹕ 웹뷰 타이틀

        return componentInterface;
    }
}
