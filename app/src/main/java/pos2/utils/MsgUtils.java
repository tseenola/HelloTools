package pos2.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import pos2.constant.Constant;
import pos2.fields.F_01;
import pos2.fields.F_02;
import pos2.fields.F_03;
import pos2.fields.F_04;
import pos2.fields.F_05;
import pos2.model.Body_STD;
import pos2.model.Header_STD;
import tools.com.hellolibrary.hello_string.StringUtils;

/**
 * 2016年9月2日 by lee for：
 */
public class MsgUtils {

	/**
	 * 通过解析传入的报文，从而获得报文头对象
	 * @param msg 报文（整个报文）
	 * @return Header_STD 返回报文头对象，此对象封装了（报文长度,TPDU,报文头,消息类型,位图）;
	 * @throws Exception
	 */
	public static Header_STD parse8583MsgHeader(String msg) throws Exception {
		Class headerClass = Class.forName("pos2.model.Header_STD");
		Object header = headerClass.newInstance();
		Method headerMethods[] = headerClass.getMethods();
		List<Method> headMethodList = getRightMethodList(headerMethods,"setmF");//从方法列表中获取带有setmF的方法名
		int curPosition = 0;
		for (int i = 1; i <= 5; i++) {
			Class filedClass = Class.forName("pos2.fields.F_" + StringUtils.formatStr(i, "00"));
			Object filedObj = filedClass.newInstance();
			String desciption = filedClass.getField("DES").get(filedObj).toString();// 获取域的描述信息
			int normalLen = (int) filedClass.getField("NORMAL_LEN").get(filedObj);
			normalLen *= 2;
			String filedContent = msg.substring(curPosition,
					curPosition += normalLen);
			Method setValueMethod = filedClass.getMethod("setValue", String.class);
			setValueMethod.invoke(filedObj,filedContent);
			for(int z = 0;z<headMethodList.size();z++){
				String name= headMethodList.get(z).getName();
				String myname = StringUtils.formatStr(i, "00");
				if(headMethodList.get(z).getName().contains(myname)){
					headMethodList.get(z).invoke(header, filedObj);
				}
			}
		}
		return (Header_STD)header;
	}
	/**
	 * 通过解析传入的报文，从而获得报文体对象
	 * @param header 报文头
	 * @param msgData 报文（整个报文）
	 * @return 报文体对象 ：此对象封装了从报文解析出来的每个域的值
	 * @throws Exception
	 */
	public static Body_STD parse8583MsgBody(Header_STD header, String msgData)
			throws Exception {
		String filedInfo = "";
		Class bodyClass = Class.forName("pos2.model.Body_STD");
		Object bodyObject = bodyClass.newInstance();
		Method bodyMethod[] = bodyClass.getMethods();
		List<Method> bodyMethodList = getRightMethodList(bodyMethod,"setmF");
		// 获得位图
		String binaryBitMap = Converter.hexString2BinaryString(header.getmF05()
				.getValue());
		// 根据位图的二进制形式获得有数据的域
		char fieldChars[] = binaryBitMap.toCharArray();
		//System.out.println(fieldChars);
		// 根据有数据的域分别获取数据。
		int currentCursorIndex = header.getHeaderLen();
		for (int i = 1; i < fieldChars.length; i++) {
			try {
				if (fieldChars[i] != '0') {
					Class filedClass = Class.forName("pos2.fields.F" +StringUtils.formatStr(i + 1, "00"));
					Object filedObj = filedClass.newInstance();
					String desciption = filedClass.getField("DES").get(filedObj)
							.toString();// 获取域的描述信息
					boolean isVarLen = (boolean) filedClass.getField("IS_VAR_LEN")
							.get(filedObj);// 获得域数据是否变长
					Constant.FieldType fieldType = (Constant.FieldType)filedClass.getField("FILED_TYPE").get(filedObj);
					filedInfo = (String)filedClass.getField("FIELD_INFO").get(filedObj);
					int fieldLen = 0;
					if (isVarLen) {// 如果是变长
						// 获取该域长度值占用长度
						int llvarUseLen = (int) filedClass.getField("LLVAR_LEN")
								.get(filedObj);
						llvarUseLen *= 2;
						fieldLen = Integer.valueOf(msgData.substring(
								currentCursorIndex,
								currentCursorIndex += llvarUseLen));
						if(fieldType== Constant.FieldType.AN||fieldType==fieldType.ANS){
							fieldLen*=2;
						}else if(fieldType== Constant.FieldType.N){
							if(fieldLen%2!=0){
								fieldLen+=1;
							}
						}
					} else {// 定长
						// 获取该域的长度
						int normalLen = (int) filedClass.getField("NORMAL_LEN")
								.get(filedObj);
						normalLen *= 2;
						fieldLen = normalLen;
					}
					String fieldHexContent = msgData.substring(currentCursorIndex,
							currentCursorIndex += fieldLen);
					//todo-检查内容是否超过了最大长度
					//16进制的ANS转为为ASC
					/*String fieldAscContent = "";
					if(fieldType==FieldType.AN||fieldType==fieldType.ANS){
						fieldAscContent = Converter.hexString2Asc(fieldHexContent);
					}*/

					Method setValueMethod = filedClass.getMethod("setValue", String.class);
					setValueMethod.invoke(filedObj, fieldHexContent);

					for(int z = 0;z<bodyMethodList.size();z++){
						if(bodyMethodList.get(z).getName().contains(StringUtils.formatStr(i+1, "00"))){
							bodyMethodList.get(z).invoke(bodyObject, filedObj);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("处理第："+(i+1)+"域时，发生异常");
				System.out.println(filedInfo);
			}
		}
		return (Body_STD)bodyObject;
	}
	/**
	 * 从Method列表中获取包含有指定字符串名称的方法名
	 * @param pMethods
	 * @param rightMethodRexName
	 * @return
	 */
	public static List<Method> getRightMethodList(Method [] pMethods,String rightMethodRexName){
		List<Method> methodContainer = new ArrayList<Method>();
		for(int i = 0;i<pMethods.length;i++){
			if(pMethods[i].getName().contains("setmF")){
				methodContainer.add(pMethods[i]);
			}
		}
		return methodContainer;
	}
	/**
	 * 组装报文头
	 */
	public static void packa8583Header(F_01 f_01, F_02 f_02, F_03 f_03, F_04 f_04, F_05 f_05){

	}
	/**
	 * 通过位图对报文体进行组装
	 * @param body_Std 报文体对象
	 * @param f_05
	 */
	public static void pack8583Body(Body_STD body_Std,F_05 f_05){

	}
}
