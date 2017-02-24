package db.bill;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import db.table.DBAppParas;
import models.EmvProvider;

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

    /**
     * 初始化 Aid 参数
     */
    public static void initEmvAID() {
        List<String> aidList = new ArrayList<String>();
        List<DBAppParas> appParas = DataSupport.findAll(DBAppParas.class);
        EmvProvider emvProvider = new EmvProvider();
        if (appParas.size() > 0) {
            for (int i = 0; i < appParas.size(); i++) {
                DBAppParas paras = appParas.get(i);
                aidList.add(paras.getAID());
            }
            emvProvider.initAID(aidList.toArray(new String[aidList.size()]));
        } else {
            emvProvider.initAID(EmvProvider.AIDList);
        }
    }
}
