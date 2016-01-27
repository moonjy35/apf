package com.moon.apf.Components.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.moon.apf.Components.DefaultComponentInterface;
import com.moon.apf.Components.RelativeView.BaseRelativeComponent;
import com.moon.apf.Components.RelativeView.DefaultRelativeComponent;
import com.moon.apf.Components.Toolbar.BaseToolbar;
import com.moon.apf.Components.Toolbar.DefaultToolbar;
import com.moon.apf.Components.WebView.BaseWebViewComponent;
import com.moon.apf.LayoutInflaters.IntentLayoutInflater;

/**
 * Created by moon on 2016. 1. 27..
 */
public class IntentActivity extends BaseActivity {

    private Intent mIntent;
    private DefaultComponentInterface mComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mIntent = getIntent();

        IntentLayoutInflater inflater = new IntentLayoutInflater(this, mIntent);
        mComponent = inflater.getComponent();

        if(mComponent != null){
            Log.d("", "INFALTE FROM INTENT INFLATER");
            _ContentLayout.addView(mComponent.getView());
        }
        else
        {
            Log.d("", "THERE IS NO MEMORIZING LAYOUT");
        }
    }
}
