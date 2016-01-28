package com.moon.apf.Components.ImageView;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.moon.apf.Components.BaseComponent;
import com.moon.apf.Components.DefaultComponentInterface;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseImageComponent extends BaseComponent implements BaseImageViewInterface, DefaultComponentInterface {

    public ImageView mView;

    public BaseImageComponent() {
        super();
    }
    public BaseImageComponent(Context activityContext){
        super(activityContext);
    }

    @Override
    public View getView() {
        mView = new ImageView(_mActivityContext);
        return mView;
    }
}
