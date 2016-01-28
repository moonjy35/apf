package com.moon.apf.Components.LinearView;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.moon.apf.Components.DefaultComponentInterface;
import com.moon.apf.Components.ContainableComponentInterface;
import com.moon.apf.R;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseLinearComponent implements DefaultComponentInterface, ContainableComponentInterface {

    public Context mActivityContext;
    public ArrayList<DefaultComponentInterface> mViews = new ArrayList<>();

    public LinearLayout mView;
    public int mOrientation;
    public LinearLayout.LayoutParams mParams;

    public BaseLinearComponent(){}
    public BaseLinearComponent(int orientation){
        mOrientation = orientation;
    }
    public BaseLinearComponent(Context context, int orientation){
        mActivityContext = context;
        mOrientation = orientation;
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
    public View getView() {
        mView = new LinearLayout(mActivityContext);
        mView.setOrientation(mOrientation);
        mView.setBackgroundColor(Color.GREEN);
        mView.setId(R.id.id_menuDrawerList);

        //임시 240dp
        mParams = new LinearLayout.LayoutParams(100, ViewGroup.LayoutParams.MATCH_PARENT);
        mParams.gravity = Gravity.START;

        mView.setLayoutParams(mParams);
        mView.setBackgroundColor(Color.GREEN);

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