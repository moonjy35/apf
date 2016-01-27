package com.moon.apf.LayoutInflaters;

import android.content.Context;
import android.view.View;

import com.moon.apf.Components.DefaultComponentInterface;

/**
 * Created by moon on 2016. 1. 27..
 */
public class BaseLayoutInflater implements BaseLayoutInflaterInterface{

    public Context mActivityContext;

    public BaseLayoutInflater(Context activityContext){
        mActivityContext = activityContext;
    }

    @Override
    public DefaultComponentInterface getComponent() {
        return null;
    }
}
