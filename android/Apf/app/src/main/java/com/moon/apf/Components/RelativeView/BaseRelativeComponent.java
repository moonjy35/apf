package com.moon.apf.Components.RelativeView;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.moon.apf.Components.HasChildableComponentInterface;
import com.moon.apf.Components.DefaultComponentInterface;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseRelativeComponent implements BaseRelativeViewInterface, HasChildableComponentInterface, DefaultComponentInterface {

    public Context mContext;
    public ArrayList<DefaultComponentInterface> mViews = new ArrayList<>();

    public RelativeLayout mView;
    public RelativeLayout.LayoutParams mParams;

    public BaseRelativeComponent(Context context){
        mContext = context;
        mView = new RelativeLayout(mContext);
        mParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    public void setBelow(int target) {
        mParams.addRule(RelativeLayout.BELOW, target);
    }

    @Override
    public DefaultComponentInterface addView(DefaultComponentInterface view) {
        mViews.add(view);
        return this;
    }

    @Override
    public RelativeLayout getView() {
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
