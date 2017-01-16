package activity.key_download.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import activity.key_download.present.KeyDownLoadPrt;
import tools.com.hellolibrary.hello_base.BaseActivity;
import tools.com.hellotools.R;

/**
 * Created by lenovo on 2017/1/4.
 * 描述：
 */

public class KeyDownLoadAty extends BaseActivity implements IKeyDownLoadAty {
    private KeyDownLoadPrt mPresenter;

    @Override
    public void onSignInSucc(String pMsg) {
        Toast.makeText(this,pMsg,Toast.LENGTH_LONG);
        Log.i("vbvb","主密钥下载成功:"+pMsg);
    }

    @Override
    public void onSignInFail(String pMsg) {
        Toast.makeText(this,pMsg,Toast.LENGTH_LONG);
        Log.i("vbvb","主密钥下载失败："+pMsg);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        setContentView(R.layout.aty_key_download);
    }

    @Override
    public void initListener() {
        mPresenter.actionKeyDown();
    }

    @Override
    public void releaseResource() {

    }

    @Override
    public void initPresenter() {
        mPresenter = new KeyDownLoadPrt(this);
    }

    public static void launch(Context pContext){
        pContext.startActivity(new Intent(pContext,KeyDownLoadAty.class));
    }
}
