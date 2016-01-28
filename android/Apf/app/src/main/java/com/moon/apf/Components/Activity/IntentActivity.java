package com.moon.apf.Components.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;

import com.moon.apf.Components.DefaultComponentInterface;
import com.moon.apf.LayoutFactory.LayoutFactory;
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


        //TODO 디비 상에 저장된 정보로 불러오게끔 변경되어야함
        View view = LayoutFactory.getView(1);
        _ContentLayout.addView(view);



        //인텐트로 불러옴
//        mIntent = getIntent();
//
//        IntentLayoutInflater inflater = new IntentLayoutInflater(this, mIntent);
//        mComponent = inflater.getComponent();
//
//        if(mComponent != null){
//            Log.d("", "INFALTE FROM INTENT INFLATER");
//            _ContentLayout.addView(mComponent.getView());
//        }
//        else
//        {
//            Log.d("", "THERE IS NO MEMORIZING LAYOUT");
//        }
    }
}
