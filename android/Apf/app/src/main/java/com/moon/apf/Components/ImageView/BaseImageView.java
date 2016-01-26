package com.moon.apf.Components.ImageView;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.moon.apf.Components.DefaultViewInterface;
import com.moon.apf.R;

import java.util.ArrayList;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseImageView implements BaseImageViewInterface, DefaultViewInterface {

    public Context mContext;
    public ImageView mView;

    public BaseImageView(Context context, int orientation){
        mContext = context;
        mView = new ImageView(mContext);
    }

    @Override
    public View getView() {
        return null;
    }

}
