package db.bill;

import android.content.Context;

import com.google.gson.Gson;

import java.io.InputStream;
import java.util.List;

import db.table.DBUser;
import db.table_def_val.DBUserDefVal;
import tools.com.hellolibrary.hello_string.StringUtils;

/**
 * Created by lenovo on 2017/1/22.
 * 描述：
 */

public class DBUserBill {

    /**
     * 初始化用户表
     * @return 初始化是否成功
     */
    public static boolean initDBUserTable(Context pContext){
        InputStream lInputStream = null;
        try{
            lInputStream = pContext.getAssets().open("DBUserDefVal");
        }catch (Exception pE){
            pE.printStackTrace();
        }
        String lDBUserStr = StringUtils.streamToString(lInputStream);
        DBUserDefVal lDBUserDefVal = new Gson().fromJson(lDBUserStr, DBUserDefVal.class);
        List<DBUserDefVal.DBUserDefValListBean> lDBUserDefValList = lDBUserDefVal.getDBUserDefValList();

        for(DBUserDefVal.DBUserDefValListBean lUserDefValListBean :lDBUserDefValList){
            new DBUser(lUserDefValListBean.getUserId(), lUserDefValListBean.getPasswd(), lUserDefValListBean.getLevel()).save();
        }
        return true;
    }
}
