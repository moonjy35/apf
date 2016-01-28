package com.moon.apf.Components.ScrollView;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.moon.apf.Components.BaseComponent;
import com.moon.apf.Components.DefaultComponentInterface;
import com.moon.apf.Components.ContainableComponentInterface;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseScrollComponent extends BaseComponent implements BaseScrollViewInterface, DefaultComponentInterface, ContainableComponentInterface {

    public ArrayList<DefaultComponentInterface> mViews = new ArrayList<>();

    public ScrollView mView;
    public ScrollView.LayoutParams mParams;

    public BaseScrollComponent(){ super(); }
    public BaseScrollComponent(Context activityContext){
        super(activityContext);
    }

    @Override
    public DefaultComponentInterface addView(DefaultComponentInterface view) {
        mViews.add(view);
        return this;
    }

    @Override
    public ScrollView getView() {
        mView = new ScrollView(_mActivityContext);
        mParams = new ScrollView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mView.setLayoutParams(mParams);
        mView.setBackgroundColor(Color.WHITE);

        if(!mViews.isEmpty()){
            Iterator<DefaultComponentInterface> pageViews = mViews.iterator();
            while(pageViews.hasNext()){
                View view = pageViews.next().getView();
                mView.addView(view);
            }
        }

        return mView;
    }
}
