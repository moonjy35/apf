package com.moon.apf.Components.ViewPager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by moon on 2016. 1. 26..
 */
public interface BaseViewPagerInterface {

    ViewPager getView();
    void addPageView(View view);
}
