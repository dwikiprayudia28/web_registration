package id.jexpress.service.impl;

import id.jexpress.service.UserService;
import id.jexpress.util.PasswordEncoderGenerator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service("userDetailsService")
@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private PasswordEncoderGenerator passwordEncoderGenerator;
	
	@Autowired
	private UserService userService;

	@SuppressWarnings({ "static-access" })
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		String[] passAndName = username.split("\\$\\#");
		
		id.jexpress.model.User user = new id.jexpress.model.User();
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		try {
			user = userService.getUserByUsername(passAndName[1]);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("Login Failed");
		}
		
		String passEncode = passwordEncoderGenerator.getEncodeGenMD5(passAndName[0]);
		if (!passEncode.equals(user.getPassword())){
			throw new UsernameNotFoundException("Invalid username/password");
		} else {
			
		}
		User user2 = new User(user.getName(), user.getPassword(), grantedAuthorities);
		return user2;
		
	}
	
}