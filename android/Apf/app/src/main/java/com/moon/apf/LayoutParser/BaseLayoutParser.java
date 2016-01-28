package com.moon.apf.LayoutParser;

import android.util.Log;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.moon.apf.ApfApplication;
import com.moon.apf.Components.DefaultComponentInterface;
import com.moon.apf.LayoutFactory.ComponentFactory;
import com.moon.apf.LayoutFactory.ComponentNodeList;
import com.moon.apf.LayoutFactory.LayoutFactory;
import com.moon.apf.LayoutInflaters.BaseLayoutInflater;
import com.moon.apf.LayoutInflaters.SerializedLayout;

import java.util.ArrayList;

import io.realm.Realm;

/**
 * Created by moon on 2016. 1. 27..
 */
public class BaseLayoutParser implements BaseLayoutParserInterface {

    private String mSource;
    private ArrayList<ComponentNodeList> mLayoutComponentList;

    private LayoutFactory mLayoutFactory;
    private ComponentFactory mComponentFactory;

    public BaseLayoutParser(LayoutFactory layoutFactory, ComponentFactory componentFactory){
        mLayoutFactory = layoutFactory;
        mComponentFactory = componentFactory;
        mLayoutComponentList = new ArrayList<ComponentNodeList>();
    }

    public BaseLayoutParserInterface setSource(String source) {
        mSource = source;
        return this;
    }

    @Override
    public void parse() {

        //TODO 렐름에 넣었다 빼는 것을 테스트해보아야함
        JsonArray json = new JsonParser().parse(mSource).getAsJsonArray();
        Log.d("MEMORIZER", json + "");

        for (int i = 0; i < json.size(); i++) {
            JsonObject element = (JsonObject) json.get(i);

            String id = element.get("id").getAsString();
            int version = element.get("version").getAsInt();
            JsonArray layout = element.get("layout").getAsJsonArray();

            Log.d("MEMORIZER", id + "");
            Log.d("MEMORIZER", version + "");
            Log.d("MEMORIZER", layout + "");

            LayoutFactory parsedLayout = parseLayoutIterator(layout);

//            SerializedLayout serializedLayout = new SerializedLayout();
//            serializedLayout.setId(id);
//            serializedLayout.setVersion(version);
//            serializedLayout.setSerializedLayout(BaseLayoutInflater.convertToBytes(parsedLayout));
        }
    }

    public LayoutFactory parseLayoutIterator(JsonArray layout){

        for(int contianerIndex = 0; contianerIndex < layout.size(); contianerIndex++){
            JsonObject ui = (JsonObject) layout.get(contianerIndex);

            DefaultComponentInterface containable = this.parseComponent(ui);
            mLayoutFactory.addContainableComponent(new ComponentNodeList(containable));

            if(ui.has("contains")){
                JsonArray child = ui.get("contains").getAsJsonArray();

                for(int j = 0; j < child.size(); j++){
                    DefaultComponentInterface chidable = this.parseComponent((JsonObject) child.get(j));
                    mLayoutFactory.addChildableComponent(contianerIndex, chidable);
                }
            }
        }

        mLayoutFactory.toString();

        return mLayoutFactory;
    }

    public DefaultComponentInterface parseComponent(JsonObject componentJson){
        DefaultComponentInterface component = mComponentFactory.get(componentJson);
        return component;
    }
}
