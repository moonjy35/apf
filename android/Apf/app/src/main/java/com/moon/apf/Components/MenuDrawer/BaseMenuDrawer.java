package com.moon.apf.Components.MenuDrawer;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.moon.apf.Components.DefaultViewInterface;
import com.moon.apf.Components.HasChildableViewInterface;
import com.moon.apf.R;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseMenuDrawer implements BaseMenuDrawerInterface, DefaultViewInterface, HasChildableViewInterface{

    public Context mContext;
    public ArrayList<DefaultViewInterface> mViews = new ArrayList<>();

    public DrawerLayout mView;
    public DrawerLayout.LayoutParams mParams;

    public BaseMenuDrawer(Context context){
        mContext = context;

        mView = new DrawerLayout(mContext);
        mView.setId(R.id.id_menuDrawer);
        mParams = new DrawerLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    public DefaultViewInterface addView(DefaultViewInterface view) {
        mViews.add(view);
        return this;
    }

    @Override
    public DefaultViewInterface addContentView(DefaultViewInterface view) {
        mViews.add(view);
        return this;
    }

    @Override
    public DefaultViewInterface addDrawerView(DefaultViewInterface view) {
        mViews.add(view);
        return this;
    }

    @Override
    public View getView() {
        mView.setLayoutParams(mParams);

        if(!mViews.isEmpty()){
            Iterator<DefaultViewInterface> views = mViews.iterator();
            while(views.hasNext()){
                View view = views.next().getView();
                mView.addView(view);
            }
        }

        return mView;
    }
}