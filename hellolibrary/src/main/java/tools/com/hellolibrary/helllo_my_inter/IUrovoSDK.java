package tools.com.hellolibrary.helllo_my_inter;

/**
 * Created by lenovo on 2017/1/31.
 * 描述：
 */

public interface IUrovoSDK {
    public static final int ParentKeyNo = 0;
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
