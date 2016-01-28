package com.moon.apf.LayoutParser;

import android.content.Context;
import android.util.Log;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.moon.apf.ComponentFactory.ComponentSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

/**
 * Created by moon on 2016. 1. 27..
 */
public class BaseLayoutParser implements BaseLayoutParserInterface {

    private String mSource;

    public BaseLayoutParser(){

    }

    public BaseLayoutParserInterface setSource(String source) {
        mSource = source;
        return this;
    }

    @Override
    public void parse() {
        JsonArray json = new JsonParser().parse(mSource).getAsJsonArray();
        Log.d("MEMORIZER", json + "");

        //소스 순회
        Iterator<?> jsonIterator = json.iterator();
        while(jsonIterator.hasNext()){
            JsonObject element = (JsonObject) jsonIterator.next();

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
        //소스 - 레이아웃 순회
        Iterator<?> layoutIterator = layout.iterator();
        while(layoutIterator.hasNext()){
            JsonObject ui = (JsonObject) layoutIterator.next();

            this.parseComponent(ui);

            if(ui.has("contains")){
                JsonArray child = ui.get("contains").getAsJsonArray();

                Iterator<?> childIterator = child.iterator();
                while(childIterator.hasNext()){
                    this.parseComponent((JsonObject)childIterator.next());
                }
            }
        }
    }

    public void parseComponent(JsonObject componentJson){
        String component = componentJson.get("component").getAsString();
        String type = componentJson.get("type").getAsString();
        String title = componentJson.get("title").getAsString();

        new ComponentSource(componentJson).get();
    }
}
