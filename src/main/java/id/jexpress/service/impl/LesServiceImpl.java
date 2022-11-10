package id.jexpress.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import id.jexpress.dao.LesDao;
import id.jexpress.model.Les;
import id.jexpress.service.LesService;

@Service
@Transactional
public class LesServiceImpl implements LesService {
	
	@Autowired
	private LesDao lesDao;

	@Override
	public String insertLes(Les les) {
		return lesDao.insertLes(les);
	}

	@Override
	public List<Les> getListLesByCreatedUser(String createdBy) {
		return lesDao.getListLesByCreatedUser(createdBy);
	}

	@Override
	public Les getLesById(Integer id) {
		return lesDao.getLesById(id);
	}

	@Override
	public void updateLes(Les les) {
		lesDao.updateLes(les);
	}

	@Override
	public void updatePaidLes(Les les) {
		lesDao.updatePaidLes(les);
	}

}
