package pos;

import android.text.TextUtils;

import java.lang.reflect.Method;

import tools.com.hellolibrary.hello_convert.ConvertUtils;
import tools.com.hellolibrary.hello_string.StringUtils;

public class Field {

    /**
     * length : 4
     * name : 报文长度
     * lengtype : fix
     * content : bcd
     * align : right
     * fill : 0
     * value :
     * haveToExist : false
     */

    private H1Bean h1;
    /**
     * length : 10
     * name : TPDU
     * lengtype : fix
     * content : bcd
     * align : right
     * fill : 0
     * value :
     * haveToExist : false
     */

    private H2Bean h2;
    /**
     * length : 12
     * name : 报文头
     * lengtype : fix
     * content : bcd
     * align : right
     * fill : 0
     * value :
     * haveToExist : false
     */

    private H3Bean h3;
    /**
     * length : 4
     * name : 消息类型
     * lengtype : fix
     * content : bcd
     * align : right
     * fill : 0
     * value :
     * haveToExist : false
     */

    private F0Bean f0;
    /**
     * length : 64
     * name : 位图
     * lengtype : fix
     * content : bcd
     * align : right
     * fill : 0
     * value :
     * haveToExist : false
     */

    private F1Bean f1;
    /**
     * length : 19
     * name : 主账号
     * lengtype : llvar
     * align : left
     * content : bcd
     * fill : 0
     * value :
     * haveToExist : false
     */

    private F2Bean f2;
    /**
     * length : 6
     * name : 交易处理码
     * lengtype : fix
     * content : bcd
     * align : right
     * fill : 0
     * value :
     * haveToExist : false
     */

    private F3Bean f3;
    /**
     * length : 12
     * name : 交易金额
     * lengtype : fix
     * content : bcd
     * align : right
     * fill : 0
     * value :
     * haveToExist : false
     */

    private F4Bean f4;
    /**
     * length : 6
     * name : 受卡方系统跟踪号
     * lengtype : fix
     * content : bcd
     * align : right
     * fill : 0
     * value :
     * haveToExist : false
     */

    private F11Bean f11;
    /**
     * length : 6
     * name : 受卡方所在地时间
     * lengtype : fix
     * content : bcd
     * align : right
     * fill : 0
     * value :
     * haveToExist : false
     */

    private F12Bean f12;
    /**
     * length : 4
     * name : 受卡方所在地日期
     * lengtype : fix
     * content : bcd
     * align : right
     * fill : 0
     * value :
     * haveToExist : false
     */

    private F13Bean f13;
    /**
     * length : 4
     * name : 卡有效期
     * lengtype : fix
     * content : bcd
     * align : right
     * fill : 0
     * value :
     * haveToExist : false
     */

    private F14Bean f14;
    /**
     * length : 4
     * name : 清算日期
     * lengtype : fix
     * content : bcd
     * align : right
     * fill : 0
     * value :
     * haveToExist : false
     */

    private F15Bean f15;
    /**
     * length : 3
     * name : 服务点输入方式码
     * lengtype : fix
     * align : left
     * content : bcd
     * fill : 0
     * value :
     * haveToExist : false
     */

    private F22Bean f22;
    /**
     * length : 3
     * name : 卡序列号
     * lengtype : fix
     * align : right
     * content : bcd
     * fill : 0
     * value :
     * haveToExist : false
     */

    private F23Bean f23;
    /**
     * length : 2
     * name : 服务点条件码
     * lengtype : fix
     * content : bcd
     * align : right
     * fill :
     * value :
     * haveToExist : false
     */

    private F25Bean f25;
    /**
     * length : 2
     * name : 域 26 服务点 PIN 获取码
     * lengtype : fix
     * content : bcd
     * align : right
     * fill : 0
     * value :
     * haveToExist : false
     */

    private F26Bean f26;
    /**
     * length : 11
     * name : 受理机构标识码
     * lengtype : llvar
     * align : left
     * content : bcd
     * fill : 0
     * value :
     * haveToExist : false
     */

    private F32Bean f32;
    /**
     * length : 37
     * name : 2 磁道数据
     * lengtype : llvar
     * align : left
     * content : asc
     * fill : 0
     * value :
     * haveToExist : false
     */

    private F35Bean f35;
    /**
     * length : 104
     * name : 3 磁道数据
     * lengtype : lllvar
     * align : left
     * content : asc
     * fill : 0
     * value :
     * haveToExist : false
     */

