package utils;

import android.text.TextUtils;


import com.urovo.poscommon.models.KeyType;
import com.urovo.poscommon.utils.Ped;

import db.bill.DBPosSettingBill;
import tools.com.hellolibrary.hello_convert.ConvertUtils;
import tools.com.hellolibrary.hello_string.StringUtils;

/**对敏感数据进行处理的工具类
 * Created by KuCoffee on 2016/12/28.
 */

public class SensitiveDataUtil {

    /**根据敏感数据规则要求，如果是2域或者14域，全部用0替换
     * 如果是35域或者36域前32位全部用0替换
     * @param orgData
     * @return
     */
    public static String hideSensitiveData(int field ,String orgData) {
        String data = "";
        if(TextUtils.isEmpty(orgData)){
            return "";
        }
        if(field==2 || field==14) {
            return StringUtils.fillContentBy(StringUtils.Dir.left, "0", "0", orgData.length());
        }else if(field==35||field==36){
            data = orgData.replace("=", "D");
            if(data.length()<=32){
                data = StringUtils.fillContentBy(StringUtils.Dir.left, "0", "0", 32);
            }else{
                data = StringUtils.fillContentBy(StringUtils.Dir.left, "0", "0", 32)+data.substring(32);
            }
        }
        return data;
    }

    /**获取加密后的敏感信息
     * @param datas 卡号、有效期、CVD2、第2磁条、第3磁条
     * @return
     */
    public static String getEncryptionData(int keyIndex, String[] datas) {
        String resultTxt = "A00201";
        String sensitiveData = "";
        byte[] bitmap = new byte[2];
        if(!TextUtils.isEmpty(datas[0])) {//卡号
            bitmap[0] ^= 0x80;
            if(datas[0].length() <= 19) {
                sensitiveData += datas[0];
            }
            else {
                sensitiveData += datas[0].substring(0, 19);
            }
            sensitiveData += "F";
        }
        if(!TextUtils.isEmpty(datas[1])) {
            bitmap[0] ^= 0x40;
            sensitiveData += datas[1];
            sensitiveData += "F";
        }
        if(!TextUtils.isEmpty(datas[2])) {
            bitmap[0] ^= 0x20;
            sensitiveData += datas[2];
            sensitiveData += "F";
        }
        if(!TextUtils.isEmpty(datas[3])) {
            bitmap[0] ^= 0x10;
            if(datas[3].length() <= 32) {
                sensitiveData += datas[3];
            }
            else {
                sensitiveData += datas[3].substring(0, 32);
            }
            sensitiveData += "F";
        }
        if(!TextUtils.isEmpty(datas[4])) {
            bitmap[0] ^= 0x08;
            if(datas[4].length() <= 32) {
                sensitiveData += datas[4];
            }
            else {
                sensitiveData += datas[4].substring(0, 32);
            }
            sensitiveData += "F";
        }

        if(sensitiveData.length() / 16 != 0) {
            int addCount = 16 - (sensitiveData.length() % 16);
            for(int i = 0; i < addCount; ++i) {
                sensitiveData += "F";
            }
        }

        byte[] ascBitmap = new byte[bitmap.length * 2];
        ConvertUtils.BcdToAsc(ascBitmap, bitmap, ascBitmap.length);
        resultTxt += new String(ascBitmap);//位图

        byte[] ascSens = sensitiveData.getBytes();
        byte[] bcdSens = new byte[ascSens.length / 2];//待加密数据
        ConvertUtils.AscToBcd(bcdSens, ascSens, ascSens.length);
        byte[] bcdSec = new byte[bcdSens.length];//加密后的数据
        for(int i = 0; i < (bcdSens.length / 8); ++i) {
            byte[] indata = new byte[8];
            byte[] outdata = new byte[8];
            System.arraycopy(bcdSens, i * 8, indata, 0, 8);
            int iRet = Ped.Urovo_PciDes(KeyType._MACKEY,
                    DBPosSettingBill.getMacKeyIndex(),
                    indata.length, indata,
                    outdata,
                    0x01);
            if(iRet != 0) {
                throw new IllegalStateException("敏感数据加密失败");
            }
            System.arraycopy(outdata, 0, bcdSec, i * 8, 8);
        }
        byte[] ascSec = new byte[bcdSec.length * 2];
        ConvertUtils.BcdToAsc(ascSec, bcdSec, ascSec.length);
        resultTxt += new String(ascSec);
        return resultTxt;
    }

    /*public void AscToBcd(byte[] sBcdBuf, byte[] sAscBuf, int iAscLen) {
        int i, j;

        j = 0;

        for (i = 0; i < (iAscLen + 1) / 2; i++) {
            sBcdBuf[i] = (byte) (aasc_to_bcd(sAscBuf[j++]) << 4);
            if (j >= iAscLen) {
                sBcdBuf[i] |= 0x00;
            } else {
                sBcdBuf[i] |= aasc_to_bcd(sAscBuf[j++]);
            }
        }
    }

    public static void BcdToAsc(byte[] sAscBuf, byte[] sBcdBuf, int iAscLen) {
        int i, j;

        j = 0;
        for (i = 0; i < iAscLen / 2; i++) {
            sAscBuf[j] = (byte) ((sBcdBuf[i] & 0xf0) >> 4);
            sAscBuf[j] = abcd_to_asc(sAscBuf[j]);
            j++;
            sAscBuf[j] = (byte) (sBcdBuf[i] & 0x0f);
            sAscBuf[j] = abcd_to_asc(sAscBuf[j]);
            j++;
        }
        if (iAscLen % 2 != 0) {
            sAscBuf[j] = (byte) ((sBcdBuf[i] & 0xf0) >> 4);
            sAscBuf[j] = abcd_to_asc(sAscBuf[j]);
        }
    }*/
}
