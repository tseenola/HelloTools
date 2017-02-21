package activity.balance.model;

import base.BaseReq;
import pos2.fields.F02;
import pos2.fields.F03;
import pos2.fields.F11;
import pos2.fields.F14;
import pos2.fields.F22;
import pos2.fields.F23;
import pos2.fields.F25;
import pos2.fields.F35;
import pos2.fields.F36;
import pos2.fields.F41;
import pos2.fields.F42;
import pos2.fields.F49;
import pos2.fields.F52;
import pos2.fields.F55;
import pos2.fields.F60;
import pos2.fields.F62;
import pos2.fields.F64;

/**
 * Created by lenovo on 2017/2/5.
 * 描述：
 */

public class BalanceReq extends BaseReq{
    public F02 f02;
    public F03 f03;
    public F11 f11;
    public F14 f14;
    public F22 f22;
    public F23 f23;
    public F25 f25;
    public F35 f35;
    public F36 f36;
    public F41 f41;
    public F42 f42;
    public F49 f49;
    public F52 f52;
    public F55 f55;
    public F60 f60;
    public F62 f62;
    public F64 f64;

    public BalanceReq(F02 pF02, F03 pF03, F11 pF11, F14 pF14, F22 pF22, F23 pF23,F25 pF25, F35 pF35, F36 pF36, F41 pF41, F42 pF42, F49 pF49, F52 pF52, F55 pF55, F60 pF60, F62 pF62, F64 pF64) {
        f02 = pF02;
        f03 = pF03;
        f11 = pF11;
        f14 = pF14;
        f22 = pF22;
        f23 = pF23;
        f25 = pF25;
        f35 = pF35;
        f36 = pF36;
        f41 = pF41;
        f42 = pF42;
        f49 = pF49;
        f52 = pF52;
        f55 = pF55;
        f60 = pF60;
        f62 = pF62;
        f64 = pF64;
    }

    public F02 getF02() {
        return f02;
    }

    public void setF02(F02 pF02) {
        f02 = pF02;
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

    public F14 getF14() {
        return f14;
    }

    public void setF14(F14 pF14) {
        f14 = pF14;
    }

    public F22 getF22() {
        return f22;
    }

    public void setF22(F22 pF22) {
        f22 = pF22;
    }

    public F23 getF23() {
        return f23;
    }

    public void setF23(F23 pF23) {
        f23 = pF23;
    }

    public F25 getF25() {
        return f25;
    }

    public void setF25(F25 pF25) {
        f25 = pF25;
    }

    public F35 getF35() {
        return f35;
    }

    public void setF35(F35 pF35) {
        f35 = pF35;
    }

    public F36 getF36() {
        return f36;
    }

    public void setF36(F36 pF36) {
        f36 = pF36;
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

    public F49 getF49() {
        return f49;
    }

    public void setF49(F49 pF49) {
        f49 = pF49;
    }

    public F52 getF52() {
        return f52;
    }

    public void setF52(F52 pF52) {
        f52 = pF52;
    }

    public F55 getF55() {
        return f55;
    }

    public void setF55(F55 pF55) {
        f55 = pF55;
    }

    public F60 getF60() {
        return f60;
    }

    public void setF60(F60 pF60) {
        f60 = pF60;
    }

    public F62 getF62() {
        return f62;
    }

    public void setF62(F62 pF62) {
        f62 = pF62;
    }

    public F64 getF64() {
        return f64;
    }

    public void setF64(F64 pF64) {
        f64 = pF64;
    }
}
