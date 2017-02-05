package activity.init_para.presenter;

/**
 * Created by lenovo on 2017/1/19.
 * 描述：
 */

public interface IInitParamPrt {
    /**
     * 执行ic卡参数下载
     */
    void actionIcCardParamDown();

    /**
     * 执行capk下载
     * @param pCapkSeq 下载第几条Capk
     */
    void actionCapkDown(int pCapkSeq);


    /**
     * 执行Aid下载
     * @param pAidSeq 下载第几条Aid
     */
    void actionAidDown(int pAidSeq);

    /**
     * 更新 aid和capk下载状态
     * 将是否需要下载aid和capk状态更新为false
     */
    void updateAidCapkStatus();
}
