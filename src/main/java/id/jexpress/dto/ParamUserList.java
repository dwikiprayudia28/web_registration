package id.jexpress.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class ParamUserList implements Serializable {

	private static final long serialVersionUID = 6041398175353467593L;

	private Integer userId;
	private BigInteger userNik;
	private String userNikExt;
	private String userName;
	private Integer jobPositionId;
	private Integer userCompanyId;
	private String departmentName;
	
	private Date startEfectiveDate;
	private Date endEfectiveDate;
	private String startEfectiveDateStr;
	private String endEfectiveDateStr;
	
	private String officeName;
	private Integer isRegistered;
	private String approveByName;
	private Integer role;
	private Integer allowPhoto;
	private String imei;
	
	private Integer pageSize;
	private Integer page;
	private Integer submitSearch;

	private String byUserId = "";
	private String byUserNik = "";
	private String byUserNikExt = "";
	private String byUserName = "";
	private String byJobPositionId = "";
	private String byUserCompanyId = "";
	private String byDepartmentName = "";
	private String byEfectiveDate = "";
	private String byOfficeName = "";
	private String byIsRegistered = "";
	private String byApproveByName = "";
	private String byRole = "";
	private String byAllowPhoto = "";
	private String byRoleAccess = "";
	private String byImei = "";

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public BigInteger getUserNik() {
		return userNik;
	}

	public void setUserNik(BigInteger userNik) {
		this.userNik = userNik;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSubmitSearch() {
		return submitSearch;
	}

	public void setSubmitSearch(Integer submitSearch) {
		this.submitSearch = submitSearch;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public Integer getIsRegistered() {
		return isRegistered;
	}

	public void setIsRegistered(Integer isRegistered) {
		this.isRegistered = isRegistered;
	}

	public String getApproveByName() {
		return approveByName;
	}

	public void setApproveByName(String approveByName) {
		this.approveByName = approveByName;
	}

	public String getByUserId() {
		return byUserId;
	}

	public void setByUserId(String byUserId) {
		this.byUserId = byUserId;
	}

	public String getByUserNik() {
		return byUserNik;
	}

	public void setByUserNik(String byUserNik) {
		this.byUserNik = byUserNik;
	}

	public String getByUserName() {
		return byUserName;
	}

	public void setByUserName(String byUserName) {
		this.byUserName = byUserName;
	}

	public String getByOfficeName() {
		return byOfficeName;
	}

	public void setByOfficeName(String byOfficeName) {
		this.byOfficeName = byOfficeName;
	}

	public String getByIsRegistered() {
		return byIsRegistered;
	}

	public void setByIsRegistered(String byIsRegistered) {
		this.byIsRegistered = byIsRegistered;
	}

	public String getByApproveByName() {
		return byApproveByName;
	}

	public void setByApproveByName(String byApproveByName) {
		this.byApproveByName = byApproveByName;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getByRole() {
		return byRole;
	}

	public void setByRole(String byRole) {
		this.byRole = byRole;
	}

	public Integer getAllowPhoto() {
		return allowPhoto;
	}

	public void setAllowPhoto(Integer allowPhoto) {
		this.allowPhoto = allowPhoto;
	}

	public String getByAllowPhoto() {
		return byAllowPhoto;
	}

	public void setByAllowPhoto(String byAllowPhoto) {
		this.byAllowPhoto = byAllowPhoto;
	}

	public String getByRoleAccess() {
		return byRoleAccess;
	}

	public void setByRoleAccess(String byRoleAccess) {
		this.byRoleAccess = byRoleAccess;
	}

	public String getUserNikExt() {
		return userNikExt;
	}

	public void setUserNikExt(String userNikExt) {
		this.userNikExt = userNikExt;
	}

	public Integer getJobPositionId() {
		return jobPositionId;
	}

	public void setJobPositionId(Integer jobPositionId) {
		this.jobPositionId = jobPositionId;
	}

	public Integer getUserCompanyId() {
		return userCompanyId;
	}

	public void setUserCompanyId(Integer userCompanyId) {
		this.userCompanyId = userCompanyId;
	}

	public Date getStartEfectiveDate() {
		return startEfectiveDate;
	}

	public void setStartEfectiveDate(Date startEfectiveDate) {
		this.startEfectiveDate = startEfectiveDate;
	}

	public Date getEndEfectiveDate() {
		return endEfectiveDate;
	}

	public void setEndEfectiveDate(Date endEfectiveDate) {
		this.endEfectiveDate = endEfectiveDate;
	}

	public String getStartEfectiveDateStr() {
		return startEfectiveDateStr;
	}

	public void setStartEfectiveDateStr(String startEfectiveDateStr) {
		this.startEfectiveDateStr = startEfectiveDateStr;
	}

	public String getEndEfectiveDateStr() {
		return endEfectiveDateStr;
	}

	public void setEndEfectiveDateStr(String endEfectiveDateStr) {
		this.endEfectiveDateStr = endEfectiveDateStr;
	}

	public String getByUserNikExt() {
		return byUserNikExt;
	}

	public void setByUserNikExt(String byUserNikExt) {
		this.byUserNikExt = byUserNikExt;
	}

	public String getByJobPositionId() {
		return byJobPositionId;
	}

	public void setByJobPositionId(String byJobPositionId) {
		this.byJobPositionId = byJobPositionId;
	}

	public String getByUserCompanyId() {
		return byUserCompanyId;
	}

	public void setByUserCompanyId(String byUserCompanyId) {
		this.byUserCompanyId = byUserCompanyId;
	}

	public String getByEfectiveDate() {
		return byEfectiveDate;
	}

	public void setByEfectiveDate(String byEfectiveDate) {
		this.byEfectiveDate = byEfectiveDate;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getByDepartmentName() {
		return byDepartmentName;
	}

	public void setByDepartmentName(String byDepartmentName) {
		this.byDepartmentName = byDepartmentName;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getByImei() {
		return byImei;
	}

	public void setByImei(String byImei) {
		this.byImei = byImei;
	}

}
