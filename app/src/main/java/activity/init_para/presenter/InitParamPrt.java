package activity.init_para.presenter;

import android.content.Context;
import android.util.Log;

import activity.init_para.model.AidDownLoadReq;
import activity.init_para.model.CAPKDownReq;
import activity.init_para.model.IcParamReq;
import activity.init_para.view.IInitParamAty;
import base.BaseDealPrt;
import base.BaseReq;
import pos2.fields.F03;
import pos2.fields.F11;
import pos2.fields.F25;
import pos2.fields.F41;
import pos2.fields.F42;
import pos2.fields.F60;
import pos2.fields.F63;
import pos2.fields.F64;
import pos2.model.Body_STD;

/**
 * Created by lenovo on 2017/1/19.
 * 描述：
 */

public class InitParamPrt extends BaseDealPrt implements IInitParamPrt {
    private IInitParamAty mView;
    private Context mContext;
    public InitParamPrt(IInitParamAty pView){
        mView = pView;
        mContext = (Context) pView;
    }
    @Override
    public void actionInitParaDown() {
        /**
         * ic卡参数下载
         */
        IcParamReq lIcParamReq = new IcParamReq(
                new F03("920000"),
                new F11(""),
                new F25("14"),
                new F41("1201QZ8Q"),
                new F42("103100048141347"),
                new F60("A00199"),
                new F64("0000000000000000")
        );
        lIcParamReq.actionDeal(mContext, "49.4.175.10", 5005, 100, "6000080000", "0800", "03,41,42,60", lIcParamReq, new BaseReq.ResultListener() {
            @Override
            public void succ(Body_STD pBody_std) {
                Log.i("vbvb","ic卡参数下载成功");
            }

            @Override
            public void fail(Body_STD pBody_std) {
                Log.i("vbvb","ic卡参数下载失败");
            }
        });


        /**
         * aid参数下载
         */
        AidDownLoadReq lAidDownLoadReq = new AidDownLoadReq(
                new F03("990000"),
                new F11(""),
                new F25("14"),
                new F41("1201QZ8Q"),
                new F42("103100048141347"),
                new F60("A00199"),
                new F63(""),
                new F64("")
        );
        lAidDownLoadReq.actionDeal(mContext, "49.4.175.10", 5005, 100, "6000080000", "0800", "03,41,42,60", lAidDownLoadReq, new BaseReq.ResultListener() {
            @Override
            public void succ(Body_STD pBody_std) {
                Log.i("vbvb","aid 下载成功");
            }

            @Override
            public void fail(Body_STD pBody_std) {
                Log.i("vbvb","aid 下载失败");
            }
        });


        /**
         * 认证中心公钥下载
         */
        CAPKDownReq lCAPKDownReq = new CAPKDownReq(
                new F03("930000"),
                new F11(""),
                new F25("14"),
                new F41("1201QZ8Q"),
                new F42("103100048141347"),
                new F60("A00199"),
                new F63(""),
                new F64("0000000000000000")
        );
        lCAPKDownReq.actionDeal(mContext, "49.4.175.10", 5005, 100, "6000080000", "0800", "03,41,42,60", lCAPKDownReq, new BaseReq.ResultListener() {
            @Override
            public void succ(Body_STD pBody_std) {
                Log.i("vbvb","公钥下载成功");
            }

            @Override
            public void fail(Body_STD pBody_std) {
                Log.i("vbvb","公钥下载失败");
            }
        });

    }
}
