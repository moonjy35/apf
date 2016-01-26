package com.moon.apf.Ui.Toolbar;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by moon on 2016. 1. 26..
 */
public class NavigationToolbar extends BaseToolbar{

    public NavigationToolbar(Context context){
        super(context);

        setToolbarColor(Color.BLUE);
    }

    private void hideDefaultTitle(){
        ((AppCompatActivity)mContext).getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public Toolbar getView() {
        this.hideDefaultTitle();

        Toolbar toolbar = super.getView();

        return toolbar;
    }
}
