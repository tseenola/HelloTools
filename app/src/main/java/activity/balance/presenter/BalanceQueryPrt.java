package activity.balance.presenter;

import com.hello.readcard.model.CardInfoModel;

import activity.balance.model.BalanceQueryReq;
import base.BaseReq;
import base.BaseSwipeCardPrt;
import db.bill.DBPosSettingBill;
import pos2.fields.F02;
import pos2.fields.F03;
import pos2.fields.F11;
import pos2.fields.F14;
import pos2.fields.F22;
import pos2.fields.F23;
import pos2.fields.F25;
import pos2.fields.F35;
import pos2.fields.F36;
import pos2.fields.F41;
import pos2.fields.F42;
import pos2.fields.F49;
import pos2.fields.F52;
import pos2.fields.F55;
import pos2.fields.F60;
import pos2.fields.F62;
import pos2.fields.F64;
import utils.SensitiveDataUtil;

/**
 * Created by lenovo on 2017/2/28.
 * 描述：
 */

public class BalanceQueryPrt extends BaseSwipeCardPrt{
    public BalanceQueryPrt() {

    }

    @Override
    public BaseReq actionDeal(CardInfoModel pCardInfoModel) {
        BalanceQueryReq lBalanceReq = new BalanceQueryReq(
                new F02(SensitiveDataUtil.hideSensitiveData(2,pCardInfoModel.getCardNo())),
                new F03("310000"),
                new F11(DBPosSettingBill.getTraceNo()),
                new F14(SensitiveDataUtil.hideSensitiveData(14,pCardInfoModel.getValidTime())),
                new F22(getField22_2(pCardInfoModel.getSwipedMode(),pCardInfoModel.getEncrypedPwd())),//new F22(getField22(pCardInfoModel.getSwipedMode(),pPinEncryStr)),
                new F23(pCardInfoModel.getCardSeqNo()),
                new F25("14"),
                new F35(SensitiveDataUtil.hideSensitiveData(35,pCardInfoModel.getTrack2())),
                new F36(SensitiveDataUtil.hideSensitiveData(36,pCardInfoModel.getTrack3())),
                new F41(DBPosSettingBill.getTerminalNo()),
                new F42(DBPosSettingBill.getMerchantNo()),
                new F49("156"),
                new F52(pCardInfoModel.getEncrypedPwd()),
                new F55(getF55ForOnlineTx()),
                new F60(SensitiveDataUtil.getEncryptionData(1,
                        new String[] {
                                pCardInfoModel.getCardNo(),
                                pCardInfoModel.getValidTime(),
                                "",
                                pCardInfoModel.getTrack2().replaceAll("=", "D"),
                                pCardInfoModel.getTrack3().replaceAll("=", "D")
                        })),
                new F62(DBPosSettingBill.getTraceNo()+DBPosSettingBill.getBatchNo()),
                new F64("")
        );
        return lBalanceReq;
    }
}
