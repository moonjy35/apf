package com.moon.apf.Components.RelativeView;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.moon.apf.Components.ChildViewInterface;
import com.moon.apf.Components.ParentViewInterface;
import com.moon.apf.Components.DefaultViewInterface;
import com.moon.apf.R;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseRelativeView implements BaseRelativeViewInterface, ParentViewInterface, DefaultViewInterface {

    public Context mContext;
    public ArrayList<ChildViewInterface> mViews;

    public RelativeLayout mView;
    public RelativeLayout.LayoutParams mParams;

    public BaseRelativeView(Context context){
        mContext = context;
        mView = new RelativeLayout(mContext);
        mParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    public void setBelow(int target) {
        mParams.addRule(RelativeLayout.BELOW, R.id.toolbar);
    }

    @Override
    public void addView(ChildViewInterface view) {
        if(mViews != null){
            mViews = new ArrayList<>();
        }

        mViews.add(view);
    }

    @Override
    public RelativeLayout getView() {
        mView.setLayoutParams(mParams);
        mView.setBackgroundColor(Color.WHITE);

        Iterator<ChildViewInterface> pageViews = mViews.iterator();
        while(pageViews.hasNext()){
            View view = pageViews.next().getView();
            mView.addView(view);
        }

        return mView;
    }
}
