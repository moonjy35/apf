package com.moon.apf.Components.ViewPager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.moon.apf.Components.DefaultViewInterface;
import com.moon.apf.Components.HasChildableViewInterface;
import com.moon.apf.R;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseViewPager implements BaseViewPagerInterface, HasChildableViewInterface, DefaultViewInterface {

    public Context mContext;
    public ArrayList<DefaultViewInterface> mViews = new ArrayList<>();

    public ViewPager mView;
    public ViewGroup.LayoutParams mParams;

    public BaseViewPager(Context context){
        mContext = context;
        mView = new ViewPager(mContext);
        mView.setId(R.id.id_viewpager);
        mParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    public void setPagerAdapter(BaseViewPagerAdapter adapter) {
        mView.setAdapter(adapter);
    }

    @Override
    public DefaultViewInterface addView(DefaultViewInterface view) {
        mViews.add(view);

        return this;
    }

    @Override
    public ViewPager getView() {
        if(!mViews.isEmpty()){
            Iterator<DefaultViewInterface> pageViews = mViews.iterator();
            while(pageViews.hasNext()){
                View view = pageViews.next().getView();
                mView.addView(view);
            }

            this.setPagerAdapter(new BaseViewPagerAdapter(mView));
        }

        return mView;
    }
}
