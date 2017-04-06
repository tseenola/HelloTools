package activity.test;

import com.urovo.calculatemac.MacCalculater;

import java.util.List;

import db.bill.DBPosSettingBill;
import tools.com.hellolibrary.hello_convert.ConvertUtils;
import tools.com.hellolibrary.hello_string.StringUtils;

/**
 * Created by lenovo on 2017/4/6.
 * 描述：
 */

public class Mod2 {

    /**
     * FieldType : 64
     * MsgDes :
     * IsNeedMac : false
     * BitmapHexStr:
     * MacHexStr : [{"Length":4,"Des":"报文长度","LengType":"fix","Align":"right","ContentType":"bcd","Fill":"0","Value":"","IsOpen":true},{"Length":10,"Des":"TPDU","LengType":"fix","Align":"right","ContentType":"bcd","Fill":"0","Value":"","IsOpen":true},{"Length":12,"Des":"报文头","LengType":"fix","Align":"right","ContentType":"bcd","Fill":"0","Value":"","IsOpen":true},{"Length":4,"Des":"消息类型","LengType":"fix","Align":"right","ContentType":"bcd","Fill":"0","Value":"","IsOpen":true},{"Length":64,"Des":"位图的16进制字符串表示","LengType":"fix","Align":"right","ContentType":"b","Fill":"0","Value":"","IsOpen":true}]
     * Bodies : [{"Length":0,"FieldOrder":"f1","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":19,"FieldOrder":"f2","Des":"主账号","LengType":"llvar","Align":"left","ContentType":"bcd","Fill":"0","Value":"","IsOpen":true},{"Length":6,"FieldOrder":"f3","Des":"交易处理码","LengType":"fix","ContentType":"bcd","Align":"right","Fill":"0","Value":"","IsOpen":true},{"Length":12,"FieldOrder":"f4","Des":"交易金额","LengType":"fix","ContentType":"bcd","Align":"right","Fill":"0","Value":"","IsOpen":true},{"Length":0,"FieldOrder":"f5","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f6","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f7","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f8","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f9","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f10","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":6,"FieldOrder":"f11","Des":"流水号","LengType":"fix","ContentType":"bcd","Align":"right","Fill":"0","Value":"","IsOpen":true},{"Length":6,"FieldOrder":"f12","Des":"交易时间","LengType":"fix","ContentType":"bcd","Align":"right","Fill":"0","Value":"","IsOpen":true},{"Length":4,"FieldOrder":"f13","Des":"交易日期","LengType":"fix","ContentType":"bcd","Align":"right","Fill":"0","Value":"","IsOpen":true},{"Length":4,"FieldOrder":"f14","Des":"卡有效期","LengType":"fix","ContentType":"bcd","Align":"right","Fill":"0","Value":"","IsOpen":true},{"Length":4,"FieldOrder":"f15","Des":"清算日期","LengType":"fix","ContentType":"bcd","Align":"right","Fill":"0","Value":"","IsOpen":true},{"Length":0,"FieldOrder":"f16","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f17","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f18","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f19","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f20","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f21","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":3,"FieldOrder":"f22","Des":"服务点输入方式码","LengType":"fix","Align":"left","ContentType":"bcd","Fill":"0","Value":"","IsOpen":true},{"Length":3,"FieldOrder":"f23","Des":"卡序列号","LengType":"fix","Align":"right","ContentType":"bcd","Fill":"0","Value":"","IsOpen":true},{"Length":0,"FieldOrder":"f24","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":2,"FieldOrder":"f25","Des":"服务点条件码","LengType":"fix","ContentType":"bcd","Align":"right","Fill":" ","Value":"","IsOpen":true},{"Length":2,"FieldOrder":"f26","Des":"服务点 PIN 获取码","LengType":"fix","ContentType":"bcd","Align":"right","Fill":"0","Value":"","IsOpen":true},{"Length":0,"FieldOrder":"f27","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f28","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f29","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f30","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f31","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":11,"FieldOrder":"f32","Des":"受理机构标识码","LengType":"llvar","Align":"left","ContentType":"bcd","Fill":"0","Value":"","IsOpen":true},{"Length":0,"FieldOrder":"f33","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f34","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":37,"FieldOrder":"f35","Des":"2 磁道数据","LengType":"llvar","Align":"left","ContentType":"asc","Fill":"0","Value":"","IsOpen":true},{"Length":104,"FieldOrder":"f36","Des":"3 磁道数据","LengType":"lllvar","Align":"left","ContentType":"asc","Fill":"0","Value":"","IsOpen":true},{"Length":12,"FieldOrder":"f37","Des":"检索参考号","LengType":"fix","ContentType":"asc","Align":"left","Fill":" ","Value":"","IsOpen":true},{"Length":6,"FieldOrder":"f38","Des":"授权标识应答码","LengType":"fix","ContentType":"asc","Align":"left","Fill":" ","Value":"","IsOpen":true},{"Length":2,"FieldOrder":"f39","Des":"应答码","LengType":"fix","ContentType":"asc","Align":"left","Fill":" ","Value":"","IsOpen":true},{"Length":0,"FieldOrder":"f40","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":8,"FieldOrder":"f41","Des":"受卡机终端标识码","LengType":"fix","ContentType":"asc","Align":"left","Fill":" ","Value":"","IsOpen":true},{"Length":15,"FieldOrder":"f42","Des":"受卡方标识码","LengType":"fix","ContentType":"asc","Align":"left","Fill":" ","Value":"","IsOpen":true},{"Length":0,"FieldOrder":"f43","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":25,"FieldOrder":"f44","Des":"附加响应数据","LengType":"lllvar","ContentType":"asc","Align":"left","Fill":" ","Value":"","IsOpen":true},{"Length":0,"FieldOrder":"f45","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f46","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f47","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":512,"FieldOrder":"f48","Des":"附加数据 - 私有","LengType":"lllvar","ContentType":"bcd","Align":"left","Fill":"0","Value":"","IsOpen":true},{"Length":3,"FieldOrder":"f49","Des":"交易货币代码","LengType":"fix","ContentType":"asc","Align":"left","Fill":" ","Value":"","IsOpen":true},{"Length":0,"FieldOrder":"f50","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f51","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":8,"FieldOrder":"f52","Des":"个人标识码数据","LengType":"fix","ContentType":"asc","Align":"left","Fill":"0","Value":"","IsOpen":true},{"Length":16,"FieldOrder":"f53","Des":"安全控制信息","LengType":"fix","ContentType":"bcd","Align":"right","Fill":"0","Value":"","IsOpen":true},{"Length":20,"FieldOrder":"f54","Des":"余额","LengType":"lllvar","ContentType":"asc","Align":"left","Fill":" ","Value":"","IsOpen":true},{"Length":255,"FieldOrder":"f55","Des":" IC 卡数据域","LengType":"lllvar","ContentType":"hex","Align":"left","Fill":"0","Value":"","IsOpen":true},{"Length":0,"FieldOrder":"f56","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f57","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":100,"FieldOrder":"f58","Des":"电子钱包标准的交易信息","LengType":"lllvar","ContentType":"hex","Align":"left","Fill":"0","Value":"","IsOpen":true},{"Length":0,"FieldOrder":"f59","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":17,"FieldOrder":"f60","Des":"自定义域","LengType":"lllvar","Align":"left","ContentType":"hex","Fill":"0","Value":"","IsOpen":true},{"Length":29,"FieldOrder":"f61","Des":"原始信息域","LengType":"lllvar","Align":"left","ContentType":"bcd","Fill":" ","Value":"","IsOpen":true},{"Length":512,"FieldOrder":"f62","Des":"自定义域","LengType":"lllvar","ContentType":"bcd","Align":"left","Fill":"0","Value":"","IsOpen":true},{"Length":512,"FieldOrder":"f63","Des":"自定义域","LengType":"lllvar","ContentType":"b","Align":"left","Fill":"0","Value":"","IsOpen":true},{"Length":64,"FieldOrder":"f64","Des":"报文鉴别码","LengType":"fix","Align":"left","ContentType":"b","Fill":"0","Value":"","IsOpen":true}]
     */

