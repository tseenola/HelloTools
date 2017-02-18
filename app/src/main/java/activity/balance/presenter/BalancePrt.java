package activity.balance.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import activity.balance.view.IBalanceAty;
import base.ReadCardTemp;
import core.CardReader;
import models.CardInfoModel;

/**
 * Created by lenovo on 2017/2/5.
 * 描述：
 */
public class BalancePrt extends ReadCardTemp implements IBalancePrt{

    private final IBalanceAty mView;
    private Context mContext;
    public BalancePrt(IBalanceAty pView) {
        mContext = (Context) pView;
        mView = pView;
    }


    /*@Override
    public void actionReadCard() {
        new CardReader().readCard(new CardReader.OnReadCardFinish() {
            @Override
            public void onReadCardSucc(final CardInfoModel pPardInfo) {
                CardReader.checkCardThreadIsRun = false;
                ThreadUtil.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mView.onReadCardSucc(pPardInfo);
                    }
                });
            }

            @Override
            public void onReadCardFail(final String pFailMsg) {
                ThreadUtil.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mView.onReadCardFail(pFailMsg);
                    }
                });
            }
        });
    }*/

    @Override
    public void actionQueryBalance() {
        actionReadCardProcess(this);



    }


    @Override
    public void onReadCardSucc(CardInfoModel pPardInfo) {
        CardReader.checkCardThreadIsRun = false;
        Log.i("vbvb","读卡成功："+pPardInfo.toString());
        inputTradePwdEntry(pPardInfo);
    }

    @Override
    public void onReadCardFail(String pFailMsg) {
        Log.i("vbvb","读卡失败：");
    }

    @Override
    public void onEncryPwdSucc(CardInfoModel pCardInfoModel, String pPinEncryStr) {
        Toast.makeText(mContext, "读卡且获取密码成功："+pCardInfoModel.toString()+" 密码为："+pPinEncryStr, Toast.LENGTH_SHORT).show();
        Log.i("vbvb","读卡且获取密码成功："+pCardInfoModel.toString()+" 密码为："+pPinEncryStr);
        /*BalanceReq lBalanceReq = new BalanceReq(
                new F02(SensitiveDataUtil.hideSensitiveData(2,pCardInfoModel.getCardNo())),
                new F03("310000"),
                new F11(DBPosSettingBill.getTraceNo()+""),
                new F14(SensitiveDataUtil.hideSensitiveData(14,pCardInfoModel.getValidTime())),
                new F22(pCardInfoModel.getCardSeqNo()),
                new F23(""),
                new F25("14"),
                new F35(SensitiveDataUtil.hideSensitiveData(35,pCardInfoModel.getTrack2())),
                new F36(SensitiveDataUtil.hideSensitiveData(36,pCardInfoModel.getTrack3())),
                new F41(DBPosSettingBill.getTerminalNo()),
                new F42(DBPosSettingBill.getMerchantNo()),
                new F49("156"),
                new F52(pPinEncryStr),
                new F55( ),
                new F60(SensitiveDataUtil.getEncryptionData(1,
                        new String[] {
                                pCardInfoModel.getCardNo(),
                                pCardInfoModel.getValidTime(),
                                "",
                                pCardInfoModel.getTrack2().replaceAll("=", "D"),
                                pCardInfoModel.getTrack3().replaceAll("=", "D")
                        })),
                new F62(DBPosSettingBill.getTraceNo()),
                new F64("")
        );

        lBalanceReq.actionDeal(mContext, "0200", "02,03,11,14,22,23,25,35,36,41,42,49,52,55,60,62,64", lBalanceReq, new BaseReq.ResultListener() {
            @Override
            public void succ(Body_STD pBody_std) {

            }

            @Override
            public void fail(Body_STD pBody_std) {

            }
        });*/
    }

    @Override
    public void onEncryPwdFail(String pErroMsg) {
        Log.i("vbvb","读卡且获取密码失败："+pErroMsg);
    }
}
