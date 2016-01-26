package com.moon.apf;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.moon.apf.Activity.DefaultActivity;


public class MainActivity extends DefaultActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout container = new RelativeLayout(this);
        RelativeLayout.LayoutParams containerParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        container.setLayoutParams(containerParams);

        Toolbar toolbar = new Toolbar(this);
        Toolbar.LayoutParams toolbarParams = new Toolbar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        toolbar.setLayoutParams(toolbarParams);
        toolbar.setMinimumHeight(46);
        toolbar.setId(R.id.toolbar);


        RelativeLayout content = new RelativeLayout(this);
        RelativeLayout.LayoutParams contentParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        contentParams.addRule(RelativeLayout.BELOW, R.id.toolbar);
        content.setLayoutParams(contentParams);
        content.setBackgroundColor(Color.WHITE);


        container.addView(toolbar);
        container.addView(content);

        setContentView(container);

        setSupportActionBar(toolbar);
    }
}