    private String FieldType;
    private String MsgDes;
    private boolean IsNeedMac;
    private String MacHexStr;
    /**
     * Length : 4
     * Des : 报文长度
     * LengType : fix
     * Align : right
     * ContentType : bcd
     * Fill : 0
     * Value :
     * IsOpen : true
     */

    private List<HeadersBean> Headers;
    /**
     * Length : 0
     * FieldOrder : f1
     * Des : 备用
     * LengType :
     * Align :
     * ContentType :
     * Fill :
     * Value :
     * IsOpen : false
     */

    private List<BodiesBean> Bodies;

    public String getFieldType() {
        return FieldType;
    }

    public void setFieldType(String FieldType) {
        this.FieldType = FieldType;
    }

    public String getMsgDes() {
        return MsgDes;
    }

    public void setMsgDes(String MsgDes) {
        this.MsgDes = MsgDes;
    }

    public boolean isIsNeedMac() {
        return IsNeedMac;
    }

    public void setIsNeedMac(boolean IsNeedMac) {
        this.IsNeedMac = IsNeedMac;
    }

    public String getMacHexStr() {
        return MacHexStr;
    }

    public void setMacHexStr(String pMacHexStr) {
        MacHexStr = pMacHexStr;
    }

    public List<HeadersBean> getHeaders() {
        return Headers;
    }