    private F36Bean f36;
    /**
     * length : 12
     * name : 检索参考号
     * lengtype : fix
     * content : asc
     * align : left
     * fill :
     * value :
     * haveToExist : false
     */

    private F37Bean f37;
    /**
     * length : 6
     * name : 授权标识应答码
     * lengtype : fix
     * content : asc
     * align : left
     * fill :
     * value :
     * haveToExist : false
     */

    private F38Bean f38;
    /**
     * length : 2
     * name : 应答码
     * lengtype : fix
     * content : asc
     * align : left
     * fill :
     * value :
     * haveToExist : false
     */

    private F39Bean f39;
    /**
     * length : 95
     * name : 应答码描述
     * lengtype : ans
     * content : asc
     * align : left
     * fill :
     * value :
     * haveToExist : false
     */

    private F40Bean f40;
    /**
     * length : 8
     * name : 受卡机终端标识码
     * lengtype : fix
     * content : asc
     * align : left
     * fill :
     * value :
     * haveToExist : false
     */

    private F41Bean f41;
    /**
     * length : 15
     * name : 受卡方标识码
     * lengtype : fix
     * content : asc
     * align : left
     * fill :
     * value :
     * haveToExist : false
     */

    private F42Bean f42;
    /**
     * length : 25
     * name : 附加响应数据
     * lengtype : lllvar
     * content : asc
     * align : left
     * fill :
     * value :
     * haveToExist : false
     */

    private F44Bean f44;
    /**
     * length : 512
     * name : 附加数据 - 私有
     * lengtype : lllvar
     * content : bcd
     * align : left
     * fill : 0
     * value :
     * haveToExist : false
     */

    private F48Bean f48;
    /**
     * length : 3
     * name : 交易货币代码
     * lengtype : fix
     * content : asc
     * align : left
     * fill :
     * value :
     * haveToExist : false
     */

    private F49Bean f49;
    /**
     * length : 8
     * name : 个人标识码数据
     * lengtype : fix
     * content : asc
     * align : left
     * fill : 0
     * value :
     * haveToExist : false
     */

    private F52Bean f52;
    /**
     * length : 16
     * name : 安全控制信息
     * lengtype : fix
     * content : bcd
     * align : right
     * fill : 0
     * value :
     * haveToExist : false
     */

    private F53Bean f53;
    /**
     * length : 20
     * name : 余额
     * lengtype : lllvar
     * content : asc
     * align : left
     * fill :
     * value :
     * haveToExist : false
     */

    private F54Bean f54;
    /**
     * length : 255
     * name :  IC 卡数据域
     * lengtype : lllvar
     * content : hex
     * align : left
     * fill : 0
     * value :
     * haveToExist : false
     */

    private F55Bean f55;
    /**
     * length : 100
     * name : 电子钱包标准的交易信息
     * lengtype : lllvar
     * content : hex
     * align : left
     * fill : 0
     * value :
     * haveToExist : false
     */

    private F58Bean f58;
    /**
     * length : 17
     * name : 自定义域
     * lengtype : lllvar
     * align : left
     * content : hex
     * fill : 0
     * value :
     * haveToExist : false
     */

    private F60Bean f60;
    /**
     * length : 29
     * name : 原始信息域
     * lengtype : lllvar
     * align : left
     * content : bcd
     * fill :
     * value :
     * haveToExist : false
     */

    private F61Bean f61;
    /**
     * length : 512
     * name : 自定义域
     * lengtype : lllvar
     * content : bcd
     * align : left
     * fill : 0
     * value :
     * haveToExist : false
     */

    private F62Bean f62;
    /**
     * length : 512
     * name : 自定义域
     * lengtype : lllvar
     * content : b
     * align : left
     * fill : 0
     * value :
     * haveToExist : false
     */

    private F63Bean f63;
    /**
     * length : 64
     * name : 报文鉴别码
     * lengtype : fix
     * align : left
     * content : b
     * fill : 0
     * value :
     * haveToExist : false
     */

    private F64Bean f64;

    public H1Bean getH1() {
        return h1;
    }

    public void setH1(H1Bean h1) {
        this.h1 = h1;
    }

    public H2Bean getH2() {
        return h2;
    }

    public void setH2(H2Bean h2) {
        this.h2 = h2;
    }

    public H3Bean getH3() {
        return h3;
    }

    public void setH3(H3Bean h3) {
        this.h3 = h3;
    }

