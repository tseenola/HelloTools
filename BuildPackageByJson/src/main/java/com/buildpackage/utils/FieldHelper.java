package com.buildpackage.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.buildpackage.modle.Field;
import com.buildpackage.modle.IField;
import com.google.gson.Gson;
import com.urovo.calculatemac.MacCalculater_9606;
import com.urovo.calculatemac.utils.MacCalculaterUtils;

import java.io.InputStream;
import java.util.List;

import tools.com.hellolibrary.hello_convert.ConvertUtils;
import tools.com.hellolibrary.hello_string.StringUtils;

/**
 * Created by lenovo on 2017/4/7.
 * 描述：
 */

public class FieldHelper implements IField{

    private FieldHelper() {
    }

    private static final FieldHelper mFieldHelper = new FieldHelper();
    public static FieldHelper getInstance(){
        return mFieldHelper;
    }
    @Override
    public Field getFieldInfoInstance(Context pContext){
        InputStream lInputStream = null;
        try{
            lInputStream = pContext.getAssets().open("FieldInfo.txt");
        }catch (Exception pE){
            pE.printStackTrace();
        }
        String lSignIn = StringUtils.streamToString(lInputStream);
        Field lFieldInfo = new Gson().fromJson(lSignIn, Field.class);
        return lFieldInfo;
    }
    /**
     * 报文组成（报文长度+tpdu+报文头+消息类型+位图+1到63域的值+mac）
     * 其中tpdu,报文头，消息类型已经有值。
     * 还需要求得：1到64域的值，位图，Mac，报文长度
     * 最后拼接起来就是整个报文。
     */
    @Override
    public String buildMsg(Field pField) {
        List<Field.BodiesBean> lReqBeanList = pField.getBodies();
        String binaryBitmap = "";
        String hexBody = "";
        //1.求：1到64域的值
        for(int i = 0;i<Integer.valueOf(pField.getFieldType());i++){
            Field.BodiesBean lReqBean = lReqBeanList.get(i);
            //拼接域的值
            hexBody+=lReqBean.getValue();
            //拼接二进制字符串位图
            if(lReqBean.getValue().equals("")){
                binaryBitmap+="0";
            }else {
                binaryBitmap+="1";
            }
        }

        //2.求：位图
        String BitmapHexStr = ConvertUtils.binaryStringToHexString(binaryBitmap);
        pField.getHeaders().get(4).setValue(BitmapHexStr);

        //3.求：mac
        if(pField.isIsNeedMac()){
            byte lNeedCalMacDatas [] = ConvertUtils.hexStringToByte(hexBody);

            byte lMacResult []= MacCalculaterUtils.getMac(pField.getMacIndex(),lNeedCalMacDatas.length,lNeedCalMacDatas,new MacCalculater_9606());
            BitmapHexStr += ConvertUtils.bytesToHexString(lMacResult);
            pField.setMacHexStr(BitmapHexStr);
        }

        //获取整个头部报文（tpdu+报文头+消息类型+位图）
        String hexHeader = "";
        for(int i = 0;i<pField.getHeaders().size();i++){
            hexHeader+=pField.getHeaders().get(i).getValue();
        }
        //获取除了报文长度以外的所有报文（tpdu+报文头+消息类型+位图+1到63域的值+mac）
        String msgHaveNoMsgLength = hexHeader+hexBody+pField.getMacHexStr();
        //4.求报文长度
        int msgLen = msgHaveNoMsgLength.length() / 2;
        pField.getHeaders().get(0).setValue(tools.com.hellolibrary.hello_string.StringUtils.fillContentBy(tools.com.hellolibrary.hello_string.StringUtils.Dir.left, "0", Integer.toHexString(msgLen).toUpperCase(), pField.getHeaders().get(0).getLength()));
        //求整个报文（报文长度+报文头+消息类型+位图+1到63域的值+mac）；
        String headerMsg = "";
        for(int i = 0;i<pField.getHeaders().size();i++){
            headerMsg+=pField.getHeaders().get(i).getValue();
        }
        String finalHexMsg = headerMsg + hexBody + pField.getMacHexStr();
        return finalHexMsg;
    }

    @Override
    public byte[] getBytesMsg(Field pField) {
        return ConvertUtils.hexStringToByte(buildMsg(pField));
    }

