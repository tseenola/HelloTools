package tools.com.hellolibrary.hello_ssl;

import android.content.Context;
import android.util.Log;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManagerFactory;

import tools.com.hellolibrary.R;

/**
 *
 * Created by beimenshisan on 2016/11/17.
 *                  描述：android和服务器建立SSL双向通讯，
 * 客户端需要两个文件，一个是私钥文件（后缀名一般为*.keystroe,不过后缀不重要，不同程序员可能会使用不同的后缀名，
 * 有的使用keystore作为后缀,有的可能不用后缀，这个文件是服务器人员生成的客户端密钥库文件），
 * 另外一个是信任证书文件(信任证书文件是使用服务器证书crt生成的。客户端可以使用这个对服务器进行验证，
 * 名称一般用truststore****命名，这个也要转为bks格式android才能使用
 * 另外如果是服务器给的上面两个文件的给一般是jks格式，但是android版本只支持bks格式的密钥文件和信任证书文件，
 * 所以需要对这个两个文件进行格式转换，如果是java两个文件都不需要转换
 * 我在网上找的一个可以转换格式的软件名称为：keystore explorer ,网址：http://www.keystore-explorer.org/
 * 用这个软件可以将jks格式的文件转换为bks格式。
 *      1.关于bks文件的生成问题：需要下载bcprov-ext-jdk15on-150.jar————>将bcprov-ext-jdk15on-150.jar
 * 复制到%JRE_HOME%\lib\ext，与%JDK_HOME%\jre\lib\ext下————>修改%JRE_HOME%\lib\security\java.security,
 * 与%JDK_HOME%\jre\lib\security\java.security往最后添加，前面已经有10个了
 * security.provider.11=org.bouncycastle.jce.provider.BouncyCastleProvider
 * 如果用命令行转换为bks可以参考网址：http://www.myexception.cn/software/1632902.html
 * 如果是使用keystore explorer就可以直接转换了。
 * 以上两个文件都是服务器搞好以后发给客户端使用。
 *
 * 关于报错：之前出现过加载证书报 Wrong version of keystore on android call  的错误，是因为使用了jks格式的证书，转换为bks就不再报错了
 *
 */

public class SSLUtils {

    private static final String CLIENT_KET_PASSWORD = "urovo";//私钥密码
    private static final String CLIENT_TRUST_PASSWORD = "222222";//信任证书密码

    private SSLUtils() {
    }


    public static SSLSocket mSocket;

    /**
     * 获取android ssl socket双向认证socket
     *
     * @param pContext
     * @return
     */
    public static int getSocket(Context pContext,String pIp,int pPort) {
        try {
            //（1）通过指定协议（一般是TLS）获取SSL上下文（SSLContext）实例。
            SSLContext sslContext = SSLContext.getInstance("TLS");
            //（2）通过指定算法（X.509相关）获取密钥管理器工厂（KeyManagerFactory）实例。
            KeyManagerFactory keyManager = KeyManagerFactory.getInstance("X509");
            //（3）通过指定算法（X.509相关）获取信任管理器工厂（TrustManagerFactory）实例。
            TrustManagerFactory trustManager = TrustManagerFactory.getInstance("X509");
            //（4）通过指定类型和提供者获取密钥库（KeyStore）实例。提供者为BC
            KeyStore kks = KeyStore.getInstance("BKS");
            //（5）通过指定类型和提供者获取信任密钥库（KeyStore）实例。
            KeyStore tks = KeyStore.getInstance("BKS");
            //（6）（4）中密钥库实例使用约定的密码加载（Load）密钥库文件（.keystore）。
            kks.load(pContext.getResources().openRawResource(R.raw.client), CLIENT_KET_PASSWORD.toCharArray());
            //（7）（5）中信任密钥库实例使用约定的密码加载（Load）密钥库文件（.keystore）。
            tks.load(pContext.getResources().openRawResource(R.raw.truststore), CLIENT_TRUST_PASSWORD.toCharArray());
            //（8）密钥管理器工厂实例使用约定的密码和（4）中密钥库进行初始化（Initialize）。
            keyManager.init(kks, CLIENT_KET_PASSWORD.toCharArray());
            //（9）信任密钥管理器工厂实例使用约定的密码和（5）中密钥库进行初始化（Initialize）。
            trustManager.init(tks);
            //初始化SSLContext
            //（10）当SSL上下文实力初始化成功后，就可以获取该上下文实例所关联的套接字工厂（SocketFactory）实例
            sslContext.init(keyManager.getKeyManagers(), trustManager.getTrustManagers(), null);
            //（11）套接字工厂实例依据指定的主机和端口来创建（Create）客户端套接字（Socket）。
            mSocket = (SSLSocket) sslContext.getSocketFactory().createSocket(pIp,pPort);
            //（12）当SSL服务套接字创建成功，就可以向服务端发送请求，与服务端进行通信。
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("vbvb","建立连接失败"+e.getMessage());
            return -1;
        }
    }


    /**
     * 获取socket的输出信息
     *
     * @param
     * @param
     */

    public static String[] sendMsg(Context pContext ,String pIp,int pPort,byte[] paramArrayOfByte) {
        if(getSocket(pContext,pIp,pPort)!=0){
            closeSocket();
            return new String[]{"-1","建立socket失败"};
        }
        try {
            //向服务器端发送数据
            DataOutputStream out = new DataOutputStream(mSocket.getOutputStream());
            out.write(paramArrayOfByte);
            out.flush();
            out.close();


            //读取服务器端数据
            InputStream ins = mSocket.getInputStream();
            byte[] buffer = new byte[1024];

            int len = ins.read(buffer);

            String result = new String(buffer, 0, len);
            ins.close();

            closeSocket();
            return new String[]{"0",result};
        } catch (IOException pE) {
            pE.printStackTrace();
            closeSocket();
            return new String[]{"-1","发送或者接受数据异常"};
        }
    }

    /**
     * 关闭socket，结束通讯
     */
    public static void closeSocket() {
        try {
            if(mSocket!=null&&mSocket.isConnected()){
                mSocket.close();
                mSocket = null;
            }

        } catch (IOException pE) {
            pE.printStackTrace();
        }
    }

    public static interface SocketListener {
        void onConnected(SSLSocket socket);

        void onConFail();
    }

    public static interface SendMsgListener {
        void onSendSucc();

        void onSendFail();
    }

    public static interface GetMsgListener {
        void onGetFail();

        void onGetSucc(String msg);
    }
}
