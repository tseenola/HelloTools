package base;


import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;

import java.lang.reflect.Field;
import java.util.List;

import core.MacCalculater;
import db.bill.DBPosSettingBill;
import models.MsgType;
import models.MsgTypeInfo;
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
	private int mMsgType;
	private String mBitMap;

	@Override
	public void actionDeal(final Context pContext, MsgType pMsgType, final BaseReq pDealReq, final ResultListener pResultListener) {
		final MsgTypeInfo lMsgTypeInfo = pMsgType.getValue();
		mMsgType = Integer.valueOf(lMsgTypeInfo.getType());
		final String lTpdu = DBPosSettingBill.getTpdu();
		final String lIp = DBPosSettingBill.getIp();
		final int lPort = DBPosSettingBill.getPort();
		final int lTime = DBPosSettingBill.getSocketTimeOut();
		ThreadUtil.runCachedService(new Runnable() {
			@Override
			public void run() {
				SystemClock.sleep(500);
				//组包
				byte sendMsgByte [] = pack(lTpdu,lMsgTypeInfo.getType(),lMsgTypeInfo.getMustHaveField(),pDealReq);
				//发包
				sendPack(pContext, sendMsgByte, lIp, lPort, lTime);
				//流水加1
				tranceNoAddOne();
				//收包
				String rcvedHexMsg = rcvPack();
				//解包
				final Object [] unPackResult = unPack(rcvedHexMsg);
				//final Object [] unPackResult = unPack("010F600000000808102038000002D0000E9400000000001813590122303031323031515A38513130333130303034383134313334371662646262643264376233633962396136003301179600641C1ADA22BEF375639B45E7F2BEF375639B45E7F2BEF375639B45E7F200123130303030303230303030300152313131313131202020203232323232322020202033333333333320202020202020202020202020202020202020202020202020202020202020202020B9ABD6F7B7D8B4E4CEA2B4F3CFC3202020202020202020202020202020202020202020202020202037333932FF00FF50FF50FF50FCC0FF00FE50FE508000BF5000000000000303031003000099999999000001000000010100000000");//签到收到的成功报文
				//final Object [] unPackResult = unPack("005E600000000808102000000002D10000900000303031323031515A3851313033313030303438313431333437166264626264326437623363396239613600323635354541363238434636323538354636353545413632384346363235383546");//主密钥下载收到的成功报文
				//final Object [] unPackResult = unPack("005F600000000808102020000002D00003920000100000303031323031515A38513130333130303034383134313334371662646262643264376233633962396136002212E0E0C801562200040202020156015601000001000CB2857CFD07D48322");//IC卡终端参数下载
				//final Object [] unPackResult = unPack("007F600000000808102020000002D00003990000100000303031323031515A38513130333130303034383134313334371662646262643264376233633962396136005402A0000000041010FFFFFFFFFFFFFFFFFF020000FC50A8A0000400000000F850A8F8000000000005000100000000001090109F370400857F5DE36BC970C4");//第1条aid
				//final Object [] unPackResult = unPack("011D600000000808102020000002D00003930000100000303031323031515A38513130333130303034383134313334371662646262643264376233633962396136021202A000000003080101B0D9FD6ED75D51D0E30664BD157023EAA1FFA871E4DA65672B863D255E81E137A51DE4F72BCC9E44ACE12127F87E263D3AF9DD9CF35CA4A7B01E907000BA85D24954C2FCA3074825DDD4C0C8F186CB020F683E02F2DEAD3969133F06F7845166ACEB57CA0FC2603445469811D293BFEFBAFAB57631B3DD91E796BF850A25012F1AE38F05AA5C4D6D03B1DC2E568612785938BBC9B3CD3A910C1DA55A5A9218ACE0F7A21287752682F15832A678D6E1ED0B00000320D213126955DE205ADC2FD2822BD22DE21CF9A8231231A06BC4B27E172FE7");//第1条capk
				//检包
				final boolean isDealSucc = chkPack(unPackResult);
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
			String finalBinaryBitmap = "";//实际情况的位图和预计位图可能不一样（实际位图可能这个域没有值，所以需要判断对应域是否有值，如果没有值，该域为“0”，有值该域位图为“1”）
			for (int o = 0; o < bitmapChars.length; o++) {
				if (bitmapChars[o] == '1') {
						try {
						//获取值
						BaseField baseField = (BaseField) signInField[i].get(pDealReq);
						String value = baseField.value;
						//判断该域是否有值，然后要重新计算位图，
						if(TextUtils.isEmpty(value)){
							if(o==63){
								finalBinaryBitmap += "1";
							}else {
								finalBinaryBitmap += "0";
							}
							i++;
							continue;
						}else{
							finalBinaryBitmap += "1";
						}

						//获取域类型
						Class clazz = Class.forName("pos2.fields.F"
								+ StringUtils.formatStr(o + 1, "00"));
						Field fieldTypeField = clazz.getField("FILED_TYPE");
						Constant.FieldType fieldType = (Constant.FieldType) fieldTypeField.get(pDealReq);
						//当长度不够时获取左边补还是右补
						Field lDIR = clazz.getField("DIR");
						StringUtils.Dir lDir = (StringUtils.Dir)lDIR.get(pDealReq);
						//当长度不够时填充什么，一般是填充0或者空格
						Field lFiLL = clazz.getField("FiLL");
						String lFill = (String)lFiLL.get(pDealReq);

						switch (fieldType){
							case ASCII:
								value = ConvertUtils.strToHexString(value);
								break;
							case BCD:
							case BIN:
							case HEX:
							case TRACK:
								break;
							default:
								throw new NullPointerException("没有找到对应域类型");
						}

						//获取域长度类型
						/*Field lengTypeField = clazz.getField("lengtype");
						String lengtype = (String) lengTypeField.get(pDealReq);*/
						Field lengTypeField = clazz.getField("lengthtype");
						BaseField.LenthType lengtype = (BaseField.LenthType) lengTypeField.get(pDealReq);

						//域值的串长度
						int valLen = value.length();
						switch (lengtype){
							case fix:
								break;
							case llvar:
								if(fieldType== Constant.FieldType.BCD ||fieldType== Constant.FieldType.TRACK){
									//BCD长度为偶数
									if(valLen%2!=0){
										value = StringUtils.fillContentBy(lDir,lFill,value,valLen+1);
									}
									value = (tools.com.hellolibrary.hello_string.StringUtils.fillContentBy(tools.com.hellolibrary.hello_string.StringUtils.Dir.left,"0",valLen+"",2)+value);
								}else {
									value = (tools.com.hellolibrary.hello_string.StringUtils.fillContentBy(tools.com.hellolibrary.hello_string.StringUtils.Dir.left,"0",valLen/2+"",2)+value);
								}

								break;
							case lllvar:
								if(fieldType== Constant.FieldType.BCD){

									//BCD长度为偶数
									if(valLen%2!=0){
										value = StringUtils.fillContentBy(lDir,lFill,value,valLen+1);
									}
									value = (tools.com.hellolibrary.hello_string.StringUtils.fillContentBy(tools.com.hellolibrary.hello_string.StringUtils.Dir.left,"0",valLen+"",4)+value);
								}else {
									value = (tools.com.hellolibrary.hello_string.StringUtils.fillContentBy(tools.com.hellolibrary.hello_string.StringUtils.Dir.left,"0",valLen/2+"",4)+value);
								}

								break;
							default:
								throw new NullPointerException("没有找到对应长度类型");
						}
						target+=value;
					} catch (Exception e) {
						e.printStackTrace();
					}
					i++;
				}else{
					finalBinaryBitmap += "0";
				}
			}
			//拼接位图
			//target = bitmap+target;
		    target = ConvertUtils.binaryStringToHexString(finalBinaryBitmap)+target;
			//拼接消息类型
			target = pDealType + target;
			//计算mac(如果不需要计算直接返回原值)
			target = MacCalculater.getMac(finalBinaryBitmap,target);
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
	public void tranceNoAddOne() {
		DBPosSettingBill.tranceNoAddOne();
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

	/**
	 * 检查包
	 * 1.交易状态是否为00
	 * 2.消息类型是否对应
	 * 3.商户号是否匹配
	 * 4.终端号是否匹配
	 * @param pUnPackResult pUnPackResult[0]解包后的报文头，pUnPackResult[1]解包后的报文体，
	 * @return 交易是否成功
	 */
	@Override
	public boolean chkPack(Object [] pUnPackResult) {

		Body_STD lBody_std = (Body_STD)pUnPackResult[1];
		String retCode = lBody_std.getmF39().getValue();
		if(!retCode.contains("3030-->00")){
			return false;
		}

		int lRcvMsgType = Integer.valueOf(((Header_STD)pUnPackResult[0]).getmF04().getValue());
		int z = mMsgType+10;
		if((mMsgType+10)!=lRcvMsgType){
			return false;
		}

		String rcvTerminalNo = lBody_std.getmF41().getValue();
		if(!rcvTerminalNo.contains(DBPosSettingBill.getTerminalNo())){
			return false;
		}

		String rcvMerchantNo = lBody_std.getmF42().getValue();
		if(!rcvMerchantNo.contains(DBPosSettingBill.getMerchantNo())){
			return false;
		}
		return true;
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


	public void getFieldBitmap(List<BaseField> pList) {
		String bitmapBinaryStr = "";
		for(BaseField lField:pList){
			if (TextUtils.isEmpty(lField.getValue())){
				bitmapBinaryStr +=0;
			}else {
				bitmapBinaryStr +=1;
			}
			Log.i("vbvb","bitmap: "+bitmapBinaryStr);
		}
	}
}
