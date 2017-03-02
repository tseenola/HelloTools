package com.hello.readcard.enumm;

/**
 * Created by lenovo on 2017/2/22.
 * 描述：刷卡类型
 *
 */

public enum SwipedMode {

    NO_SWIPE_INSERT(0),// 没有刷卡/插卡
    CARD_SWIPED(1),// 刷卡
    CARD_INSERTED(2),// 插卡
    CLCARD_SWIPED(16);// 非接

    private int mMode;
    SwipedMode(int pMode){
        mMode = pMode;
    }

    public int getMode() {
        return mMode;
    }


}
