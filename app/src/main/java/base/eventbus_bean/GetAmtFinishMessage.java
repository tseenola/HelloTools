package base.eventbus_bean;

/**
 * Created by lenovo on 2017/5/3.
 * 描述：当
 */

public class GetAmtFinishMessage {
    private String mAmt;
    private boolean mIsGetAmtSucc;
    public String getAmt() {
        return mAmt;
    }

    public void setAmt(String pAmt) {
        mAmt = pAmt;
    }

    public boolean isGetAmtSucc() {
        return mIsGetAmtSucc;
    }

    public void setGetAmtSucc(boolean pGetAmtSucc) {
        mIsGetAmtSucc = pGetAmtSucc;
    }
}
