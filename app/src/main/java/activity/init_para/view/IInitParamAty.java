package activity.init_para.view;

/**
 * Created by lenovo on 2017/1/19.
 * 描述：
 */

public interface IInitParamAty {
    /**
     * ic卡参数下载成功
     * @param pAidNo 需要下载的aid数量
     * @param pCapkNo 需要下载的capk数量
     */
    void onICParamDownSucc(int pAidNo,int pCapkNo);

    /**
     * ic卡参数下载失败
     * @param pMsg
     */
    void onICParamDownInFail(String pMsg);

    /**
     * CAPK下载
     * @param pMsg
     * @param pCapkSeq
     */
    void onCAPKDownDownSucc(String pMsg, int pCapkSeq);
    void onCAPKDownDownInFail(String pMsg);

    /**
     * aid下载
     * @param pMsg
     */
    void onAidDownSucc(String pMsg,int pWitchAid);
    void onAidDownInFail(String pMsg);
}
