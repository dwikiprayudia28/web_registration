package id.jexpress.dto;

import java.io.Serializable;
import java.util.Date;

public class ParamLemburList implements Serializable {

	private static final long serialVersionUID = 5940328339960819655L;

	private Integer id;
	private String userName;
	private String state;
	private String stateUserName;
	private Date startDateEstimasiFrom;
	private Date startDateEstimasiUntil;
	private String startDateEstimasiFromStr;
	private String startDateEstimasiUntilStr;
	private Date endDateEstimasiFrom;
	private Date endDateEstimasiUntil;
	private String endDateEstimasiFromStr;
	private String endDateEstimasiUntilStr;
	private String eventEstimasi;
	private String taskEstimasi;
	private Integer app1StateEstimasi;
	private String app1UserNameEstimasi;

	private Date startDateRealisasiFrom;
	private Date startDateRealisasiUntil;
	private String startDateRealisasiFromStr;
	private String startDateRealisasiUntilStr;
	private Date endDateRealisasiFrom;
	private Date endDateRealisasiUntil;
	private String endDateRealisasiFromStr;
	private String endDateRealisasiUntilStr;
	private String taskRealisasi;
	private Integer app1StateRealisasi;
	private String app1UserNameRealisasi;
	private Integer app2StateRealisasi;
	private String app2UserNameRealisasi;

	private Integer pageSize;
	private Integer page;
	private Integer submitSearch;

	private String byId = "";
	private String byUserName = "";
	private String byState = "";
	private String byStateUserName = "";
	private String byStartDateEstimasi = "";
	private String byEndDateEstimasi = "";
	private String byEventEstimasi = "";
	private String byTaskEstimasi = "";
	private String byApp1StateEstimasi = "";
	private String byApp1UserNameEstimasi = "";

	private String byStartDateRealisasi = "";
	private String byEndDateRealisasi = "";
	private String byTaskRealisasi = "";
	private String byApp1StateRealisasi = "";
	private String byApp1UserNameRealisasi = "";
	private String byApp2StateRealisasi = "";
	private String byApp2UserNameRealisasi = "";
	private String byRoleAccess = "";

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getByRoleAccess() {
		return byRoleAccess;
	}

