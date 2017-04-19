package com.customview.keytool.triple_des.algorithm;

import com.customview.keytool.des.algorithm.DesImpl;
import com.customview.keytool.des.utils.DesUtils;

import tools.com.hellolibrary.hello_convert.ConvertUtils;

/**
 * Created by lenovo on 2017/4/11.
 * 描述：3des加密默认实现类，此类实现了{@link ITripleDes}
 */

public class TripleDesImpl implements ITripleDes{
    private TripleDesImpl(){}
    private static final TripleDesImpl mTripleDesImpl = new TripleDesImpl();
    public static ITripleDes getInstance() {
        return mTripleDesImpl;
    }

    @Override
    public byte[] encrypt_16(byte[] pKey, byte[] pData) throws Exception {
        checkParams16(pKey,pData);

        byte k1[] = new byte [8];
        byte k2[] = new byte [8];
        System.arraycopy(pKey, 0, k1, 0, 8);
        System.arraycopy(pKey, 8, k2, 0, 8);
        byte k3 [] = k1;

        byte encypt1 [] = DesUtils.encrypt(k1,pData,DesImpl.getInstance());
        byte decypt2 [] = DesUtils.decrypt(k2,encypt1,DesImpl.getInstance());
        byte encypt3 [] = DesUtils.encrypt(k3,decypt2,DesImpl.getInstance());

        return encypt3;
    }

    @Override
    public byte[] encrypt_16(String pHexStrKey, String pHexStrData) throws Exception {
        byte lKeys []= ConvertUtils.hexStringToByte(pHexStrKey);
        byte lDatas [] = ConvertUtils.hexStringToByte(pHexStrData);
        return encrypt_16(lKeys,lDatas);
    }

    @Override
    public byte[] decrypt_16(byte[] pKey, byte[] pData) throws Exception {
        checkParams16(pKey,pData);

        byte k1[] = new byte [8];
        byte k2[] = new byte [8];
        System.arraycopy(pKey, 0, k1, 0, 8);
        System.arraycopy(pKey, 8, k2, 0, 8);
        byte k3 [] = k1;

        byte decypt3 [] = DesUtils.decrypt(k3,pData,DesImpl.getInstance());
        byte encypt2 [] = DesUtils.encrypt(k2,decypt3,DesImpl.getInstance());
        byte decypt1 [] = DesUtils.decrypt(k1,encypt2,DesImpl.getInstance());

        return decypt1;
    }

    @Override
    public byte[] decrypt_16(String pHexStrKey, String pHexStrData) throws Exception {
        byte lKeys []= ConvertUtils.hexStringToByte(pHexStrKey);
        byte lDatas [] = ConvertUtils.hexStringToByte(pHexStrData);
        return decrypt_16(lKeys,lDatas);
    }

    @Override
    public byte[] encrypt_24(byte[] pKey, byte[] pData) throws Exception {
        checkParams24(pKey,pData);

        byte k1[] = new byte [8];
        byte k2[] = new byte [8];
        byte k3[] = new byte [8];
        System.arraycopy(pKey, 0, k1, 0, 8);
        System.arraycopy(pKey, 8, k2, 0, 8);
        System.arraycopy(pKey, 16,k3, 0, 8);

        byte encypt1 [] = DesUtils.encrypt(k1,pData,DesImpl.getInstance());
        byte decypt2 [] = DesUtils.decrypt(k2,encypt1,DesImpl.getInstance());
        byte encypt3 [] = DesUtils.encrypt(k3,decypt2,DesImpl.getInstance());

        return encypt3;
    }

    @Override
    public byte[] encrypt_24(String pHexStrKey, String pHexStrData) throws Exception {
        byte lKeys []= ConvertUtils.hexStringToByte(pHexStrKey);
        byte lDatas [] = ConvertUtils.hexStringToByte(pHexStrData);
        return encrypt_24(lKeys,lDatas);
    }

    @Override
    public byte[] decrypt_24(byte[] pKey, byte[] pData) throws Exception {
        checkParams24(pKey,pData);

        byte k1[] = new byte [8];
        byte k2[] = new byte [8];
        byte k3[] = new byte [8];
        System.arraycopy(pKey, 0, k1, 0, 8);
        System.arraycopy(pKey, 8, k2, 0, 8);
        System.arraycopy(pKey, 16,k3, 0, 8);

        byte decypt3 [] = DesUtils.decrypt(k3,pData,DesImpl.getInstance());
        byte encypt2 [] = DesUtils.encrypt(k2,decypt3,DesImpl.getInstance());
        byte decypt1 [] = DesUtils.decrypt(k1,encypt2,DesImpl.getInstance());

        return decypt1;
    }

    @Override
    public byte[] decrypt_24(String pHexStrKey, String pHexStrData) throws Exception {
        byte lKeys []= ConvertUtils.hexStringToByte(pHexStrKey);
        byte lDatas [] = ConvertUtils.hexStringToByte(pHexStrData);
        return decrypt_24(lKeys,lDatas);
    }

    /**
     * 检查传入的3DES（密钥长度16个自己）参数是否正确
     * @param pKey
     * @param pData
     */
    protected void checkParams16(byte[] pKey, byte[] pData){
        if(pKey.length != 16){
            throw new IllegalArgumentException("checkParams16 3Des密钥长度应该是16字节");
        }

        if(pData.length %8 != 0){
            throw new IllegalArgumentException("被加密数据的长度应该为8的倍数");
        }
    }

    /**
     * 检查传入的3DES（密钥长度16个自己）参数是否正确
     * @param pKey
     * @param pData
     */
    protected void checkParams24(byte[] pKey, byte[] pData){
        if(pKey.length != 24){
            throw new IllegalArgumentException("checkParams24 3Des密钥长度应该是24字节");
        }

        if(pData.length %8 != 0){
            throw new IllegalArgumentException("被加密数据的长度应该为8的倍数");
        }
    }

}
