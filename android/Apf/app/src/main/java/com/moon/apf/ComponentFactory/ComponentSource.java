package com.moon.apf.ComponentFactory;

import android.util.Log;

import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Created by moon on 2016. 1. 27..
 */
public class ComponentSource {

    private JsonObject mSource;

    public ComponentSource(JsonObject source){
        mSource = source;
    }

    public void get(){
        String component = mSource.get("component").getAsString();
        String type = mSource.get("type").getAsString();
        String title = mSource.get("title").getAsString();

        Log.d("COMPONENT SOURCE", component + "");
        Log.d("COMPONENT SOURCE", type + "");
        Log.d("COMPONENT SOURCE", title + "");
    }
}
