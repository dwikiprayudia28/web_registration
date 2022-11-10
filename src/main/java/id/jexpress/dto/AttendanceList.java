package id.jexpress.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class AttendanceList implements Serializable {

	private static final long serialVersionUID = 7854095639209076337L;

	private Integer id;
	private Integer userId;
	private String userName;
	private BigInteger userNik;
	private String userNikExt;
	private String userCompanyName;
	private String userOfficeName;
	private String userDepartmentName;
	private String userJobPositionName;

	private Date arriveTime;
	private String arriveZName;
	private Integer arriveOfficeId;
	private String arriveOfficeName;
	private Integer arriveApproval;
	private String arriveApprovalName;
	private String arriveUserAprove;
	private BigInteger arriveUserNikAprove;

	private Date departTime;
	private Integer departOfficeId;
	private String departOfficeName;
	private String departZName;
	private Integer departApproval;
	private String departApprovalName;
	private String departUserAprove;
	private BigInteger departUserNikAprove;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public BigInteger getUserNik() {
		return userNik;
	}

	public void setUserNik(BigInteger userNik) {
		this.userNik = userNik;
	}

	public String getUserNikExt() {
		return userNikExt;
	}

	public void setUserNikExt(String userNikExt) {
		this.userNikExt = userNikExt;
	}

	public String getUserCompanyName() {
		return userCompanyName;
	}

	public void setUserCompanyName(String userCompanyName) {
		this.userCompanyName = userCompanyName;
	}

	public String getUserOfficeName() {
		return userOfficeName;
	}

	public void setUserOfficeName(String userOfficeName) {
		this.userOfficeName = userOfficeName;
	}

	public String getUserDepartmentName() {
		return userDepartmentName;
	}

	public void setUserDepartmentName(String userDepartmentName) {
		this.userDepartmentName = userDepartmentName;
	}

	public String getUserJobPositionName() {
		return userJobPositionName;
	}

	public void setUserJobPositionName(String userJobPositionName) {
		this.userJobPositionName = userJobPositionName;
	}

	public Date getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(Date arriveTime) {
		this.arriveTime = arriveTime;
	}

	public Integer getArriveOfficeId() {
		return arriveOfficeId;
	}

	public void setArriveOfficeId(Integer arriveOfficeId) {
		this.arriveOfficeId = arriveOfficeId;
	}

	public String getArriveOfficeName() {
		return arriveOfficeName;
	}

	public void setArriveOfficeName(String arriveOfficeName) {
		this.arriveOfficeName = arriveOfficeName;
	}

	public Date getDepartTime() {
		return departTime;
	}

	public void setDepartTime(Date departTime) {
		this.departTime = departTime;
	}

	public Integer getDepartOfficeId() {
		return departOfficeId;
	}

	public void setDepartOfficeId(Integer departOfficeId) {
		this.departOfficeId = departOfficeId;
	}

	public String getDepartOfficeName() {
		return departOfficeName;
	}

	public void setDepartOfficeName(String departOfficeName) {
		this.departOfficeName = departOfficeName;
	}

	public String getArriveZName() {
		return arriveZName;
	}

	public void setArriveZName(String arriveZName) {
		this.arriveZName = arriveZName;
	}

	public String getDepartZName() {
		return departZName;
	}

	public void setDepartZName(String departZName) {
		this.departZName = departZName;
	}

	public Integer getArriveApproval() {
		return arriveApproval;
	}

	public void setArriveApproval(Integer arriveApproval) {
		this.arriveApproval = arriveApproval;
	}

	public String getArriveApprovalName() {
		return arriveApprovalName;
	}

	public void setArriveApprovalName(String arriveApprovalName) {
		this.arriveApprovalName = arriveApprovalName;
	}

	public Integer getDepartApproval() {
		return departApproval;
	}

	public void setDepartApproval(Integer departApproval) {
		this.departApproval = departApproval;
	}

	public String getDepartApprovalName() {
		return departApprovalName;
	}

	public void setDepartApprovalName(String departApprovalName) {
		this.departApprovalName = departApprovalName;
	}

	public String getArriveUserAprove() {
		return arriveUserAprove;
	}

	public void setArriveUserAprove(String arriveUserAprove) {
		this.arriveUserAprove = arriveUserAprove;
	}

	public String getDepartUserAprove() {
		return departUserAprove;
	}

	public void setDepartUserAprove(String departUserAprove) {
		this.departUserAprove = departUserAprove;
	}

	public BigInteger getArriveUserNikAprove() {
		return arriveUserNikAprove;
	}

	public void setArriveUserNikAprove(BigInteger arriveUserNikAprove) {
		this.arriveUserNikAprove = arriveUserNikAprove;
	}

	public BigInteger getDepartUserNikAprove() {
		return departUserNikAprove;
	}

	public void setDepartUserNikAprove(BigInteger departUserNikAprove) {
		this.departUserNikAprove = departUserNikAprove;
	}

}
