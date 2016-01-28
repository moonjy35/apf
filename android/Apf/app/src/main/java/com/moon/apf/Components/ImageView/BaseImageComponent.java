package com.moon.apf.Components.ImageView;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.moon.apf.Components.DefaultComponentInterface;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseImageComponent implements BaseImageViewInterface, DefaultComponentInterface {

    public Context mActivityContext;
    public ImageView mView;

    public BaseImageComponent() { }
    public BaseImageComponent(Context context){
        mActivityContext = context;
    }

    @Override
    public void setContext(Context context) {
        mActivityContext = context;
    }

    @Override
    public View getView() {
        mView = new ImageView(mActivityContext);
        return mView;
    }

}
