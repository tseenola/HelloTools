package com.hello.readcard.read_card_service;

import com.hello.readcard.model.CardInfoModel;
import com.jniexport.UROPElibJni;

import tools.com.hellolibrary.hello_thread.ThreadUtil;


/**
 * Created by lenovo on 2017/2/16.
 * 描述：
 */

public class BaseReadService {
    protected CardReader.OnReadCardFinish mOnReadCardFinish;


    protected void sendSuccMsgToUiThread(final CardInfoModel cardInfo){
        CardReader.checkCardThreadIsRun = false;
        ThreadUtil.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mOnReadCardFinish.onReadCardSucc(cardInfo);
            }
        });
    }

    protected void sendFailMsgToUiThread(final String pErrorMsg){
        ThreadUtil.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mOnReadCardFinish.onReadCardFail(pErrorMsg);
            }
        });
    }

    /**
     * 获取TLV
     */
    protected static String GetTlv(int Tag) {
        byte outData[] = new byte[255];
        int length = UROPElibJni.GetTlv(Tag, outData);
        if (length > 0) {
            return bytes2HexString(outData, length);
        } else {
            return "";
        }
    }

    protected static String bytes2HexString(byte[] b, int blen) {
        String ret = "";
        int i = 0;
        for (byte element : b) {
            String hex = Integer.toHexString(element & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret += hex.toUpperCase();
            i++;
            if (i >= blen) {
                break;
            }
        }
        return ret;
    }

}
