package tools.com.hellolibrary.hello_base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import tools.com.hellolibrary.helllo_my_inter.ActivityTemplate;

/**
 * Created by lenovo on 2016/10/15.
 * 描述：
 */

public abstract class BaseActivity extends Activity implements ActivityTemplate,View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBaseView();
        initPresenter();
        initData();
        initView();
        initListener();
    }
    private void initBaseView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
    protected void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
