package com.moon.apf.Components.ScrollView;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.moon.apf.Components.DefaultComponentInterface;
import com.moon.apf.Components.HasChildableComponentInterface;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseScrollComponent implements BaseScrollViewInterface, DefaultComponentInterface, HasChildableComponentInterface {

    public Context mContext;
    public ArrayList<DefaultComponentInterface> mViews = new ArrayList<>();

    public ScrollView mView;
    public ScrollView.LayoutParams mParams;

    public BaseScrollComponent(Context context){
        mContext = context;
        mView = new ScrollView(mContext);
        mParams = new ScrollView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    public DefaultComponentInterface addView(DefaultComponentInterface view) {
        mViews.add(view);
        return this;
    }

    @Override
    public ScrollView getView() {
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
