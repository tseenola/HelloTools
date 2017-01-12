package factory;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import pos.Field;
import tools.com.hellolibrary.hello_string.StringUtils;

/**
 * Created by lenovo on 2017/1/12.
 * 描述：
 */

public class FieldFactory {


    public static Field getField(Context pContext,DearType pDealType) throws IOException {
        InputStream lIs = null;
        switch (pDealType){
            case keyDownload:
                lIs = pContext.getAssets().open("KeyDownLoadReq");
            break;
            case signIn:
                lIs = pContext.getAssets().open("SignInReq");
            break;
        }
        String lReq = StringUtils.streamToString(lIs);
        Gson lGson = new Gson();
        Field lField = lGson.fromJson(lReq, Field.class);
        return lField;
    }

    public static enum DearType{
        keyDownload,signIn
    }

}
