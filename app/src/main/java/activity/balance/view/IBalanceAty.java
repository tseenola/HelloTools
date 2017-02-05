package activity.balance.view;

/**
 * Created by lenovo on 2017/2/5.
 * 描述：
 */

public interface IBalanceAty {
    /**
     * 查询成功返回余额，余额单位为分
     * @param pAmt
     */
    void onQueryBalanceSucc(String pAmt);

    /**
     * 查询失败返回失败原因
     * @param pErrMsg 失败原因
     */
    void onQueryBalanceFail(String pErrMsg);
}
