package com.customview.writemasterkey;

/**
 * Created by lenovo on 2017/1/31.
 * 描述：
 */

public interface IUrovoSDK {
    public static final int BE_USED_TO_LOAD_PARENT_KEY = 0;//when DownloadKey is used to load parent key, this parameter can be ignore. 当Downladkey函数被用来加载主密钥，这个参数填写0
    /**
     * 密钥类型
     */
    final class KeyUsage {
        public final static byte _ENCRPTKEY = 1;
        public final static byte _PINKEY = 2;
        public final static byte _MACKEY = 3;
        public final static byte _MASTKEY = 4;
        public final static byte _TLK = 5;
    }

    /**
     * 算法类型
     */
    final class Algorithm{
        public final static byte _ECB = 1;
        public final static byte _CBC = 2;
    }
}
