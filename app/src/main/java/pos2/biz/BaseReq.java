package pos2.biz;


import android.content.Context;
import android.util.Log;

import java.lang.reflect.Field;

import pos.IPosTempTemplet;
import pos2.constant.Constant;
import pos2.model.BaseField;
import pos2.model.Body_STD;
import pos2.model.Header_STD;
import pos2.utils.MsgUtils;
import pos2.utils.StringUtils;
import tools.com.hellolibrary.hello_convert.ConvertUtils;
import tools.com.hellolibrary.hello_socket.SocketUtils;
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
	public void actionDeal(final Context pContext,final String pIp,final int pPort,final int pTime, final String pTpdu, final String pDealType, final String pBitMapStr, final BaseReq pDealReq) {
		ThreadUtil.runCachedService(new Runnable() {
			@Override
			public void run() {
				byte sendMsgByte [] = pack(pTpdu,pDealType,pBitMapStr,pDealReq);//组包
				sendPack(pContext, sendMsgByte, pIp, pPort, pTime);//发包
				String rcvedHexMsg = rcvPack();//收包
				unPack(rcvedHexMsg);
				//unPack("002F600008000008002000008000C000109400001431323031515A38513130333130303034383134313334370003A00199");//解包
				chkPack();//检包
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
	public void unPack(String pRcvedHexMsg) {
		try {
			Header_STD lHeader_std = MsgUtils.parse8583MsgHeader(pRcvedHexMsg);
			Body_STD lBody_std = MsgUtils.parse8583MsgBody(lHeader_std,pRcvedHexMsg);
			lBody_std.show();
		} catch (Exception pE) {
			pE.printStackTrace();
		}

	}

	@Override
	public String rcvPack() {
		byte pRevMsgByte[] = revMsg(100);
		return ConvertUtils.bytesToHexString(pRevMsgByte);
	}

	@Override
	public void chkPack() {

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
}
