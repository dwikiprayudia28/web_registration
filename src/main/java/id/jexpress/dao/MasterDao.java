package id.jexpress.dao;

import id.jexpress.model.Master;

import java.util.List;

public interface MasterDao {
	
	List<Master> getListMasterByType(String type);

}
