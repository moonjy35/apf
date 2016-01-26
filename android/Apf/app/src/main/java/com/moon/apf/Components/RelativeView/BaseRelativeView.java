package com.moon.apf.Components.RelativeView;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.moon.apf.Components.ChildViewInterface;
import com.moon.apf.Components.ParentViewInterface;
import com.moon.apf.R;

import java.util.ArrayList;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseRelativeView implements BaseRelativeViewInterface, ParentViewInterface {

    public Context mContext;
    public ArrayList<ChildViewInterface> views;

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

    }

    @Override
    public RelativeLayout getView() {
        mView.setLayoutParams(mParams);
        mView.setBackgroundColor(Color.WHITE);

        return mView;
    }
}
