package id.jexpress.dao.impl;

import id.jexpress.dao.MasterDao;
import id.jexpress.model.Master;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MasterDaoImpl implements MasterDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session session;

	public final Session getSession() {
		session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	@Override
	public List<Master> getListMasterByType(String type) {
		Query query = sessionFactory
				.getCurrentSession()
				.createSQLQuery("" 
								+ "SELECT " 
								+ "  id, " 
								+ "  value, " 
								+ "  type "
								+ "FROM MASTER "
								+ "WHERE type = :p_type ")
				.setParameter("p_type", type);

		List<Object> list = query.list();
		List<Master> listResult = new ArrayList<Master>();
		
		for(Object obj : list){
			
			Object[] result = (Object[]) obj;
			int i = 0;
			Master master = new Master();
			master.setId((int) result[i++]);
			master.setValue((String) result[i++]);
			master.setDataType((String) result[i++]);
			
			listResult.add(master);
		}
		
		return listResult;
	}

}
