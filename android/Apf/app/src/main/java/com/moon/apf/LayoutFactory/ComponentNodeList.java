package com.moon.apf.LayoutFactory;

import android.util.Log;
import android.view.View;

import com.moon.apf.Components.ContainableComponentInterface;
import com.moon.apf.Components.DefaultComponentInterface;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moon on 2016. 1. 28..
 */
public class ComponentNodeList {

    private View mView;

    private DefaultComponentInterface mComponent;
    private ArrayList<DefaultComponentInterface> mComponentList;

    public ComponentNodeList(DefaultComponentInterface component){
        mComponent = component;
    }

    public void addChild(DefaultComponentInterface component){
        if(mComponentList == null){
            mComponentList = new ArrayList<DefaultComponentInterface>();
        }

        mComponentList.add(component);
    }

    @Override
    public String toString() {

        Log.d("NODE", "SELF : " + mComponent);

        if(!mComponentList.isEmpty()){
            Iterator<DefaultComponentInterface> iterator = mComponentList.iterator();
            while(iterator.hasNext()){
                Log.d("NODE", iterator.next() + "");
            }
        }

        return super.toString();
    }

    public View getView(){
//        mView = mComponent.getView();

        if(!mComponentList.isEmpty()){
            Iterator<DefaultComponentInterface> iterator = mComponentList.iterator();

            while(iterator.hasNext()){
                DefaultComponentInterface component = iterator.next();
            }
        }




        return null;
    }
}
