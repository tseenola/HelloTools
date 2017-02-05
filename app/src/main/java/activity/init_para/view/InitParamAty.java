package activity.init_para.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import activity.init_para.presenter.InitParamPrt;
import tools.com.hellolibrary.hello_base.BaseActivity;
import tools.com.hellolibrary.hello_dialog.DialogUtil;
import tools.com.hellotools.R;

/**
 * Created by lenovo on 2017/1/19.
 * 描述：初始化pos参数
 */

public class InitParamAty extends BaseActivity implements IInitParamAty {
    private int mAidNo;
    private int mCapkNo;
    private InitParamPrt mPresenter;

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        setContentView(R.layout.aty_init_para_down);
    }

    @Override
    public void initListener() {
        DialogUtil.showProgressDialog(this,false,DialogUtil.STYLE_CIRCAL,"ic卡参数下载中",25);
        mPresenter.actionIcCardParamDown();
        //mPresenter.actionAidDown(1);
    }

    @Override
    public void releaseResource() {

    }

    @Override
    public void initPresenter() {
        mPresenter = new InitParamPrt(this);
    }

    public static void launch(Context pContext){
        pContext.startActivity(new Intent(pContext,InitParamAty.class));
    }


    @Override
    public void onICParamDownSucc(int pAidNo, int pCapkNo) {
        DialogUtil.hideProgressDialog();
        mAidNo = pAidNo;
        mCapkNo = pCapkNo;
        DialogUtil.showProgressDialog(this,false,DialogUtil.STYLE_CIRCAL,"Aid下载中",25);
        mPresenter.actionAidDown(1);//下载第一条aid
    }

    @Override
    public void onICParamDownInFail(String pMsg) {

    }

    @Override
    public void onCAPKDownDownSucc(String pMsg, int pCapkSeq) {
        Log.i("vbvb","第"+pCapkSeq+"条capk下载成功："+pMsg);
        if(pCapkSeq<mCapkNo){
            mPresenter.actionCapkDown(pCapkSeq+1);
        }else{
            DialogUtil.hideProgressDialog();
            mPresenter.updateAidCapkStatus();
        }
    }

    @Override
    public void onCAPKDownDownInFail(String pMsg) {

    }

    @Override
    public void onAidDownSucc(String pMsg, int pWitchAid) {
        Log.i("vbvb","第"+pWitchAid+"条aid下载成功："+pMsg);
        if(pWitchAid<mAidNo){
            mPresenter.actionAidDown(pWitchAid+1);
        }else{
            DialogUtil.hideProgressDialog();
            DialogUtil.showProgressDialog(this,false,DialogUtil.STYLE_CIRCAL,"Capk下载中",25);
            mPresenter.actionCapkDown(1);
        }
    }

    @Override
    public void onAidDownInFail(String pMsg) {

    }
}
