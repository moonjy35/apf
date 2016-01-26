package com.moon.apf.Ui.ContentView;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.moon.apf.R;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseContentView implements BaseContentViewInterface {
    public Context mContext;
    public RelativeLayout mView;
    public RelativeLayout.LayoutParams mParams;

    public BaseContentView(Context context){
        mContext = context;
        mView = new RelativeLayout(mContext);
        mParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    public void setBelow(int target) {
        mParams.addRule(RelativeLayout.BELOW, R.id.toolbar);
    }

    @Override
    public RelativeLayout getView() {
        mView.setLayoutParams(mParams);
        mView.setBackgroundColor(Color.WHITE);

        return mView;
    }
}
