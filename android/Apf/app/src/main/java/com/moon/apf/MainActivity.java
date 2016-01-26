package com.moon.apf;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.moon.apf.Activity.DefaultActivity;
import com.moon.apf.Ui.ContentView.DefaultContentView;
import com.moon.apf.Ui.Toolbar.DefaultToolbar;


public class MainActivity extends DefaultActivity {

    private RelativeLayout mLayout;
    private Toolbar mToolbar;
    private RelativeLayout mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLayout = new DefaultContentView(this).getView();

        DefaultToolbar defaultToolbar = new DefaultToolbar(this);
        defaultToolbar.setAsToolbar();

        mToolbar = defaultToolbar.getView();
        mToolbar.setTitle("yo!");

        DefaultContentView defaultContentView = new DefaultContentView(this);
        defaultContentView.setBelow(defaultToolbar.getToolbarId());
        mContent = defaultContentView.getView();

        mLayout.addView(mToolbar);
        mLayout.addView(mContent);

        setContentView(mLayout);
    }
}
