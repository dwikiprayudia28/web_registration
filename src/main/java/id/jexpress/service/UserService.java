package id.jexpress.service;

import id.jexpress.model.User;

public interface UserService {

	User getUserByUsername(String username);

	String insertUser(User user);

	String editUser(User user);

}
