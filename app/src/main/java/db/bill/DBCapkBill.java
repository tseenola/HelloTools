package db.bill;

import org.litepal.crud.DataSupport;

import db.table.DBCapk;

/**
 * Created by lenovo on 2017/2/5.
 * 描述：
 */

public class DBCapkBill {
    /**
     * 清空Capk表
     */
    public static void clearTable(){
        DataSupport.deleteAll(DBCapk.class);
    }

    /**
     * 插入单条Capk
     * @param pCapk
     */
    public static void inserAid(String pCapk){
        new DBCapk().insert(pCapk);
    }
}
