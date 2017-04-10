package com.buildpackage.fields;

import com.buildpackage.constant.Constant;

import java.lang.reflect.Method;



/**
 * Created by lenovo on 2017/1/18.
 * 描述：
 */

public class FieldInfo {
    private String mDES;
    private boolean mIS_VAR_LEN;
    private Constant.FieldType mFILED_TYPE;
    private int mVAR_LEN;
    private int mCONTENT_MAX_LEN;
    private int mNORMAL_LEN;
    private String mFIELD_INFO;
    private Method mMethod;
    public FieldInfo(String pDES,boolean pIS_VAR_LEN,Constant.FieldType pFieldType,
                     int pVAR_LEN,int pNORMAL_LEN,int pCONTENT_MAX_LEN,String pFIELD_INFO,Method pMethod){
        mDES = pDES;
        mIS_VAR_LEN = pIS_VAR_LEN;
        mFILED_TYPE = pFieldType;
        mVAR_LEN = pVAR_LEN;
        mCONTENT_MAX_LEN = pCONTENT_MAX_LEN;
        mNORMAL_LEN = pNORMAL_LEN;
        mFIELD_INFO = pFIELD_INFO;
        mMethod = pMethod;
    }

    public String getDES() {
        return mDES;
    }

    public void setDES(String pDES) {
        mDES = pDES;
    }

    public boolean IS_VAR_LEN() {
        return mIS_VAR_LEN;
    }

    public void setIS_VAR_LEN(boolean pIS_VAR_LEN) {
        mIS_VAR_LEN = pIS_VAR_LEN;
    }

    public Constant.FieldType getFILED_TYPE() {
        return mFILED_TYPE;
    }

    public void setFILED_TYPE(Constant.FieldType pFILED_TYPE) {
        mFILED_TYPE = pFILED_TYPE;
    }

    public int getVAR_LEN() {
        return mVAR_LEN;
    }

    public void setVAR_LEN(int pVAR_LEN) {
        mVAR_LEN = pVAR_LEN;
    }

    public int getCONTENT_MAX_LEN() {
        return mCONTENT_MAX_LEN;
    }

    public void setCONTENT_MAX_LEN(int pCONTENT_MAX_LEN) {
        mCONTENT_MAX_LEN = pCONTENT_MAX_LEN;
    }

    public int getNORMAL_LEN() {
        return mNORMAL_LEN;
    }

    public void setNORMAL_LEN(int pNORMAL_LEN) {
        mNORMAL_LEN = pNORMAL_LEN;
    }

    public String getFIELD_INFO() {
        return mFIELD_INFO;
    }

    public void setFIELD_INFO(String pFIELD_INFO) {
        mFIELD_INFO = pFIELD_INFO;
    }

    public Method getMethod() {
        return mMethod;
    }

    public void setMethod(Method pMethod) {
        mMethod = pMethod;
    }
}
