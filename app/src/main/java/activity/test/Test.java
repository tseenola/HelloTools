package activity.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.customview.keytool.rsa.RSAUtils;

import java.security.PrivateKey;
import java.security.PublicKey;


/**
 * Created by lenovo on 2017/3/1.
 * 描述：
 */

public class Test extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            PublicKey lRSAPublicKey = RSAUtils.loadPublicKey(this.getResources().openRawResource(com.customview.keytool.R.raw.rsa_public_key));
            PrivateKey lPrivateKey = RSAUtils.loadPrivateKey(this.getResources().openRawResource(com.customview.keytool.R.raw.private_key_pkcs8));
            String data = "你好";
            byte pData [] = data.getBytes();
            byte pData2 [] = new byte[256];
            System.arraycopy(pData,0,pData2,0,pData.length);
            byte enResult []= RSAUtils.encryptData(pData2,lRSAPublicKey);
            Log.i("vbvb","解密结果"+new String(enResult));
            byte deResult [] = RSAUtils.decryptData(enResult,lPrivateKey);
            Log.i("vbvb","解密结果"+new String(deResult));
        } catch (Exception pE) {
            pE.printStackTrace();
        }


    }

    public static void launch(Context pContext) {
        pContext.startActivity(new Intent(pContext,Test.class));
    }
}
