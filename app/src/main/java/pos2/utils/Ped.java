package pos2.utils;

/*public class Ped {
    private static MaxqManager mMaxqManager = null;

    public Ped() {
        Maxq1850init();
    }

    private static boolean Maxq1850init() {
        mMaxqManager = new MaxqManager();
        int ret = mMaxqManager.open();
        if (ret != 0)
            return false;

        return true;
    }

    private static boolean Maxqinit() {
        int ret = 0;

        if (mMaxqManager == null) {
            mMaxqManager = new MaxqManager();
            ret = mMaxqManager.open();
        }

        if (ret != 0)
            return false;
        return true;
    }

    *//**用指定密钥DES/3DES运算的内部方法
     * @param KeyIdx
     * @param data
     * @param datalen
     * @param key
     * @param out
     * @param mode
     * @return
     *//*
    *//*private static int Do3Des(int KeyIdx, byte[] data, int datalen, byte[] key, byte out[], int mode) {
        int ret = -255;
        int j = datalen / 8;
        int k = datalen % 8;
//        byte[] key1 = new byte[8];
//        byte[] key2 = new byte[8];
        byte[] result = new byte[8];
        byte[] buff = new byte[8];

        if (k != 0)
            j++;

        byte[] datas = new byte[j * 8];
        byte[] outs = new byte[j * 8];

        Maxqinit();

        System.arraycopy(data, 0, datas, 0, datalen);

        if (mode == 0) {
            // ECB解密
            for (int i = 0; i < j; i++) {
                System.arraycopy(datas, i * 8, buff, 0, 8);
                ret = Urovo_PciDes(Constants.KEY_TYPE._ENCRPTKEY, KeyIdx, 8, buff, result, 0x00);
                System.arraycopy(result, 0, outs, i * 8, 8);
            }
        }
        else if (mode == 1) {
            // ECB加密
            for (int i = 0; i < j; i++) {
                System.arraycopy(datas, i * 8, buff, 0, 8);
                ret = Urovo_PciDes(Constants.KEY_TYPE._ENCRPTKEY, KeyIdx, 8, buff, result, 0x01);
                System.arraycopy(result, 0, outs, i * 8, 8);
            }
        }
        else if (mode == 2) {
            // CBC解密，还没有实现
//            for (int i = 0; i < j; i++) {
//                System.arraycopy(datas, i * 8, buff, 0, 8);
//                ret = Urovo_PciDes(Constants.KEY_TYPE._ENCRPTKEY, KeyIdx, 8, buff, result, 0x00);
//                System.arraycopy(result, 0, outs, i * 8, 8);
//            }
        }
        else if (mode == 3) {
            // CBC加密
            byte[] intvalue = new byte[8];
            for (int i = 0; i < j; i++) {
                System.arraycopy(result, 0, intvalue, 0, 8);
                System.arraycopy(datas, i * 8, buff, 0, 8);
                buff = Funs.getxor(buff, intvalue, 8);
                ret = Urovo_PciDes(Constants.KEY_TYPE._ENCRPTKEY, KeyIdx, 8, buff, result, 0x01);
                System.arraycopy(result, 0, outs, i * 8, 8);
            }
        }
        System.arraycopy(outs, 0, out, 0, datalen);
        return ret;
    }*//*

    *//**
     * 写入主密钥
     *
     * @param KeyType  :密钥类型,
     * @param key_no   :密钥号
     * @param key_len  :密钥长度(一般十六个字节长)
     * @param key_data :密钥数据(明文) 返回0成功，非0不成功
     *//*
    public static int Urovo_PCIWriteMKey(int KeyType, int key_no, int key_len, byte[] key_data) {
        int iRet = 0;
        byte[] response = new byte[16];
        byte[] reslen = new byte[1];
        byte kt = 0;

        Maxqinit();

        if (KeyType == Constants.KEY_TYPE._TLK)
            kt = Constants.KEY_TYPE._MASTKEY;
        else
            kt = (byte) KeyType;

        for (int i = 1; i <= 7; i++){
            iRet = mMaxqManager.deleteKey(i, key_no, response, reslen);
            Log.i("vbvb","delete:"+iRet);
        }
        iRet = mMaxqManager.loadKey(kt, key_no, 0, key_data, key_len, response, reslen);
        return iRet;
    }

    *//**通过KEK写入MasterKey
     * @param masterKeyIndex 主密钥索引
     * @param kekLen	KEK字节长度
     * @param kekData KEK字节数组
     * @param masterSecLen masterKey密文长度
     * @param masterSecData masterKey密文字节数组
     * @return 0：成功； -1：写入KEK失败；-2：主密钥解密失败；-3写入主密钥明文失败
     *//*
    public static int writeMasterKeyByKEK(int masterKeyIndex, int kekLen, byte[] kekData, int masterSecLen, byte[] masterSecData) {
        int iRet = Urovo_PCIWriteMKey(Constants.KEY_TYPE._MASTKEY, masterKeyIndex, kekLen, kekData);
        if(iRet != 0) {
            return -1;
        }
        byte[] masterKeyData = new byte[masterSecLen];
        iRet = Urovo_PciDes(Constants.KEY_TYPE._MASTKEY, masterKeyIndex,
                masterSecLen, masterSecData,
                masterKeyData, 0x00);
        if(iRet != 0) {
            return -2;
        }
        iRet = Urovo_PCIWriteMKey(Constants.KEY_TYPE._MASTKEY, masterKeyIndex, masterKeyData.length, masterKeyData);
        if(iRet != 0) {
            return -3;
        }
        return 0;
    }

    *//**
     * 指定的密钥号做运算
     *
     * @param KeyType :密钥类型,
     * @param key_no  :密钥号
     * @param inlen   :密钥长度(一般十六个字节长)
     * @param indata  :被加解密的数据
     * @param desout  :结果
     * @param mode    :1为加密，0为解密
     * @return 返回0成功，非0不成功
     *//*
    public static int Urovo_PciDes(int KeyType, int key_no, int inlen, byte[] indata, byte[] desout, int mode) {
        int iRet;
        byte[] reslen = new byte[1];
        byte[] dStartValue = new byte[8];
        int kt = 0;

        Maxqinit();

        if (KeyType == Constants.KEY_TYPE._TLK)
            kt = Constants.KEY_TYPE._MASTKEY;
        else
            kt = (byte) KeyType;

        if (mode == 0x01)
            iRet = mMaxqManager.encryptData(kt, key_no, 1, dStartValue, 8, 0x00, indata, inlen, desout, reslen);
        else
            iRet = mMaxqManager.decryptData(kt, key_no, 1, dStartValue, 8, 0x00, indata, inlen, desout, reslen);

        return iRet;
    }

    *//**
     * 写工作密钥
     *
     * @param KeyType     :密钥类型,
     * @param key_no      :密钥号
     * @param key_len     :密钥长度(一般十六个字节长)
     * @param key_data    :被写进去的密钥
     * @param mkey_no     :为主密钥号,是通过这个索引对应的主密钥对key_data运算
     * @param sbcdMacbuff :检验值
     * @param iCheckMode  :1要求校验，0不要校验 返回0成功，非0不成功
     *//*
    *//*public static int Urovo_PciWriteWorkKey(int KeyType, int key_no, int key_len, byte[] key_data, int mkey_no, byte[] sbcdMacbuff, int iCheckMode) {
        int iRet;
        byte[] reslen = new byte[1];
        byte[] dStartValue = new byte[8];

        byte[] response = new byte[16];
        byte[] sTemp = new byte[32 + 1];
        byte[] sbuf = new byte[33];
        int kt = 0;

        if (KeyType == Constants.KEY_TYPE._TLK)
            kt = Constants.KEY_TYPE._MASTKEY;
        else
            kt = (byte) KeyType;

        Maxqinit();
        // 先用test ID写进去。
        for (int i = 1; i <= 7; i++) {
            iRet = mMaxqManager.deleteKey(i, Constants._PED_TESTKEY_ID, response, reslen);
        }

        iRet = mMaxqManager.loadKey(Constants.KEY_TYPE._MACKEY, Constants._PED_TESTKEY_ID, mkey_no, key_data, key_len, response, reslen);
        if (iRet != 0x00)
            return ResponseCode._PCI_MAXQ32550_ERROR;

        Arrays.fill(sTemp, (byte) 0);
        Arrays.fill(sbuf, (byte) 0);

        // 对8个0做3des运算
        iRet = mMaxqManager.encryptData(Constants.KEY_TYPE._MACKEY, Constants._PED_TESTKEY_ID, 1, dStartValue, 8, 0x00, sTemp, 8, sbuf, reslen);


        if (iRet != 0x00)
            return ResponseCode._PCI_MAXQ32550_ERROR;

        if (iCheckMode == 1)
            if (Funs.comparabytes(sbcdMacbuff, sbuf, 4) != 0)
                return ResponseCode._OPER_VERIFY_ERROR;
        for (int i = 1; i <= 7; i++)
            iRet = mMaxqManager.deleteKey(i, key_no, response, reslen);

        iRet = mMaxqManager.loadKey(kt, key_no, mkey_no, key_data, key_len, response, reslen);
        return iRet;
    }*//*

    *//*public static int PINDES(int keyIndex, String CarNo, String PinD, String[] Pin_OUT) {
        int i, n;
        int j = 0;
        // 处理帐号
        int iRet;
        byte[] PAN = new byte[17];
        byte[] BCarNo = CarNo.getBytes();
        byte[] card_buf = new byte[16];

        iRet = Funs.ExtractPAN(BCarNo, PAN);
        Funs.AscToBcd(card_buf, PAN, 16);

        byte[] pin = PinD.getBytes();
        byte[] pin_buf = new byte[17];
        byte[] enpin_buf = new byte[8];
        byte[] buf = new byte[20];

        pin_buf[0] = (byte) pin.length;
        System.arraycopy(pin, 0, buf, 0, pin.length);
        n = pin.length;
        for (i = n; i < 17; i++) {
            buf[i] = 'F';
        }
        byte[] tempbuff = new byte[7];

        ConvertUtils.AscToBcd(tempbuff, buf, 14);
        System.arraycopy(tempbuff, 0, pin_buf, 1, 7);

        ConvertUtils.do_xor_urovo(card_buf, pin_buf, 8);
        Arrays.fill(enpin_buf, (byte) 0);
        System.arraycopy(card_buf, 0, enpin_buf, 0, 8);

        byte[] pin_out = new byte[8];
        if (Constants.Pin1850) {
            for (j = 0; j < 3; j++) {
                iRet = Urovo_PciDes(Constants.KEY_TYPE._PINKEY, Integer.parseInt(ConfigUtil.getParamValue(keyIndex, "iPinKIndex")), 8, enpin_buf, pin_out, 1);
                if (iRet == 0) {
                    break;
                }
            }

            if (iRet != 0) {
                return ResponseCode._PCI_MAXQ32550_ERROR;
            }
        } else if (Constants.PinTxt) {

        }

        if (iRet == 0) {
            byte[] byteArray = new byte[16];
            ConvertUtils.BcdToAsc(byteArray, pin_out, 16);
            String strout = new String(byteArray);
            Pin_OUT[0] = strout;
            return 0;
        } else {
            return iRet;
        }
    }*//*

    public int GetMac(int macKeyIndex, short DataInLen, byte[] DataIn, byte[] MacOut, byte mode) {
        byte[] buf = new byte[17];
        byte[] tmpbuf = new byte[17];
        int i, l, k, iRet = 0;

        byte[] inbuf = new byte[DataInLen + 8];
        byte[] Macbuf = new byte[9];

        Arrays.fill(buf, (byte) 0x00);
        System.arraycopy(DataIn, 0, inbuf, 0, DataInLen);

        if (DataInLen % 8 != 0)
            l = DataInLen / 8 + 1;
        else
            l = DataInLen / 8;

        if (mode == 0x00) {
            for (i = 0; i < l; i++) {
                for (k = 0; k < 8; k++)
                    buf[k] ^= inbuf[i * 8 + k];
                buf[8] = 0x00;
            }

            iRet = Urovo_PciDes(Constants.KEY_TYPE._MACKEY, macKeyIndex, 8, buf, Macbuf, 1);
            if(iRet != 0) {
                return -1;
            }
            System.arraycopy(Macbuf, 0, MacOut, 0, 8);
            return 0;
        }
        else if (mode == 0x10) {
            buf = new byte[8];
            for (i = 0; i < l; i++)
                for (k = 0; k < 8; k++)
                    buf[k] ^= inbuf[i * 8 + k];

            ConvertUtils.BcdToAsc(tmpbuf, buf, 16);
            tmpbuf[16] = 0;

            System.arraycopy(tmpbuf, 0, buf, 0, 8);

            iRet = Urovo_PciDes(Constants.KEY_TYPE._MACKEY, macKeyIndex, 8, buf, Macbuf, 1);

            Arrays.fill(buf, (byte) 0x00);
            System.arraycopy(Macbuf, 0, buf, 0, 8);

            for (k = 0; k < 8; k++)
                buf[k] ^= tmpbuf[8 + k];

            Arrays.fill(Macbuf, (byte) 0x00);

            iRet = Urovo_PciDes(Constants.KEY_TYPE._MACKEY, macKeyIndex, 8, buf, Macbuf, 1);

            Arrays.fill(buf, (byte) 0x00);
            System.arraycopy(Macbuf, 0, buf, 0, 8);

            Arrays.fill(tmpbuf, (byte) 0x00);
            ConvertUtils.BcdToAsc(tmpbuf, buf, 16);
            System.arraycopy(tmpbuf, 0, MacOut, 0, 8);

            return 0;
        }
        return -2;
    }

    *//**用指定密钥块进行DES/3DES运算
     * @param KeyIdx 待运算的密钥索引
     * @param DataInLen 输入数据长度
     * @param DataIn 输入数据
     * @param DataOut 输出数据
     * @param mode 0-ECB解密；1-ECB加密
     * @return
     *//*
    *//*public static int CalcDES(int KeyIdx, int DataInLen, byte[] DataIn, byte[] DataOut, int mode) {
        byte[] plantbuf = new byte[16];

        if (mode == 0x00) {
            // ECB解密
            return Do3Des(KeyIdx, DataIn, DataInLen, plantbuf, DataOut, 0x00);
        }
        else if (mode == 0x01) {
            // ECB加密
            return Do3Des(KeyIdx, DataIn, DataInLen, plantbuf, DataOut, 0x01);
        }
        else if (mode == 0x02) {

        }
        else if (mode == 0x03) {
            // CBC加密
        }
        return 0;
    }*//*

    *//*public int WriteKey(int srcKeyType, int srcKeyIdx, int dstKeyType, int dstKeyIdx, int algthflag, int dstKeyLen, byte[] bufIn, int iCheckMode, int checkbuflen, byte[] aucCheckBuf) {
        int iRet = 0;
        byte[] buf = new byte[16];

        Maxqinit();

        // 先确定要被写入的是什么类型的密钥
        switch (dstKeyType) {
            case Constants.KEY_TYPE._TLK:
                //TLK明文加密,先不管,暂时不会用到
                // 以明文方式 srcKeyIdx应该不用判断。只要srcKeyType表示是明文。就不需要考虑srcKeyIdx
                if (srcKeyType == 0x00) {
                    iRet = Urovo_PCIWriteMKey(dstKeyType, (byte) 0, (byte) dstKeyLen, bufIn);
                    if (iRet != 0)
                        return ResponseCode._PCI_MAXQ32550_ERROR;

                    return iRet;
                } else if (srcKeyType == Constants.KEY_TYPE._TLK) {
                    // 先用原来的密钥解出来，再存进去
                    iRet = Urovo_PciDes(Constants.KEY_TYPE._TLK, dstKeyLen, 0, bufIn, buf, 0);
                    if (iRet != 0)
                        return ResponseCode._PCI_MAXQ32550_ERROR;

                    iRet = Urovo_PCIWriteMKey(dstKeyType, (byte) 0, (byte) dstKeyLen, buf);
                    if (iRet != 0)
                        return ResponseCode._PCI_MAXQ32550_ERROR;

                    return iRet;
                }
                break;
            case Constants.KEY_TYPE._MASTKEY:
                if (srcKeyType == 0x00) {
                    //写工作密钥
                    iRet = Urovo_PCIWriteMKey(dstKeyType, dstKeyIdx, dstKeyLen, bufIn);
                    if (iRet != 0)
                        return ResponseCode._PCI_MAXQ32550_ERROR;

                    return iRet;
                } else if (srcKeyType == Constants.KEY_TYPE._TLK) {
                    // 先用原来的密钥解出来，再存进去
                    iRet = Urovo_PciDes(Constants.KEY_TYPE._TLK, dstKeyLen, 0, bufIn, buf, 0);
                    if (iRet != 0)
                        return ResponseCode._PCI_MAXQ32550_ERROR;

                    iRet = Urovo_PCIWriteMKey(dstKeyType, dstKeyIdx, dstKeyLen, buf);
                    if (iRet != 0)
                        return ResponseCode._PCI_MAXQ32550_ERROR;
                    return iRet;
                }
                break;
            case Constants.KEY_TYPE._ENCRPTKEY:
            case Constants.KEY_TYPE._MACKEY:
            case Constants.KEY_TYPE._PINKEY:
                //写工作密钥
                iRet = Urovo_PciWriteWorkKey(dstKeyType, dstKeyIdx, dstKeyLen, bufIn, srcKeyIdx, aucCheckBuf, iCheckMode);
                return iRet;
            default:
                return ResponseCode._NORMAL_ERROR;
        }

        return ResponseCode._NORMAL_ERROR;
    }*//*
}*/
