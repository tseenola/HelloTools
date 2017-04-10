package activity.test;

/**
 * Created by lenovo on 2017/4/5.
 * 描述：
 */

/*public class Mod {

    *//**
     * FieldType : 64
     * MsgLength : 指报文长度——请在代码中根据实际报文动态为本字段赋值
     * MsgDes : 指签到或者其它——请在代码中根据实际报文动态为本字段赋值
     * MsgType : 指0800或者其它——请在代码中根据实际报文动态为本字段赋值
     * TPDU : 指tpdu——请在代码中根据实际报文动态为本字段赋值
     * MsgHead : 指报文头——请在代码中根据实际报文动态为本字段赋值
     * BitmapHexStr : 指位图的16进制字符串——请在代码中根据实际报文动态为本字段赋值
     * IsNeedMac : false
     * Req : [{"Length":0,"FieldOrder":"f1","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":19,"FieldOrder":"f2","Des":"主账号","LengType":"llvar","Align":"left","ContentType":"bcd","Fill":"0","Value":"","IsOpen":true},{"Length":6,"FieldOrder":"f3","Des":"交易处理码","LengType":"fix","ContentType":"bcd","Align":"right","Fill":"0","Value":"","IsOpen":true},{"Length":12,"FieldOrder":"f4","Des":"交易金额","LengType":"fix","ContentType":"bcd","Align":"right","Fill":"0","Value":"","IsOpen":true},{"Length":0,"FieldOrder":"f5","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f6","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f7","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f8","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f9","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f10","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":6,"FieldOrder":"f11","Des":"流水号","LengType":"fix","ContentType":"bcd","Align":"right","Fill":"0","Value":"","IsOpen":true},{"Length":6,"FieldOrder":"f12","Des":"交易时间","LengType":"fix","ContentType":"bcd","Align":"right","Fill":"0","Value":"","IsOpen":true},{"Length":4,"FieldOrder":"f13","Des":"交易日期","LengType":"fix","ContentType":"bcd","Align":"right","Fill":"0","Value":"","IsOpen":true},{"Length":4,"FieldOrder":"f14","Des":"卡有效期","LengType":"fix","ContentType":"bcd","Align":"right","Fill":"0","Value":"","IsOpen":true},{"Length":4,"FieldOrder":"f15","Des":"清算日期","LengType":"fix","ContentType":"bcd","Align":"right","Fill":"0","Value":"","IsOpen":true},{"Length":0,"FieldOrder":"f16","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f17","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f18","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f19","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f20","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f21","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":3,"FieldOrder":"f22","Des":"服务点输入方式码","LengType":"fix","Align":"left","ContentType":"bcd","Fill":"0","Value":"","IsOpen":true},{"Length":3,"FieldOrder":"f23","Des":"卡序列号","LengType":"fix","Align":"right","ContentType":"bcd","Fill":"0","Value":"","IsOpen":true},{"Length":0,"FieldOrder":"f24","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":2,"FieldOrder":"f25","Des":"服务点条件码","LengType":"fix","ContentType":"bcd","Align":"right","Fill":" ","Value":"","IsOpen":true},{"Length":2,"FieldOrder":"f26","Des":"服务点 PIN 获取码","LengType":"fix","ContentType":"bcd","Align":"right","Fill":"0","Value":"","IsOpen":true},{"Length":0,"FieldOrder":"f27","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f28","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f29","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f30","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f31","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":11,"FieldOrder":"f32","Des":"受理机构标识码","LengType":"llvar","Align":"left","ContentType":"bcd","Fill":"0","Value":"","IsOpen":true},{"Length":0,"FieldOrder":"f33","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f34","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":37,"FieldOrder":"f35","Des":"2 磁道数据","LengType":"llvar","Align":"left","ContentType":"asc","Fill":"0","Value":"","IsOpen":true},{"Length":104,"FieldOrder":"f36","Des":"3 磁道数据","LengType":"lllvar","Align":"left","ContentType":"asc","Fill":"0","Value":"","IsOpen":true},{"Length":12,"FieldOrder":"f37","Des":"检索参考号","LengType":"fix","ContentType":"asc","Align":"left","Fill":" ","Value":"","IsOpen":true},{"Length":6,"FieldOrder":"f38","Des":"授权标识应答码","LengType":"fix","ContentType":"asc","Align":"left","Fill":" ","Value":"","IsOpen":true},{"Length":2,"FieldOrder":"f39","Des":"应答码","LengType":"fix","ContentType":"asc","Align":"left","Fill":" ","Value":"","IsOpen":true},{"Length":0,"FieldOrder":"f40","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":8,"FieldOrder":"f41","Des":"受卡机终端标识码","LengType":"fix","ContentType":"asc","Align":"left","Fill":" ","Value":"","IsOpen":true},{"Length":15,"FieldOrder":"f42","Des":"受卡方标识码","LengType":"fix","ContentType":"asc","Align":"left","Fill":" ","Value":"","IsOpen":true},{"Length":0,"FieldOrder":"f43","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":25,"FieldOrder":"f44","Des":"附加响应数据","LengType":"lllvar","ContentType":"asc","Align":"left","Fill":" ","Value":"","IsOpen":true},{"Length":0,"FieldOrder":"f45","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f46","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f47","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":512,"FieldOrder":"f48","Des":"附加数据 - 私有","LengType":"lllvar","ContentType":"bcd","Align":"left","Fill":"0","Value":"","IsOpen":true},{"Length":3,"FieldOrder":"f49","Des":"交易货币代码","LengType":"fix","ContentType":"asc","Align":"left","Fill":" ","Value":"","IsOpen":true},{"Length":0,"FieldOrder":"f50","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f51","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":8,"FieldOrder":"f52","Des":"个人标识码数据","LengType":"fix","ContentType":"asc","Align":"left","Fill":"0","Value":"","IsOpen":true},{"Length":16,"FieldOrder":"f53","Des":"安全控制信息","LengType":"fix","ContentType":"bcd","Align":"right","Fill":"0","Value":"","IsOpen":true},{"Length":20,"FieldOrder":"f54","Des":"余额","LengType":"lllvar","ContentType":"asc","Align":"left","Fill":" ","Value":"","IsOpen":true},{"Length":255,"FieldOrder":"f55","Des":" IC 卡数据域","LengType":"lllvar","ContentType":"hex","Align":"left","Fill":"0","Value":"","IsOpen":true},{"Length":0,"FieldOrder":"f56","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":0,"FieldOrder":"f57","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":100,"FieldOrder":"f58","Des":"电子钱包标准的交易信息","LengType":"lllvar","ContentType":"hex","Align":"left","Fill":"0","Value":"","IsOpen":true},{"Length":0,"FieldOrder":"f59","Des":"备用","LengType":"","Align":"","ContentType":"","Fill":"","Value":"","IsOpen":false},{"Length":17,"FieldOrder":"f60","Des":"自定义域","LengType":"lllvar","Align":"left","ContentType":"hex","Fill":"0","Value":"","IsOpen":true},{"Length":29,"FieldOrder":"f61","Des":"原始信息域","LengType":"lllvar","Align":"left","ContentType":"bcd","Fill":" ","Value":"","IsOpen":true},{"Length":512,"FieldOrder":"f62","Des":"自定义域","LengType":"lllvar","ContentType":"bcd","Align":"left","Fill":"0","Value":"","IsOpen":true},{"Length":512,"FieldOrder":"f63","Des":"自定义域","LengType":"lllvar","ContentType":"b","Align":"left","Fill":"0","Value":"","IsOpen":true},{"Length":64,"FieldOrder":"f64","Des":"报文鉴别码","LengType":"fix","Align":"left","ContentType":"b","Fill":"0","Value":"","IsOpen":true}]
     *//*

    private String FieldType;
    private String MsgLength;
    private String MsgDes;
    private String MsgType;
    private String TPDU;
    private String MsgHead;
    private String BitmapHexStr;
    private boolean IsNeedMac;
    *//**
     * Length : 0
     * FieldOrder : f1
     * Des : 备用
     * LengType :
     * Align :
     * ContentType :
     * Fill :
     * Value :
     * IsOpen : false
     *//*

    private List<ReqBean> Req;
    private String mHexMsg;

    public String getFieldType() {
        return FieldType;
    }

    public void setFieldType(String FieldType) {
        this.FieldType = FieldType;
    }

    public String getMsgLength() {
        return MsgLength;
    }

    public void setMsgLength(String MsgLength) {
        this.MsgLength = MsgLength;
    }

    public String getMsgDes() {
        return MsgDes;
    }

    public void setMsgDes(String MsgDes) {
        this.MsgDes = MsgDes;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String MsgType) {
        this.MsgType = MsgType;
    }

    public String getTPDU() {
        return TPDU;
    }

    public void setTPDU(String TPDU) {
        this.TPDU = TPDU;
    }

    public String getMsgHead() {
        return MsgHead;
    }

    public void setMsgHead(String MsgHead) {
        this.MsgHead = MsgHead;
    }

    public String getBitmapHexStr() {
        return BitmapHexStr;
    }

    public void setBitmapHexStr(String BitmapHexStr) {
        this.BitmapHexStr = BitmapHexStr;
    }

    public boolean isIsNeedMac() {
        return IsNeedMac;
    }

    public void setIsNeedMac(boolean IsNeedMac) {
        this.IsNeedMac = IsNeedMac;
    }

    public List<ReqBean> getReq() {
        return Req;
    }

    public void setReq(List<ReqBean> Req) {
        this.Req = Req;
    }

    *//**
     * 构建报文
     * 报文长度+tpdu+报文头+消息类型+位图+1到64域的值+mac
     *
     *//*
    public String buildMsg() {
        List<ReqBean> lReqBeanList = getReq();
        String targetMsg = "";
        String binaryBitmap = "";
        String mac = "";
        for(int i = 0;i<Integer.valueOf(this.getFieldType());i++){
            ReqBean lReqBean = lReqBeanList.get(i);
            //拼接域的值
            targetMsg+=lReqBean.getValue();
            //拼接位图
            if(lReqBean.getValue().equals("")){
                binaryBitmap+="0";
            }else {
                binaryBitmap+="1";
            }
        }
        //binary字符串转换为16进制字符串
        BitmapHexStr = ConvertUtils.binaryStringToHexString(binaryBitmap);
        //判断是否需要计算mac

        if(this.isIsNeedMac()){
            mac = new MacCalculater().getMac(DBPosSettingBill.getMacKeyIndex(),binaryBitmap,targetMsg);
        }
        String msg = this.getTPDU()+this.getMsgHead()+this.getMsgType()+BitmapHexStr+targetMsg+mac;
        //拼接长度
        int msgLen = msg.length() / 2;
        msg = tools.com.hellolibrary.hello_string.StringUtils.fillContentBy(tools.com.hellolibrary.hello_string.StringUtils.Dir.left, "0", Integer.toHexString(msgLen).toUpperCase(), 4) + msg;
        return msg;
    }

    public static class ReqBean {
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
                throw new IllegalStateException("\r\n" +
                        "~~~~(>_<)~~~~~~~~(>_<)~~~~ \r\n" +
                        "你不能为关闭状态的域赋值，若要为该域赋值，必须先起用该域。 \r\n" +
                        "若起用对应的域，请在配置文件FieldInfo2.txt文件中将对应域的 IsOpen 字段设置为true。\r\n" +
                        "你需要启用的域基本信息如下：\r\n" +
                        "Length:"+Length +"\r\n" +
                        "FieldOrder:"+FieldOrder+"\r\n"+
                        "IsOpen:"+IsOpen +"\r\n" +
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

        *//**
         * 将传入的值进行格式化为16进制字符串（）；
         * @param pReqBean
         * @param pValue
         *//*
        private String formatToHex(ReqBean pReqBean, String pValue) {
            //先根据类型进行转换（如果该域的类型是asc码，需要转换为16进制字符串。如果bcd不用转）
            String lTarget = "";
            switch (pReqBean.getContentType()) {
                case "asc":
                    lTarget = ConvertUtils.strToHexString(pValue);
                    break;
                case "bcd":
                case "hex":
                case "bitmap":
                    lTarget = pValue;
                    break;
                default:
                    throw new NullPointerException("没有找到对应域类型");
            }
            //然后判断该域是否是定长,如果是边长还要拼接长度,如果bcd不是偶数还要根据在左边或者右边填充（填充什么根据fill）

            String pTargetValue = lTarget;
            int pTargetValueLen = lTarget.length();
            String contentType = pReqBean.getContentType();
            StringUtils.Dir lDir = pReqBean.getAlign()=="left"? StringUtils.Dir.left: StringUtils.Dir.right;
            switch (pReqBean.getLengType()) {
                case "fix":
                    break;
                case "llvar":
                    if (contentType == "bcd") {
                        //BCD长度为偶数
                        if (pTargetValueLen % 2 != 0) {
                            pTargetValue = StringUtils.fillContentBy(lDir, pReqBean.getFill(), pTargetValue, pTargetValueLen + 1);
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
                            pTargetValue = StringUtils.fillContentBy(lDir, pReqBean.getFill(), pTargetValue, pTargetValueLen + 1);
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
}*/
