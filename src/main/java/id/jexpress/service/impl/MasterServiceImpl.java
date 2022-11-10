package id.jexpress.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import id.jexpress.dao.MasterDao;
import id.jexpress.model.Master;
import id.jexpress.service.MasterService;

@Service
@Transactional
public class MasterServiceImpl implements MasterService {
	
	@Autowired
	private MasterDao masterDao;

	@Override
	public List<Master> getListMasterByType(String type) {
		return masterDao.getListMasterByType(type);
	}

}
