package com.moon.apf.Components.ViewPager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.moon.apf.Components.ChildViewInterface;
import com.moon.apf.Components.ParentViewInterface;
import com.moon.apf.R;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseViewPager implements BaseViewPagerInterface, ParentViewInterface {

    public Context mContext;
    public ArrayList<ChildViewInterface> views;

    public ViewPager mViewPager;
    public ViewGroup.LayoutParams mParams;

    public BaseViewPager(Context context){
        views = new ArrayList<>();

        mContext = context;
        mViewPager = new ViewPager(mContext);
        mViewPager.setId(R.id.id_viewpager);
        mParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    public void addView(ChildViewInterface view) {
        views.add(view);
    }

    @Override
    public ViewPager getView() {
        Iterator<ChildViewInterface> pageViews = views.iterator();
        while(pageViews.hasNext()){
            View view = pageViews.next().getView();
            mViewPager.addView(view);
        }

        return mViewPager;
    }
}
