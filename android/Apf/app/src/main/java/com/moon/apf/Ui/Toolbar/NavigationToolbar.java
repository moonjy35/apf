package com.moon.apf.Ui.Toolbar;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by moon on 2016. 1. 26..
 */
public class NavigationToolbar extends BaseToolbar{

    public NavigationToolbar(Context context){
        super(context);

        setToolbarColor(Color.BLUE);


    }

    private void hideToolbarTitle(){
        ((AppCompatActivity)mContext).getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public Toolbar getView() {
        this.hideToolbarTitle();

        Toolbar toolbar = super.getView();
        //TODO 툴바 상단 하단 마진 혹은 패딩 제거
        toolbar.setContentInsetsRelative(0, 0);

        LinearLayout layout = new LinearLayout(mContext);
        layout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.CENTER;

        layout.setLayoutParams(params);

        TextView textView = new TextView(mContext);
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        textView.setText("타이틀 테스트");
        textView.setBackgroundColor(Color.DKGRAY);

        layout.addView(textView);

        toolbar.addView(layout);

        return toolbar;
    }
}
