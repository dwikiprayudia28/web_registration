package id.jexpress.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Attendance implements Serializable {

	private static final long serialVersionUID = -212086076147209419L;

	private Integer id;
	private Integer userId;
	private Date arriveTime;
	private Integer arriveOfficeId;
	private BigDecimal arriveLatitude;
	private BigDecimal arriveLongitude;
	private BigDecimal arriveDistance;
	private BigDecimal arriveAltitude;
	private BigDecimal arriveAccuracy;
	private String arriveImg;
	private String arriveZName;
	private Integer arriveApproval;
	private String arriveUserAprove;
	private Date arriveTimeAprove;
	private Date departTime;
	private Integer departOfficeId;
	private BigDecimal departLatitude;
	private BigDecimal departLongitude;
	private BigDecimal departDistance;
	private BigDecimal departAltitude;
	private BigDecimal departAccuracy;
	private String departImg;
	private String departZName;
	private Integer departApproval;
	private String departUserAprove;
	private Date departTimeAprove;
	private Integer state;
	private String remark;
	private Date createdTime;
	private String createdUser;
	private Date modifiedTime;
	private String modifiedUser;

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

	public BigDecimal getArriveLatitude() {
		return arriveLatitude;
	}

	public void setArriveLatitude(BigDecimal arriveLatitude) {
		this.arriveLatitude = arriveLatitude;
	}

	public BigDecimal getArriveLongitude() {
		return arriveLongitude;
	}

	public void setArriveLongitude(BigDecimal arriveLongitude) {
		this.arriveLongitude = arriveLongitude;
	}

	public BigDecimal getArriveDistance() {
		return arriveDistance;
	}

	public void setArriveDistance(BigDecimal arriveDistance) {
		this.arriveDistance = arriveDistance;
	}

	public BigDecimal getArriveAltitude() {
		return arriveAltitude;
	}

	public void setArriveAltitude(BigDecimal arriveAltitude) {
		this.arriveAltitude = arriveAltitude;
	}

	public BigDecimal getArriveAccuracy() {
		return arriveAccuracy;
	}

	public void setArriveAccuracy(BigDecimal arriveAccuracy) {
		this.arriveAccuracy = arriveAccuracy;
	}

	public String getArriveImg() {
		return arriveImg;
	}

	public void setArriveImg(String arriveImg) {
		this.arriveImg = arriveImg;
	}

	public String getArriveZName() {
		return arriveZName;
	}

	public void setArriveZName(String arriveZName) {
		this.arriveZName = arriveZName;
	}

	public Integer getArriveApproval() {
		return arriveApproval;
	}

	public void setArriveApproval(Integer arriveApproval) {
		this.arriveApproval = arriveApproval;
	}

	public String getArriveUserAprove() {
		return arriveUserAprove;
	}

	public void setArriveUserAprove(String arriveUserAprove) {
		this.arriveUserAprove = arriveUserAprove;
	}

	public Date getArriveTimeAprove() {
		return arriveTimeAprove;
	}

	public void setArriveTimeAprove(Date arriveTimeAprove) {
		this.arriveTimeAprove = arriveTimeAprove;
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

	public BigDecimal getDepartLatitude() {
		return departLatitude;
	}

	public void setDepartLatitude(BigDecimal departLatitude) {
		this.departLatitude = departLatitude;
	}

	public BigDecimal getDepartLongitude() {
		return departLongitude;
	}

	public void setDepartLongitude(BigDecimal departLongitude) {
		this.departLongitude = departLongitude;
	}

	public BigDecimal getDepartDistance() {
		return departDistance;
	}

	public void setDepartDistance(BigDecimal departDistance) {
		this.departDistance = departDistance;
	}

	public BigDecimal getDepartAltitude() {
		return departAltitude;
	}

	public void setDepartAltitude(BigDecimal departAltitude) {
		this.departAltitude = departAltitude;
	}

	public BigDecimal getDepartAccuracy() {
		return departAccuracy;
	}

	public void setDepartAccuracy(BigDecimal departAccuracy) {
		this.departAccuracy = departAccuracy;
	}

	public String getDepartImg() {
		return departImg;
	}

	public void setDepartImg(String departImg) {
		this.departImg = departImg;
	}

	public String getDepartZName() {
		return departZName;
	}

	public void setDepartZName(String departZName) {
		this.departZName = departZName;
	}

	public Integer getDepartApproval() {
		return departApproval;
	}

	public void setDepartApproval(Integer departApproval) {
		this.departApproval = departApproval;
	}

	public String getDepartUserAprove() {
		return departUserAprove;
	}

	public void setDepartUserAprove(String departUserAprove) {
		this.departUserAprove = departUserAprove;
	}

	public Date getDepartTimeAprove() {
		return departTimeAprove;
	}

	public void setDepartTimeAprove(Date departTimeAprove) {
		this.departTimeAprove = departTimeAprove;
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

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

}
