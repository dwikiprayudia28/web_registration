package id.jexpress.dao.impl;

import id.jexpress.dao.LesDao;
import id.jexpress.model.Les;
import id.jexpress.util.PasswordEncoderGenerator;

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
public class LesDaoImpl implements LesDao {
	
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

	@Override
	public String insertLes(Les les) {
		Authentication userlogin = SecurityContextHolder.getContext().getAuthentication();
		Date now = Calendar.getInstance().getTime();
		
		String msg = "";
		try {
			Query query = sessionFactory
					.getCurrentSession()
					.createSQLQuery(""
							+ "INSERT INTO registrasi.les ("
							+ "  name,"
							+ "  address,"
							+ "  born_date,"
							+ "  kelas_id,"
							+ "  jurusan_id,"
							+ "  jenis_pertemuan_id,"
							+ "  jadwal_id,"
							+ "  status,"
							+ "  created_time,"
							+ "  created_by"
							+ ") "
							+ "VALUES"
							+ "  ("
							+ "    :p_name,"
							+ "    :p_address,"
							+ "    :p_born_date,"
							+ "    :p_kelas_id,"
							+ "    :p_jurusan_id,"
							+ "    :p_jenis_pertemuan_id,"
							+ "    :p_jadwal_id,"
							+ "    :p_status,"
							+ "    :p_created_time,"
							+ "    :p_created_by"
							+ "  ) ;")
					.setParameter("p_name", les.getName())
					.setParameter("p_address", les.getAddress())
					.setParameter("p_born_date", les.getBornDate())
					.setParameter("p_kelas_id", les.getKelasId())
					.setParameter("p_jurusan_id", les.getJurusanId())
					.setParameter("p_jenis_pertemuan_id", les.getJenisPertemuanId())
					.setParameter("p_jadwal_id", les.getJadwalId())
					.setParameter("p_status", "unpaid")
					.setParameter("p_created_time", now)
					.setParameter("p_created_by", userlogin.getName());
			
			 query.executeUpdate();
			 msg = "success;success" ;
		} catch (HibernateException e) {
			 e.printStackTrace();
			 msg = "error;"+e.getCause().getMessage();
		}
		return msg;
	}

	@Override
	public List<Les> getListLesByCreatedUser(String createdBy) {
		Query query = sessionFactory
				.getCurrentSession()
				.createSQLQuery("" 
								+ "SELECT " 
								+ "  a.id, " 
								+ "  name, " 
								+ "  address, " 
								+ "  born_date, " 
								+ "  kelas_id, " 
								+ "  jurusan_id, " 
								+ "  jenis_pertemuan_id, " 
								+ "  jadwal_id, " 
								+ "  status, " 
								+ "  created_time, " 
								+ "  created_by, " 
								+ "  updated_time, " 
								+ "  updated_by, " 
								+ "  b.value AS kelas, "
								+ "  c.value AS jurusan, "
								+ "  d.value AS jenis_pertemuan, "
								+ "  e.value AS jadwal "
								+ "FROM les a "
								+ "LEFT JOIN `master` b ON a.kelas_id = b.id "
								+ "LEFT JOIN `master` c ON a.jurusan_id = c.id "
								+ "LEFT JOIN `master` d ON a.jenis_pertemuan_id = d.id "
								+ "LEFT JOIN `master` e ON a.jadwal_id = e.id "
								+ "WHERE created_by = :p_created_by ")
				.setParameter("p_created_by", createdBy);

		List<Object> list = query.list();
		List<Les> listResult = new ArrayList<Les>();
		
		for(Object obj : list){
			
			Object[] result = (Object[]) obj;
			int i = 0;
			Les les = new Les();
			les.setId((int) result[i++]);
			les.setName((String) result[i++]);
			les.setAddress((String) result[i++]);
			les.setBornDate((Date) result[i++]);
			
			les.setKelasId((int) result[i++]);
			les.setJurusanId((int) result[i++]);
			les.setJenisPertemuanId((int) result[i++]);
			les.setJadwalId((int) result[i++]);
			les.setStatus((String) result[i++]);
			
			les.setCreatedTime((Date) result[i++]);
			les.setCreatedby((String) result[i++]);
			les.setUpdatedTime((Date) result[i++]);
			les.setUpdatedBy((String) result[i++]);
			
			les.setKelas((String) result[i++]);
			les.setJurusan((String) result[i++]);
			les.setJenisPertemuan((String) result[i++]);
			les.setJadwal((String) result[i++]);
			
			listResult.add(les);
		}
		
		return listResult;
	}

