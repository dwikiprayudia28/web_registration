package id.jexpress.util;

import id.jexpress.dto.ParamAttendanceList;
import id.jexpress.dto.ParamCutiList;
import id.jexpress.dto.ParamLemburList;
import id.jexpress.dto.ParamOfficeList;
import id.jexpress.dto.ParamUserList;

import java.text.SimpleDateFormat;

public class ConditionalQueryUtil {
	
	public static ParamAttendanceList setAttendanceListConditionQuery(ParamAttendanceList param){
		
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String roleAccess = UserLoginAuthUtil.getRoleAccessLogin();
			String userIdLogin = UserLoginAuthUtil.getUserIdLogin();
			String userCompanyLogin = UserLoginAuthUtil.getCompanyLogin();
			String userChildLogin = UserLoginAuthUtil.getUserChildLogin();
			
			if(roleAccess.equalsIgnoreCase("admin_os")){
				param.setByRoleAccess(" AND (b.company_id = " + userCompanyLogin + " )");
			} else if(roleAccess.equalsIgnoreCase("manager")){
				
				if (userChildLogin != null && userChildLogin != "") {
					param.setByRoleAccess(" AND (a.user_id IN (" + userChildLogin + ") OR a.user_id = " + userIdLogin + " )");
				} else {
					param.setByRoleAccess(" AND a.user_id = " + userIdLogin + " ");
				}
			}
			
			if(param.getAttnId()!=null){
				param.setByAttdId("AND  a.id = " + param.getAttnId() + " ");
			} else {
				param.setByAttdId("");
			}
			
			if(param.getUserName() != null && !param.getUserName().isEmpty()){
				param.setByUserName("AND  b.name LIKE \'%" + param.getUserName().trim() + "%\' ");
			} else {
				param.setByUserName("");
			}
			
			if(param.getUserNik() != null){
				param.setByUserNik("AND  b.nik = " + param.getUserNik() + " ");
			} else {
				param.setByUserNik("");
			}
			
			if(param.getUserNikExt() != null && !param.getUserNikExt().isEmpty()){
				param.setByUserNikExt("AND  b.nik_ext = \'" + param.getUserNikExt().trim() + "\' ");
			} else {
				param.setByUserNikExt("");
			}
			
			if(param.getUserOfficeName() != null && !param.getUserOfficeName().isEmpty()){
				param.setByUserOfficeName("AND f.name LIKE \'%" + param.getUserOfficeName().trim() + "%\' ");
			} else {
				param.setByUserOfficeName("");
			}
			
			if(param.getUserCompanyId()!=null){
				
				if(param.getUserCompanyId().equals(-99)){
					param.setByUserCompanyId("AND  b.company_id != 1 ");
				} else {
					param.setByUserCompanyId("AND  b.company_id = " + param.getUserCompanyId() + " ");
				}
				
			} else {
				param.setByUserCompanyId("");
			}
			
			if(param.getUserJobPositionId()!=null){
				
				param.setByUserJobPositionId("AND  b.job_position_id = " + param.getUserJobPositionId() + " ");
				
			} else {
				param.setByUserJobPositionId("");
			}
			
			if(param.getUserDepartmentName() != null && !param.getUserDepartmentName().isEmpty()){
				param.setByUserDepartmentName("AND g.name LIKE \'%" + param.getUserDepartmentName().trim() + "%\' ");
			} else {
				param.setByUserDepartmentName("");
			}
			
			if(param.getStartArriveTimeStr() != null && !param.getStartArriveTimeStr().isEmpty() && param.getEndArriveTimeStr() != null && !param.getEndArriveTimeStr().isEmpty()){
				param.setStartArriveTime(new SimpleDateFormat("dd-MMM-yyyy HH:mm").parse(param.getStartArriveTimeStr()));
				param.setEndArriveTime(new SimpleDateFormat("dd-MMM-yyyy HH:mm").parse(param.getEndArriveTimeStr()));
				
				param.setByArriveTime("AND arrive_time BETWEEN \'" + format.format(param.getStartArriveTime()) + "\' AND \'" + format.format(param.getEndArriveTime()) + "\' ");
				param.setByArriveTimeInTotal("AND (" + param.getArrive_time_query() + ")  BETWEEN \'" + format.format(param.getStartArriveTime()) + "\' AND \'" + format.format(param.getEndArriveTime()) + "\' ");
			} else {
				param.setByArriveTime("");
				param.setByArriveTimeInTotal("");
			}
			
			if(param.getArriveOfficeName() != null && !param.getArriveOfficeName().isEmpty()){
				param.setByArriveOffice("AND c_name LIKE \'%" + param.getArriveOfficeName().trim() + "%\' ");
				param.setByArriveOfficeInTotal("AND (" + param.getArrive_office_name() + ") LIKE \'%" + param.getArriveOfficeName().trim() + "%\' ");
			} else {
				param.setByArriveOffice("");
				param.setByArriveOfficeInTotal("");
			}
			
			if(param.getStartDepartTimeStr() != null && !param.getStartDepartTimeStr().isEmpty() && param.getEndDepartTimeStr() != null && !param.getEndDepartTimeStr().isEmpty()){
				param.setStartDepartTime(new SimpleDateFormat("dd-MMM-yyyy HH:mm").parse(param.getStartDepartTimeStr()));
				param.setEndDepartTime(new SimpleDateFormat("dd-MMM-yyyy HH:mm").parse(param.getEndDepartTimeStr()));
				
				param.setByDepartTime("AND depart_time BETWEEN \'" + format.format(param.getStartDepartTime()) + "\' AND \'" + format.format(param.getEndDepartTime()) + "\' ");
				param.setByDepartTimeInTotal("AND (" + param.getDepart_time_query() + ") BETWEEN \'" + format.format(param.getStartDepartTime()) + "\' AND \'" + format.format(param.getEndDepartTime()) + "\' ");
			} else {
				param.setByDepartTime("");
				param.setByDepartTimeInTotal("");
			}
			
			if(param.getDepartOfficeName() != null && !param.getDepartOfficeName().isEmpty()){
				param.setByDepartOffice("AND d_name LIKE \'%" + param.getDepartOfficeName().trim() + "%\' ");
				param.setByDepartOfficeInTotal("AND (" + param.getDepart_office_name() + ") LIKE \'%" + param.getDepartOfficeName().trim() + "%\' ");
			} else {
				param.setByDepartOffice("");
				param.setByDepartOfficeInTotal("");
			}
			
			if(param.getArriveApproval() != null){
				param.setByArriveApproval("AND a.arrive_approval = " + param.getArriveApproval() + " ");
			} else {
				param.setByArriveApproval("");
			}
			
			if(param.getDepartApproval() != null){
				param.setByDepartApproval("AND a.depart_approval = " + param.getDepartApproval() + " ");
			} else {
				param.setByDepartApproval("");
			}
			
			if(param.getArriveApprovedBy() != null && !param.getArriveApprovedBy().isEmpty()){
				param.setByArriveApprovedBy("AND a.arrive_user_aprove LIKE \'%" + param.getArriveApprovedBy().trim() + "%\' ");
			} else {
				param.setByArriveApprovedBy("");
			}
			
			if(param.getDepartApprovedBy() != null && !param.getDepartApprovedBy().isEmpty()){
				param.setByDepartApprovedBy("AND a.depart_user_aprove LIKE \'%" + param.getDepartApprovedBy().trim() + "%\' ");
			} else {
				param.setByDepartApprovedBy("");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return param;
		
	}
	
	public static ParamUserList setUserListConditionQuery(ParamUserList param){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String roleAccess = UserLoginAuthUtil.getRoleAccessLogin();
		String userIdLogin = UserLoginAuthUtil.getUserIdLogin();
		String userChildLogin = UserLoginAuthUtil.getUserChildLogin();
		
		try {

			if(roleAccess.equalsIgnoreCase("manager")){
				if (userChildLogin != null && userChildLogin != "") {
					param.setByRoleAccess(" AND (a.id IN (" + userChildLogin + ") OR a.id = " + userIdLogin + " )");
				} else {
					param.setByRoleAccess(" AND a.id = " + userIdLogin + " ");
				}
			}
			
			if(param.getUserId() != null){
				param.setByUserId("AND  a.id = " + param.getUserId() + " ");
			} else {
				param.setByUserId("");
			}
			
			if(param.getUserName() != null && !param.getUserName().isEmpty()){
				param.setByUserName("AND  a.name LIKE \'%" + param.getUserName().trim() + "%\' ");
			} else {
				param.setByUserName("");
			}
			
			if(param.getUserNik() != null){
				param.setByUserNik("AND  a.nik = " + param.getUserNik() + " ");
			} else {
				param.setByUserNik("");
			}
			
			if(param.getUserNikExt() != null && !param.getUserNikExt().isEmpty()){
				param.setByUserNikExt("AND  a.nik_ext = \'" + param.getUserNikExt().trim() + "\' ");
			} else {
				param.setByUserNikExt("");
			}
			
			if(param.getUserCompanyId()!=null){
				
				if(param.getUserCompanyId().equals(-99)){
					param.setByUserCompanyId("AND  a.company_id != 1 ");
				} else {
					param.setByUserCompanyId("AND  a.company_id = " + param.getUserCompanyId() + " ");
				}
				
			} else {
				param.setByUserCompanyId("");
			}
			
			if(param.getJobPositionId()!=null){
				param.setByJobPositionId("AND  a.job_position_id = " + param.getJobPositionId() + " ");
			} else {
				param.setByJobPositionId("");
			}
			
			if(param.getDepartmentName() != null && !param.getDepartmentName().isEmpty()){
				param.setByDepartmentName("AND f.name LIKE \'%" + param.getDepartmentName().trim() + "%\' ");
			} else {
				param.setByDepartmentName("");
			}
			
			if(param.getStartEfectiveDateStr() != null && !param.getStartEfectiveDateStr().isEmpty() && param.getEndEfectiveDateStr() != null && !param.getEndEfectiveDateStr().isEmpty()){
				param.setStartEfectiveDate(new SimpleDateFormat("dd-MMM-yyyy").parse(param.getStartEfectiveDateStr()));
				param.setEndEfectiveDate(new SimpleDateFormat("dd-MMM-yyyy").parse(param.getEndEfectiveDateStr()));
				
				param.setByEfectiveDate("AND a.job_pos_efective_date BETWEEN \'" + format.format(param.getStartEfectiveDate()) + "\' AND \'" + format.format(param.getEndEfectiveDate()) + "\' ");
			} else {
				param.setByEfectiveDate("");
			}
			
			if(param.getOfficeName() != null && !param.getOfficeName().isEmpty()){
				param.setByOfficeName("AND  b.name LIKE \'%" + param.getOfficeName().trim() + "%\' ");
			} else {
				param.setByOfficeName("");
			}
			
			if(param.getIsRegistered() != null){
				param.setByIsRegistered("AND  a.is_registered = " + param.getIsRegistered() + " ");
			} else {
				param.setByIsRegistered("");
			}
			
			if(param.getApproveByName() != null && !param.getApproveByName().isEmpty()){
				param.setByApproveByName("AND  c.name LIKE \'%" + param.getApproveByName().trim() + "%\' ");
			} else {
				param.setByApproveByName("");
			}
			
			if(param.getRole() != null){
				param.setByRole("AND  a.role = " + param.getRole() + " ");
			} else {
				param.setByRole("");
			}
			
			if(param.getAllowPhoto() != null){
				param.setByAllowPhoto("AND  a.allow_photo = " + param.getAllowPhoto() + " ");
			} else {
				param.setByAllowPhoto("");
			}
			
			if(param.getImei() != null && !param.getImei().isEmpty()){
				param.setByImei("AND UPPER(a.imei) = UPPER('" + param.getImei().trim() + "') ");
			} else {
				param.setByImei("");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return param;
	}
	
	public static ParamOfficeList setOfficeListConditionQuery(ParamOfficeList param){
		
		if(param.getId() != null){
			param.setById("AND  a.id = " + param.getId() + " ");
		} else {
			param.setById("");
		}
		
		if(param.getName() != null && !param.getName().isEmpty()){
			param.setByName("AND  a.name LIKE \'%" + param.getName().trim() + "%\' ");
		} else {
			param.setByName("");
		}
		
		if(param.getAddress() != null && !param.getAddress().isEmpty()){
			param.setByAddress("AND  a.address LIKE \'%" + param.getAddress().trim() + "%\' ");
		} else {
			param.setByAddress("");
		}
		
		if(param.getLatitude() != null){
			param.setByLatitude("AND  a.latitude = " + param.getLatitude() + " ");
		} else {
			param.setByLatitude("");
		}
		
		if(param.getLongitude() != null){
			param.setByLongitude("AND  a.longitude = " + param.getLongitude() + " ");
		} else {
			param.setByLongitude("");
		}
		
		return param;
		
	}

	public static ParamCutiList setCutiListConditionQuery(ParamCutiList param) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String roleAccess = UserLoginAuthUtil.getRoleAccessLogin();
		String userIdLogin = UserLoginAuthUtil.getUserIdLogin();
		String userCompanyLogin = UserLoginAuthUtil.getCompanyLogin();
		String userChildLogin = UserLoginAuthUtil.getUserChildLogin();
		
		try {
			
			if(roleAccess.equalsIgnoreCase("admin_os")){
				param.setByRoleAccess(" AND (b.company_id = " + userCompanyLogin + " )");
			} else if(roleAccess.equalsIgnoreCase("manager")){
				if (userChildLogin != null && userChildLogin != "") {
					param.setByRoleAccess(" AND (a.user_id IN (" + userChildLogin + ") OR a.user_id = " + userIdLogin + " )");
				} else {
					param.setByRoleAccess(" AND a.user_id = " + userIdLogin + " ");
				}
			}
			
			if(param.getId() != null){
				param.setById("AND  a.id = " + param.getId() + " ");
			} else {
				param.setById("");
			}
			
			if(param.getUserName() != null && !param.getUserName().isEmpty()){
				param.setByUserName("AND  b.name LIKE \'%" + param.getUserName().trim() + "%\' ");
			} else {
				param.setByUserName("");
			}
			
			if(param.getCutiReasonId() != null){
				param.setByCutiReasonId("AND  a.cuti_reason_id = " + param.getCutiReasonId() + " ");
			} else {
				param.setByCutiReasonId("");
			}
			
			if(param.getState() != null && !param.getState().isEmpty()){
				
				if(param.getState().equalsIgnoreCase("00")){
					param.setByState("AND  (a.state = 0 AND a.approval1_state = 0 ) ");
				} else if(param.getState().equalsIgnoreCase("01")){
					param.setByState("AND  (a.state = 0 AND a.approval1_state = 1 ) ");
				} else if(param.getState().equalsIgnoreCase("1")){
					param.setByState("AND  (a.state = 1 ) ");
				} else if(param.getState().equalsIgnoreCase("-1")){
					param.setByState("AND  (a.state = -1 ) ");
				} else if(param.getState().equalsIgnoreCase("-2")){
					param.setByState("AND  (a.state = -2 ) ");
				} else {
					param.setByState("");
				}
				
			} else {
				param.setByState("");
			}
			
			if(param.getStateUserName() != null && !param.getStateUserName().isEmpty()){
				param.setByStateUserName("AND  d.name LIKE \'%" + param.getStateUserName().trim() + "%\' ");
			} else {
				param.setByStateUserName("");
			}
			
			if(param.getStartDateFromStr() != null && !param.getStartDateFromStr().isEmpty() && param.getStartDateUntilStr() != null && !param.getStartDateUntilStr().isEmpty()){
				param.setStartDateFrom(new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(param.getStartDateFromStr()));
				param.setStartDateUntil(new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(param.getStartDateUntilStr()));
				
				param.setByStartDate("AND a.start_date BETWEEN \'" + format.format(param.getStartDateFrom()) + "\' AND \'" + format.format(param.getStartDateUntil()) + "\' ");
			} else {
				param.setByStartDate("");
			}
			
			if(param.getEndDateFromStr() != null && !param.getEndDateFromStr().isEmpty() && param.getEndDateUntilStr() != null && !param.getEndDateUntilStr().isEmpty()){
				param.setEndDateFrom(new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(param.getEndDateFromStr()));
				param.setEndDateUntil(new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(param.getEndDateUntilStr()));
				
				param.setByEndDate("AND a.end_date BETWEEN \'" + format.format(param.getEndDateFrom()) + "\' AND \'" + format.format(param.getEndDateUntil()) + "\' ");
			} else {
				param.setByEndDate("");
			}
			
			if(param.getTimeType() != null){
				param.setByTimeType("AND  a.time_type = " + param.getTimeType() + " ");
			} else {
				param.setByTimeType("");
			}
			
			if(param.getApproval1State() != null){
				param.setByApproval1State("AND  a.approval1_state = " + param.getApproval1State() + " ");
			} else {
				param.setByApproval1State("");
			}
			
			if(param.getApproval1UserName() != null && !param.getApproval1UserName().isEmpty()){
				param.setByApproval1UserName("AND  e.name LIKE \'%" + param.getApproval1UserName().trim() + "%\' ");
			} else {
				param.setByApproval1UserName("");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return param;
	}

	public static ParamLemburList setLemburListConditionQuery(ParamLemburList param) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String roleAccess = UserLoginAuthUtil.getRoleAccessLogin();
		String userIdLogin = UserLoginAuthUtil.getUserIdLogin();
		String userCompanyLogin = UserLoginAuthUtil.getCompanyLogin();
		String userChildLogin = UserLoginAuthUtil.getUserChildLogin();
		
		try {
			
			if(roleAccess.equalsIgnoreCase("admin_os")){
				param.setByRoleAccess(" AND (b.company_id = " + userCompanyLogin + " )");
			} else if(roleAccess.equalsIgnoreCase("manager")){
				if (userChildLogin != null && userChildLogin != "") {
					param.setByRoleAccess(" AND (a.user_id IN (" + userChildLogin + ") OR a.user_id = " + userIdLogin + " )");
				} else {
					param.setByRoleAccess(" AND a.user_id = " + userIdLogin + " ");
				}
			}
			
			if(param.getId() != null){
				param.setById("AND  a.id = " + param.getId() + " ");
			} else {
				param.setById("");
			}
			
			if(param.getUserName() != null && !param.getUserName().isEmpty()){
				param.setByUserName("AND  b.name LIKE \'%" + param.getUserName().trim() + "%\' ");
			} else {
				param.setByUserName("");
			}
			
			if(param.getState() != null && !param.getState().isEmpty()){
				
				if(param.getState().equalsIgnoreCase("00")){
					param.setByState("AND  (a.state = 0 AND a.app1_state_estimasi = 0 ) ");
				} else if(param.getState().equalsIgnoreCase("01")){
					param.setByState("AND  (a.state = 0 AND a.app1_state_estimasi = 1 ) ");
				} else if(param.getState().equalsIgnoreCase("110")){
					param.setByState("AND  (a.state = 1 AND a.app1_state_estimasi = 1 AND a.app1_state_realisasi = 0 ) ");
				} else if(param.getState().equalsIgnoreCase("1110")){
					param.setByState("AND  (a.state = 1 AND a.app1_state_estimasi = 1 AND a.app1_state_realisasi = 1 AND a.app2_state_realisasi = 0 ) ");
				} else if(param.getState().equalsIgnoreCase("1111")){
					param.setByState("AND  (a.state = 1 AND a.app1_state_estimasi = 1 AND a.app1_state_realisasi = 1 AND a.app2_state_realisasi = 1 ) ");
				} else if(param.getState().equalsIgnoreCase("2111")){
					param.setByState("AND  (a.state = 2 AND a.app1_state_estimasi = 1 AND a.app1_state_realisasi = 1 AND a.app2_state_realisasi = 1 ) ");
				} else if(param.getState().equalsIgnoreCase("-1-1")){
					param.setByState("AND  (a.state = -1 AND a.app1_state_estimasi = -1 ) ");
				} else if(param.getState().equalsIgnoreCase("-2")){
					param.setByState("AND  (a.state = -2 ) ");
				} else if(param.getState().equalsIgnoreCase("-3")){
					param.setByState("AND  (a.state = -3 ) ");
				} else {
					param.setByState("");
				}
			} else {
				param.setByState("");
			}
			
			if(param.getStateUserName() != null && !param.getStateUserName().isEmpty()){
				param.setByStateUserName("AND  c.name LIKE \'%" + param.getStateUserName().trim() + "%\' ");
			} else {
				param.setByStateUserName("");
			}
			
			/*Estimasi*/
			if(param.getStartDateEstimasiFromStr() != null && !param.getStartDateEstimasiFromStr().isEmpty() && param.getStartDateEstimasiUntilStr() != null && !param.getStartDateEstimasiUntilStr().isEmpty()){
				param.setStartDateEstimasiFrom(new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(param.getStartDateEstimasiFromStr()));
				param.setStartDateEstimasiUntil(new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(param.getStartDateEstimasiUntilStr()));
				
				param.setByStartDateEstimasi("AND a.start_date_estimasi BETWEEN \'" + format.format(param.getStartDateEstimasiFrom()) + "\' AND \'" + format.format(param.getStartDateEstimasiUntil()) + "\' ");
			} else {
				param.setByStartDateEstimasi("");
			}
			
			if(param.getEndDateEstimasiFromStr() != null && !param.getEndDateEstimasiFromStr().isEmpty() && param.getEndDateEstimasiUntilStr() != null && !param.getEndDateEstimasiUntilStr().isEmpty()){
				param.setEndDateEstimasiFrom(new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(param.getEndDateEstimasiFromStr()));
				param.setEndDateEstimasiUntil(new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(param.getEndDateEstimasiUntilStr()));
				
				param.setByEndDateEstimasi("AND a.end_date_estimasi BETWEEN \'" + format.format(param.getEndDateEstimasiFrom()) + "\' AND \'" + format.format(param.getEndDateEstimasiUntil()) + "\' ");
			} else {
				param.setByEndDateEstimasi("");
			}
			
			if(param.getEventEstimasi() != null && !param.getEventEstimasi().isEmpty()){
				param.setByEventEstimasi("AND  a.event_estimasi LIKE \'%" + param.getEventEstimasi().trim() + "%\' ");
			} else {
				param.setByEventEstimasi("");
			}
			
			if(param.getTaskEstimasi() != null && !param.getTaskEstimasi().isEmpty()){
				param.setByTaskEstimasi("AND  a.task_estimasi LIKE \'%" + param.getTaskEstimasi().trim() + "%\' ");
			} else {
				param.setByTaskEstimasi("");
			}
			
			if(param.getApp1StateEstimasi() != null){
				param.setByApp1StateEstimasi("AND  a.app1_state_estimasi = " + param.getApp1StateEstimasi() + " ");
			} else {
				param.setByApp1StateEstimasi("");
			}
			
			if(param.getApp1UserNameEstimasi() != null && !param.getApp1UserNameEstimasi().isEmpty()){
				param.setByApp1UserNameEstimasi("AND  d.name LIKE \'%" + param.getApp1UserNameEstimasi().trim() + "%\' ");
			} else {
				param.setByApp1UserNameEstimasi("");
			}
			
			/*Realisasi*/
			if(param.getStartDateRealisasiFromStr() != null && !param.getStartDateRealisasiFromStr().isEmpty() && param.getStartDateRealisasiUntilStr() != null && !param.getStartDateRealisasiUntilStr().isEmpty()){
				param.setStartDateRealisasiFrom(new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(param.getStartDateRealisasiFromStr()));
				param.setStartDateRealisasiUntil(new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(param.getStartDateRealisasiUntilStr()));
				
				param.setByStartDateRealisasi("AND a.start_date_realisasi BETWEEN \'" + format.format(param.getStartDateRealisasiFrom()) + "\' AND \'" + format.format(param.getStartDateRealisasiUntil()) + "\' ");
			} else {
				param.setByStartDateRealisasi("");
			}
			
			if(param.getEndDateRealisasiFromStr() != null && !param.getEndDateRealisasiFromStr().isEmpty() && param.getEndDateRealisasiUntilStr() != null && !param.getEndDateRealisasiUntilStr().isEmpty()){
				param.setEndDateRealisasiFrom(new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(param.getEndDateRealisasiFromStr()));
				param.setEndDateRealisasiUntil(new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(param.getEndDateRealisasiUntilStr()));
				
				param.setByEndDateRealisasi("AND a.end_date_realisasi BETWEEN \'" + format.format(param.getEndDateRealisasiFrom()) + "\' AND \'" + format.format(param.getEndDateRealisasiUntil()) + "\' ");
			} else {
				param.setByEndDateRealisasi("");
			}
			
			if(param.getTaskRealisasi() != null && !param.getTaskRealisasi().isEmpty()){
				param.setByTaskRealisasi("AND  a.task_realisasi LIKE \'%" + param.getTaskRealisasi().trim() + "%\' ");
			} else {
				param.setByTaskRealisasi("");
			}
			
			if(param.getApp1StateRealisasi() != null){
				param.setByApp1StateRealisasi("AND  a.app1_state_realisasi = " + param.getApp1StateRealisasi() + " ");
			} else {
				param.setByApp1StateRealisasi("");
			}
			
			if(param.getApp1UserNameRealisasi() != null && !param.getApp1UserNameRealisasi().isEmpty()){
				param.setByApp1UserNameRealisasi("AND  e.name LIKE \'%" + param.getApp1UserNameRealisasi().trim() + "%\' ");
			} else {
				param.setByApp1UserNameRealisasi("");
			}
			
			if(param.getApp2StateRealisasi() != null){
				param.setByApp2StateRealisasi("AND  a.app2_state_realisasi = " + param.getApp2StateRealisasi() + " ");
			} else {
				param.setByApp2StateRealisasi("");
			}
			
			if(param.getApp2UserNameRealisasi() != null && !param.getApp2UserNameRealisasi().isEmpty()){
				param.setByApp2UserNameRealisasi("AND  f.name LIKE \'%" + param.getApp2UserNameRealisasi().trim() + "%\' ");
			} else {
				param.setByApp2UserNameRealisasi("");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return param;
	}

}
