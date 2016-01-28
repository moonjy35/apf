package com.moon.apf.Components.Toolbar;


import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import com.moon.apf.Components.DefaultComponentInterface;
import com.moon.apf.R;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseToolbar implements BaseToolbarInterface, DefaultComponentInterface {

    public Context mActivityContext;

    public Toolbar mView;
    public Toolbar.LayoutParams mParmas;

    public String mTitle;

    public BaseToolbar(){}
    public BaseToolbar(Context context){
        mActivityContext = context;
    }

    @Override
    public void setContext(Context context) {
        mActivityContext = context;
    }

    @Override
    public void setTitle(String title) {
        mTitle = title;
    }

    @Override
    public void setToolbarColor(int color) {
        mView.setBackgroundColor(color);
    }

    @Override
    public Toolbar getView() {
        mView = new Toolbar(mActivityContext);
        mParmas = new Toolbar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        this.setToolbarColor(Color.RED);

        ((AppCompatActivity) mActivityContext).setSupportActionBar(mView);

        mView.setLayoutParams(mParmas);
        mView.setMinimumHeight(46);
        mView.setId(R.id.id_toolbar);

        mView.setTitle(mTitle);

        return mView;
    }

    @Override
    public int getToolbarId() {
        return R.id.id_toolbar;
    }
}
