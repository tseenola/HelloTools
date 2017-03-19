package db.bill;

import com.urovo.poscommon.models.EmvProvider;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 初始化 capk 表
     */
    public static void initEmvCapk() {
        List<String> capkList = new ArrayList<String>();
        List<DBCapk> capks = DataSupport.findAll(DBCapk.class);

        EmvProvider emvProvider = new EmvProvider();
        if (capks.size() > 0) {
            for (int i = 0; i < capks.size(); i++) {
                DBCapk capk = capks.get(i);
                capkList.add(capk.getRID());
            }
            emvProvider.initCAPK(capkList.toArray(new String[capkList.size()]));
        } else {
            emvProvider.initCAPK(EmvProvider.CapkList);
        }
    }

}
