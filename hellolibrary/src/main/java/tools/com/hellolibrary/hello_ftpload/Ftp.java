package tools.com.hellolibrary.hello_ftpload;

import android.support.annotation.NonNull;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by lenovo on 2016/10/25.
 * 描述：建立ftp连接，这里有个坑，url地址好像是不需要加ftp://的，否则连接错误
 */

public class Ftp {

    @NonNull
    public String ftpUpload(String url, String port, String username, String password, String remotePath, String fileNamePath, String fileName) {
        FTPClient ftpClient = new FTPClient();
        FileInputStream fis = null;
        String returnMessage = "0";
        try {
            ftpClient.connect(url, Integer.parseInt(port));
            boolean loginResult = ftpClient.login(username, password);
            int returnCode = ftpClient.getReplyCode();
            if (loginResult && FTPReply.isPositiveCompletion(returnCode)) {// 如果登录成功
                ftpClient.makeDirectory(remotePath);
                // 设置上传目录
                ftpClient.changeWorkingDirectory(remotePath);
                ftpClient.setBufferSize(1024);
                ftpClient.setControlEncoding("UTF-8");
                ftpClient.enterLocalPassiveMode();
                fis = new FileInputStream(fileNamePath + fileName);
                ftpClient.storeFile(fileName, fis);

                returnMessage = "1";   //上传成功
            } else {// 如果登录失败
                returnMessage = "0";
            }


        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("FTP客户端出错！", e);
        } finally {
            //IOUtils.closeQuietly(fis);
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("关闭FTP连接发生异常！", e);
            }
        }
        return returnMessage;
    }
}
