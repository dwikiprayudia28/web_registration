package id.jexpress.dao;

import id.jexpress.model.Les;

import java.util.List;

public interface LesDao {
	
String insertLes (Les les);
	
	List<Les> getListLesByCreatedUser(String createdBy);

	Les getLesById(Integer id);

	void updateLes(Les les);

	void updatePaidLes(Les les);

}
