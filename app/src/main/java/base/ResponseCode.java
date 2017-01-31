package base;

public class ResponseCode {
    /**
     * 成功
     */
    public final static int _OK = 0;
    /**
     * 密码错误
     */
    public final static int _PWD_ERROR = 55;
    /**
     * 通用错误
     */
    public final static int _NORMAL_ERROR = -1;
    /**
     * 脚本处理失败
     */
    public final static int UEMV_PROC_SCRIPT = -194;
    /**
     * 发卡行数据认证失败
     */
    public final static int UEMV_ISSUR_AUTH = -195;
    /**
     * 返回码错误
     */
    public final static int UEMV_EMVRSP = -198;
    /**
     * IC卡命令失败
     */
    public final static int UEMV_ICCCMD = -202;
    /**
     * 交易失败,执行失败
     */
    public final static int UEMV_FAIL = -211;
    /**
     * 读卡失败
     */
    public final static int UEMV_COMMAND_FAIL = -213;
    /**
     * 卡片已锁
     */
    public final static int UEMV_CARD_BLOCK = -214;
    /**
     * 交易拒绝
     */
    public final static int UEMV_DECLINED = -225;
    /**
     * 需要发起冲正
     */
    public final static int _NEED_RESERVE = -1999;
    /**
     * 建立网络连接失败
     */
    public final static int _SOCKER_CONNECT_ERROR = -2000;
    /**
     * 发送超时
     */
    public final static int _SOCKER_SEND_TIMEOUT_ERROR = -2001;
    /**
     * 发送错误
     */
    public final static int _SOCKER_SEND_ERROR = -2002;
    /**
     * 接收错误
     */
    public final static int _SOCKER_RECEIVE_ERROR = -2003;
    /**
     * 接收超时
     */
    public final static int _SOCKER_RECEIVE_TIMEOUT_ERROR = -2004;
    /**
     * 写主密钥错
     */
    public final static int _PCI_WRITEMK_ERROR = -2005;
    /**
     * 写加密密钥错
     */
    public final static int _PCI_WRITEENCRITK_ERROR = -2006;
    /**
     * 写PINK错
     */
    public final static int _PCI_WRITEPINK_ERROR = -2007;
    /**
     * 写MACK错
     */
    public final static int _PCI_WRITEMACK_ERROR = -2008;
    /**
     * 写主密钥CRC错
     */
    public final static int _PCI_CRCMK_ERROR = -2009;
    /**
     * 写加密密钥CRC错
     */
    public final static int _PCI_CRCENCRITK_ERROR = -2010;
    /**
     * 写PINK CRC错
     */
    public final static int _PCI_CRCPINK_ERROR = -2011;
    /**
     * 写写MACK CRC错
     */
    public final static int _PCI_CRCMACK_ERROR = -2012;
    /**
     * 32550操作失败
     */
    public final static int _PCI_MAXQ32550_ERROR = -2013;
    /**
     * 校验错
     */
    public final static int _OPER_VERIFY_ERROR = -2024;
    /**
     * 刷卡错误
     */
    public final static int _E_ERR_SWIPE = -2029;
    /**
     * 刷卡超时
     */
    public final static int _E_TIMEOUT_SWIPE = -2030;
    /**
     * 帐号取出错
     */
    public final static int _E_ERR_EXTRACTPAN = -2031;
    /**
     * 读PINKEY错
     */
    public final static int _E_READ_PINKEY_ERROR = -2032;
    /**
     * 打包错
     */
    public final static int _E_PACK8583_ERROR = -2033;
    /**
     * 解包错
     */
    public final static int _E_UNPACK8583_ERROR = -2034;
    /**
     * 解包某特定数据错
     */
    public final static int _E_UNPACK8583DATAS_ERROR = -2035;
    /**
     * 39域非0
     */
    public final static int _E_F39_UNZERO = -2041;
}
