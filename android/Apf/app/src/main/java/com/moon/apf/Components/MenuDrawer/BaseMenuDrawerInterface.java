package com.moon.apf.Components.MenuDrawer;

import android.view.View;

import com.moon.apf.Components.DefaultViewInterface;

/**
 * Created by moon on 2016. 1. 26..
 */
public interface BaseMenuDrawerInterface {
    DefaultViewInterface addContentView(DefaultViewInterface view);
    DefaultViewInterface addDrawerView(DefaultViewInterface view);
}
