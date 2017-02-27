package base;

import core.CardReader;

/**
 * Created by lenovo on 2017/2/16.
 * 描述：
 */

public interface IReadCardTemp {
    /**
     * 启动卡片处理流程
     * 1.读取刷卡信息
     * 2.弹出密码键盘接收密码
     */
    void actionReadCardProcess(CardReader.OnEncryPwdFinish pOnEncryPwdFinish);
}
