package activity.sale2;

import android.app.Activity;
import android.view.View;

/**
 * Created by lenovo on 2017/4/24.
 * 描述：
 */

public abstract class Process implements OnProcessListener {
    public static boolean isGetAmtSucc = false;
    protected View mView;
    protected Activity mContext;

    public Process(View pView,Activity pContext){
        mView = pView;
        mContext = pContext;
    }

    /**
     * 执行消费流程
     * 1.获取金额
     * 2.弹出读卡界面等待用于插卡或者挥卡
     * 3.弹出密码输入框等待输入密码
     * 4.组包
     * 5.发包
     * 6.收包
     * 7.解包
     * 8.检查包
     * 9.打印
     */
    public void actionSale(){
        new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    getAmt(mView,mContext);

                    if (isGetAmtSucc){

                    }
                    getCardInfo(this);
                    getPwd(this);
                    packMsg(this);
                }
            }
        }.start();


    }

    /**
     * 1.获取金额
     * @return
     */
    public abstract void getAmt(View pView,Activity pContext);



    /**
     * 2.弹出读卡界面等待用于插卡或者挥卡
     * @return
     */
    public abstract boolean getCardInfo(OnProcessListener pOnProcessListener);

    /**
     * 3.弹出密码输入框等待输入密码
     * @return
     */
    public abstract boolean getPwd(OnProcessListener pOnProcessListener);


    /**
     * 4.组包
     * @return
     */
    public abstract boolean packMsg(OnProcessListener pOnProcessListener);


    /**
     * 5.发包
     * @return
     */
    //public abstract boolean sendMsg();


    /**
     * 6.收包
     * @return
     */
    //public abstract byte [] rcvMsg();


    /**
     * 7.解包
     * @return
     */
    //public abstract byte [] unPack();


    /**
     * 8.检查包
     * @return
     */
    //public abstract boolean checkMsg();

    /**
     * 9.打印
     * @return
     */
    //public abstract boolean print();

}
