package activity.key_download.present;


import com.buildpackage.model.Body_STD;

/**
 * Created by lenovo on 2017/1/5.
 * 描述：
 */

public interface IKeyDownLoadPrt {
    /**
     * 执行主密钥下载
     */
    void actionKeyDown();

    /**
     * 主密钥写入
     * @param pBody_std 报文体
     */
    void writeMasterKey(Body_STD pBody_std);
}
