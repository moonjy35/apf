package com.moon.apf.Components.Activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.moon.apf.R;

/**
 * Created by moon on 2016. 1. 26..
 */
public class BaseActivity extends AppCompatActivity {

    public DrawerLayout _DrawerLayout;
    public RelativeLayout _ContentLayout;
    public RelativeLayout _MenuLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_default);

        _DrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        _ContentLayout = (RelativeLayout)findViewById(R.id.contentLayout);
        _MenuLayout = (RelativeLayout)findViewById(R.id.menuLayout);
    }
}
