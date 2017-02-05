package db.bill;

import org.litepal.crud.DataSupport;

import db.table.DBAppParas;

/**
 * Created by lenovo on 2017/2/5.
 * 描述：
 */

public class DBAppParasBill {

    /**
     * 清空AppParas表
     */
    public static void clearTable(){
        DataSupport.deleteAll(DBAppParas.class);
    }

    /**
     * 插入Aid
     * @param pAid
     */
    public static void inserAid(String pAid){
        new DBAppParas().insert(pAid);
    }
}