    public void setHeaders(List<HeadersBean> Headers) {
        this.Headers = Headers;
    }

    public List<BodiesBean> getBodies() {
        return Bodies;
    }

    public void setBodies(List<BodiesBean> Bodies) {
        this.Bodies = Bodies;
    }

    /**
     * 报文组成（报文长度+tpdu+报文头+消息类型+位图+1到63域的值+mac）
     * 其中tpdu,报文头，消息类型已经有值。
     * 还需要求得：1到64域的值，位图，Mac，报文长度
     * 最后拼接起来就是整个报文。
     */
    public String buildMsg() {
        List<Mod2.BodiesBean> lReqBeanList = getBodies();
        String binaryBitmap = "";
        String hexBody = "";
        //1.求：1到64域的值
        for(int i = 0;i<Integer.valueOf(this.getFieldType());i++){
            Mod2.BodiesBean lReqBean = lReqBeanList.get(i);
            //拼接域的值
            hexBody+=lReqBean.getValue();
            //拼接二进制字符串位图
            if(lReqBean.getValue().equals("")){
                binaryBitmap+="0";
            }else {
                binaryBitmap+="1";
            }
        }

        //2.求：位图
        String BitmapHexStr = ConvertUtils.binaryStringToHexString(binaryBitmap);
        getHeaders().get(4).setValue(BitmapHexStr);

        //3.求：mac
        if(this.isIsNeedMac()){
            BitmapHexStr = new MacCalculater().getMac(DBPosSettingBill.getMacKeyIndex(),binaryBitmap,hexBody);
            this.setMacHexStr(BitmapHexStr);
        }

        //获取整个头部报文（tpdu+报文头+消息类型+位图）
        String hexHeader = "";
        for(int i = 0;i<this.getHeaders().size();i++){
            hexHeader+=this.getHeaders().get(i).getValue();
        }
        //获取除了报文长度以外的所有报文（tpdu+报文头+消息类型+位图+1到63域的值+mac）
        String msgHaveNoMsgLength = hexHeader+hexBody+this.getMacHexStr();
        //4.求报文长度
        int msgLen = msgHaveNoMsgLength.length() / 2;
        getHeaders().get(0).setValue(tools.com.hellolibrary.hello_string.StringUtils.fillContentBy(tools.com.hellolibrary.hello_string.StringUtils.Dir.left, "0", Integer.toHexString(msgLen).toUpperCase(), getHeaders().get(0).getLength()));
        //求整个报文（报文长度+报文头+消息类型+位图+1到63域的值+mac）；
        String headerMsg = "";
        for(int i = 0;i<this.getHeaders().size();i++){
            headerMsg+=this.getHeaders().get(i).getValue();
        }
        String finalHexMsg = headerMsg + hexBody + this.getMacHexStr();

        return finalHexMsg;
    }

