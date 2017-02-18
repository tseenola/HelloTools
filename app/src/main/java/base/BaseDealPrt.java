package base;

/**
 * Created by lenovo on 2017/1/11.
 * 描述：
 */

/*public class BaseDealPrt implements IBaseDealPrt {

    @Override
    public void initSocket(String ServerIp, int iPort, int timeout) {
        final int initRet = SocketUtils.initSocket(ServerIp,iPort,timeout);
        if(initRet!=0){
            throw new IllegalStateException("建立socket失败:initRet"+initRet);
        }
    }

    @Override
    public void sendMsg(byte[] buff, int usLen) {
        final int sendMsgRet = SocketUtils.sendMsg(buff);
        if (sendMsgRet!=0){
            throw new IllegalStateException("发送失败:sendMsgRet"+sendMsgRet);
        }
    }

    @Override
    public byte[] revMsg(int MS) {
        byte revMsg[] = SocketUtils.revMsg(MS);
        if(revMsg==null){
            throw new IllegalStateException("接收失败:revMsgRet");
        }
        return revMsg;
    }

    @Override
    public void unPackRcvHexStr(Context pContexts,byte[] rcvdMsg) {
        Field lField = null;
        try {
            lField = FieldFactory.getField(pContexts, FieldFactory.DearType.unpack);
        } catch (IOException pE) {
            pE.printStackTrace();
        }
        String revMsgHexStr  = ConvertUtils.bytesToHexString(rcvdMsg);

    }
}*/
