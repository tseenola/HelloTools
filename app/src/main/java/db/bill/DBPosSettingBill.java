package db.bill;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import org.litepal.crud.DataSupport;

import java.io.InputStream;
import java.util.List;

import db.table.DBPosSetting;
import db.table_def_val.DBPosSettingDefVal;
import tools.com.hellolibrary.hello_string.StringUtils;

/**
 * Created by lenovo on 2017/1/22.
 * 描述：
 */

public class DBPosSettingBill {
    /**
     * 初始化Pos参数表
     * @return 是否初始化成功
     */
    public static boolean initPosSettingTable(Context pContext) {
        InputStream lInputStream = null;
        try{
            lInputStream = pContext.getAssets().open("DBPosSettingDefVal");
        }catch (Exception pE){
            pE.printStackTrace();
        }
        String lDBPosSettingStr = StringUtils.streamToString(lInputStream);
        DBPosSettingDefVal lDBPosSettingDefVal = new Gson().fromJson(lDBPosSettingStr, DBPosSettingDefVal.class);
        List<DBPosSettingDefVal.DBPosSettingDefValListBean> lDBPosSettingDefValList = lDBPosSettingDefVal.getDBPosSettingDefValList();

        for(DBPosSettingDefVal.DBPosSettingDefValListBean lDefValBean :lDBPosSettingDefValList){
            new DBPosSetting(lDefValBean.getKeyIndex(), lDefValBean.getParmName(), lDefValBean.getParmValue(), lDefValBean.getParmMemo()).save();
        }
        return true;
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

    /**
     * 获得pin密钥索引
     * @return
     */
    public static int getPinKeyIndex(){
        int pinKeyIndex = 0;
        try {
            pinKeyIndex = Integer.valueOf(getParamValue(1,"iPinKIndex"));
        }catch (Exception pE){
            pE.printStackTrace();
        }
        return pinKeyIndex;
    }

    /**
     * 获得磁道密钥索引
     * @return
     */
    public static int getTrackKeyIndex(){
        int trackIndex = 0;
        try {
            trackIndex = Integer.valueOf(getParamValue(1,"iEncryptIndex"));
        }catch (Exception pE){
            pE.printStackTrace();
        }
        return trackIndex;
    }

    /**
     * 获得主密钥索引
     * @return
     */
    public static int getMasterKeyIndex(){
        int masterKeyIndex = 0;
        try {
            masterKeyIndex = Integer.valueOf(getParamValue(1,"iMKIndex"));
        }catch (Exception pE){
            pE.printStackTrace();
        }
        return masterKeyIndex;
    }

    /**
     * 获取Mac密钥索引
     * @return
     */
    public static int getMacKeyIndex(){
        int macKeyIndex = 0;
        try {
            macKeyIndex = Integer.valueOf(getParamValue(1,"iMACKIndex"));
        }catch (Exception pE){
            pE.printStackTrace();
        }
        return macKeyIndex;
    }

    /**
     * 获取当前凭证号（流水）
     * @return
     */
    public static int getTraceNo(){
        int traceNo = 0;
        try {
            traceNo = Integer.valueOf(getParamValue(1,"iNowTraceNo"));
        }catch (Exception pE){
            pE.printStackTrace();
        }
        return traceNo;
    }


    /**
     * 设置不需要下载Aid参数
     * @param pVal 0不需要，1需要
     */
    public static void setNoNeedDownAid(String pVal) {
        setParamValue(1,"fNeedDLEmvParas",pVal);
    }

    /**
     * 设置是否需需要下载Capk
     * @param pVal 0不需要，1需要
     */
    public static void setNoNeedDownCapk(String pVal) {
        setParamValue(1,"fNeedDLEmvPublicKeys",pVal);
    }


    /**
     * 设置签到状态
     * @param pB
     */
    public static void setSignInStatus(boolean pB) {
        setParamValue(1,"isSign",pB?"1":"0");
    }

    /**
     * 获取tpdu
     */
    public static String getTpdu(){
        return getParamValue(1,"sTPDU");
    }

    /**
     * 获取端口
     * @return
     */
    public static int getPort(){
        return Integer.valueOf(getParamValue(1,"sIPport"));
    }

    /**
     * 获取ip地址
     * @return
     */
    public static String getIp(){
        return getParamValue(1,"sIPAddr");
    }

    /**
     * 获取网络超时时间
     * @return
     */
    public static int getSocketTimeOut(){
        return Integer.valueOf(getParamValue(1,"iCommWaitTime"));
    }


    /**
     * 获取终端号
     * @return
     */
    public static String getTerminalNo(){
        return getParamValue(1,"sTermId");
    }

    /**
     * 获取商户号
     * @return
     */
    public static String getMerchantNo(){
        return getParamValue(1,"sUnitNum");
    }

    /**
     * 获取参数值
     */
    private static String getParamValue(int keyIndex, String parmName) {
        String parmValue = "";
        try {
            List<DBPosSetting> dbPosSettingList = DataSupport.where("keyIndex=? and parmName=?", keyIndex + "", parmName + "").find(DBPosSetting.class);
            if (dbPosSettingList == null) {
                parmValue = "";
            } else {
                if (dbPosSettingList.size() == 0) {
                    parmValue = "";
                } else {
                    DBPosSetting dbPosSetting = dbPosSettingList.get(0);
                    if (dbPosSetting != null) {
                        parmValue = dbPosSetting.getParmValue();
                    } else {
                        parmValue = "";
                    }
                }
            }
        } catch (Exception ex) {
            Log.e("ConfigUtil", ex.getMessage(), ex);
            parmValue = "";
        }
        return parmValue;
    }


    /**
     * 设置参数值 ConfigUtil.setParamValue(keyIndex, "iNowTraceNo", recvISO8583.szField62.substring(0, 6));
     */
    public static boolean setParamValue(int keyIndex, String parmName, String parmValue) {
        boolean bResult = false;
        try {
            List<DBPosSetting> dbPosSettingList = DataSupport.where("keyIndex=? and parmName=?", keyIndex + "", parmName).find(DBPosSetting.class);
            if (dbPosSettingList == null || dbPosSettingList.size() == 0) {
                // 如果不存在数据，则新增
                new DBPosSetting(keyIndex, parmName, parmValue, "").save();
            } else {
                // 如果存在数据，则更新
                ContentValues values = new ContentValues();
                values.put("parmValue", parmValue);
                DataSupport.updateAll(DBPosSetting.class, values, "keyIndex=? and parmName=?", keyIndex + "", parmName);
            }
            bResult = true;
        } catch (Exception ex) {
            bResult = false;
        }
        return bResult;
    }

}
