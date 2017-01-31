package base;


import android.content.Context;
import android.util.Log;

import java.lang.reflect.Field;

import pos.IPosTempTemplet;
import pos2.constant.Constant;
import pos2.model.BaseField;
import pos2.model.Body_STD;
import pos2.model.Header_STD;
import pos2.utils.MsgUtils;
import tools.com.hellolibrary.hello_convert.ConvertUtils;
import tools.com.hellolibrary.hello_socket.SocketUtils;
import tools.com.hellolibrary.hello_string.StringUtils;
import tools.com.hellolibrary.hello_thread.ThreadUtil;

import static tools.com.hellolibrary.hello_socket.SocketUtils.initSocket;
import static tools.com.hellolibrary.hello_socket.SocketUtils.revMsg;

/**
 * 报文请求基础类，采用模板方法模式
 */
public abstract class  BaseReq implements IPosTempTemplet{
	public String mMesType;
	public String mBitMap;

	@Override
	public void actionDeal(final Context pContext, final String pIp, final int pPort, final int pTime, final String pTpdu, final String pDealType, final String pBitMapStr, final BaseReq pDealReq, final ResultListener pResultListener) {
		ThreadUtil.runCachedService(new Runnable() {
			@Override
			public void run() {
				/*byte sendMsgByte [] = pack(pTpdu,pDealType,pBitMapStr,pDealReq);//组包
				sendPack(pContext, sendMsgByte, pIp, pPort, pTime);//发包
				String rcvedHexMsg = rcvPack();//收包
				final Object [] unPackResult = unPack(rcvedHexMsg);//解包*/
				final Object [] unPackResult = unPack("010F600000000808102038000002D0000E9400000000001813590122303031323031515A38513130333130303034383134313334371662646262643264376233633962396136003301179600641C1ADA22BEF375639B45E7F2BEF375639B45E7F2BEF375639B45E7F200123130303030303230303030300152313131313131202020203232323232322020202033333333333320202020202020202020202020202020202020202020202020202020202020202020B9ABD6F7B7D8B4E4CEA2B4F3CFC3202020202020202020202020202020202020202020202020202037333932FF00FF50FF50FF50FCC0FF00FE50FE508000BF5000000000000303031003000099999999000001000000010100000000");//签到收到的成功报文
				//final Object [] unPackResult = unPack("005E600000000808102000000002D10000900000303031323031515A3851313033313030303438313431333437166264626264326437623363396239613600323635354541363238434636323538354636353545413632384346363235383546");//主密钥下载收到的成功报文
				//final Object [] unPackResult = unPack("005F600000000808102020000002D00003920000000002303031323031515A38513130333130303034383134313334371662646262643264376233633962396136002212E0E0C801562200040202020156015601000001000CE8C100E135A5A203");//IC卡终端参数下载
				//final Object [] unPackResult = unPack("007F600000000808102020000002D00003990000100013303031323031515A38513130333130303034383134313334371662646262643264376233633962396136005401A0000000651010FFFFFFFFFFFFFFFFFF020000FC602428000010000000FC60ACF8000000000005000100000000001090109F3704006BB9753DC988387C");//aid下载
				//final Object [] unPackResult = unPack("00FD600000000808102020000002D00003930000100001303031323031515A38513130333130303034383134313334371662646262643264376233633962396136018001A00000000307010190A89F25A56FA6DA258C8CA8B40427D927B4A1EB4D7EA326BBB12F97DED70AE5E4480FC9C5E8A972177110A1CC318D06D2F8F5C4844AC5FA79A4DC470BB11ED635699C17081B90F1B984F12E92C1C529276D8AF8EC7F28492097D8CD5BECEA16FE4088F6CFAB4A1B42328A1B996F9278B0B7E3311CA5EF856C2F888474B83612A82E4E00D0CD4069A6783140433D50725F000003B4BC56CC4E88324932CBC643D6898F6FE593B172171231361DCC2A6237598B");//认证中心公钥下载
				final boolean isDealSucc = chkPack(unPackResult);//检包
				ThreadUtil.runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (isDealSucc){
							pResultListener.succ((Body_STD) unPackResult[1]);
						}else{
							pResultListener.fail((Body_STD) unPackResult[1]);
						}
					}
				});
			}
		});
	}

	@Override
	public byte[] pack(String pTpdu, String pDealType, String pBitMapStr, BaseReq pDealReq) {
			String bitmap = getBitmap(pBitMapStr);
			String binaryBitmap = ConvertUtils.hexStringToBinaryString(bitmap);
			String target = "";
			char bitmapChars[] = binaryBitmap.toCharArray();
			Class signInReqClazz = pDealReq.getClass();
			Field signInField[] = signInReqClazz.getFields();
			int i = 0;
			for (int o = 0; o < bitmapChars.length; o++) {
				if (bitmapChars[o] == '1') {
					try {
						//获取值
						BaseField baseField = (BaseField) signInField[i].get(pDealReq);
						String value = baseField.value;
						//获取域类型
						Class clazz = Class.forName("pos2.fields.F"
								+ StringUtils.formatStr(o + 1, "00"));
						Field fieldTypeField = clazz.getField("FILED_TYPE");
						Constant.FieldType fieldType = (Constant.FieldType) fieldTypeField.get(pDealReq);
						switch (fieldType){
							case AN:
							case ANS:
								value = ConvertUtils.strToHexString(value);
								break;
							case N:
							case B:
							case HEX:
								break;
							default:
								throw new NullPointerException("没有找到对应域类型");
						}
						//获取域长度类型
						Field lengTypeField = clazz.getField("lengtype");
						String lengtype = (String) lengTypeField.get(pDealReq);
						switch (lengtype){
							case "fix":
								break;
							case "llvar":
								value = (tools.com.hellolibrary.hello_string.StringUtils.fillContentBy(tools.com.hellolibrary.hello_string.StringUtils.Dir.left,"0",value.length()/2+"",2)+value);
								break;
							case "lllvar":
								value = (tools.com.hellolibrary.hello_string.StringUtils.fillContentBy(tools.com.hellolibrary.hello_string.StringUtils.Dir.left,"0",value.length()/2+"",4)+value);
								break;
							default:
								throw new NullPointerException("没有找到对应长度类型");
						}
						target+=value;
					} catch (Exception e) {
						e.printStackTrace();
					}
					i++;
				}
			}
			//拼接位图
			target = bitmap+target;
			//拼接消息类型
			target = pDealType + target;
			//拼接tpdu
			target = pTpdu + target;
			//拼接长度
			int msgLen = target.length()/2;
			target = tools.com.hellolibrary.hello_string.StringUtils.fillContentBy(tools.com.hellolibrary.hello_string.StringUtils.Dir.left,"0",Integer.toHexString(msgLen).toUpperCase(),4)+target;
			Log.i("vbvb","baowen:"+target);
			return ConvertUtils.hexStringToByte(target);
	}

	@Override
	public void sendPack(final Context pContext, final byte [] lSendMsg, final String pIp, final int pPort, final int pTimeOut) {
			initSocket(pIp,pPort,pTimeOut);

			final int sendMsgRet = SocketUtils.sendMsg(lSendMsg);
			if (sendMsgRet!=0){
				throw new IllegalStateException("发送失败:sendMsgRet"+sendMsgRet);
			}
	}

	@Override
	public Object [] unPack(String pRcvedHexMsg) {
		try {
			Object unPackResult [] = new Object[2];
			Header_STD lHeader_std = MsgUtils.parse8583MsgHeader(pRcvedHexMsg);
			Body_STD lBody_std = MsgUtils.parse8583MsgBody(lHeader_std,pRcvedHexMsg);
			unPackResult[0] = lHeader_std;
			unPackResult[1] = lBody_std;
			lHeader_std.show();
			lBody_std.show();
			return unPackResult;
		} catch (Exception pE) {
			pE.printStackTrace();
		}
		return null;
	}

	@Override
	public String rcvPack() {
		byte pRevMsgByte[] = revMsg(100);
		return ConvertUtils.bytesToHexString(pRevMsgByte);
	}

	@Override
	public boolean chkPack(Object [] pUnPackResult) {
		String retCode = ((Body_STD)pUnPackResult[1]).getmF39().getValue();
		if(retCode.contains("3030-->00")){
			return true;
		}
		return false;
	}


	/**
	 * 获得bitmap的16进制表示
	 *
	 * @param bitmapStr
	 *            :
	 * @return
	 */
	private String getBitmap(String bitmapStr) {
		String bitmap = bitmapStr;
		String str = "";
		for (int i = 1; i < 65; i++) {
			String s = tools.com.hellolibrary.hello_string.StringUtils.fillContentBy(tools.com.hellolibrary.hello_string.StringUtils.Dir.left, "0", i+"", 2);
			if(bitmap.contains(s)){
				str += 1;
			}else {
				str += 0;
			}
		}
		return ConvertUtils.binaryStringToHexString(str);
	}


	public interface ResultListener {
		void succ(Body_STD pBody_std);
		void fail(Body_STD pBody_std);
	}
}
