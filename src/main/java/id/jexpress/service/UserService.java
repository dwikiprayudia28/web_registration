package id.jexpress.service;

import id.jexpress.dto.UserDetail;
import id.jexpress.model.User;

public interface UserService {

	User getUserByUsername(String username);

	String insertUser(User user);

	String editUser(User user);

//	List<UserList> getListingUser(ParamUserList param);
//
//	Integer getTotalListingUser(ParamUserList param);

	UserDetail getUserById(Integer userId);

//	List<User> getOptionUserApprove();
//
//	String resetUser(String userIdStr);
//
//	String deleteUser(String userIdStr);
//	
//	UserChild getListUserChild(User userManager);
//
//	String activateUser(String userIdStr);
//
//	Boolean checkIsHRUser(String userId);

}
