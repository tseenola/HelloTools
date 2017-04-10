package activity.sign_in.presenter;


import com.buildpackage.model.Body_STD;

/**
 * Created by lenovo on 2017/1/5.
 * 描述：
 */

public interface ISignInPrt {
    /**
     * 执行签到
     */
    void actionSign();

    /**
     * 1.同步批次号
     * 2.同步流水号
     * 3.写入工作密钥
     * 4.同步签到状态到数据库（是否已经签到）
     */
    void syncParaWithServiceAndDB(Body_STD pBody_std);
}
