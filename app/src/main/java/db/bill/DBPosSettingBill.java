package db.bill;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import org.litepal.crud.DataSupport;

import java.io.InputStream;
import java.util.List;

import base.MyApplication;
import db.table.DBPosSetting;
import db.table_def_val.DBPosSettingDefVal;
import tools.com.hellolibrary.hello_string.StringUtils;

/**
 * Created by lenovo on 2017/1/22.
 * 描述：
 */

public class DBPosSettingBill {

    /**
     * 将一个数据库中还不存在的ｋｅｙ动态添加到数据库中。
     * @return
     */
    public static boolean addNewRecord(String parmName, String parmValue){
        InputStream lInputStream = null;
        try{
            lInputStream = MyApplication.getApp().getAssets().open("DBPosSettingDefVal");
        }catch (Exception pE){
            pE.printStackTrace();
        }
        String lDBPosSettingStr = StringUtils.streamToString(lInputStream);
        DBPosSettingDefVal lDBPosSettingDefVal = new Gson().fromJson(lDBPosSettingStr, DBPosSettingDefVal.class);
        List<DBPosSettingDefVal.DBPosSettingDefValListBean> lDBPosSettingDefValList = lDBPosSettingDefVal.getDBPosSettingDefValList();
        for(DBPosSettingDefVal.DBPosSettingDefValListBean lDBPosSettingDefValListBean:lDBPosSettingDefValList){
            if(TextUtils.equals(lDBPosSettingDefValListBean.getParmName(),parmName)){
                return new DBPosSetting(lDBPosSettingDefValListBean.getKeyIndex(), lDBPosSettingDefValListBean.getParmName(), parmValue, lDBPosSettingDefValListBean.getParmMemo()).save();
            }
        }
        return false;
    }
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
        setBatch(pBatch);
        setTraceNo(pTrace);
    }

    /**
     * 设置流水号
     * @param pTrace
     */
    public static void setTraceNo(String pTrace){
        if(pTrace.length()!=6){
            throw new IllegalArgumentException("传入的流水号不合法,长度错误！");
        }
        setParamValue(1,"iNowTraceNo",pTrace);
    }

    /**
     * 流水号加1
     */
    public static void tranceNoAddOne() {
        int tranceNo = Integer.valueOf(getTraceNo());
        setTraceNo(StringUtils.fillContentBy(StringUtils.Dir.left,"0",tranceNo+1+"",6));
    }

    /**
     * 设置批次号
     * @param pBatch
     */
    public static void setBatch(String pBatch){
        if(pBatch.length()!=6){
            throw new IllegalArgumentException("传入的批次号不合法");
        }
        ContentValues batchVal = new ContentValues();
        batchVal.put("parmValue", pBatch);
        DataSupport.updateAll(DBPosSetting.class, batchVal, "keyIndex=? and parmName=?","1", "iNowBatchNo");
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
     * @return 返回5位数的流水号
     */
    public static String getTraceNo(){
        String traceNo = "";
        traceNo = StringUtils.fillContentBy(StringUtils.Dir.left,"0",getParamValue(1,"iNowTraceNo"),5);
        if(Integer.valueOf(traceNo)>=999999L){
            throw new IllegalStateException("流水号不足，请先结算！");
        }
        return traceNo;
    }


    /**
     * 获取当前批次号
     * @return 返回5位字符串批次号
     */
    public static String getBatchNo(){
        String batchNo = "";
        try {
            batchNo = StringUtils.fillContentBy(StringUtils.Dir.left,"0",getParamValue(1,"iNowBatchNo"),5);
        }catch (Exception pE){
            pE.printStackTrace();
        }
        return batchNo;
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
                //new DBPosSetting(keyIndex, parmName, parmValue, "").save();
                addNewRecord(parmName, parmValue);
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
