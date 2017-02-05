package base;

/**
 * Created by lenovo on 2016/3/10.
 */
public class ConfigValues {
    /**
     * APP是否第一次启动
     */
    public static final String APP_IS_FIRST_OPEN = "APP_IS_FORST_OPEN";
    /**
     * 卡Bin版本
     */
    public static final String CARD_BIN_VERSION = "CARD_BIN_VERSION";
    /**
     * 小额商户默认通讯信息
     */
    public static final String DEFAULT_NORMAL_TPDU = "6000080000";
    public static final String DEFAULT_NORMAL_ADDR = "49.4.175.10";
    public static final String DEFAULT_NORMAL_PORT = "5005";

    public static final String DEFAULT_NORMAL_TPDU_CLEAR = "6000550000";
    public static final String DEFAULT_NORMAL_ADDR_CLEAR = "210.22.188.35";
    public static final String DEFAULT_NORMAL_PORT_CLEAR = "8213";
    /**
     * 大额商户默认通讯信息
     */
    public static final String DEFAULT_LARGE_TPDU = "6004010000";
    public static final String DEFAULT_LARGE_ADDR = "210.22.188.35";
    public static final String DEFAULT_LARGE_PORT = "8210";
    public static final String DEFAULT_LARGE_TPDU_CLEAR = "6000550000";
    public static final String DEFAULT_LARGE_ADDR_CLEAR = "210.22.188.35";
    public static final String DEFAULT_LARGE_PORT_CLEAR = "8213";
    /**
     * 小额商户默认商户信息
     */
    public static final String DEFAULT_NORMAL_MID = "103100048141347";
    public static final String DEFAULT_NORMAL_TID = "1201QZ8Q";
    public static final String DEFAULT_NORMAL_MNAME = "";
    public static final String DEFAULT_NORMAL_CLEAR_FLAG = "0";
    public static final String DEFAULT_NORMAL_CLEAR_ID = "";
    public static final String DEFAULT_NORMAL_ELEC_FLAG = "0";
    /**
     * 大额商户默认商户信息
     */
    public static final String DEFAULT_LARGE_MID = "301310054114716";
    public static final String DEFAULT_LARGE_TID = "00000000";
    public static final String DEFAULT_LARGE_MNAME = "上海匹匹扣网络科技有限公司";
    public static final String DEFAULT_LARGE_CLEAR_FLAG = "0";
    public static final String DEFAULT_LARGE_CLEAR_ID = "";
    public static final String DEFAULT_LARGE_ELEC_FLAG = "1";
    /**
     * 默认凭证号
     */
    public static final String DEFAULT_COMMON_TRACENO = "000001";
    /**
     * 默认批次号
     */
    public static final String DEFAULT_COMMON_BATCHNO = "000001";
    /**
     * 默认超时时间
     */
    public static final String DEFAULT_COMMON_COMM_TIMEOUT = "45";
    /**
     * 默认冲正次数
     */
    public static final String DEFAULT_COMMON_REVERSE_TIMES = "3";
    /**
     * 默认下载EVM参数
     */
    public static final String DEFAULT_COMMON_DOWNLOAD_EVM_PARM = "1";
    /**
     * 默认下载EVM KEYS
     */
    public static final String DEFAULT_COMMON_DOWNLOAD_EVM_KEY = "1";
    /**
     * 默认的小票张数
     */
    public static final String DEFAULT_COMMON_TICKET_NUM = "2";
    /**
     * 默认的已签到标识
     */
    public static final String DEFAULT_COMMON_SIGN_FLAG = "logout";
    /**
     * 默认的最后一次签到时间
     */
    public static final String DEFAULT_COMMON_LAST_LOGIN_TIME = "0";
    /**
     * 默认的最大退货金额
     */
    public static final String DEFAULT_COMMON_MAX_REFUND_AMT = "10000";
    /**
     * 默认的最大交易笔数
     */
    public static final String DEFAULT_COMMON_MAX_TRADE_COUNT = "100";

    /**
     * 小额免密免签参数
     */
    public static final int EC_SWITCH = 100;        // 非接交易通道开关
    public static final int EC_TIME = 101;          // 闪卡当笔重刷时间
    public static final int EC_TIME2 = 102;         // 闪卡记录可重刷时间
    public static final int EC_LIMIT_NO_PWD = 103; // 免密限额
    public static final int EC_FLAG = 104;          // 非接快速标识
    public static final int EC_BIN_A = 105;         // 非接bin标识A
    public static final int EC_BIN_B = 106;         // 非接bin标识B
    public static final int EC_CDCVM = 107;         // CDCVM标识
    public static final int EC_LIMIT_NO_SIGN = 108;// 免签限额
    public static final int EC_NO_SIGN_FLAG = 109; // 免签标识

    // 消费撤销手输卡号
    public static final int pos_hand_card_number_salevoid = 110;
    // 预授权撤销手输卡号
    public static final int pos_hand_card_number_PreAuthVoid = 111;
    // 预授权完成联机手输卡号
    public static final int pos_hand_card_number_PreAuthComp_Req = 112;
    // 预授权完成离线手输卡号
    public static final int pos_hand_card_number_PreAuthComp_Ntc = 113;
    // 预授权完成撤销手输卡号
    public static final int pos_hand_card_number_PreAuthCompVoid = 114;

    // 消费撤销是否需要输入密码
    public static final int pos_input_pwd_salevoid = 115;
    // 预授权撤销是否需要密码
    public static final int pos_input_pwd_preauthvoid = 116;
    // 预授权完成（请求）是否需要输入密码
    public static final int pos_input_pwd_preauthcomp_req = 117;
}
