package activity.sign_in3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by lenovo on 2017/5/9.
 * 描述：
 */

public class SignIn3 extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.aty_sign_in);
        new SignInProcess(this.getWindow().getDecorView(), this).actionSignIn();
    }

    public static void launch(Context pContext) {
        pContext.startActivity(new Intent(pContext,SignIn3.class));
    }
}
