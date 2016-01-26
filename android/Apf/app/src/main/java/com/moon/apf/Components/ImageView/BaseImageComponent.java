package com.moon.apf.Components.ImageView;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.moon.apf.Components.DefaultComponentInterface;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseImageComponent implements BaseImageViewInterface, DefaultComponentInterface {

    public Context mContext;
    public ImageView mView;

    public BaseImageComponent(Context context){
        mContext = context;
        mView = new ImageView(mContext);
    }

    @Override
    public View getView() {
        return null;
    }

}
