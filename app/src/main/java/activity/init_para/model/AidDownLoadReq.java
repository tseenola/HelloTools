package activity.init_para.model;

import com.buildpackage.fields.F03;
import com.buildpackage.fields.F11;
import com.buildpackage.fields.F25;
import com.buildpackage.fields.F41;
import com.buildpackage.fields.F42;
import com.buildpackage.fields.F60;
import com.buildpackage.fields.F63;
import com.buildpackage.fields.F64;

import base.BaseReq;


/**
 * Created by lenovo on 2017/1/19.
 * 描述：Aid参数下载
 */

public class AidDownLoadReq extends BaseReq{
    public F03 f03;
    public F11 f11;
    public F25 f25;
    public F41 f41;
    public F42 f42;
    public F60 f60;
    public F63 f63;
    public F64 f64;

    public AidDownLoadReq(F03 f03, F11 f11, F25 f25, F41 f41, F42 f42, F60 f60, F63 f63, F64 f64) {
        this.f03= f03;
        this.f11= f11;
        this.f25= f25;
        this.f41= f41;
        this.f42= f42;
        this.f60= f60;
        this.f63= f63;
        this.f64= f64;
    }

    public F03 getF03() {
        return f03;
    }

    public void setF03(F03 pF03) {
        f03 = pF03;
    }

    public F11 getF11() {
        return f11;
    }

    public void setF11(F11 pF11) {
        f11 = pF11;
    }

    public F25 getF25() {
        return f25;
    }

    public void setF25(F25 pF25) {
        f25 = pF25;
    }

    public F41 getF41() {
        return f41;
    }

    public void setF41(F41 pF41) {
        f41 = pF41;
    }

    public F42 getF42() {
        return f42;
    }

    public void setF42(F42 pF42) {
        f42 = pF42;
    }

    public F60 getF60() {
        return f60;
    }

    public void setF60(F60 pF60) {
        f60 = pF60;
    }

    public F63 getF63() {
        return f63;
    }

    public void setF63(F63 pF63) {
        f63 = pF63;
    }

    public F64 getF64() {
        return f64;
    }

    public void setF64(F64 pF64) {
        f64 = pF64;
    }
}
