package id.jexpress.dao;

import id.jexpress.dto.UserDetail;
import id.jexpress.model.User;

public interface UserDao {

	User findByUserName(String username);

	String insertUser(User user);

	String editUser(User user);

//	List<UserList> getListingUser(ParamUserList param);

//	Integer getTotalListingUser(ParamUserList param);

	UserDetail getUserById(Integer userId);
//
//	List<User> getOptionUserApprove();
//
//	Integer resetUser(Integer userId);
//
//	Integer deleteUser(Integer userId);
//
//	UserChild getListUserChild(User userManager);
//
//	Integer activateUser(Integer userId);
//
//	Boolean checkIsHRUser(String userId);
//
//	Integer backupUser(Integer userId);
//
//	String checkBeforeDeleteUser(Integer userId);

}
