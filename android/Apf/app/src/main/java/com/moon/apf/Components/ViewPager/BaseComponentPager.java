package com.moon.apf.Components.ViewPager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.moon.apf.Components.DefaultComponentInterface;
import com.moon.apf.Components.ContainableComponentInterface;
import com.moon.apf.R;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseComponentPager implements BaseViewPagerInterface, ContainableComponentInterface, DefaultComponentInterface {

    public Context mActivityContext;
    public ArrayList<DefaultComponentInterface> mViews = new ArrayList<>();

    public ViewPager mView;
    public ViewGroup.LayoutParams mParams;

    public BaseComponentPager(){}
    public BaseComponentPager(Context context){
        mActivityContext = context;
    }

    @Override
    public void setContext(Context context) {
        mActivityContext = context;
    }

    @Override
    public void setPagerAdapter(BaseViewPagerAdapter adapter) {
        mView.setAdapter(adapter);
    }

    @Override
    public DefaultComponentInterface addView(DefaultComponentInterface view) {
        mViews.add(view);

        return this;
    }

    @Override
    public ViewPager getView() {
        mView = new ViewPager(mActivityContext);
        mView.setId(R.id.id_viewpager);
        mParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        if(!mViews.isEmpty()){
            Iterator<DefaultComponentInterface> views = mViews.iterator();
            while(views.hasNext()){
                View view = views.next().getView();
                mView.addView(view);
            }

            this.setPagerAdapter(new BaseViewPagerAdapter(mView));
        }

        return mView;
    }
}