    public F0Bean getF0() {
        return f0;
    }

    public void setF0(F0Bean f0) {
        this.f0 = f0;
    }

    public F1Bean getF1() {
        return f1;
    }

    public void setF1(F1Bean f1) {
        this.f1 = f1;
    }

    public F2Bean getF2() {
        return f2;
    }

    public void setF2(F2Bean f2) {
        this.f2 = f2;
    }

    public F3Bean getF3() {
        return f3;
    }

    public void setF3(F3Bean f3) {
        this.f3 = f3;
    }

    public F4Bean getF4() {
        return f4;
    }

    public void setF4(F4Bean f4) {
        this.f4 = f4;
    }

    public F11Bean getF11() {
        return f11;
    }

    public void setF11(F11Bean f11) {
        this.f11 = f11;
    }

    public F12Bean getF12() {
        return f12;
    }

    public void setF12(F12Bean f12) {
        this.f12 = f12;
    }

    public F13Bean getF13() {
        return f13;
    }

    public void setF13(F13Bean f13) {
        this.f13 = f13;
    }

    public F14Bean getF14() {
        return f14;
    }

    public void setF14(F14Bean f14) {
        this.f14 = f14;
    }

    public F15Bean getF15() {
        return f15;
    }

    public void setF15(F15Bean f15) {
        this.f15 = f15;
    }

    public F22Bean getF22() {
        return f22;
    }

    public void setF22(F22Bean f22) {
        this.f22 = f22;
    }

    public F23Bean getF23() {
        return f23;
    }

    public void setF23(F23Bean f23) {
        this.f23 = f23;
    }

    public F25Bean getF25() {
        return f25;
    }

    public void setF25(F25Bean f25) {
        this.f25 = f25;
    }

    public F26Bean getF26() {
        return f26;
    }

    public void setF26(F26Bean f26) {
        this.f26 = f26;
    }

    public F32Bean getF32() {
        return f32;
    }

    public void setF32(F32Bean f32) {
        this.f32 = f32;
    }

    public F35Bean getF35() {
        return f35;
    }

    public void setF35(F35Bean f35) {
        this.f35 = f35;
    }

    public F36Bean getF36() {
        return f36;
    }

    public void setF36(F36Bean f36) {
        this.f36 = f36;
    }

    public F37Bean getF37() {
        return f37;
    }

    public void setF37(F37Bean f37) {
        this.f37 = f37;
    }

    public F38Bean getF38() {
        return f38;
    }

    public void setF38(F38Bean f38) {
        this.f38 = f38;
    }

    public F39Bean getF39() {
        return f39;
    }

    public void setF39(F39Bean f39) {
        this.f39 = f39;
    }

    public F40Bean getF40() {
        return f40;
    }

    public void setF40(F40Bean f40) {
        this.f40 = f40;
    }

    public F41Bean getF41() {
        return f41;
    }

    public void setF41(F41Bean f41) {
        this.f41 = f41;
    }

    public F42Bean getF42() {
        return f42;
    }

    public void setF42(F42Bean f42) {
        this.f42 = f42;
    }

    public F44Bean getF44() {
        return f44;
    }

    public void setF44(F44Bean f44) {
        this.f44 = f44;
    }

    public F48Bean getF48() {
        return f48;
    }

    public void setF48(F48Bean f48) {
        this.f48 = f48;
    }

    public F49Bean getF49() {
        return f49;
    }

    public void setF49(F49Bean f49) {
        this.f49 = f49;
    }

    public F52Bean getF52() {
        return f52;
    }

    public void setF52(F52Bean f52) {
        this.f52 = f52;
    }

    public F53Bean getF53() {
        return f53;
    }

    public void setF53(F53Bean f53) {
        this.f53 = f53;
    }

    public F54Bean getF54() {
        return f54;
    }

    public void setF54(F54Bean f54) {
        this.f54 = f54;
    }

    public F55Bean getF55() {
        return f55;
    }

    public void setF55(F55Bean f55) {
        this.f55 = f55;
    }

    public F58Bean getF58() {
        return f58;
    }

    public void setF58(F58Bean f58) {
        this.f58 = f58;
    }

    public F60Bean getF60() {
        return f60;
    }

    public void setF60(F60Bean f60) {
        this.f60 = f60;
    }

    public F61Bean getF61() {
        return f61;
    }

    public void setF61(F61Bean f61) {
        this.f61 = f61;
    }

    public F62Bean getF62() {
        return f62;
    }

