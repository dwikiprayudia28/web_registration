package id.jexpress.dto;

import id.jexpress.model.User;

import java.io.Serializable;

public class UserDetail implements Serializable {

	private static final long serialVersionUID = -3604414610215127942L;

	private User user;
	private User userApprove;

	private String jobPositionName;
	private String companyName;
	private String departmentName;

	private String isRegisteredStr;
	private String roleStr;
	private String allowPhotoStr;
	private String isDeletedStr;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUserApprove() {
		return userApprove;
	}

	public void setUserApprove(User userApprove) {
		this.userApprove = userApprove;
	}

	public String getJobPositionName() {
		return jobPositionName;
	}

	public void setJobPositionName(String jobPositionName) {
		this.jobPositionName = jobPositionName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getIsRegisteredStr() {
		return isRegisteredStr;
	}


	public String getRoleStr() {
		return roleStr;
	}


	public String getAllowPhotoStr() {
		return allowPhotoStr;
	}


	public String getIsDeletedStr() {
		return isDeletedStr;
	}


}
