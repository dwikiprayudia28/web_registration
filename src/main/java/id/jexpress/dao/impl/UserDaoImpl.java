package id.jexpress.dao.impl;

import id.jexpress.dao.UserDao;
import id.jexpress.dto.UserChild;
import id.jexpress.dto.UserDetail;
import id.jexpress.model.User;
import id.jexpress.util.PasswordEncoderGenerator;
import id.jexpress.util.UserLoginAuthUtil;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private PasswordEncoderGenerator passwordEncoderGenerator;
	
	private Session session;
	
	public final Session getSession() {
		session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findByUserName(String username) {
		User user = new User();
		try {
			Query query = sessionFactory
					.getCurrentSession()
					.createSQLQuery(""
							+ "SELECT "
							+ "  username, "
							+ "  password "
							+ "FROM USER "
							+ "WHERE username = :p_user_name ")
					.setParameter("p_user_name", username);
			
			List<Object> list = query.list();
			
			for(Object obj : list){
				
				Object[] result = (Object[]) obj;
				int i = 0;
				
				user.setName((String) result[i++]);
				user.setPassword((String) result[i++]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}


	@Override
	public String insertUser(User user) {
		
		Authentication userlogin = SecurityContextHolder.getContext().getAuthentication();
		Date now = Calendar.getInstance().getTime();
		
		String msg = "";
		try {
			Query query = sessionFactory
					.getCurrentSession()
					.createSQLQuery(""
							+ "INSERT INTO registrasi.user ("
							+ "  password,"
							+ "  username,"
							+ "  email"
							+ ") "
							+ "VALUES"
							+ "  ("
							+ "    :p_password,"
							+ "    :p_name,"
							+ "	   :p_email "
							+ "  ) ;")
					.setParameter("p_name", user.getName())
					.setParameter("p_password", passwordEncoderGenerator.getEncodeGenMD5(user.getPassword()))
					.setParameter("p_email", user.getEmail());
			
			 query.executeUpdate();
			 msg = "success;success" ;
		} catch (HibernateException e) {
			 e.printStackTrace();
			 msg = "error;"+e.getCause().getMessage();
		}
		return msg;
	}

	@Override
	public String editUser (User user) {
		Authentication userlogin = SecurityContextHolder.getContext().getAuthentication();
		Date now = Calendar.getInstance().getTime();
		
		String msg = "";
		try {
			if(UserLoginAuthUtil.getRoleAccessLogin().equalsIgnoreCase("superadmin")){
				Query query = sessionFactory
						.getCurrentSession()
						.createSQLQuery(""
								+ "UPDATE "
								+ "  jexpress.jx_attn_user "
								+ "SET "
								+ "  nik = :p_nik,"
								+ "  nik_ext = :p_nik_ext,"
								+ "  name = :p_name,"
								+ "  job_position_id = :p_job_position_id,"
								+ "  departement_id = :p_department_id,"
								+ "  job_pos_efective_date = :p_job_pos_efective_date,"
								+ "  company_id = :p_company_id,"
								+ "  office_id = :p_office_id,"
								+ "  approve_by = :p_approve_by,"
								+ "  role = :p_role,"
								+ "  allow_photo = :p_allow_photo, "
								+ "  modified_user = :p_modified_user,"
								+ "  modified_time = :p_modified_time "
								+ "WHERE id = :p_id ; ")
//						.setParameter("p_nik", user.getNik())
//						.setParameter("p_nik_ext", user.getNikExt())
//						.setParameter("p_name", user.getName())
//						.setParameter("p_job_position_id", user.getJobPositionId())
//						.setParameter("p_department_id", user.getDepartmentId())
//						.setParameter("p_job_pos_efective_date", user.getJobPosEfectiveDate())
//						.setParameter("p_company_id", user.getCompanyId())
//						.setParameter("p_office_id", user.getOfficeId())
//						.setParameter("p_approve_by", user.getApproveBy())
//						.setParameter("p_role", user.getRole())
//						.setParameter("p_allow_photo", user.getAllowPhoto())
//						.setParameter("p_id", user.getId())
						.setParameter("p_modified_user", userlogin.getName())
						.setParameter("p_modified_time", now);
				
				query.executeUpdate();
			} else {
				Query query = sessionFactory
						.getCurrentSession()
						.createSQLQuery(""
								+ "UPDATE "
								+ "  jexpress.jx_attn_user "
								+ "SET "
								+ "  office_id = :p_office_id,"
								+ "  modified_user = :p_modified_user,"
								+ "  modified_time = :p_modified_time "
								+ "WHERE id = :p_id ; ")
//						.setParameter("p_office_id", user.getOfficeId())
						.setParameter("p_id", user.getId())
						.setParameter("p_modified_user", userlogin.getName())
						.setParameter("p_modified_time", now);
				
				query.executeUpdate();
			}
			
			msg = "success;success" ;
		} catch (Exception e) {
			e.printStackTrace();
			msg = "error;"+e.getCause().getMessage();
		}
		
		return msg;
	}

	

	

	@Override
	public UserDetail getUserById(Integer userId) {
		
		Query query = sessionFactory
				.getCurrentSession()
				.createSQLQuery(""
						+ "SELECT "
						+ "  a.id, "
						+ "  a.nik, "
						+ "  a.nik_ext,"
						+ "  a.name,"
						+ "  a.job_position_id, "
						+ "  e.name AS job_position_name, "
						+ "  a.departement_id, "
						+ "  f.name AS department_name, "
						+ "  a.job_pos_efective_date, "
						+ "  a.company_id, "
						+ "  d.name AS company_name, "
						+ "  a.office_id, "
						+ "  b.name AS office_name, "
						+ "  a.imei,"
						+ "  a.m_phone, "
						+ "  a.m_phone2, "
						+ "  a.is_registered, "
						+ "  a.type_device, "
						+ "  a.last_attn_id, "
						+ "  a.approve_by, "
						+ "  c.name AS approve_by_name, "
						+ "  a.role,"
						+ "  a.allow_photo,"
						+ "  a.is_deleted "
						+ "FROM "
						+ "  jx_attn_user a "
						+ "  LEFT JOIN jx_attn_office b ON a.office_id = b.id "
						+ "  LEFT JOIN jx_attn_user c ON a.approve_by = c.id "
						+ "  INNER JOIN jx_attn_company d ON a.company_id = d.id"
						+ "  LEFT JOIN jx_attn_job_position e ON a.job_position_id = e.id "
						+ "  LEFT JOIN jx_attn_department f ON a.departement_id = f.id "
						+ "WHERE a.id = :p_user_id ; ")
				.setParameter("p_user_id", userId);
		
		Object queryResult = query.list().get(0);
		Object[] result = (Object[]) queryResult;
		
		UserDetail detail = new UserDetail();
//		User user = new User(); 
//		Office office = new Office();
//		User userApprove = new User();
//		
//		int i = 0;
//		
//		user.setId((Integer) result[i++]);
//		user.setNik((BigInteger) result[i++]);
//		user.setNikExt((String) result[i++]);
//		user.setName((String) result[i++]);
//		user.setJobPositionId((Integer) result[i++]);
//		detail.setJobPositionName((String) result[i++]);
//		user.setDepartmentId((Integer) result[i++]);
//		detail.setDepartmentName((String) result[i++]);
//		user.setJobPosEfectiveDate((Date) result[i++]);
//		
//		try {
//			if(user.getJobPosEfectiveDate()!=null){
//				String sDate1 = user.getJobPosEfectiveDate().toString();
//				Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
//				user.setJobPosEfectiveDate(date1);
//			}
//			
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
	    
//		user.setCompanyId((Integer) result[i++]);
//		detail.setCompanyName((String) result[i++]);
//		user.setOfficeId((Integer) result[i++]);
//		office.setId(user.getOfficeId());
//		office.setName((String) result[i++]);
//		user.setImei((String) result[i++]);
//		user.setmPhone((String) result[i++]);
//		user.setmPhone2((String) result[i++]);
//		user.setIsRegistered((Integer) result[i++]);
//		user.setTypeDevice((Integer) result[i++]);
//		user.setLastAttnId((Integer) result[i++]);
//		user.setApproveBy((Integer) result[i++]);
//		userApprove.setId(user.getApproveBy());
//		userApprove.setName((String) result[i++]);
//		user.setRole((Integer) result[i++]);
//		user.setAllowPhoto((Integer) result[i++]);
//		user.setIsDeleted((Integer) result[i++]);
		
		
//		detail.setUser(user);
//		detail.setOffice(office);
//		detail.setUserApprove(userApprove);
//		
//		detail.setIsRegisteredStr("");
//		detail.setRoleStr("");
//		detail.setAllowPhotoStr("");
//		detail.setIsDeletedStr("");
		
		return detail;
	}


}
