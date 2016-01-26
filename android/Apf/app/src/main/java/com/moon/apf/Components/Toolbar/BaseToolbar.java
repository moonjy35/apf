package com.moon.apf.Components.Toolbar;


import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import com.moon.apf.Components.ChildViewInterface;
import com.moon.apf.Components.ParentViewInterface;
import com.moon.apf.R;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseToolbar implements BaseToolbarInterface, ParentViewInterface {

    public Context mContext;
    public Toolbar mView;

    private Toolbar.LayoutParams mParmas;

    public BaseToolbar(Context context){
        mContext = context;

        mView = new Toolbar(mContext);
        mParmas = new Toolbar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        this.setToolbarColor(Color.RED);
    }

    @Override
    public void setTitle(String title) {
        mView.setTitle(title);
    }

    @Override
    public void setAsToolbar() {
        ((AppCompatActivity)mContext).setSupportActionBar(mView);
    }

    @Override
    public void setToolbarColor(int color) {
        mView.setBackgroundColor(color);
    }

    @Override
    public void addView(ChildViewInterface view) {
        
    }

    @Override
    public Toolbar getView() {
        mView.setLayoutParams(mParmas);
        mView.setMinimumHeight(46);
        mView.setId(R.id.toolbar);

        return mView;
    }

    @Override
    public int getToolbarId() {
        return mView.getId();
    }
}
