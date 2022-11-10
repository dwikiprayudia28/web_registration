package id.jexpress.dto;

import java.io.Serializable;

public class ParamLemburApproval implements Serializable {

	private static final long serialVersionUID = -3745135307599727870L;

	private String lemburIdStr;
	private Integer lemburId;
	private Integer state;
	private String remark;

	public String getLemburIdStr() {
		return lemburIdStr;
	}

	public void setLemburIdStr(String lemburIdStr) {
		this.lemburIdStr = lemburIdStr;
	}

	public Integer getLemburId() {
		return lemburId;
	}

	public void setLemburId(Integer lemburId) {
		this.lemburId = lemburId;
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