	public void setByRoleAccess(String byRoleAccess) {
		this.byRoleAccess = byRoleAccess;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Date getStartDateEstimasiFrom() {
		return startDateEstimasiFrom;
	}

	public void setStartDateEstimasiFrom(Date startDateEstimasiFrom) {
		this.startDateEstimasiFrom = startDateEstimasiFrom;
	}

	public Date getStartDateEstimasiUntil() {
		return startDateEstimasiUntil;
	}

	public void setStartDateEstimasiUntil(Date startDateEstimasiUntil) {
		this.startDateEstimasiUntil = startDateEstimasiUntil;
	}

	public String getStartDateEstimasiFromStr() {
		return startDateEstimasiFromStr;
	}

	public void setStartDateEstimasiFromStr(String startDateEstimasiFromStr) {
		this.startDateEstimasiFromStr = startDateEstimasiFromStr;
	}

	public String getStartDateEstimasiUntilStr() {
		return startDateEstimasiUntilStr;
	}

	public void setStartDateEstimasiUntilStr(String startDateEstimasiUntilStr) {
		this.startDateEstimasiUntilStr = startDateEstimasiUntilStr;
	}

	public Date getEndDateEstimasiFrom() {
		return endDateEstimasiFrom;
	}

	public void setEndDateEstimasiFrom(Date endDateEstimasiFrom) {
		this.endDateEstimasiFrom = endDateEstimasiFrom;
	}

	public Date getEndDateEstimasiUntil() {
		return endDateEstimasiUntil;
	}

	public void setEndDateEstimasiUntil(Date endDateEstimasiUntil) {
		this.endDateEstimasiUntil = endDateEstimasiUntil;
	}

	public String getEndDateEstimasiFromStr() {
		return endDateEstimasiFromStr;
	}

	public void setEndDateEstimasiFromStr(String endDateEstimasiFromStr) {
		this.endDateEstimasiFromStr = endDateEstimasiFromStr;
	}

	public String getEndDateEstimasiUntilStr() {
		return endDateEstimasiUntilStr;
	}

	public void setEndDateEstimasiUntilStr(String endDateEstimasiUntilStr) {
		this.endDateEstimasiUntilStr = endDateEstimasiUntilStr;
	}

	public String getByUserName() {
		return byUserName;
	}

	public void setByUserName(String byUserName) {
		this.byUserName = byUserName;
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

	public String getByStartDateEstimasi() {
		return byStartDateEstimasi;
	}

	public void setByStartDateEstimasi(String byStartDateEstimasi) {
		this.byStartDateEstimasi = byStartDateEstimasi;
	}

	public String getByEndDateEstimasi() {
		return byEndDateEstimasi;
	}

	public void setByEndDateEstimasi(String byEndDateEstimasi) {
		this.byEndDateEstimasi = byEndDateEstimasi;
	}

	public String getEventEstimasi() {
		return eventEstimasi;
	}

	public void setEventEstimasi(String eventEstimasi) {
		this.eventEstimasi = eventEstimasi;
	}

	public String getTaskEstimasi() {
		return taskEstimasi;
	}

	public void setTaskEstimasi(String taskEstimasi) {
		this.taskEstimasi = taskEstimasi;
	}

	public String getByEventEstimasi() {
		return byEventEstimasi;
	}

	public void setByEventEstimasi(String byEventEstimasi) {
		this.byEventEstimasi = byEventEstimasi;
	}

	public String getByTaskEstimasi() {
		return byTaskEstimasi;
	}

	public void setByTaskEstimasi(String byTaskEstimasi) {
		this.byTaskEstimasi = byTaskEstimasi;
	}

	public Integer getApp1StateEstimasi() {
		return app1StateEstimasi;
	}

	public void setApp1StateEstimasi(Integer app1StateEstimasi) {
		this.app1StateEstimasi = app1StateEstimasi;
	}

	public String getApp1UserNameEstimasi() {
		return app1UserNameEstimasi;
	}

	public void setApp1UserNameEstimasi(String app1UserNameEstimasi) {
		this.app1UserNameEstimasi = app1UserNameEstimasi;
	}

	public String getByApp1StateEstimasi() {
		return byApp1StateEstimasi;
	}

	public void setByApp1StateEstimasi(String byApp1StateEstimasi) {
		this.byApp1StateEstimasi = byApp1StateEstimasi;
	}

	public String getByApp1UserNameEstimasi() {
		return byApp1UserNameEstimasi;
	}

	public void setByApp1UserNameEstimasi(String byApp1UserNameEstimasi) {
		this.byApp1UserNameEstimasi = byApp1UserNameEstimasi;
	}

	public Date getStartDateRealisasiFrom() {
		return startDateRealisasiFrom;
	}

	public void setStartDateRealisasiFrom(Date startDateRealisasiFrom) {
		this.startDateRealisasiFrom = startDateRealisasiFrom;
	}

	public Date getStartDateRealisasiUntil() {
		return startDateRealisasiUntil;
	}

	public void setStartDateRealisasiUntil(Date startDateRealisasiUntil) {
		this.startDateRealisasiUntil = startDateRealisasiUntil;
	}

	public String getStartDateRealisasiFromStr() {
		return startDateRealisasiFromStr;
	}

	public void setStartDateRealisasiFromStr(String startDateRealisasiFromStr) {
		this.startDateRealisasiFromStr = startDateRealisasiFromStr;
	}

	public String getStartDateRealisasiUntilStr() {
		return startDateRealisasiUntilStr;
	}

	public void setStartDateRealisasiUntilStr(String startDateRealisasiUntilStr) {
		this.startDateRealisasiUntilStr = startDateRealisasiUntilStr;
	}

	public Date getEndDateRealisasiFrom() {
		return endDateRealisasiFrom;
	}

	public void setEndDateRealisasiFrom(Date endDateRealisasiFrom) {
		this.endDateRealisasiFrom = endDateRealisasiFrom;
	}

	public Date getEndDateRealisasiUntil() {
		return endDateRealisasiUntil;
	}

	public void setEndDateRealisasiUntil(Date endDateRealisasiUntil) {
		this.endDateRealisasiUntil = endDateRealisasiUntil;
	}

	public String getEndDateRealisasiFromStr() {
		return endDateRealisasiFromStr;
	}

	public void setEndDateRealisasiFromStr(String endDateRealisasiFromStr) {
		this.endDateRealisasiFromStr = endDateRealisasiFromStr;
	}

	public String getEndDateRealisasiUntilStr() {
		return endDateRealisasiUntilStr;
	}

	public void setEndDateRealisasiUntilStr(String endDateRealisasiUntilStr) {
		this.endDateRealisasiUntilStr = endDateRealisasiUntilStr;
	}

	public String getByStartDateRealisasi() {
		return byStartDateRealisasi;
	}

	public void setByStartDateRealisasi(String byStartDateRealisasi) {
		this.byStartDateRealisasi = byStartDateRealisasi;
	}

	public String getByEndDateRealisasi() {
		return byEndDateRealisasi;
	}

	public void setByEndDateRealisasi(String byEndDateRealisasi) {
		this.byEndDateRealisasi = byEndDateRealisasi;
	}

	public String getTaskRealisasi() {
		return taskRealisasi;
	}

	public void setTaskRealisasi(String taskRealisasi) {
		this.taskRealisasi = taskRealisasi;
	}

	public Integer getApp1StateRealisasi() {
		return app1StateRealisasi;
	}

	public void setApp1StateRealisasi(Integer app1StateRealisasi) {
		this.app1StateRealisasi = app1StateRealisasi;
	}

	public String getApp1UserNameRealisasi() {
		return app1UserNameRealisasi;
	}

	public void setApp1UserNameRealisasi(String app1UserNameRealisasi) {
		this.app1UserNameRealisasi = app1UserNameRealisasi;
	}

	public Integer getApp2StateRealisasi() {
		return app2StateRealisasi;
	}

	public void setApp2StateRealisasi(Integer app2StateRealisasi) {
		this.app2StateRealisasi = app2StateRealisasi;
	}

	public String getApp2UserNameRealisasi() {
		return app2UserNameRealisasi;
	}

	public void setApp2UserNameRealisasi(String app2UserNameRealisasi) {
		this.app2UserNameRealisasi = app2UserNameRealisasi;
	}

	public String getByTaskRealisasi() {
		return byTaskRealisasi;
	}

	public void setByTaskRealisasi(String byTaskRealisasi) {
		this.byTaskRealisasi = byTaskRealisasi;
	}

	public String getByApp1StateRealisasi() {
		return byApp1StateRealisasi;
	}

	public void setByApp1StateRealisasi(String byApp1StateRealisasi) {
		this.byApp1StateRealisasi = byApp1StateRealisasi;
	}

	public String getByApp1UserNameRealisasi() {
		return byApp1UserNameRealisasi;
	}

	public void setByApp1UserNameRealisasi(String byApp1UserNameRealisasi) {
		this.byApp1UserNameRealisasi = byApp1UserNameRealisasi;
	}

	public String getByApp2StateRealisasi() {
		return byApp2StateRealisasi;
	}

	public void setByApp2StateRealisasi(String byApp2StateRealisasi) {
		this.byApp2StateRealisasi = byApp2StateRealisasi;
	}

	public String getByApp2UserNameRealisasi() {
		return byApp2UserNameRealisasi;
	}

	public void setByApp2UserNameRealisasi(String byApp2UserNameRealisasi) {
		this.byApp2UserNameRealisasi = byApp2UserNameRealisasi;
	}

}
