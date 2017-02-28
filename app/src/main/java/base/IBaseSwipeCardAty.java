package base;

import pos2.model.Body_STD;

/**
 * Created by lenovo on 2017/2/28.
 * 描述：
 */

public interface IBaseSwipeCardAty {
    void onDealSucc(String pMsg,Body_STD pBody_std);
    void onDealFail(String pErrorMsg,Body_STD pBody_std);
}
