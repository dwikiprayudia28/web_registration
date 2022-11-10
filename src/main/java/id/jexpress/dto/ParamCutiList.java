package id.jexpress.dto;

import java.io.Serializable;
import java.util.Date;

public class ParamCutiList implements Serializable {

	private static final long serialVersionUID = -1724549035901573257L;

	private Integer id;
	private String userName;
	private Integer cutiReasonId;
	private String state;
	private String stateUserName;
	private Date startDateFrom;
	private Date startDateUntil;
	private String startDateFromStr;
	private String startDateUntilStr;
	private Date endDateFrom;
	private Date endDateUntil;
	private String endDateFromStr;
	private String endDateUntilStr;
	private Integer timeType;
	private Integer approval1State;
	private String approval1UserName;

	private Boolean isExcel;
	private Integer pageSize;
	private Integer page;
	private Integer submitSearch;

	private String byId = "";
	private String byUserName = "";
	private String byCutiReasonId = "";
	private String byState = "";
	private String byStateUserName = "";
	private String byStartDate = "";
	private String byEndDate = "";
	private String byTimeType = "";
	private String byApproval1State = "";
	private String byApproval1UserName = "";
	private String byRoleAccess = "";

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getIsExcel() {
		return isExcel;
	}

	public void setIsExcel(Boolean isExcel) {
		this.isExcel = isExcel;
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

	public String getById() {
		return byId;
	}

	public void setById(String byId) {
		this.byId = byId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getCutiReasonId() {
		return cutiReasonId;
	}

	public void setCutiReasonId(Integer cutiReasonId) {
		this.cutiReasonId = cutiReasonId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStateUserName() {
		return stateUserName;
	}

	public void setStateUserName(String stateUserName) {
		this.stateUserName = stateUserName;
	}

	public Date getStartDateFrom() {
		return startDateFrom;
	}

	public void setStartDateFrom(Date startDateFrom) {
		this.startDateFrom = startDateFrom;
	}

	public Date getStartDateUntil() {
		return startDateUntil;
	}

	public void setStartDateUntil(Date startDateUntil) {
		this.startDateUntil = startDateUntil;
	}

	public String getStartDateFromStr() {
		return startDateFromStr;
	}

	public void setStartDateFromStr(String startDateFromStr) {
		this.startDateFromStr = startDateFromStr;
	}

	public String getStartDateUntilStr() {
		return startDateUntilStr;
	}

	public void setStartDateUntilStr(String startDateUntilStr) {
		this.startDateUntilStr = startDateUntilStr;
	}

	public Date getEndDateFrom() {
		return endDateFrom;
	}

	public void setEndDateFrom(Date endDateFrom) {
		this.endDateFrom = endDateFrom;
	}

	public Date getEndDateUntil() {
		return endDateUntil;
	}

	public void setEndDateUntil(Date endDateUntil) {
		this.endDateUntil = endDateUntil;
	}

	public String getEndDateFromStr() {
		return endDateFromStr;
	}

	public void setEndDateFromStr(String endDateFromStr) {
		this.endDateFromStr = endDateFromStr;
	}

	public String getEndDateUntilStr() {
		return endDateUntilStr;
	}

	public void setEndDateUntilStr(String endDateUntilStr) {
		this.endDateUntilStr = endDateUntilStr;
	}

	public Integer getTimeType() {
		return timeType;
	}

	public void setTimeType(Integer timeType) {
		this.timeType = timeType;
	}

	public Integer getApproval1State() {
		return approval1State;
	}

	public void setApproval1State(Integer approval1State) {
		this.approval1State = approval1State;
	}

	public String getApproval1UserName() {
		return approval1UserName;
	}

	public void setApproval1UserName(String approval1UserName) {
		this.approval1UserName = approval1UserName;
	}

	public String getByUserName() {
		return byUserName;
	}

	public void setByUserName(String byUserName) {
		this.byUserName = byUserName;
	}

	public String getByCutiReasonId() {
		return byCutiReasonId;
	}

	public void setByCutiReasonId(String byCutiReasonId) {
		this.byCutiReasonId = byCutiReasonId;
	}

	public String getByState() {
		return byState;
	}

	public void setByState(String byState) {
		this.byState = byState;
	}

	public String getByStateUserName() {
		return byStateUserName;
	}

	public void setByStateUserName(String byStateUserName) {
		this.byStateUserName = byStateUserName;
	}

	public String getByStartDate() {
		return byStartDate;
	}

	public void setByStartDate(String byStartDate) {
		this.byStartDate = byStartDate;
	}

	public String getByEndDate() {
		return byEndDate;
	}

	public void setByEndDate(String byEndDate) {
		this.byEndDate = byEndDate;
	}

	public String getByTimeType() {
		return byTimeType;
	}

	public void setByTimeType(String byTimeType) {
		this.byTimeType = byTimeType;
	}

	public String getByApproval1State() {
		return byApproval1State;
	}

	public void setByApproval1State(String byApproval1State) {
		this.byApproval1State = byApproval1State;
	}

	public String getByApproval1UserName() {
		return byApproval1UserName;
	}

	public void setByApproval1UserName(String byApproval1UserName) {
		this.byApproval1UserName = byApproval1UserName;
	}

	public String getByRoleAccess() {
		return byRoleAccess;
	}

	public void setByRoleAccess(String byRoleAccess) {
		this.byRoleAccess = byRoleAccess;
	}

}
