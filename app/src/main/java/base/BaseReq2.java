package base;

import android.content.Context;

import com.buildpackage.modle.Field;
import com.buildpackage.utils.FieldHelper;
import com.buildpackage.utils.FieldUtils;

import db.bill.DBPosSettingBill;
import tools.com.hellolibrary.hello_thread.ThreadUtil;

/**
 * Created by lenovo on 2017/4/6.
 * 描述：
 */

public abstract class BaseReq2 extends BaseReq {

    private Context mContext;

    public void actionDeal2(final Context pContext, final byte [] bytesMsg, final ResultListener pResultListener) {
        mContext = pContext;
        final String lIp = DBPosSettingBill.getIp();
        final int lPort = DBPosSettingBill.getPort();
        final int lTime = DBPosSettingBill.getSocketTimeOut();
        ThreadUtil.runFixedService(new Runnable() {
            @Override
            public void run() {
                unPack("010F600000000808102038000002D0000E9400000000001813590122303031323031515A38513130333130303034383134313334371662646262643264376233633962396136003301179600641C1ADA22BEF375639B45E7F2BEF375639B45E7F2BEF375639B45E7F200123130303030303230303030300152313131313131202020203232323232322020202033333333333320202020202020202020202020202020202020202020202020202020202020202020B9ABD6F7B7D8B4E4CEA2B4F3CFC3202020202020202020202020202020202020202020202020202037333932FF00FF50FF50FF50FCC0FF00FE50FE508000BF5000000000000303031003000099999999000001000000010100000000");//签到收到的成功报文

                /*SystemClock.sleep(500);
                //发包
                sendPack(pContext, bytesMsg, lIp, lPort, lTime);
                //流水加1
                tranceNoAddOne();
                //收包
                String rcvedHexMsg = rcvPack();
                //解包
                final Object[] unPackResult = unPack(rcvedHexMsg);
                //检包
                final boolean isDealSucc = chkPack(unPackResult);

                ThreadUtil.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (isDealSucc) {
                            pResultListener.succ((Body_STD) unPackResult[1]);
                        } else {
                            pResultListener.fail((Body_STD) unPackResult[1]);
                        }
                    }
                });*/
            }
        },1);
    }

    /**
     * 将收到的16进制字符串报文转换为对象
     * @param pRcvedHexMsg
     * @return
     */
    @Override
    public Object[] unPack(String pRcvedHexMsg) {
        Field lField = FieldUtils.parseMsg(mContext,pRcvedHexMsg,FieldHelper.getInstance());
        return super.unPack(pRcvedHexMsg);
    }

    public abstract byte [] getBytesMsg();

    public abstract String getHexStrMsg();
}
