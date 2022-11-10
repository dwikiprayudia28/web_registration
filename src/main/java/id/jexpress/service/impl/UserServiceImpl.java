package id.jexpress.service.impl;

import id.jexpress.dao.UserDao;
import id.jexpress.model.User;
import id.jexpress.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Value("${api.url}")
	private String API_URL;
	
	@Autowired UserDao userDao;
	
	@Override
	@Transactional(readOnly = true)
	public User getUserByUsername(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public String insertUser(User user) {
		
		String msg = "";
	    try {
	    	msg = userDao.insertUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			msg = "Error;"+e.getMessage();
		}
	    
		return msg;
	}

	@Override
	public String editUser(User user) {
		
		return userDao.editUser(user);
	}


}
