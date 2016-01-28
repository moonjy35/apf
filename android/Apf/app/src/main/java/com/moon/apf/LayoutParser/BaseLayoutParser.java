package com.moon.apf.LayoutParser;

import android.util.Log;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.moon.apf.Components.DefaultComponentInterface;
import com.moon.apf.LayoutFactory.ComponentFactory;
import com.moon.apf.LayoutFactory.LayoutFactory;

import java.util.Iterator;

/**
 * Created by moon on 2016. 1. 27..
 */
public class BaseLayoutParser implements BaseLayoutParserInterface {

    private String mSource;
    private LayoutFactory mLayoutFactory;
    private ComponentFactory mComponentFactory;

    public BaseLayoutParser(LayoutFactory layoutFactory, ComponentFactory componentFactory){
        mLayoutFactory = layoutFactory;
        mComponentFactory = componentFactory;
    }

    public BaseLayoutParserInterface setSource(String source) {
        mSource = source;
        return this;
    }

    @Override
    public void parse() {
        JsonArray json = new JsonParser().parse(mSource).getAsJsonArray();
        Log.d("MEMORIZER", json + "");

        for(int i = 0; i < json.size(); i++){
            JsonObject element = (JsonObject)json.get(i);

            String id = element.get("id").getAsString();
            int version = element.get("version").getAsInt();
            JsonArray layout = element.get("layout").getAsJsonArray();

            Log.d("MEMORIZER", id + "");
            Log.d("MEMORIZER", version + "");
            Log.d("MEMORIZER", layout + "");

            this.iterateLayout(layout);
        }
    }

    public void iterateLayout(JsonArray layout){

        for(int i = 0; i < layout.size(); i++){
            JsonObject ui = (JsonObject) layout.get(i);

            DefaultComponentInterface containable = this.parseComponent(ui);
            Log.d("COMPONENT", "CONTAINABLE : " + containable + "");

            if(ui.has("contains")){
                JsonArray child = ui.get("contains").getAsJsonArray();

                for(int j = 0; j < child.size(); j++){
                    DefaultComponentInterface chidable = this.parseComponent((JsonObject) layout.get(i));

                    Log.d("COMPONENT", "CHILDABLE : " + containable + "");
                }
            }
        }
    }

    public DefaultComponentInterface parseComponent(JsonObject componentJson){
        DefaultComponentInterface component = mComponentFactory.get(componentJson);
        return component;
    }
}
