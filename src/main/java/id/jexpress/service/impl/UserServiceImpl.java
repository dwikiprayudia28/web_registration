package id.jexpress.service.impl;

import id.jexpress.dao.UserDao;
import id.jexpress.dto.UserDetail;
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

//	@Override
//	public List<UserList> getListingUser(ParamUserList param) {
//		
//		return userDao.getListingUser(param);
//	}
//
//	@Override
//	public Integer getTotalListingUser(ParamUserList param) {
//		
//		return userDao.getTotalListingUser(param);
//	}

	@Override
	public UserDetail getUserById(Integer userId) {
		
		return userDao.getUserById(userId);
	}

//	@Override
//	public List<User> getOptionUserApprove() {
//		
//		return userDao.getOptionUserApprove();
//	}
//
//	@Override
//	public String resetUser(String userIdStr) {
//		
//		String[] arrUserId = userIdStr.split("&userId=");
//		arrUserId[0] = arrUserId[0].substring(7); 
//		
//		for(String userId : arrUserId){
//			userDao.backupUser(Integer.parseInt(userId));
//			userDao.resetUser(Integer.parseInt(userId));
//		}
//		
//		return "success";
//	}

//	@Override
//	public String deleteUser(String userIdStr) {
//		
//		String[] arrUserId = userIdStr.split("&userId=");
//		arrUserId[0] = arrUserId[0].substring(7); 
//		
//		for(String userId : arrUserId){
//			String checkingResult = userDao.checkBeforeDeleteUser(Integer.parseInt(userId));
//			
//			if(checkingResult.equalsIgnoreCase("clear")){
//				userDao.backupUser(Integer.parseInt(userId));
//				userDao.deleteUser(Integer.parseInt(userId));
//			} else {
//				return checkingResult;
//			}
//			
//		}
//		
//		return "success";
//	}

//	@Override
//	public UserChild getListUserChild(User userManager) {
//		
//		return userDao.getListUserChild(userManager);
//	}
//
//	@Override
//	public String activateUser(String userIdStr) {
//		
//		System.out.println(userIdStr);
//		
//		String[] arrUserId = userIdStr.split("&userId=");
//		arrUserId[0] = arrUserId[0].substring(7); 
//		
//		for(String userId : arrUserId){
//			userDao.backupUser(Integer.parseInt(userId));
//			userDao.activateUser(Integer.parseInt(userId));
//		}
//		
//		return "success";
//	}
//
//	@Override
//	public Boolean checkIsHRUser(String userId) {
//		
//		return userDao.checkIsHRUser(userId);
//	}

}
