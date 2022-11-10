package id.jexpress.dao;

import id.jexpress.model.User;

public interface UserDao {

	User findByUserName(String username);

	String insertUser(User user);

	String editUser(User user);

}
