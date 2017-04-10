package com.customview.writeworkkey;

/**
 * Created by lenovo on 2017/3/7.
 * 描述：密钥类型
 */

public enum KeyType {

     _ENCRPTKEY(1),
     _PINKEY(2),
     _MACKEY(3),
     _MASTKEY(4),
     _TLK(5);

    private int value;

    KeyType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
