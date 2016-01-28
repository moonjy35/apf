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

    private ContainableComponentInterface mContainableComponent;

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

//    @Override
//    public String toString() {
//
//        Log.d("NODE", "SELF : " + mComponent);
//
//        if(!mComponentList.isEmpty()){
//            Iterator<DefaultComponentInterface> iterator = mComponentList.iterator();
//            while(iterator.hasNext()){
//                Log.d("NODE", iterator.next() + "");
//            }
//        }
//
//        return super.toString();
//    }

    //TODO 이 부분은 컨테이너가 없을 수도 있음을 감안해서 다시 짜여야 할 수 있음
    //TODO 시리얼라이즈해서 사용할 수 있게 되어야함
    public View getView(){

        if(mComponent != null){
            mContainableComponent = (ContainableComponentInterface)mComponent;
            Log.d("PARENT COMPONENT", mComponent + "");
        }

        if(!mComponentList.isEmpty()){
            Iterator<DefaultComponentInterface> iterator = mComponentList.iterator();

            while(iterator.hasNext()){
                DefaultComponentInterface component = iterator.next();

                mContainableComponent.addView(component);

            }
        }

        mView = mContainableComponent.getView();

        Log.d("GET VIEW", mView + "");

        return mView;
    }
}
