package pos2.model;


import android.util.Log;

import pos2.fields.F_01;
import pos2.fields.F_02;
import pos2.fields.F_03;
import pos2.fields.F_04;
import pos2.fields.F_05;
import tools.com.hellolibrary.hello_convert.ConvertUtils;


/**
 * 报文头部分（这里的报文头称呼和标准银联pos规范不一样哦）
 * 范围（报文长度--位图）
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
		int f01len = mF01!=null?mF01.NORMAL_LEN:0;
		int f02len = mF02!=null?mF02.NORMAL_LEN:0;
		int f03len = mF03!=null?mF03.NORMAL_LEN:0;
		int f04len = mF04!=null?mF04.NORMAL_LEN:0;
		int f05len = mF05!=null?mF05.NORMAL_LEN:0;
		return (f01len+f02len+f03len+f04len+f05len) * 2;
	}

	public void show() {
		String f01 = mF01!=null ? "mF1" + mF01.DES + "=" + mF01.getValue():"" ;
		String f02 = mF02 != null ? "\r\nmF2" + mF02.DES+"="+mF02.getValue():"" ;
		String f03 = mF03 !=null ? "\r\nmF3" + mF03.DES+"=" + mF03.getValue() +
				"(应用类别：" + mF03.getValue().substring(0,2) +
				"软件总版本号：" +mF03.getValue().substring(2,4) +";"+
				"终端状态："+mF03.getValue().substring(4,5)+ ";"+
				"处理要求:"+mF03.getValue().substring(5,6)+";"+
				"软件分版本号:"+mF03.getValue().substring(6,12)+")" :"";
		String f04 = mF04!=null? "\r\nmF4" + mF04.DES+"="+mF04.getValue():"" ;
		String f05 = mF05!=null? "\r\nmF5" + mF05.DES+"="+mF05.getValue() + "\r\n"+
				ConvertUtils.hexStringToBinaryString(mF05.getValue()).substring(0,8)+"\r\n"+
				ConvertUtils.hexStringToBinaryString(mF05.getValue()).substring(8,16)+"\r\n"+
				ConvertUtils.hexStringToBinaryString(mF05.getValue()).substring(16,24)+"\r\n"+
				ConvertUtils.hexStringToBinaryString(mF05.getValue()).substring(24,32)+"\r\n"+
				ConvertUtils.hexStringToBinaryString(mF05.getValue()).substring(32,40)+"\r\n"+
				ConvertUtils.hexStringToBinaryString(mF05.getValue()).substring(40,48)+"\r\n"+
				ConvertUtils.hexStringToBinaryString(mF05.getValue()).substring(48,56)+"\r\n"+
				ConvertUtils.hexStringToBinaryString(mF05.getValue()).substring(56,64)+"\r\n":"";
		Log.i("vbvb","头报文解包结果\r\n"+f01+f02+f03+f04+f05);
	}
	
}
