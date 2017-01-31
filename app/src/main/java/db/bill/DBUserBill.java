package db.bill;

import db.table.DBUser;

/**
 * Created by lenovo on 2017/1/22.
 * 描述：
 */

public class DBUserBill {

    /**
     * 初始化用户表
     * @return 初始化是否成功
     */
    public static boolean initDBUserTable(){
        // 管理员
        return new DBUser("99", "12345678", "1").save() &&
        // 主管
        new DBUser("00", "112233", "2").save() &&
        // 操作员
        new DBUser("01", "0000", "3").save() &&
        new DBUser("02", "0000", "3").save() &&
        new DBUser("03", "0000", "3").save();
    }

}
