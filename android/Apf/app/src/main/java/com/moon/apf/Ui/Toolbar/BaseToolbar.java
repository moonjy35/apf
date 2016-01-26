package com.moon.apf.Ui.Toolbar;


import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import com.moon.apf.R;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseToolbar implements BaseToolbarInterface {

    public Context mContext;
    public Toolbar mView;

    private Toolbar.LayoutParams mParmas;

    public BaseToolbar(Context context){
        mContext = context;

        mView = new Toolbar(mContext);
        mParmas = new Toolbar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void setAsToolbar() {
        ((AppCompatActivity)mContext).setSupportActionBar(mView);
    }

    @Override
    public Toolbar getView() {
        mView.setLayoutParams(mParmas);
        mView.setMinimumHeight(46);
        mView.setId(R.id.toolbar);

        mView.setBackgroundColor(Color.RED);

        return mView;
    }

    @Override
    public int getToolbarId() {
        return mView.getId();
    }
}
