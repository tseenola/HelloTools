package com.urovo.poscommon.models;

/**
 * Created by lenovo on 2017/4/10.
 * 描述：算法类型
 */

public enum Algorithm {
    ECB(1),
    CBC(2);

    private int mValue;

    Algorithm(int pValue) {
        mValue = pValue;
    }

    public int getValue() {
        return mValue;
    }
}