    public static class HeadersBean {
        private int Length;
        private String Des;
        private String LengType;
        private String Align;
        private String ContentType;
        private String Fill;
        private String Value;
        private boolean IsOpen;

        public int getLength() {
            return Length;
        }

        public void setLength(int Length) {
            this.Length = Length;
        }

        public String getDes() {
            return Des;
        }

        public void setDes(String Des) {
            this.Des = Des;
        }

        public String getLengType() {
            return LengType;
        }

        public void setLengType(String LengType) {
            this.LengType = LengType;
        }

        public String getAlign() {
            return Align;
        }

        public void setAlign(String Align) {
            this.Align = Align;
        }

        public String getContentType() {
            return ContentType;
        }

        public void setContentType(String ContentType) {
            this.ContentType = ContentType;
        }

        public String getFill() {
            return Fill;
        }

        public void setFill(String Fill) {
            this.Fill = Fill;
        }

        public String getValue() {
            return Value;
        }

        public void setValue(String Value) {
            //如果传入的域的开关没有打开，就抛出异常提示
            if(!isIsOpen()){
                throw new IllegalStateException("\n" +
                        "~~~~(>_<)~~~~~~~~(>_<)~~~~ \n" +
                        "Ooops !!! \n"+
                        "你不能为关闭状态的域赋值，若要为该域赋值，必须先起用该域。 \n" +
                        "若起用对应的域——请在配置文件FieldInfo2.txt文件中将对应域的 IsOpen 字段设置为true。\n" +
                        "你需要启用的域基本信息如下：\n" +
                        "Des:"+Des+"\n"+
                        "Length:"+Length +"\n" +
                        "IsOpen:"+IsOpen +"\n" +
                        "~~~~(>_<)~~~~~~~~(>_<)~~~~");
            }
            this.Value = Value;
        }

        public boolean isIsOpen() {
            return IsOpen;
        }

        public void setIsOpen(boolean IsOpen) {
            this.IsOpen = IsOpen;
        }
    }

    public static class BodiesBean {
        private int Length;
        private String FieldOrder;
        private String Des;
        private String LengType;
        private String Align;
        private String ContentType;
        private String Fill;
        private String Value;
        private boolean IsOpen;

        public int getLength() {
            return Length;
        }

        public void setLength(int Length) {
            this.Length = Length;
        }

        public String getFieldOrder() {
            return FieldOrder;
        }

        public void setFieldOrder(String FieldOrder) {
            this.FieldOrder = FieldOrder;
        }

        public String getDes() {
            return Des;
        }

        public void setDes(String Des) {
            this.Des = Des;
        }

        public String getLengType() {
            return LengType;
        }

        public void setLengType(String LengType) {
            this.LengType = LengType;
        }

        public String getAlign() {
            return Align;
        }

        public void setAlign(String Align) {
            this.Align = Align;
        }

        public String getContentType() {
            return ContentType;
        }

        public void setContentType(String ContentType) {
            this.ContentType = ContentType;
        }

        public String getFill() {
            return Fill;
        }

        public void setFill(String Fill) {
            this.Fill = Fill;
        }

        public String getValue() {
            return Value;
        }

