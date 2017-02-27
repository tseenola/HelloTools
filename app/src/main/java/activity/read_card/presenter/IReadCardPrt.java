package activity.read_card.presenter;

import models.CardInfoModel;

/**
 * Created by lenovo on 2017/2/24.
 * 描述：
 */

public interface IReadCardPrt {
    void actionReadCardProcess();

    void actionReadPwd(CardInfoModel pPardInfo);
}
