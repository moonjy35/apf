package com.moon.apf.Components.Activity;

import android.os.Bundle;

import com.moon.apf.Components.RelativeView.BaseRelativeComponent;
import com.moon.apf.Components.RelativeView.DefaultRelativeComponent;
import com.moon.apf.Components.Toolbar.BaseToolbar;
import com.moon.apf.Components.Toolbar.DefaultToolbar;
import com.moon.apf.Components.WebView.BaseWebComponent;
import com.moon.apf.Components.WebView.DefaultWebComponent;

/**
 * Created by moon on 2016. 1. 26..
 */
public class DefaultActivity extends BaseActivity {

    public BaseRelativeComponent mLayout;
    public BaseToolbar mToolbar;
    public BaseRelativeComponent mContent;
    public BaseWebComponent mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TODO 툴바가 표시되지 않음
        //TODO 드로어는 기본으로 OFF 상태 설정해야함

        mLayout = new DefaultRelativeComponent(this);
        mToolbar = new DefaultToolbar(this, "애드투페이퍼");
        mContent = new DefaultRelativeComponent(this);
        mContent.setBelow(mToolbar.getToolbarId());

        mWebview = new DefaultWebComponent(this, "http://www.naver.com");

        mLayout.addView(mToolbar);
        mLayout.addView(mContent.addView(mWebview));

        _ContentLayout.addView(mLayout.getView());
    }
}
