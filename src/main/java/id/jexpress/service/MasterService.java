package id.jexpress.service;

import id.jexpress.model.Master;

import java.util.List;

public interface MasterService {
	
	List<Master> getListMasterByType(String type);

}
