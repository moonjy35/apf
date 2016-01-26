package com.moon.apf.Components.ScrollView;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.moon.apf.Components.DefaultViewInterface;
import com.moon.apf.Components.HasChildableViewInterface;
import com.moon.apf.R;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseScrollView implements BaseScrollViewInterface, DefaultViewInterface, HasChildableViewInterface {

    public Context mContext;
    public ArrayList<DefaultViewInterface> mViews = new ArrayList<>();

    public ScrollView mView;
    public ScrollView.LayoutParams mParams;

    public BaseScrollView(Context context){
        mContext = context;
        mView = new ScrollView(mContext);
        mParams = new ScrollView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    public DefaultViewInterface addView(DefaultViewInterface view) {
        mViews.add(view);
        return this;
    }

    @Override
    public ScrollView getView() {
        mView.setLayoutParams(mParams);
        mView.setBackgroundColor(Color.WHITE);

        if(!mViews.isEmpty()){
            Iterator<DefaultViewInterface> pageViews = mViews.iterator();
            while(pageViews.hasNext()){
                View view = pageViews.next().getView();
                mView.addView(view);
            }
        }

        return mView;
    }
}