	@Override
	public Les getLesById(Integer id) {
		Query query = sessionFactory
				.getCurrentSession()
				.createSQLQuery("" 
								+ "SELECT " 
								+ "  a.id, " 
								+ "  name, " 
								+ "  address, " 
								+ "  born_date, " 
								+ "  kelas_id, " 
								+ "  jurusan_id, " 
								+ "  jenis_pertemuan_id, " 
								+ "  jadwal_id, " 
								+ "  status, " 
								+ "  created_time, " 
								+ "  created_by, " 
								+ "  updated_time, " 
								+ "  updated_by, " 
								+ "  b.value AS kelas, "
								+ "  c.value AS jurusan, "
								+ "  d.value AS jenis_pertemuan, "
								+ "  e.value AS jadwal "
								+ "FROM les a "
								+ "LEFT JOIN `master` b ON a.kelas_id = b.id "
								+ "LEFT JOIN `master` c ON a.jurusan_id = c.id "
								+ "LEFT JOIN `master` d ON a.jenis_pertemuan_id = d.id "
								+ "LEFT JOIN `master` e ON a.jadwal_id = e.id "
								+ "WHERE a.id = :p_id ")
				.setParameter("p_id", id);

		List<Object> list = query.list();
		Les les = new Les();
		
		for(Object obj : list){
			
			Object[] result = (Object[]) obj;
			int i = 0;
			
			les.setId((int) result[i++]);
			les.setName((String) result[i++]);
			les.setAddress((String) result[i++]);
			les.setBornDate((Date) result[i++]);
			
			les.setKelasId((int) result[i++]);
			les.setJurusanId((int) result[i++]);
			les.setJenisPertemuanId((int) result[i++]);
			les.setJadwalId((int) result[i++]);
			les.setStatus((String) result[i++]);
			
			les.setCreatedTime((Date) result[i++]);
			les.setCreatedby((String) result[i++]);
			les.setUpdatedTime((Date) result[i++]);
			les.setUpdatedBy((String) result[i++]);
			
			les.setKelas((String) result[i++]);
			les.setJurusan((String) result[i++]);
			les.setJenisPertemuan((String) result[i++]);
			les.setJadwal((String) result[i++]);
			
		}
		return les;
	}

	@Override
	public void updateLes(Les les) {
		Authentication userlogin = SecurityContextHolder.getContext().getAuthentication();
		Date now = Calendar.getInstance().getTime();
		
		try {
			Query query = sessionFactory
					.getCurrentSession()
					.createSQLQuery(""
							+ "UPDATE registrasi.les SET"
							+ "  name = :p_name,"
							+ "  address = :p_address,"
							+ "  born_date = :p_born_date,"
							+ "  updated_time = :p_updated_time,"
							+ "  updated_by = :p_updated_by "
							+ "WHERE id = :p_id ")
					.setParameter("p_name", les.getName())
					.setParameter("p_address", les.getAddress())
					.setParameter("p_born_date", les.getBornDate())
					.setParameter("p_updated_time", now)
					.setParameter("p_updated_by", userlogin.getName())
					.setParameter("p_id", les.getId());
					
			
			 query.executeUpdate();
		} catch (HibernateException e) {
			 e.printStackTrace();
		}
	}

	@Override
	public void updatePaidLes(Les les) {
		Authentication userlogin = SecurityContextHolder.getContext().getAuthentication();
		Date now = Calendar.getInstance().getTime();
		
		try {
			Query query = sessionFactory
					.getCurrentSession()
					.createSQLQuery(""
							+ "UPDATE registrasi.les SET"
							+ "  status = :p_status,"
							+ "  updated_time = :p_updated_time,"
							+ "  updated_by = :p_updated_by "
							+ "WHERE id = :p_id ")
					.setParameter("p_status", les.getStatus())
					.setParameter("p_updated_time", now)
					.setParameter("p_updated_by", userlogin.getName())
					.setParameter("p_id", les.getId());
			 query.executeUpdate();
		} catch (HibernateException e) {
			 e.printStackTrace();
		}
	}

}
