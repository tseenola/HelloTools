package com.throrinstudio.android.common.libs.validator.validator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.throrinstudio.android.common.libs.validator.AbstractValidator;
import com.throrinstudio.android.common.libs.validator.ValidatorException;

/**
 * Created by lijun on 2016/10/21.
 * 描述：
 */

public class PortValidator extends AbstractValidator {
    public static final String TAG = "PortValidator";

    public PortValidator(Context c, int errorMessageRes) {
        super(c, errorMessageRes);
    }

    public PortValidator(Context c, String errorMessageString) {
        super(c, errorMessageString);
    }

    public PortValidator(Context c, int errorMessageRes, Drawable errorDrawable) {
        super(c, errorMessageRes, errorDrawable);
    }

    @Override
    public boolean isValid(String value) throws ValidatorException {
        try{
            int port = Integer.valueOf(value);
            return port>=0 && port <=65535;
        }catch (NumberFormatException e){
            Log.e(TAG,"端口只能为数字");
            e.printStackTrace();
        }
        return false;
    }
}
