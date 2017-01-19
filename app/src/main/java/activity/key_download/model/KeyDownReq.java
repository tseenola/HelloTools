package activity.key_download.model;

import base.BaseReq;
import pos2.fields.F03;
import pos2.fields.F41;
import pos2.fields.F42;
import pos2.fields.F60;

/**
 * Created by lenovo on 2017/1/19.
 * 描述：
 */

public class KeyDownReq extends BaseReq{
    public F03 f03;
    public F41 f41;
    public F42 f42;
    public F60 f60;

    /**
     * 标准位图
     */
    public KeyDownReq(F03 f03, F41 f41, F42 f42, F60 f60) {
        this.f03 = f03;
        this.f41 = f41;
        this.f42 = f42;
        this.f60 = f60;
    }

    public F03 getF03() {
        return f03;
    }

    public void setF03(F03 pF03) {
        f03 = pF03;
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
}
