package id.jexpress.auth;

import id.jexpress.service.impl.CustomUserDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		
		String userName = authentication.getName();
		String password = (String) authentication.getCredentials();
		UserDetails user = customUserDetailService.loadUserByUsername(password + "$#" + userName);
		
		Authentication auth = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
		
		return auth;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}
