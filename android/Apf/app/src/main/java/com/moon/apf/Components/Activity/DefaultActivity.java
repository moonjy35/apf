package com.moon.apf.Components.Activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.widget.LinearLayout;

import com.moon.apf.Components.LinearView.BaseLinearView;
import com.moon.apf.Components.LinearView.DefaultLinearView;
import com.moon.apf.Components.LinearView.DrawerLinearView;
import com.moon.apf.Components.MenuDrawer.BaseMenuDrawer;
import com.moon.apf.Components.MenuDrawer.DefaultMenuDrawer;
import com.moon.apf.Components.RelativeView.BaseRelativeView;
import com.moon.apf.Components.RelativeView.DefaultRelativeView;
import com.moon.apf.Components.Toolbar.BaseToolbar;
import com.moon.apf.Components.Toolbar.DefaultToolbar;
import com.moon.apf.Components.WebView.BaseWebView;
import com.moon.apf.Components.WebView.DefaultWebView;
import com.moon.apf.R;

/**
 * Created by moon on 2016. 1. 26..
 */
public class DefaultActivity extends BaseActivity {

    public BaseRelativeView mLayout;
    public BaseToolbar mToolbar;
    public BaseRelativeView mContent;
    public BaseWebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TODO 툴바가 표시되지 않음
        //TODO 드로어는 기본으로 OFF 상태 설정해야함

        mLayout = new DefaultRelativeView(this);
        mToolbar = new DefaultToolbar(this, "애드투페이퍼");
        mContent = new DefaultRelativeView(this);
        mContent.setBelow(mToolbar.getToolbarId());

        mWebview = new DefaultWebView(this, "http://www.naver.com");

        mLayout.addView(mToolbar);
        mLayout.addView(mContent.addView(mWebview));

        _ContentLayout.addView(mLayout.getView());
    }
}
