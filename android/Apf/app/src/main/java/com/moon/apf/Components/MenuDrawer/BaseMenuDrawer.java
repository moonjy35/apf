package com.moon.apf.Components.MenuDrawer;

import android.view.View;

import com.moon.apf.Components.DefaultViewInterface;
import com.moon.apf.Components.HasChildableViewInterface;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseMenuDrawer implements BaseMenuDrawerInterface, DefaultViewInterface, HasChildableViewInterface{


    @Override
    public DefaultViewInterface addView(DefaultViewInterface view) {
        return null;
    }

    @Override
    public View getView() {
        return null;
    }
}
