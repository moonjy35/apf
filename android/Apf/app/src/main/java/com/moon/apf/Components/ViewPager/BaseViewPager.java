package com.moon.apf.Components.ViewPager;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.moon.apf.Components.ParentViewInterface;
import com.moon.apf.R;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseViewPager implements BaseViewPagerInterface, ParentViewInterface {

    public Context mContext;

    public ViewPager mViewPager;
    public ViewGroup.LayoutParams mParams;

    private ArrayList<View> mPageViews;

    public BaseViewPager(Context context){

        mPageViews = new ArrayList<>();

        mContext = context;
        mViewPager = new ViewPager(mContext);
        mViewPager.setId(R.id.id_viewpager);
        mParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    public void addPageView(View view) {
        mPageViews.add(view);
        mViewPager.addView(view);
    }

    @Override
    public ViewPager getView() {
        Iterator<View> pageViews = mPageViews.iterator();
        while(pageViews.hasNext()){
            mViewPager.addView(pageViews.next());
        }

        return mViewPager;
    }
}