    @Override
    public Field parseMsg(Context pContext, String pRcvedHexMsg) {

        Field lDefVal = getFieldInfoInstance(pContext);

        int lCursorPosition = 0;//当前游标位置
        //先解析头报文
        List<Field.HeadersBean> lHeadersBeanList = lDefVal.getHeaders();
        for(int i = 0;i<lHeadersBeanList.size();i++){
            Field.HeadersBean lHeadersBean = lHeadersBeanList.get(i);
            if (lHeadersBean.isIsOpen()){
                //获取域的长度（位）
                int beanLength = lHeadersBean.getLength();
                //获取域的长度类型
                String beanLengType = lHeadersBean.getLengType();
                //获取内容类型
                String beanContentType = lHeadersBean.getContentType();
                //获取域实际占用的位数(1.如果是定长直接取长度，如果是变长需要根据变长来取长度)
                int realLength = 0;
                if(TextUtils.equals("fix",beanLengType)){
                    switch (beanContentType){
                        case "bcd":
                            realLength = beanLength %2 != 0? beanLength+1:beanLength;
                            break;
                        case "hex":
                        case "asc":
                            realLength = beanLength*2;
                            break;
                        case "b":
                            realLength = (beanLength/8)*2;
                    }
                }
                //获取具体域的值
                lHeadersBean.setValue(pRcvedHexMsg.substring(lCursorPosition,lCursorPosition+realLength));
                lCursorPosition+=realLength;
            }
        }


        //再解析体报文(1.获得位图的二进制字符串。2对二进制字符串进行遍历，为1就取值。)

        if(!lHeadersBeanList.get(4).isIsOpen()){
            throw new IllegalStateException("位图状态为关闭，无法解析位图");
        }
        //1.获得位图的二进制字符串。
        String binaryStrBitMap = ConvertUtils.hexStringToBinaryString(lHeadersBeanList.get(4).getValue());
        char [] charBitmaps = binaryStrBitMap.toCharArray();

        //2对二进制字符串进行遍历，为1就取值。
        List<Field.BodiesBean> lBodiesBeanList = lDefVal.getBodies();
        for(int i = 0;i<charBitmaps.length;i++){
            if (charBitmaps[i]=='1'){
                Field.BodiesBean lBodiesBean = lBodiesBeanList.get(i);
                if (lBodiesBean.isIsOpen()){
                    //获取域的长度（位）
                    int beanLength = lBodiesBean.getLength();
                    //获取域的长度类型
                    String beanLengType = lBodiesBean.getLengType();
                    //获取内容类型
                    String beanContentType = lBodiesBean.getContentType();
                    //获取域实际占用的位数(1.如果是定长直接取长度，如果是变长需要根据变长来取长度)
                    int realLength = 0;
                    if(TextUtils.equals("fix",beanLengType)){
                        switch (beanContentType){
                            case "bcd":
                                realLength = beanLength %2 != 0? beanLength+1:beanLength;
                                break;
                            case "hex":
                            case "asc":
                                realLength = beanLength*2;
                                break;
                            case "b":
                                realLength = (beanLength/8)*2;
                                break;
                            default:
                                throw new IllegalStateException("没有找到对应的内容类型，请确认长度类型是否为 bcd,hex,asc,b");
                        }
                    }else {
                        int varLength = 0;
                        switch (beanLengType){
                            case "llvar":
                                varLength = 2;
                                break;
                            case "lllvar":
                                varLength = 4;
                                break;
                        }
                        String varLengthStr = pRcvedHexMsg.substring(lCursorPosition,lCursorPosition+varLength);
                        Log.i("vbvb","变成域长度："+varLengthStr);
                        int fieldLen = Integer.valueOf(varLengthStr);
                        lCursorPosition+=varLength;
                        switch (beanContentType){
                            case "bcd":
                                realLength = fieldLen %2 != 0? fieldLen+1:fieldLen;
                                break;
                            case "hex":
                            case "asc":
                                realLength = fieldLen*2;
                                break;
                            case "b":
                                realLength = (fieldLen/8)*2;
                                break;
                            default:
                                throw new IllegalStateException("没有找到对应的内容类型，请确认长度类型是否为 bcd,hex,asc,b");
                        }
                        //将边长实际的长度发到长度中
                        lBodiesBean.setLength(realLength);
                    }
                    //获取具体域的值
                    String value = pRcvedHexMsg.substring(lCursorPosition,lCursorPosition+realLength);
                    Log.i("vbvb","分割的字符串为："+lBodiesBean.getDes()+":"+value);
                    lBodiesBean.setValue(value);
                    lCursorPosition+=realLength;
                }
            }
        }
        return lDefVal;
    }

    @Override
    public Field parseMsg(Context pContext, byte[] pBytesMsg) {
        return parseMsg(pContext,ConvertUtils.bytesToHexString(pBytesMsg));
    }
}
