package com.moon.apf.LayoutFactory;

import android.util.Log;
import android.view.View;

import com.moon.apf.Components.DefaultComponentInterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moon on 2016. 1. 28..
 */
public class LayoutFactory implements Serializable {

    private static final long serialVersionUID = 1209L;

    //TODO 임시 static
    public static ArrayList<ComponentNodeList> mComponentNodeList;

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

    public ArrayList<ComponentNodeList> getLayout(){
        return mComponentNodeList;
    }



    //TODO 임시 static
    //TODO 차후에 string id 로 레이아웃을 변경할 수 있게 바꿔야 함
    public static View getView(int index){

        View v = mComponentNodeList.get(index).getView();

//        View v = null;
//        Iterator<ComponentNodeList> iterator = mComponentNodeList.iterator();
//        while(iterator.hasNext()){
//            ComponentNodeList target = (ComponentNodeList) iterator.next();
//        }

        return v;
    }


    @Override
    public String toString() {
        Iterator<?> iterator = mComponentNodeList.iterator();

        while(iterator.hasNext()){
            ComponentNodeList target = (ComponentNodeList) iterator.next();
            target.getView();
            Log.d("LAYOUT FACTORY", target + "");
        }

        return super.toString();
    }
}
