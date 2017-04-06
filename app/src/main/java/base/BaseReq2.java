package base;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import java.io.InputStream;
import java.util.List;

import activity.test.Mod2;
import db.bill.DBPosSettingBill;
import tools.com.hellolibrary.hello_convert.ConvertUtils;
import tools.com.hellolibrary.hello_string.StringUtils;
import tools.com.hellolibrary.hello_thread.ThreadUtil;

/**
 * Created by lenovo on 2017/4/6.
 * 描述：
 */

public class BaseReq2 extends BaseReq {

    private Context mContext;

    public void actionDeal2(final Context pContext, final byte [] bytesMsg, final ResultListener pResultListener) {
        mContext = pContext;
        final String lIp = DBPosSettingBill.getIp();
        final int lPort = DBPosSettingBill.getPort();
        final int lTime = DBPosSettingBill.getSocketTimeOut();
        ThreadUtil.runFixedService(new Runnable() {
            @Override
            public void run() {
                unPack("010F600000000808102038000002D0000E9400000000001813590122303031323031515A38513130333130303034383134313334371662646262643264376233633962396136003301179600641C1ADA22BEF375639B45E7F2BEF375639B45E7F2BEF375639B45E7F200123130303030303230303030300152313131313131202020203232323232322020202033333333333320202020202020202020202020202020202020202020202020202020202020202020B9ABD6F7B7D8B4E4CEA2B4F3CFC3202020202020202020202020202020202020202020202020202037333932FF00FF50FF50FF50FCC0FF00FE50FE508000BF5000000000000303031003000099999999000001000000010100000000");//签到收到的成功报文

                /*SystemClock.sleep(500);
                //发包
                sendPack(pContext, bytesMsg, lIp, lPort, lTime);
                //流水加1
                tranceNoAddOne();
                //收包
                String rcvedHexMsg = rcvPack();
                //解包
                final Object[] unPackResult = unPack(rcvedHexMsg);
                //检包
                final boolean isDealSucc = chkPack(unPackResult);

                ThreadUtil.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (isDealSucc) {
                            pResultListener.succ((Body_STD) unPackResult[1]);
                        } else {
                            pResultListener.fail((Body_STD) unPackResult[1]);
                        }
                    }
                });*/
            }
        },1);
    }

    /**
     * 将收到的16进制字符串报文转换为对象
     * @param pRcvedHexMsg
     * @return
     */
    @Override
    public Object[] unPack(String pRcvedHexMsg) {
        int lCursorPosition = 0;//当前游标位置
        InputStream lInputStream = null;
        try{
            lInputStream = mContext.getAssets().open("FieldInfo3.txt");
        }catch (Exception pE){
            pE.printStackTrace();
        }
        String lSignIn = StringUtils.streamToString(lInputStream);
        Mod2 lDefVal = new Gson().fromJson(lSignIn, Mod2.class);

        //先解析头报文
        List<Mod2.HeadersBean> lHeadersBeanList = lDefVal.getHeaders();
        for(int i = 0;i<lHeadersBeanList.size();i++){
            Mod2.HeadersBean lHeadersBean = lHeadersBeanList.get(i);
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
        List<Mod2.BodiesBean> lBodiesBeanList = lDefVal.getBodies();
        for(int i = 0;i<charBitmaps.length;i++){
            if (charBitmaps[i]=='1'){
                Mod2.BodiesBean lBodiesBean = lBodiesBeanList.get(i);
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



        return super.unPack(pRcvedHexMsg);
    }
}
