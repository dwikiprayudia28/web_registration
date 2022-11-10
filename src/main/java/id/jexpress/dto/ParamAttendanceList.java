package id.jexpress.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class ParamAttendanceList implements Serializable {

	private static final long serialVersionUID = -4470811843759273878L;

	private Integer attnId;
	private String userName;
	private BigInteger userNik;
	private String userNikExt;
	private String userOfficeName;
	private Integer userCompanyId;
	private Integer userJobPositionId;
	private String userDepartmentName;
	private Date startArriveTime;
	private Date endArriveTime;
	private String startArriveTimeStr;
	private String endArriveTimeStr;
	private String arriveOfficeName;
	private Integer arriveApproval;
	private String arriveApprovedBy;
	private Date startDepartTime;
	private Date endDepartTime;
	private String startDepartTimeStr;
	private String endDepartTimeStr;
	private String departOfficeName;
	private Integer departApproval;
	private String departApprovedBy;
	private Integer pageSize;
	private Integer page;
	private Integer submitSearch;

	private final String arrive_time_query = "  (a.arrive_time+INTERVAL COALESCE((SELECT add_hour FROM jx_attn_timezone WHERE zone_name = a.arrive_zname),0) HOUR) ";
	private final String depart_time_query = "  (a.depart_time+INTERVAL COALESCE((SELECT add_hour FROM jx_attn_timezone WHERE zone_name = a.depart_zname),0) HOUR) ";

	private final String arrive_office_name = "" 
			+ "  CASE "
			+ "    WHEN a.arrive_office_id = -1 "
			+ "    THEN 'Out of Office Location' " 
			+ "    ELSE c.name "
			+ "  END ";

	private final String depart_office_name = "" 
			+ "  CASE "
			+ "    WHEN a.depart_office_id = -1 "
			+ "    THEN 'Out of Office Location' " 
			+ "    ELSE d.name "
			+ "  END ";

	private final String arrive_approval_query = "" 
			+ "  CASE "
			+ "		WHEN a.arrive_approval = 1 THEN 'Approved' "
			+ "		WHEN a.arrive_approval = 0 THEN 'Submitted' "
			+ "		WHEN a.arrive_approval = -1 THEN 'Rejected' " 
			+ "	 ELSE '' "
			+ "  END ";

	private final String depart_approval_query = "" 
			+ "  CASE "
			+ "		WHEN a.depart_approval = 1 THEN 'Approved' "
			+ "		WHEN a.depart_approval = 0 THEN 'Submitted' "
			+ "		WHEN a.depart_approval = -1 THEN 'Rejected' " 
			+ "	 ELSE '' "
			+ "  END ";

	private String byAttdId = "";
	private String byUserName = "";
	private String byUserNik = "";
	private String byUserNikExt = "";
	private String byUserOfficeName;
	private String byUserCompanyId = "";
	private String byUserJobPositionId = "";
	private String byUserDepartmentName = "";
	private String byArriveTime = "";
	private String byArriveTimeInTotal = "";
	private String byArriveOffice = "";
	private String byArriveOfficeInTotal = "";
	private String byArriveApprovedBy = "";
	private String byDepartTime = "";
	private String byDepartTimeInTotal = "";
	private String byDepartOffice = "";
	private String byDepartOfficeInTotal = "";
	private String byArriveApproval = "";
	private String byDepartApproval = "";
	private String byDepartApprovedBy = "";
	private String byRoleAccess = "";

	public Integer getAttnId() {
		return attnId;
	}

	public void setAttnId(Integer attnId) {
		this.attnId = attnId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getStartArriveTime() {
		return startArriveTime;
	}

	public void setStartArriveTime(Date startArriveTime) {
		this.startArriveTime = startArriveTime;
	}

	public Date getEndArriveTime() {
		return endArriveTime;
	}

	public void setEndArriveTime(Date endArriveTime) {
		this.endArriveTime = endArriveTime;
	}

	public String getArriveOfficeName() {
		return arriveOfficeName;
	}

	public void setArriveOfficeName(String arriveOfficeName) {
		this.arriveOfficeName = arriveOfficeName;
	}

	public Date getStartDepartTime() {
		return startDepartTime;
	}

	public void setStartDepartTime(Date startDepartTime) {
		this.startDepartTime = startDepartTime;
	}

	public Date getEndDepartTime() {
		return endDepartTime;
	}

	public void setEndDepartTime(Date endDepartTime) {
		this.endDepartTime = endDepartTime;
	}

	public String getDepartOfficeName() {
		return departOfficeName;
	}

	public void setDepartOfficeName(String departOfficeName) {
		this.departOfficeName = departOfficeName;
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

	public String getStartArriveTimeStr() {
		return startArriveTimeStr;
	}

	public void setStartArriveTimeStr(String startArriveTimeStr) {
		this.startArriveTimeStr = startArriveTimeStr;
	}

	public String getEndArriveTimeStr() {
		return endArriveTimeStr;
	}

	public void setEndArriveTimeStr(String endArriveTimeStr) {
		this.endArriveTimeStr = endArriveTimeStr;
	}

	public String getStartDepartTimeStr() {
		return startDepartTimeStr;
	}

	public void setStartDepartTimeStr(String startDepartTimeStr) {
		this.startDepartTimeStr = startDepartTimeStr;
	}

	public String getEndDepartTimeStr() {
		return endDepartTimeStr;
	}

	public void setEndDepartTimeStr(String endDepartTimeStr) {
		this.endDepartTimeStr = endDepartTimeStr;
	}

	public String getByAttdId() {
		return byAttdId;
	}

	public void setByAttdId(String byAttdId) {
		this.byAttdId = byAttdId;
	}

	public String getByUserName() {
		return byUserName;
	}

	public void setByUserName(String byUserName) {
		this.byUserName = byUserName;
	}

	public String getByArriveTime() {
		return byArriveTime;
	}

	public void setByArriveTime(String byArriveTime) {
		this.byArriveTime = byArriveTime;
	}

	public String getByArriveOffice() {
		return byArriveOffice;
	}

	public void setByArriveOffice(String byArriveOffice) {
		this.byArriveOffice = byArriveOffice;
	}

	public String getByDepartTime() {
		return byDepartTime;
	}

	public void setByDepartTime(String byDepartTime) {
		this.byDepartTime = byDepartTime;
	}

	public String getByDepartOffice() {
		return byDepartOffice;
	}

	public void setByDepartOffice(String byDepartOffice) {
		this.byDepartOffice = byDepartOffice;
	}

	public String getByArriveTimeInTotal() {
		return byArriveTimeInTotal;
	}

	public void setByArriveTimeInTotal(String byArriveTimeInTotal) {
		this.byArriveTimeInTotal = byArriveTimeInTotal;
	}

	public String getByArriveOfficeInTotal() {
		return byArriveOfficeInTotal;
	}

	public void setByArriveOfficeInTotal(String byArriveOfficeInTotal) {
		this.byArriveOfficeInTotal = byArriveOfficeInTotal;
	}

	public String getByDepartTimeInTotal() {
		return byDepartTimeInTotal;
	}

	public void setByDepartTimeInTotal(String byDepartTimeInTotal) {
		this.byDepartTimeInTotal = byDepartTimeInTotal;
	}

	public String getByDepartOfficeInTotal() {
		return byDepartOfficeInTotal;
	}

	public void setByDepartOfficeInTotal(String byDepartOfficeInTotal) {
		this.byDepartOfficeInTotal = byDepartOfficeInTotal;
	}

	public String getArrive_time_query() {
		return arrive_time_query;
	}

	public String getArrive_office_name() {
		return arrive_office_name;
	}

	public String getDepart_time_query() {
		return depart_time_query;
	}

	public String getDepart_office_name() {
		return depart_office_name;
	}

	public String getArrive_approval_query() {
		return arrive_approval_query;
	}

	public String getDepart_approval_query() {
		return depart_approval_query;
	}

	public Integer getArriveApproval() {
		return arriveApproval;
	}

	public void setArriveApproval(Integer arriveApproval) {
		this.arriveApproval = arriveApproval;
	}

	public Integer getDepartApproval() {
		return departApproval;
	}

	public void setDepartApproval(Integer departApproval) {
		this.departApproval = departApproval;
	}

	public String getByArriveApproval() {
		return byArriveApproval;
	}

	public void setByArriveApproval(String byArriveApproval) {
		this.byArriveApproval = byArriveApproval;
	}

	public String getByDepartApproval() {
		return byDepartApproval;
	}

	public void setByDepartApproval(String byDepartApproval) {
		this.byDepartApproval = byDepartApproval;
	}

	public BigInteger getUserNik() {
		return userNik;
	}

	public void setUserNik(BigInteger userNik) {
		this.userNik = userNik;
	}

	public String getByUserNik() {
		return byUserNik;
	}

	public void setByUserNik(String byUserNik) {
		this.byUserNik = byUserNik;
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

	public String getByUserNikExt() {
		return byUserNikExt;
	}

	public void setByUserNikExt(String byUserNikExt) {
		this.byUserNikExt = byUserNikExt;
	}

	public Integer getUserCompanyId() {
		return userCompanyId;
	}

	public void setUserCompanyId(Integer userCompanyId) {
		this.userCompanyId = userCompanyId;
	}

	public String getByUserCompanyId() {
		return byUserCompanyId;
	}

	public void setByUserCompanyId(String byUserCompanyId) {
		this.byUserCompanyId = byUserCompanyId;
	}

	public String getUserOfficeName() {
		return userOfficeName;
	}

	public void setUserOfficeName(String userOfficeName) {
		this.userOfficeName = userOfficeName;
	}

	public String getByUserOfficeName() {
		return byUserOfficeName;
	}

	public void setByUserOfficeName(String byUserOfficeName) {
		this.byUserOfficeName = byUserOfficeName;
	}

	public String getUserDepartmentName() {
		return userDepartmentName;
	}

	public void setUserDepartmentName(String userDepartmentName) {
		this.userDepartmentName = userDepartmentName;
	}

	public String getByUserDepartmentName() {
		return byUserDepartmentName;
	}

	public void setByUserDepartmentName(String byUserDepartmentName) {
		this.byUserDepartmentName = byUserDepartmentName;
	}

	public String getArriveApprovedBy() {
		return arriveApprovedBy;
	}

	public void setArriveApprovedBy(String arriveApprovedBy) {
		this.arriveApprovedBy = arriveApprovedBy;
	}

	public String getDepartApprovedBy() {
		return departApprovedBy;
	}

	public void setDepartApprovedBy(String departApprovedBy) {
		this.departApprovedBy = departApprovedBy;
	}

	public String getByArriveApprovedBy() {
		return byArriveApprovedBy;
	}

	public void setByArriveApprovedBy(String byArriveApprovedBy) {
		this.byArriveApprovedBy = byArriveApprovedBy;
	}

	public String getByDepartApprovedBy() {
		return byDepartApprovedBy;
	}

	public void setByDepartApprovedBy(String byDepartApprovedBy) {
		this.byDepartApprovedBy = byDepartApprovedBy;
	}

	public Integer getUserJobPositionId() {
		return userJobPositionId;
	}

	public void setUserJobPositionId(Integer userJobPositionId) {
		this.userJobPositionId = userJobPositionId;
	}

	public String getByUserJobPositionId() {
		return byUserJobPositionId;
	}

	public void setByUserJobPositionId(String byUserJobPositionId) {
		this.byUserJobPositionId = byUserJobPositionId;
	}
	
}
