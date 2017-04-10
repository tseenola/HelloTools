package com.buildpackage.utils;

import android.content.Context;

import com.buildpackage.modle.Field;
import com.buildpackage.modle.IField;

import tools.com.hellolibrary.hello_convert.ConvertUtils;

/**
 * Created by lenovo on 2017/4/7.
 * 描述：
 */

public class FieldUtils {
    public static Field getFieldInfoInstance(Context pContext,IField pIField){
        return pIField.getFieldInfoInstance(pContext);
    }

    public static String buildMsg(Field pField,IField pIField){
        return pIField.buildMsg(pField);
    }

    public static byte[] getBytesMsg(Field pField,IField pIField) {
        return ConvertUtils.hexStringToByte(buildMsg(pField,pIField));
    }

    public static Field parseMsg(Context pContext, String pRcvedHexMsg,IField pIField){
        return pIField.parseMsg(pContext,pRcvedHexMsg);
    }

    public static Field parseMsg(Context pContext, byte[] pBytesMsg,IField pIField) {
        return parseMsg(pContext,ConvertUtils.bytesToHexString(pBytesMsg),pIField);
    }
}
