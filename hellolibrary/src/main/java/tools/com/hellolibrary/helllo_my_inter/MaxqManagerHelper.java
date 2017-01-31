package tools.com.hellolibrary.helllo_my_inter;

import android.device.MaxqManager;

/**
 * Created by lenovo on 2017/1/31.
 * 描述：
 */

public class MaxqManagerHelper implements IUrovoSDK{

    protected MaxqManager mMaxqManager;

    /**
     * 初始化安全芯片
     * @return
     */
    protected boolean initMaxqManager() {
        int ret = 0;
        if (mMaxqManager == null) {
            mMaxqManager = new MaxqManager();
            ret = mMaxqManager.open();
        }
        return ret == 0;
    }

    /**
     * 关闭安全芯片
     * @return
     */
    protected boolean closeMaxqManager() {
        int ret = 0;
        if (mMaxqManager != null) {
            ret = mMaxqManager.close();
        }
        return ret == 0;
    }
}
