package activity.key_download.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import activity.key_download.present.KeyDownLoadPrt;
import tools.com.hellolibrary.hello_base.BaseActivity;
import tools.com.hellolibrary.hello_dialog.DialogUtil;
import tools.com.hellotools.R;

/**
 * Created by lijun on 2017/1/4.
 * 描述：
 */

public class KeyDownLoadAty extends BaseActivity implements IKeyDownLoadAty {
    private KeyDownLoadPrt mPresenter;

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
        DialogUtil.showProgressDialog(this,true,DialogUtil.STYLE_CIRCAL,"主密钥下载中",25);
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

    @Override
    public void onKeyDownSucc(String pMsg) {
        Toast.makeText(this,pMsg,Toast.LENGTH_LONG).show();
        DialogUtil.hideProgressDialog();
    }

    @Override
    public void onKeyDownFail(String pMsg) {
        Toast.makeText(this,pMsg,Toast.LENGTH_LONG).show();
        DialogUtil.hideProgressDialog();
    }

}
