package id.jexpress.dto;

import java.io.Serializable;

public class ParamCutiApproval implements Serializable {

	private static final long serialVersionUID = -8647545337075267688L;

	private String cutiIdStr;
	private Integer cutiId;
	private Integer state;
	private String remark;

	public String getCutiIdStr() {
		return cutiIdStr;
	}

	public void setCutiIdStr(String cutiIdStr) {
		this.cutiIdStr = cutiIdStr;
	}

	public Integer getCutiId() {
		return cutiId;
	}

	public void setCutiId(Integer cutiId) {
		this.cutiId = cutiId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
