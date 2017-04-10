package base;


import com.buildpackage.model.Body_STD;

/**
 * Created by lenovo on 2017/2/28.
 * 描述：
 */

public interface IBaseSwipeCardAty {
    /**
     * 涉及到刷卡的交易成功回调
     * @param pMsg 成功提示
     * @param pBody_std 返回的报文对象
     */
    void onDealSucc(String pMsg,Body_STD pBody_std);

    /**
     * 涉及到刷卡的交易失败回调
     * @param pErrorMsg 失败提示
     * @param pBody_std 返回的失败报文对象
     */
    void onDealFail(String pErrorMsg,Body_STD pBody_std);
}
