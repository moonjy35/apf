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
    public RelativeLayout _MenuLayoutLeft;
    public RelativeLayout _MenuLayoutRight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_drawer);

        _DrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        _ContentLayout = (RelativeLayout)findViewById(R.id.contentLayout);
        _MenuLayoutLeft = (RelativeLayout)findViewById(R.id.menuLayoutLeft);
        _MenuLayoutRight = (RelativeLayout)findViewById(R.id.menuLayoutRight);
    }
}
