package activity.sign_in2.modle;

import android.content.Context;
import android.util.Log;

import com.buildpackage.modle.Field;
import com.buildpackage.utils.FieldHelper;
import com.buildpackage.utils.FieldUtils;

import java.util.List;

import base.BaseReq2;
import db.bill.DBPosSettingBill;
import tools.com.hellolibrary.hello_convert.ConvertUtils;


/**
 * 2016年9月18日 by lee for：签到请求报文
 */
public class SignInReq2 extends BaseReq2 {

	private Context mContext;

	public SignInReq2(Context pContext) {
		mContext = pContext;
	}


	/**
	 * 将16进制字符串转换为byte数组；
	 * @return
     */
	@Override
	public byte [] getBytesMsg() {
		String hexStrMsg = getHexStrMsg();
		return ConvertUtils.hexStringToByte(hexStrMsg);
	}

	/**
	 * 余额查询报文
	 */
	@Override
	public String getHexStrMsg(){
		Field lFieldInfo = FieldUtils.getFieldInfoInstance(mContext,FieldHelper.getInstance());

		//设置基本信息
		lFieldInfo.setMsgDes("签到");
		lFieldInfo.setIsNeedMac(false);
		//设置报文头
		List<Field.HeadersBean> lHeadersBeanList = lFieldInfo.getHeaders();
		lHeadersBeanList.get(1).setValue(DBPosSettingBill.getTpdu());
		lHeadersBeanList.get(3).setValue("0800");
		//设置报文体
		//开始设置个个域的值
		List<Field.BodiesBean> lReqBeanList = lFieldInfo.getBodies();
		lReqBeanList.get(2).setValue("940000");
		lReqBeanList.get(24).setValue("14");
		lReqBeanList.get(40).setValue(DBPosSettingBill.getTerminalNo());
		lReqBeanList.get(41).setValue(DBPosSettingBill.getMerchantNo());
		lReqBeanList.get(59).setValue("A00199");
		String hexMsg =FieldUtils.buildMsg(lFieldInfo,FieldHelper.getInstance());

		Log.i("vbvb","发送出去的报文的16进制字符串表示："+hexMsg);
		return hexMsg;
	}
}