    public void setF62(F62Bean f62) {
        this.f62 = f62;
    }

    public F63Bean getF63() {
        return f63;
    }

    public void setF63(F63Bean f63) {
        this.f63 = f63;
    }

    public F64Bean getF64() {
        return f64;
    }

    public void setF64(F64Bean f64) {
        this.f64 = f64;
    }

    public static class H1Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class H2Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class H3Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F0Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F1Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F2Bean {
        private int length;
        private String name;
        private String lengtype;
        private String align;
        private String content;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F3Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F4Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F11Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F12Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F13Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F14Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F15Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F22Bean {
        private int length;
        private String name;
        private String lengtype;
        private String align;
        private String content;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F23Bean {
        private int length;
        private String name;
        private String lengtype;
        private String align;
        private String content;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F25Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F26Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F32Bean {
        private int length;
        private String name;
        private String lengtype;
        private String align;
        private String content;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F35Bean {
        private int length;
        private String name;
        private String lengtype;
        private String align;
        private String content;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F36Bean {
        private int length;
        private String name;
        private String lengtype;
        private String align;
        private String content;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F37Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F38Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F39Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F40Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F41Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F42Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F44Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F48Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F49Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F52Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F53Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F54Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F55Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F58Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F60Bean {
        private int length;
        private String name;
        private String lengtype;
        private String align;
        private String content;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F61Bean {
        private int length;
        private String name;
        private String lengtype;
        private String align;
        private String content;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F62Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F63Bean {
        private int length;
        private String name;
        private String lengtype;
        private String content;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    public static class F64Bean {
        private int length;
        private String name;
        private String lengtype;
        private String align;
        private String content;
        private String fill;
        private String value;
        private boolean haveToExist;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLengtype() {
            return lengtype;
        }

        public void setLengtype(String lengtype) {
            this.lengtype = lengtype;
        }

        public String getAlign() {
            return align;
        }

        public void setAlign(String align) {
            this.align = align;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getFill() {
            return fill;
        }

        public void setFill(String fill) {
            this.fill = fill;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public boolean isHaveToExist() {
            return haveToExist;
        }

        public void setHaveToExist(boolean haveToExist) {
            this.haveToExist = haveToExist;
        }
    }

    /**
     * 1.遍历所有域的值，如果这个域有值，如果是BCD，如果是Binary，如果是ASC，如果是Hex，进行相应的转换
     * private int length;
     * private String name;
     * private boolean bitmap;
     * private String lengtype;
     * private String content;
     * private String align;
     * private String fill;
     * private String value;
     */
    public byte[] pack() {
        String lSendMsg = "";
        if (f0 != null && !TextUtils.isEmpty(f0.value)) {
            lSendMsg += getHexString(f0.length, f0.name, f0.lengtype, f0.content, f0.align, f0.align, f0.fill, f0.value);
        }
        if (f1 != null && !TextUtils.isEmpty(f1.value)) {
            lSendMsg += getHexString(f1.length, f1.name, f1.lengtype, f1.content, f1.align, f1.align, f1.fill, f1.value);
        }
        if (f2 != null && !TextUtils.isEmpty(f2.value)) {
            lSendMsg += getHexString(f2.length, f2.name, f2.lengtype, f2.content, f2.align, f2.align, f2.fill, f2.value);
        }
        if (f3 != null && !TextUtils.isEmpty(f3.value)) {
            lSendMsg += getHexString(f3.length, f3.name, f3.lengtype, f3.content, f3.align, f3.align, f3.fill, f3.value);
        }
        if (f4 != null && !TextUtils.isEmpty(f4.value)) {
            lSendMsg += getHexString(f4.length, f4.name, f4.lengtype, f4.content, f4.align, f4.align, f4.fill, f4.value);
        }
        if (f11 != null && !TextUtils.isEmpty(f11.value)) {
            lSendMsg += getHexString(f11.length, f11.name, f11.lengtype, f11.content, f11.align, f11.align, f11.fill, f11.value);
        }
        if (f12 != null && !TextUtils.isEmpty(f12.value)) {
            lSendMsg += getHexString(f12.length, f12.name, f12.lengtype, f12.content, f12.align, f12.align, f12.fill, f12.value);
        }
        if (f13 != null && !TextUtils.isEmpty(f13.value)) {
            lSendMsg += getHexString(f13.length, f13.name, f13.lengtype, f13.content, f13.align, f13.align, f13.fill, f13.value);
        }
        if (f14 != null && !TextUtils.isEmpty(f14.value)) {
            lSendMsg += getHexString(f14.length, f14.name, f14.lengtype, f14.content, f14.align, f14.align, f14.fill, f14.value);
        }
        if (f15 != null && !TextUtils.isEmpty(f15.value)) {
            lSendMsg += getHexString(f15.length, f15.name, f15.lengtype, f15.content, f15.align, f15.align, f15.fill, f15.value);
        }
        if (f22 != null && !TextUtils.isEmpty(f22.value)) {
            lSendMsg += getHexString(f22.length, f22.name, f22.lengtype, f22.content, f22.align, f22.align, f22.fill, f22.value);
        }
        if (f23 != null && !TextUtils.isEmpty(f23.value)) {
            lSendMsg += getHexString(f23.length, f23.name, f23.lengtype, f23.content, f23.align, f23.align, f23.fill, f23.value);
        }
        if (f25 != null && !TextUtils.isEmpty(f25.value)) {
            lSendMsg += getHexString(f25.length, f25.name, f25.lengtype, f25.content, f25.align, f25.align, f25.fill, f25.value);
        }
        if (f26 != null && !TextUtils.isEmpty(f26.value)) {
            lSendMsg += getHexString(f26.length, f26.name, f26.lengtype, f26.content, f26.align, f26.align, f26.fill, f26.value);
        }
        if (f32 != null && !TextUtils.isEmpty(f32.value)) {
            lSendMsg += getHexString(f32.length, f32.name, f32.lengtype, f32.content, f32.align, f32.align, f32.fill, f32.value);
        }
        if (f35 != null && !TextUtils.isEmpty(f35.value)) {
            lSendMsg += getHexString(f35.length, f35.name, f35.lengtype, f35.content, f35.align, f35.align, f35.fill, f35.value);
        }
        if (f36 != null && !TextUtils.isEmpty(f36.value)) {
            lSendMsg += getHexString(f36.length, f36.name, f36.lengtype, f36.content, f36.align, f36.align, f36.fill, f36.value);
        }
        if (f37 != null && !TextUtils.isEmpty(f37.value)) {
            lSendMsg += getHexString(f37.length, f37.name, f37.lengtype, f37.content, f37.align, f37.align, f37.fill, f37.value);
        }
        if (f38 != null && !TextUtils.isEmpty(f39.value)) {
            lSendMsg += getHexString(f38.length, f38.name, f38.lengtype, f38.content, f38.align, f38.align, f38.fill, f38.value);
        }
        if (f40 != null && !TextUtils.isEmpty(f40.value)) {
            lSendMsg += getHexString(f40.length, f40.name, f40.lengtype, f40.content, f40.align, f40.align, f40.fill, f40.value);
        }
        if (f41 != null && !TextUtils.isEmpty(f41.value)) {
            lSendMsg += getHexString(f41.length, f41.name, f41.lengtype, f41.content, f41.align, f41.align, f41.fill, f41.value);
        }
        if (f42 != null && !TextUtils.isEmpty(f42.value)) {
            lSendMsg += getHexString(f42.length, f42.name, f42.lengtype, f42.content, f42.align, f42.align, f42.fill, f42.value);
        }
        if (f44 != null && !TextUtils.isEmpty(f44.value)) {
            lSendMsg += getHexString(f44.length, f44.name, f44.lengtype, f44.content, f44.align, f44.align, f44.fill, f44.value);
        }
        if (f48 != null && !TextUtils.isEmpty(f48.value)) {
            lSendMsg += getHexString(f48.length, f48.name, f48.lengtype, f48.content, f48.align, f48.align, f48.fill, f48.value);
        }
        if (f49 != null && !TextUtils.isEmpty(f49.value)) {
            lSendMsg += getHexString(f49.length, f49.name, f49.lengtype, f49.content, f49.align, f49.align, f49.fill, f49.value);
        }
        if (f52 != null && !TextUtils.isEmpty(f52.value)) {
            //lSendMsg+=getHexString(f52 .length,f52 .name,f52 .lengtype,f52 .content,f52 .align,f52 .align,f52 .fill,f52 .value);
        }
        if (f53 != null && !TextUtils.isEmpty(f53.value)) {
            lSendMsg += getHexString(f53.length, f53.name, f53.lengtype, f53.content, f53.align, f53.align, f53.fill, f53.value);
        }
        if (f54 != null && !TextUtils.isEmpty(f54.value)) {
            lSendMsg += getHexString(f54.length, f54.name, f54.lengtype, f54.content, f54.align, f54.align, f54.fill, f54.value);
        }
        if (f55 != null && !TextUtils.isEmpty(f55.value)) {
            lSendMsg += getHexString(f55.length, f55.name, f55.lengtype, f55.content, f55.align, f55.align, f55.fill, f55.value);
        }
        if (f58 != null && !TextUtils.isEmpty(f58.value)) {
            //lSendMsg+=getHexString(f58 .length,f58 .name,f58 .lengtype,f58 .content,f58 .align,f58 .align,f58 .fill,f58 .value);
        }
        if (f60 != null && !TextUtils.isEmpty(f60.value)) {
            lSendMsg += getHexString(f60.length, f60.name, f60.lengtype, f60.content, f60.align, f60.align, f60.fill, f60.value);
        }
        if (f61 != null && !TextUtils.isEmpty(f61.value)) {
            lSendMsg += getHexString(f61.length, f61.name, f61.lengtype, f61.content, f61.align, f61.align, f61.fill, f61.value);
        }
        if (f62 != null && !TextUtils.isEmpty(f62.value)) {
            lSendMsg += getHexString(f62.length, f62.name, f62.lengtype, f62.content, f62.align, f62.align, f62.fill, f62.value);
        }
        if (f63 != null && !TextUtils.isEmpty(f63.value)) {
            lSendMsg += getHexString(f63.length, f63.name, f63.lengtype, f63.content, f63.align, f63.align, f63.fill, f63.value);
        }
        if (f64 != null && !TextUtils.isEmpty(f64.value)) {
            //lSendMsg+=getHexString(f64 .length,f64 .name,f64 .lengtype,f64.content,f64 .align,f64 .align,f64 .fill,f64 .value);
        }

        //加上Tpdu
        String tpduMsg ="6000080000"+lSendMsg;
        //加上长度
        int changdu = tpduMsg.length()/2;

        String changduStr = StringUtils.fillContentBy(StringUtils.Dir.left,"0",Integer.toHexString(changdu).toUpperCase(),4);

        String finalMsg = changduStr+tpduMsg;
        //转为字节数组用于发送
        byte lSendMsgByte[] = ConvertUtils.hexStringToByte(finalMsg);

        return lSendMsgByte;

    }

    /**
     * 根据不同的域的类型获取对应的16进制字符串
     *
     * @param pLength
     * @param pName
     * @param plengtype
     * @param pContent
     * @param pAlign
     * @param pAlign1
     * @param pFill
     * @param pValue
     */
    private String getHexString(int pLength, String pName, String plengtype, String pContent, String pAlign, String pAlign1, String pFill, String pValue) {
        String org = pValue;
        String target = "";
        switch (pContent) {
            case "bcd":
                target = org;
                break;
            case "b":
                target = org;
                break;
            case "asc":
                target = ConvertUtils.strToHexString(org);
                break;
            case "hex":
                target = org;
                break;
            case "bitmap":
                target = getBitmap(pValue);
                break;
        }

        String target2 = "";
        switch (plengtype) {
            case "fix":
                target2 = target;
                break;
            case "llvar":
                target2 += StringUtils.fillContentBy(StringUtils.Dir.left,"0",target.length()/2+"",2)+target;
                break;
            case "lllvar":
                target2 += StringUtils.fillContentBy(StringUtils.Dir.left,"0",target.length()/2+"",4)+target;
                break;
        }

        return target2;
    }

    /**
     * 获取属性名数组
     */
    private String[] getFiledName(Object o) {
        java.lang.reflect.Field[] fields = o.getClass().getDeclaredFields();
        String[] fieldNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            fieldNames[i] = fields[i].getName();
        }
        return fieldNames;
    }

    /**
     * 根据属性名获取属性值
     */
    private Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(o, new Object[]{});
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获得bitmap
     *
     * @param bitmapStr
     *            :
     * @return 0010000000100000000000001000000000000000110000000000000000010000
     */
    protected String getBitmap(String bitmapStr) {
        String bitmap = bitmapStr;
        String str = "";
        for (int i = 1; i < 65; i++) {
            String s = StringUtils.fillContentBy(StringUtils.Dir.left, "0", i+"", 2);
            if(bitmap.contains(s)){
                str += 1;
            }else {
                str += 0;
            }
        }
        return ConvertUtils.binaryStringToHexString(str);
    }
}
