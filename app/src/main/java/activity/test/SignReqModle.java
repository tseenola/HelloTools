package activity.test;

import java.util.List;

/**
 * Created by lenovo on 2017/4/2.
 * 描述：
 */

public class SignReqModle {

    /**
     * msgLength :
     * msgDes : 签到
     * msgType : 0800
     * TPDU :
     * msgHead :
     * bitmap :
     * SignReq : [{"fieldOrder":"0","length":6,"des":"交易处理码","lengthType":"fix","contentType":"bcd","align":"right","fill":"0","value":"940000","haveToExist":true},{"fieldOrder":"0","length":2,"des":"服务点条件码","lengthType":"fix","contentType":"bcd","align":"right","fill":" ","value":"14","haveToExist":true},{"fieldOrder":"0","length":8,"des":"受卡机终端标识码","lengthType":"fix","contentType":"asc","align":"left","fill":" ","value":"","haveToExist":true},{"fieldOrder":"0","length":15,"des":"受卡方标识码","lengthType":"fix","contentType":"asc","align":"left","fill":" ","value":"","haveToExist":true},{"fieldOrder":"0","length":17,"des":"自定义域","lengthType":"lllvar","align":"left","contentType":"hex","fill":"0","value":"A00199","haveToExist":true}]
     */

    private String msgLength;
    private String msgDes;
    private String msgType;
    private String TPDU;
    private String msgHead;
    private String bitmap;
    /**
     * fieldOrder : 0
     * length : 6
     * des : 交易处理码
     * lengthType : fix
     * contentType : bcd
     * align : right
     * fill : 0
     * value : 940000
     * haveToExist : true
     */

    private List<SignReqBean> SignReq;

    public String getMsgLength() {
        return msgLength;
    }

    public void setMsgLength(String msgLength) {
        this.msgLength = msgLength;
    }

    public String getMsgDes() {
        return msgDes;
    }

    public void setMsgDes(String msgDes) {
        this.msgDes = msgDes;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getTPDU() {
        return TPDU;
    }

    public void setTPDU(String TPDU) {
        this.TPDU = TPDU;
    }

    public String getMsgHead() {
        return msgHead;
    }

    public void setMsgHead(String msgHead) {
        this.msgHead = msgHead;
    }

    public String getBitmap() {
        return bitmap;
    }

    public void setBitmap(String bitmap) {
        this.bitmap = bitmap;
    }

    public List<SignReqBean> getSignReq() {
        return SignReq;
    }

    public void setSignReq(List<SignReqBean> SignReq) {
        this.SignReq = SignReq;
    }

    public static class SignReqBean {
        private String fieldOrder;
        private int length;
        private String des;
        private String lengthType;
        private String contentType;
        private String align;
        private String fill;
        private String value;
        private boolean haveToExist;

        public String getFieldOrder() {
            return fieldOrder;
        }

        public void setFieldOrder(String fieldOrder) {
            this.fieldOrder = fieldOrder;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public String getLengthType() {
            return lengthType;
        }

        public void setLengthType(String lengthType) {
            this.lengthType = lengthType;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
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
}
