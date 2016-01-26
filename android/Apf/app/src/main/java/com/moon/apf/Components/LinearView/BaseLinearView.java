package com.moon.apf.Components.LinearView;

import android.content.Context;
import android.graphics.Color;
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
public class BaseLinearView implements DefaultViewInterface, HasChildableViewInterface{

    public Context mContext;
    public ArrayList<DefaultViewInterface> mViews = new ArrayList<>();

    public LinearLayout mView;
    public LinearLayout.LayoutParams mParams;

    public BaseLinearView(Context context){
        mContext = context;
        mView = new LinearLayout(mContext);
        mParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    public DefaultViewInterface addView(DefaultViewInterface view) {
        mViews.add(view);
        return this;
    }

    @Override
    public View getView() {
        mView.setLayoutParams(mParams);
        mView.setBackgroundColor(Color.WHITE);

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