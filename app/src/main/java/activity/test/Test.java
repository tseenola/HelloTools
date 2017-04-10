package activity.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.io.InputStream;

import tools.com.hellolibrary.hello_string.StringUtils;


/**
 * Created by lenovo on 2017/3/1.
 * 描述：
 */

public class Test extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InputStream lInputStream = null;
        try{
            lInputStream = this.getAssets().open("FieldInfo3.txt");
        }catch (Exception pE){
            pE.printStackTrace();
        }
        String lSignIn = StringUtils.streamToString(lInputStream);
        /*Mod2 lDefVal = new Gson().fromJson(lSignIn, Mod2.class);
        //设置基本信息
        lDefVal.setMsgDes("签到");
        lDefVal.setIsNeedMac(false);
        //设置报文头
        List<Mod2.HeadersBean> lHeadersBeanList = lDefVal.getHeaders();
        lHeadersBeanList.get(1).setValue(DBPosSettingBill.getTpdu());
        lHeadersBeanList.get(3).setValue("0800");
        //设置报文体
        //开始设置个个域的值
        List<Mod2.BodiesBean> lReqBeanList = lDefVal.getBodies();
        lReqBeanList.get(2).setValue("940000");
        lReqBeanList.get(24).setValue("14");
        lReqBeanList.get(40).setValue(DBPosSettingBill.getTerminalNo());
        lReqBeanList.get(41).setValue(DBPosSettingBill.getMerchantNo());
        lReqBeanList.get(59).setValue("A00199");
        String hexMsg = lDefVal.buildMsg();
        Log.i("vbvb","发送出去的报文的16进制字符串表示："+hexMsg);*/

    }



    /**
     * 余额查询报文
     */
    /*public void balanceQuery(){
        InputStream lInputStream = null;
        try{
            lInputStream = this.getAssets().open("FieldInfo2.txt");
        }catch (Exception pE){
            pE.printStackTrace();
        }
        String lSignIn = StringUtils.streamToString(lInputStream);
        Mod lDefVal = new Gson().fromJson(lSignIn, Mod.class);
        //设置交易类型
        lDefVal.setMsgDes("签到");
        lDefVal.setMsgType("0800");
        //设置tpdu
        lDefVal.setTPDU(DBPosSettingBill.getTpdu());
        //设置是否需要mac
        lDefVal.setIsNeedMac(false);
        //开始设置个个域的值
        List<Mod.ReqBean> lReqBeanList = lDefVal.getReq();
        lReqBeanList.get(2).setValue("940000");
        lReqBeanList.get(24).setValue("14");
        lReqBeanList.get(40).setValue(DBPosSettingBill.getTerminalNo());
        lReqBeanList.get(41).setValue(DBPosSettingBill.getMerchantNo());
        lReqBeanList.get(59).setValue("A00199");
        String hexMsg = lDefVal.buildMsg();
        Log.i("vbvb","发送出去的报文的16进制字符串表示："+hexMsg);
    }*/

    public static void launch(Context pContext) {
        pContext.startActivity(new Intent(pContext,Test.class));
    }
}
