package activity.balance.presenter;

import base.IReadCardTemp;

/**
 * Created by lenovo on 2017/2/5.
 * 描述：
 */

public interface IBalancePrt extends IReadCardTemp{

    /**
     * 执行余额查询
     */
    void actionQueryBalance();
}
