package com.moon.apf.LayoutFactory;

import android.util.Log;

import com.moon.apf.Components.DefaultComponentInterface;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moon on 2016. 1. 28..
 */
public class LayoutFactory {

    private ArrayList<ComponentNodeList> mComponentNodeList;

    public LayoutFactory(){
        mComponentNodeList = new ArrayList<ComponentNodeList>();
    }

    public void addContainableComponent(ComponentNodeList componentList){
        mComponentNodeList.add(componentList);
    }

    public void addChildableComponent(int index, DefaultComponentInterface component){
        ComponentNodeList componentNode = (ComponentNodeList) mComponentNodeList.get(index);
        componentNode.addChild(component);
    }

    @Override
    public String toString() {
        Iterator<?> iterator = mComponentNodeList.iterator();

        while(iterator.hasNext()){
            ComponentNodeList target = (ComponentNodeList) iterator.next();

            Log.d("LAYOUT FACTORY", target + "");
        }

        return super.toString();
    }
}
