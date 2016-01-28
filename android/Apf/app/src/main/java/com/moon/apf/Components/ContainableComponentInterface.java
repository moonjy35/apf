package com.moon.apf.Components;

import android.view.View;

/**
 * Created by moon on 2016. 1. 26..
 */
public interface ContainableComponentInterface {
    DefaultComponentInterface addView(DefaultComponentInterface view);
    View getView();
}
