package com.buildpackage.modle;

import android.content.Context;

/**
 * Created by lenovo on 2017/4/7.
 * 描述：
 */

public interface IField {


    Field getFieldInfoInstance(Context pContext);



    /**
     * 作用：组包
     * 报文组成（报文长度+tpdu+报文头+消息类型+位图+1到63域的值+mac）
     * 其中tpdu,报文头，消息类型已经有值。
     * 还需要求得：1到64域的值，位图，Mac，报文长度
     * 最后拼接起来就是整个报文。
     * @return 返回完整的16进制字符串报文
     */
    String buildMsg(Field pField);


    /**
     * 作用：组包
     * 报文组成（报文长度+tpdu+报文头+消息类型+位图+1到63域的值+mac）
     * 其中tpdu,报文头，消息类型已经有值。
     * 还需要求得：1到64域的值，位图，Mac，报文长度
     * 最后拼接起来就是整个报文。
     * @return 返回完整报文字符串数组
     */
    byte[] getBytesMsg(Field pField);

    /**
     * 解包
     * @param pContext
     * @param pRcvedHexMsg 收到的16进制字符串报文
     * @return 返回解包后的对象
     */
    Field parseMsg(Context pContext, String pRcvedHexMsg);


    /**
     * 解包
     * @param pContext
     * @param pBytesMsg 收到的报文byte数组
     * @return 返回解包后的对象
     */
    Field parseMsg(Context pContext, byte [] pBytesMsg);
}
