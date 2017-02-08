package tools.com.hellolibrary.helllo_my_inter;

import tools.com.hellolibrary.hello_thread.ThreadUtil;

/**
 * Created by lenovo on 2017/2/7.
 * 描述：
 */

public abstract class CardReaderTemp {

    public abstract void initCardReader();

    public abstract void startRead();

    public abstract void stopCardReader();

    public void readCard(){
        ThreadUtil.runCachedService(new Runnable() {
            @Override
            public void run() {
                initCardReader();
                startRead();
                stopCardReader();
            }
        });
    }
}