        public void setValue(String Value) {
            //如果传入的域的开关没有打开，就抛出异常提示
            if(!isIsOpen()){
                throw new IllegalStateException("\n" +
                        "~~~~(>_<)~~~~~~~~(>_<)~~~~ \n" +
                        "Ooops !!! \n"+
                        "你不能为关闭状态的域赋值，若要为该域赋值，必须先启用该域。 \n" +
                        "若想启用对应的域——请在配置文件FieldInfo2.txt文件中将对应域的 IsOpen 字段设置为true。\n" +
                        "你需要启用的域基本信息如下：\n" +
                        "Length:"+Length +"\n" +
                        "Des:"+Des+"\n"+
                        "FieldOrder:"+FieldOrder+"\n"+
                        "IsOpen:"+IsOpen +"\n" +
                        "~~~~(>_<)~~~~~~~~(>_<)~~~~");
            }
            String hexStr = formatToHex(this,Value);//对传入的值进行格式化.
            this.Value = hexStr;
        }

        public boolean isIsOpen() {
            return IsOpen;
        }

        public void setIsOpen(boolean IsOpen) {
            this.IsOpen = IsOpen;
        }

        /**
         * 将传入的值进行格式化为16进制字符串（）；
         * @param pBodiesBean
         * @param pValue
         */
        private String formatToHex(Mod2.BodiesBean pBodiesBean, String pValue) {
            //先根据类型进行转换（如果该域的类型是asc码，需要转换为16进制字符串。如果bcd不用转）
            String lTarget = "";
            switch (pBodiesBean.getContentType()) {
                case "asc":
                    lTarget = ConvertUtils.strToHexString(pValue);
                    break;
                case "bcd":
                case "hex":
                case "b":
                    lTarget = pValue;
                    break;
                default:
                    throw new NullPointerException("没有以下域的类型"+pBodiesBean.getDes());
            }
            //然后判断该域是否是定长,如果是边长还要拼接长度,如果bcd不是偶数还要根据在左边或者右边填充（填充什么根据fill）

            String pTargetValue = lTarget;
            int pTargetValueLen = lTarget.length();
            String contentType = pBodiesBean.getContentType();
            StringUtils.Dir lDir = pBodiesBean.getAlign()=="left"? StringUtils.Dir.left: StringUtils.Dir.right;
            switch (pBodiesBean.getLengType()) {
                case "fix":
                    break;
                case "llvar":
                    if (contentType == "bcd") {
                        //BCD长度为偶数
                        if (pTargetValueLen % 2 != 0) {
                            pTargetValue = StringUtils.fillContentBy(lDir, pBodiesBean.getFill(), pTargetValue, pTargetValueLen + 1);
                        }
                        pTargetValue = (tools.com.hellolibrary.hello_string.StringUtils.fillContentBy(tools.com.hellolibrary.hello_string.StringUtils.Dir.left, "0", pTargetValueLen + "", 2) + pTargetValue);
                    } else {
                        pTargetValue = (tools.com.hellolibrary.hello_string.StringUtils.fillContentBy(tools.com.hellolibrary.hello_string.StringUtils.Dir.left, "0", pTargetValueLen / 2 + "", 2) + pTargetValue);
                    }
                    break;
                case "lllvar":
                    if (contentType == "bcd") {
                        //BCD长度为偶数
                        if (pTargetValueLen % 2 != 0) {
                            pTargetValue = StringUtils.fillContentBy(lDir, pBodiesBean.getFill(), pTargetValue, pTargetValueLen + 1);
                        }
                        pTargetValue = (tools.com.hellolibrary.hello_string.StringUtils.fillContentBy(tools.com.hellolibrary.hello_string.StringUtils.Dir.left, "0", pTargetValueLen + "", 4) + pTargetValue);
                    } else {
                        pTargetValue = (tools.com.hellolibrary.hello_string.StringUtils.fillContentBy(tools.com.hellolibrary.hello_string.StringUtils.Dir.left, "0", pTargetValueLen / 2 + "", 4) + pTargetValue);
                    }
                    break;
                default:
                    throw new NullPointerException("没有找到对应长度类型");
            }
            return pTargetValue;
        }
    }
}
