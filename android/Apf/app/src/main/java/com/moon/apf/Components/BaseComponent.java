package com.moon.apf.Components;

import android.content.Context;

import com.moon.apf.ApfApplication;

/**
 * Created by moon on 2016. 1. 28..
 */
public class BaseComponent {

    public Context _mActivityContext;

    public BaseComponent(){
        _mActivityContext = ApfApplication._currentActivityContext;
    }
    public BaseComponent(Context activityContext){
        _mActivityContext = activityContext;
    }

    public void setContext(Context activityContext){
        _mActivityContext = activityContext;
    }
}
