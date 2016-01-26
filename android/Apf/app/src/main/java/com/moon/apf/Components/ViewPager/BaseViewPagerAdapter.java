package com.moon.apf.Components.ViewPager;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseViewPagerAdapter extends PagerAdapter {

    private ViewPager mPager;

    public BaseViewPagerAdapter(ViewPager pager){
        mPager = pager;
    }

    public Object instantiateItem(ViewGroup collection, int position) {
        View v = mPager.getChildAt(position);

        return v;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == ((View) arg1);
    }
}
