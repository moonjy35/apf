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

        return componentInterface;
    }
}
