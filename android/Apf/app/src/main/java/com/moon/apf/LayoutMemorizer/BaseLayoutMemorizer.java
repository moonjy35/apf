package com.moon.apf.LayoutMemorizer;

import com.moon.apf.LayoutFactory.ComponentFactory;
import com.moon.apf.LayoutFactory.LayoutFactory;
import com.moon.apf.LayoutParser.BaseLayoutParser;

/**
 * Created by moon on 2016. 1. 27..
 */
public class BaseLayoutMemorizer implements BaseLayoutMemorizerInterface {

    private String mSource;

    public BaseLayoutMemorizer(){}

    @Override
    public BaseLayoutMemorizerInterface setSource(String source) {
        mSource = source;
        return this;
    }

    @Override
    public void memorize() {
        new BaseLayoutParser(new LayoutFactory(), new ComponentFactory()).setSource(mSource).parse();
    }
}
