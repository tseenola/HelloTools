package base;

import android.content.Context;

import models.CardInfoModel;
import models.MsgType;

/**
 * Created by lenovo on 2017/2/28.
 * 描述：
 */

public interface IBaseSwipeCardPrt {
    void actionCardDeal(Context pContext, CardInfoModel pCardInfoModel, MsgType pMsgType,IBaseSwipeCardAty pIBaseSwipeCardAty);
}
