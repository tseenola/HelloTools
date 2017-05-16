package activity.sale2;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.buildpackage.modle.Field;
import com.buildpackage.utils.FieldHelper;
import com.buildpackage.utils.FieldUtils;
import com.hello.readcard.enumm.SwipedMode;
import com.hello.readcard.model.CardInfoModel;
import com.jniexport.UROPElibJni;

import java.util.List;

import base.MyApplication;
import db.bill.DBPosSettingBill;
import tools.com.hellolibrary.hello_convert.ConvertUtils;

/**
 * Created by lenovo on 2017/5/3.
 * 描述：
 */

public class SaleReq implements IReqTemplete{

    private final Context mContext;
    private CardInfoModel mCardInfoModel;

    public SaleReq(Context pContext) {
        mContext = pContext;
    }

    @Override
    public byte[] getBytesMsg() {
        String hexStrMsg = getHexStrMsg();
        return ConvertUtils.hexStringToByte(hexStrMsg);
    }

    @Override
    public String getHexStrMsg() {
        mCardInfoModel = MyApplication.getApp().getCardInfoModel();

        Field lFieldInfo = FieldUtils.getFieldInfoInstance(mContext, FieldHelper.getInstance());
        //设置基本信息
        lFieldInfo.setMsgDes("消费");
        lFieldInfo.setIsNeedMac(true);
        lFieldInfo.setMacIndex(3);
        //设置报文头
        List<Field.HeadersBean> lHeadersBeanList = lFieldInfo.getHeaders();
        lHeadersBeanList.get(1).setValue(DBPosSettingBill.getTpdu());
        lHeadersBeanList.get(3).setValue("0200");
        //设置报文体
        //开始设置个个域的值
        List<Field.BodiesBean> lReqBeanList = lFieldInfo.getBodies();
        lReqBeanList.get(1).setValue(mCardInfoModel.getCardNo());
        lReqBeanList.get(2).setValue("000000");
        lReqBeanList.get(3).setValue(MyApplication.getApp().getGetAmtFinishMessage().getAmt());
        lReqBeanList.get(10).setValue(DBPosSettingBill.getTraceNo());
        lReqBeanList.get(13).setValue(mCardInfoModel.getValidTime());
        lReqBeanList.get(21).setValue(getField22_2(mCardInfoModel.getSwipedMode(),mCardInfoModel.getEncrypedPwd()));
        lReqBeanList.get(22).setValue(mCardInfoModel.getCardSeqNo());
        lReqBeanList.get(24).setValue("00");
        lReqBeanList.get(34).setValue(mCardInfoModel.getTrack2());
        lReqBeanList.get(35).setValue(mCardInfoModel.getTrack3());
        lReqBeanList.get(40).setValue(DBPosSettingBill.getTerminalNo());
        lReqBeanList.get(41).setValue(DBPosSettingBill.getMerchantNo());
        lReqBeanList.get(48).setValue("156");
        lReqBeanList.get(51).setValue(mCardInfoModel.getEncrypedPwd());
        lReqBeanList.get(52).setValue("2600000000000000");
        lReqBeanList.get(54).setValue(getF55ForOnlineTx());
        lReqBeanList.get(59).setValue("010000");
        lReqBeanList.get(61).setValue(DBPosSettingBill.getBatchNo());
        String hexMsg =FieldUtils.buildMsg(lFieldInfo,FieldHelper.getInstance());
        Log.i("vbvb","发送出去的报文的16进制字符串表示："+hexMsg);
        return hexMsg;
    }

    /**
     * 获取IC卡的发送数据,是在报文上送时，从这里取出55域
     * @return
     */
    public String getF55ForOnlineTx() {
        String str = "";
        int[] IccDatasLen = new int[2];
        byte[] ICCDatas = new byte[256];
        byte[] ICCDatasAsc = new byte[1024];

        int get55Result = UROPElibJni.GetF55ForOnlineTx(ICCDatas, IccDatasLen);
        if (IccDatasLen[0] > 512)
            IccDatasLen[0] = 512;

        if (IccDatasLen[0] > 0) {
            int Bcdlen = IccDatasLen[0];
            ICCDatasAsc = new byte[Bcdlen * 2];
            ConvertUtils.BcdToAsc(ICCDatasAsc, ICCDatas, Bcdlen * 2);

            str = new String(ICCDatasAsc);
            Log.i("vbvb","Ic卡数据域 : "+str);
            return str;
        } else {
            Log.i("vbvb","Ic卡数据域 : ");
            return "";
        }
    }

    public String getField22_2(SwipedMode pSwipedMode, String sPINData) {
        String str1 = "";
        if(pSwipedMode == SwipedMode.NO_SWIPE_INSERT) {
            str1 = "001";
        } else if (pSwipedMode == SwipedMode.CARD_SWIPED) {
            str1 = "002";
        } else if (pSwipedMode == SwipedMode.CARD_INSERTED) {
            str1 = "005";
        } else if (pSwipedMode == SwipedMode.CLCARD_SWIPED) {
            str1 = "007";
        }
        if (TextUtils.isEmpty(sPINData)) {
            str1 += "2";
        } else {
            str1 += "1";
        }
        return str1;
    }
}
