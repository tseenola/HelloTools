package service;

import android.util.Log;

import com.jniexport.UROPElibJni;

import core.CardReader;
import models.CardInfoModel;
import models.SwipedMode;


public class MagReadService extends BaseReadService{
    // 磁条卡刷卡状态
    protected boolean MagCardReadSuccess = false;
    /**
     * 读磁条卡
     */
    public void ReadMagCard() {
        byte[] strip = new byte[2];
        byte[] tracks = new byte[256];

        if (!MagCardReadSuccess) {
            int ret = UROPElibJni.MagCardCheck(strip);
            if (ret == 0 && strip[0] != 0) {
                ret = UROPElibJni.MagCardGetTracks(tracks);
                if (ret == 0) {
                    try {
                        CardInfoModel cardInfo = new CardInfoModel();
                        String[] tempTracks = GetMagCardStr(tracks);

                        if (tempTracks[0] != null && !tempTracks[0].equals("")) {
                            cardInfo.setTrack1(tempTracks[0]);
                        }
                        if (tempTracks[1] != null && !tempTracks[1].equals("")) {
                            cardInfo.setTrack2(tempTracks[1]);

                            int index = tempTracks[1].indexOf("=");
                            if(index > 0) {
                                // 卡号
                                cardInfo.setCardNo(tempTracks[1].substring(0, index));
                                // 有效期
                                cardInfo.setValidTime(tempTracks[1].substring(index + 1, index + 5));
                            }
                        }
                        if (tempTracks[2] != null && !tempTracks[2].equals("")) {
                            cardInfo.setTrack3(tempTracks[2]);
                        }
                        if (!cardInfo.getCardNo().isEmpty()) {
                            MagCardReadSuccess = true;
                            cardInfo.setSwipedMode(SwipedMode.CARD_SWIPED);
                            sendSuccMsgToUiThread(cardInfo);
                        }
                    } catch (Exception ex) {
                        Log.i("vbvb",ex.getMessage());
                        sendFailMsgToUiThread("读取磁条卡出错");
                    }
                }
            }
        }
    }

    public MagReadService(CardReader.OnReadCardFinish pOnReadCardFinish) {
        mOnReadCardFinish = pOnReadCardFinish;
        this.MagCardReadSuccess = false;
    }

    public static String[] GetMagCardStr(byte[] Tracks) {
        String[] trackInfo = new String[3];
        int len = Tracks.length;
        int Tlen = 0;
        for (int i = 0; i < len; i++) {
            if (Tracks[i] == (byte) 0xD1) {
                i++;
                Tlen = Tracks[i];
                if (Tlen > 512) {
                    Tlen = 512;
                }
                byte[] Btrack1 = new byte[Tlen];
                i++;
                System.arraycopy(Tracks, i, Btrack1, 0, Tlen);
                trackInfo[0] = new String(Btrack1);
                i += Tlen;
            }
            if (Tracks[i] == (byte) 0xD2) {
                i++;
                Tlen = Tracks[i];
                if (Tlen > 512) {
                    Tlen = 512;
                }
                byte[] Btrack2 = new byte[Tlen];
                i++;
                System.arraycopy(Tracks, i, Btrack2, 0, Tlen);
                trackInfo[1] = new String(Btrack2);
                i += Tlen;
            }
            if (Tracks[i] == (byte) 0xD3) {
                i++;
                Tlen = Tracks[i];
                if (Tlen > 512) {
                    Tlen = 512;
                }
                byte[] Btrack3 = new byte[Tlen];
                i++;
                System.arraycopy(Tracks, i, Btrack3, 0, Tlen);
                trackInfo[2] = new String(Btrack3);
                i += Tlen;
            }
        }
        return trackInfo;
    }


}
