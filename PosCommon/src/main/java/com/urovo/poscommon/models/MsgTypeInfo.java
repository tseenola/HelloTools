package com.urovo.poscommon.models;

/**
 * Created by lenovo on 2017/2/22.
 * 描述：定义交易类型
 * 交易类型包括三个方面
 * 1.交易的汉字描述
 * 2.发包类型：eg:消费 0800
 * 3.此交易类型必须有的域有哪些。eg:消费必须有 2域，5域，63域，64域。。。就需要传入：02,05,63,64
 */

public class MsgTypeInfo {
    String mDes;
    String mType;
    String mMustHaveField;

    /**
     *
     * @param pDes 交易类型的描述：eg:主密钥下载
     * @param pType 交易类型对应的type eg:0800
     * @param pMustHaveField 此交易类型为M的域有哪些（哪些域文档写的必须有值） eg：签到必须有3域，25域，41域，42域，60域，对应的值就是：03,25,41,42,60
     */
    public MsgTypeInfo(String pDes, String pType, String pMustHaveField) {
        mDes = pDes;
        mType = pType;
        mMustHaveField = pMustHaveField;
    }

    public String getDes() {
        return mDes;
    }

    public void setDes(String pDes) {
        mDes = pDes;
    }

    public String getType() {
        return mType;
    }

    public void setType(String pType) {
        mType = pType;
    }

    public String getMustHaveField() {
        return mMustHaveField;
    }

    public void setMustHaveField(String pMustHaveField) {
        mMustHaveField = pMustHaveField;
    }
}
