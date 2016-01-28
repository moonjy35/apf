package com.moon.apf.Components.MenuDrawer;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
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
public class BaseMenuDrawer implements BaseMenuDrawerInterface, DefaultComponentInterface, ContainableComponentInterface {

    public Context mActivityContext;
    public ArrayList<DefaultComponentInterface> mViews = new ArrayList<>();

    public DrawerLayout mView;
    public DrawerLayout.LayoutParams mParams;

    public BaseMenuDrawer(){}
    public BaseMenuDrawer(Context context){
        mActivityContext = context;
    }

    @Override
    public void setContext(Context context) {
        mActivityContext = context;
    }

    @Override
    public DefaultComponentInterface addView(DefaultComponentInterface view) {
        mViews.add(view);
        return this;
    }

    @Override
    public DefaultComponentInterface addContentView(DefaultComponentInterface view) {
        mViews.add(view);
        return this;
    }

    @Override
    public DefaultComponentInterface addDrawerView(DefaultComponentInterface view) {
        mViews.add(view);
        return this;
    }

    @Override
    public View getView() {
        mView = new DrawerLayout(mActivityContext);
        mView.setId(R.id.id_menuDrawer);
        mParams = new DrawerLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        mView.setLayoutParams(mParams);

        if(!mViews.isEmpty()){
            Iterator<DefaultComponentInterface> views = mViews.iterator();
            while(views.hasNext()){
                View view = views.next().getView();
                mView.addView(view);
            }
        }

        return mView;
    }
}