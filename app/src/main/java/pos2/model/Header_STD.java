package pos2.model;


import pos2.fields.F_01;
import pos2.fields.F_02;
import pos2.fields.F_03;
import pos2.fields.F_04;
import pos2.fields.F_05;
import pos2.utils.Converter;

/**
 * ��׼8583ͷ����
 * 2016��8��29��
 * by lee
 * for����ȡ���ĵĹ̶���Ϣ�����ĳ��ȣ�TPDU,����ͷ,��Ϣ���ͣ�λͼ��
 */
public class Header_STD {
	private F_01 mF01;
	private F_02 mF02;
	private F_03 mF03;
	private F_04 mF04;
	private F_05 mF05;
	private int headerLen;//����
	public F_01 getmF01() {
		return mF01;
	}
	public void setmF01(F_01 mF1) {
		this.mF01 = mF1;
	}
	public F_02 getmF02() {
		return mF02;
	}
	public void setmF02(F_02 mF2) {
		this.mF02 = mF2;
	}
	public F_03 getmF03() {
		return mF03;
	}
	public void setmF03(F_03 mF3) {
		this.mF03 = mF3;
	}
	public F_04 getmF04() {
		return mF04;
	}
	public void setmF04(F_04 mF4) {
		this.mF04 = mF4;
	}
	public F_05 getmF05() {
		return mF05;
	}
	public void setmF05(F_05 mF5) {
		this.mF05 = mF5;
	}
	public int getHeaderLen() {
		//return (mF01.NORMAL_LEN+mF02.NORMAL_LEN+mF03.NORMAL_LEN+mF04.NORMAL_LEN+mF05.NORMAL_LEN) * 2;
		return (mF01.NORMAL_LEN+mF02.NORMAL_LEN+mF04.NORMAL_LEN+mF05.NORMAL_LEN) * 2;
	}
	@Override
	public String toString() {
		/*return "mF1" + mF01.DES+"="+mF01.getValue() +
				"\r\nmF2" + mF02.DES+"="+mF02.getValue() +
				"\r\nmF3" + mF03.DES+"=" + mF03.getValue() +
				"(应用类别：" + mF03.getValue().substring(0,2) +
				"软件总版本号：" +mF03.getValue().substring(2,4) +";"+
				"终端状态："+mF03.getValue().substring(4,5)+ ";"+
				"处理要求:"+mF03.getValue().substring(5,6)+";"+
				"软件分版本号:"+mF03.getValue().substring(6,12)+")"+
				"\r\nmF4" + mF04.DES+"="+mF04.getValue() +
				"\r\nmF5" + mF05.DES+"="+mF05.getValue() + "\r\n"+
				Converter.hexString2BinaryString(mF05.getValue()).substring(0,8)+"\r\n"+
				Converter.hexString2BinaryString(mF05.getValue()).substring(8,16)+"\r\n"+
				Converter.hexString2BinaryString(mF05.getValue()).substring(16,24)+"\r\n"+
				Converter.hexString2BinaryString(mF05.getValue()).substring(24,32)+"\r\n"+
				Converter.hexString2BinaryString(mF05.getValue()).substring(32,40)+"\r\n"+
				Converter.hexString2BinaryString(mF05.getValue()).substring(40,48)+"\r\n"+
				Converter.hexString2BinaryString(mF05.getValue()).substring(48,56)+"\r\n"+
				Converter.hexString2BinaryString(mF05.getValue()).substring(56,64)+"\r\n";*/
		return "mF1" + mF01.DES+"="+mF01.getValue() +
				"\r\nmF2" + mF02.DES+"="+mF02.getValue() +
				/*"\r\nmF3" + mF03.DES+"=" + mF03.getValue() +
				"(应用类别：" + mF03.getValue().substring(0,2) +
				"软件总版本号：" +mF03.getValue().substring(2,4) +";"+
				"终端状态："+mF03.getValue().substring(4,5)+ ";"+
				"处理要求:"+mF03.getValue().substring(5,6)+";"+
				"软件分版本号:"+mF03.getValue().substring(6,12)+")"+*/
				"\r\nmF4" + mF04.DES+"="+mF04.getValue() +
				"\r\nmF5" + mF05.DES+"="+mF05.getValue() + "\r\n"+
				Converter.hexString2BinaryString(mF05.getValue()).substring(0,8)+"\r\n"+
				Converter.hexString2BinaryString(mF05.getValue()).substring(8,16)+"\r\n"+
				Converter.hexString2BinaryString(mF05.getValue()).substring(16,24)+"\r\n"+
				Converter.hexString2BinaryString(mF05.getValue()).substring(24,32)+"\r\n"+
				Converter.hexString2BinaryString(mF05.getValue()).substring(32,40)+"\r\n"+
				Converter.hexString2BinaryString(mF05.getValue()).substring(40,48)+"\r\n"+
				Converter.hexString2BinaryString(mF05.getValue()).substring(48,56)+"\r\n"+
				Converter.hexString2BinaryString(mF05.getValue()).substring(56,64)+"\r\n";
	}
	public void show() {
		System.out.println(toString());
	}
	
}
