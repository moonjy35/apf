package com.moon.apf.Components.Toolbar;

import android.support.v7.widget.Toolbar;

/**
 * Created by moon on 2016. 1. 26..
 */
public interface BaseToolbarInterface {
    Toolbar getView();
    int getToolbarId();

    void setAsToolbar();
    void setTitle(String title);
    void setToolbarColor(int color);


}
