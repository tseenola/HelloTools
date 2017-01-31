package db.bill;

import android.content.ContentValues;

import org.litepal.crud.DataSupport;

import base.ConfigValues;
import base.Constants;
import db.table.DBPosSetting;

/**
 * Created by lenovo on 2017/1/22.
 * 描述：
 */

public class DBPosSettingBill {

    /**
     * 初始化Pos参数表
     * @return 是否初始化成功
     */
    public static boolean initPosSettingTable(){
        boolean result = false;
        try {
            new DBPosSetting(Constants.PK_INDEX_NORMAL, "iMKIndex", "1", "主密钥索引").save();
            new DBPosSetting(Constants.PK_INDEX_NORMAL, "iMKGap", "2", "暂不用到").save();
            new DBPosSetting(Constants.PK_INDEX_NORMAL, "iMACKIndex", "3", "MAC密钥索引").save();
            new DBPosSetting(Constants.PK_INDEX_NORMAL, "iEncryptIndex", "4", "磁道加密密钥索引").save();
            new DBPosSetting(Constants.PK_INDEX_NORMAL, "iPinKIndex", "5", "PIN密钥索引").save();

            new DBPosSetting(Constants.PK_INDEX_NORMAL, "iNowTraceNo", ConfigValues.DEFAULT_COMMON_TRACENO, "凭证号").save();
            new DBPosSetting(Constants.PK_INDEX_NORMAL, "iNowBatchNo", ConfigValues.DEFAULT_COMMON_BATCHNO, "批次号").save();
            new DBPosSetting(Constants.PK_INDEX_NORMAL, "iCommWaitTime", ConfigValues.DEFAULT_COMMON_COMM_TIMEOUT, "超时时间").save();
            new DBPosSetting(Constants.PK_INDEX_NORMAL, "iReReverseTimes", ConfigValues.DEFAULT_COMMON_REVERSE_TIMES, "冲正次数").save();

            new DBPosSetting(Constants.PK_INDEX_NORMAL, "sTermId", ConfigValues.DEFAULT_NORMAL_TID, "终端号").save();
            new DBPosSetting(Constants.PK_INDEX_NORMAL, "sUnitNum", ConfigValues.DEFAULT_NORMAL_MID, "商户号").save();
            new DBPosSetting(Constants.PK_INDEX_NORMAL, "sUnitChnName", ConfigValues.DEFAULT_NORMAL_MNAME, "商户名").save();

            new DBPosSetting(Constants.PK_INDEX_NORMAL, "sIPAddr", ConfigValues.DEFAULT_NORMAL_ADDR, "IP地址").save();
            new DBPosSetting(Constants.PK_INDEX_NORMAL, "sIPport", ConfigValues.DEFAULT_NORMAL_PORT, "端口号").save();
            new DBPosSetting(Constants.PK_INDEX_NORMAL, "sTPDU", ConfigValues.DEFAULT_NORMAL_TPDU, "TPDU").save();
            new DBPosSetting(Constants.PK_INDEX_NORMAL, "bElecSignFlag", ConfigValues.DEFAULT_NORMAL_ELEC_FLAG, "电子签名标识").save();
            new DBPosSetting(Constants.PK_INDEX_NORMAL, "bClearFlag", ConfigValues.DEFAULT_NORMAL_CLEAR_FLAG, "交行二次清分开关").save();
            new DBPosSetting(Constants.PK_INDEX_NORMAL, "sClearID", ConfigValues.DEFAULT_NORMAL_CLEAR_ID, "交行二次清分标识").save();

            new DBPosSetting(Constants.PK_INDEX_NORMAL, "fNeedDLEmvParas", ConfigValues.DEFAULT_COMMON_DOWNLOAD_EVM_PARM, "需要下载EMV参数").save();
            new DBPosSetting(Constants.PK_INDEX_NORMAL, "fNeedDLEmvPublicKeys", ConfigValues.DEFAULT_COMMON_DOWNLOAD_EVM_KEY, "需要下载公钥").save();
            new DBPosSetting(Constants.PK_INDEX_NORMAL, "iTicketNum", ConfigValues.DEFAULT_COMMON_TICKET_NUM, "小票张数").save();
            new DBPosSetting(Constants.PK_INDEX_NORMAL, "isSign", ConfigValues.DEFAULT_COMMON_SIGN_FLAG, "是否已签到状态").save();
            new DBPosSetting(Constants.PK_INDEX_NORMAL, "lastLoginTime", ConfigValues.DEFAULT_COMMON_LAST_LOGIN_TIME, "最后一次签到时间").save();
            new DBPosSetting(Constants.PK_INDEX_NORMAL, "iMaxRefundAmt", ConfigValues.DEFAULT_COMMON_MAX_REFUND_AMT, "最大退货金额").save();
            new DBPosSetting(Constants.PK_INDEX_NORMAL, "iMaxTradeCount", ConfigValues.DEFAULT_COMMON_MAX_TRADE_COUNT, "最大交易笔数").save();

            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = false;
        }
        return result;
    }

    /**
     * 签到以后同步批次号和流水号
     *
     * @param pBatch 批次号
     * @param pTrace 流水号
     */
    public static void syncBatchAndTrace(String pBatch, String pTrace) {
        // 如果存在数据，则更新
        ContentValues batchVal = new ContentValues();
        batchVal.put("parmValue", pBatch);
        DataSupport.updateAll(DBPosSetting.class, batchVal, "keyIndex=? and parmName=?","1", "iNowBatchNo");

        ContentValues traceVal = new ContentValues();
        traceVal.put("parmValue", pTrace);
        DataSupport.updateAll(DBPosSetting.class, traceVal, "keyIndex=? and parmName=?","1", "iNowTraceNo");
    }
}
