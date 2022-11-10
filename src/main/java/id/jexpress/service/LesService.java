package id.jexpress.service;

import java.util.List;

import id.jexpress.model.Les;

public interface LesService {
	
	String insertLes (Les les);
	
	List<Les> getListLesByCreatedUser(String createdBy);

	Les getLesById(Integer id);

	void updateLes(Les les);

	void updatePaidLes(Les les);

}
