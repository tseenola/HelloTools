package activity.sign_in3;

import android.util.Log;

import com.buildpackage.modle.Field;
import com.buildpackage.utils.FieldHelper;
import com.buildpackage.utils.FieldUtils;

import java.util.List;

import activity.sale2.IReqTemplete;
import base.MyApplication;
import db.bill.DBPosSettingBill;
import tools.com.hellolibrary.hello_convert.ConvertUtils;

/**
 * Created by lenovo on 2017/5/9.
 * 描述：
 */

public class SignReq3 implements IReqTemplete {
    @Override
    public byte[] getBytesMsg() {
        String hexStrMsg = getHexStrMsg();
        return ConvertUtils.hexStringToByte(hexStrMsg);
    }

    @Override
    public String getHexStrMsg() {
        Field lFieldInfo = FieldUtils.getFieldInfoInstance(MyApplication.getContext(), FieldHelper.getInstance());

        //设置基本信息
        lFieldInfo.setMsgDes("签到");
        lFieldInfo.setIsNeedMac(true);
        lFieldInfo.setMacIndex(3);
        //设置报文头
        List<Field.HeadersBean> lHeadersBeanList = lFieldInfo.getHeaders();
        lHeadersBeanList.get(1).setValue(DBPosSettingBill.getTpdu());
        lHeadersBeanList.get(3).setValue("0820");
        //设置报文体
        //开始设置个个域的值
        List<Field.BodiesBean> lReqBeanList = lFieldInfo.getBodies();
        lReqBeanList.get(2).setValue("910000");
        lReqBeanList.get(10).setValue(DBPosSettingBill.getTraceNo());
        lReqBeanList.get(24).setValue("00");
        lReqBeanList.get(40).setValue(DBPosSettingBill.getTerminalNo());
        lReqBeanList.get(41).setValue(DBPosSettingBill.getMerchantNo());
        String hexMsg =FieldUtils.buildMsg(lFieldInfo,FieldHelper.getInstance());

        Log.i("vbvb","发送出去的报文的16进制字符串表示："+hexMsg);
        return hexMsg;
    }
}
