package pos2.biz;
import pos2.fields.F03;
import pos2.fields.F25;
import pos2.fields.F41;
import pos2.fields.F42;
import pos2.fields.F60;


/**
 * 2016年9月18日 by lee for：签到请求报文
 */
public class SignInReq extends BaseReq{

	// 签到真实报文：003C600401000060310031000108000020000000C00012000029363239363930303233303133313030343839393030303100110000013200300003303031

	public F03 f03;
	public F25 f25;
	public F41 f41;
	public F42 f42;
	public F60 f60;

	/**
	 * 标准位图
	 */
	public SignInReq(F03 f03, F25 f25, F41 f41, F42 f42, F60 f60) {
		this.f03 = f03;
		this.f25 = f25;
		this.f41 = f41;
		this.f42 = f42;
		this.f60 = f60;
	}

	public F03 getF03() {
		return f03;
	}

	public void setF03(F03 f03) {
		this.f03 = f03;
	}

	public F25 getF25() {
		return f25;
	}

	public void setF25(F25 f25) {
		this.f25 = f25;
	}

	public F41 getF41() {
		return f41;
	}

	public void setF41(F41 f41) {
		this.f41 = f41;
	}

	public F42 getF42() {
		return f42;
	}

	public void setF42(F42 f42) {
		this.f42 = f42;
	}

	public F60 getF60() {
		return f60;
	}

	public void setF60(F60 f60) {
		this.f60 = f60;
	}

}
