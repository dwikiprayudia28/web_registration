package id.jexpress.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserLoginAuthUtil {

	public static String getRoleAccessLogin() {
		
		Authentication userlogin = SecurityContextHolder.getContext().getAuthentication();
		List<GrantedAuthority> listAuthorities = new ArrayList<GrantedAuthority>();
		listAuthorities.addAll(userlogin.getAuthorities());
		
		return listAuthorities.get(1).getAuthority();
	}
	
	public static String getUserIdLogin() {
		
		Authentication userlogin = SecurityContextHolder.getContext().getAuthentication();
		List<GrantedAuthority> listAuthorities = new ArrayList<GrantedAuthority>();
		listAuthorities.addAll(userlogin.getAuthorities());
		
		String arr[] = listAuthorities.get(0).getAuthority().split(";");
		
		return arr[0];
	}
	
	public static String getNikLogin() {
		
		Authentication userlogin = SecurityContextHolder.getContext().getAuthentication();
		List<GrantedAuthority> listAuthorities = new ArrayList<GrantedAuthority>();
		listAuthorities.addAll(userlogin.getAuthorities());
		
		String arr[] = listAuthorities.get(0).getAuthority().split(";");
		
		return arr[1];
	}
	
	public static String getCompanyLogin() {
		
		Authentication userlogin = SecurityContextHolder.getContext().getAuthentication();
		List<GrantedAuthority> listAuthorities = new ArrayList<GrantedAuthority>();
		listAuthorities.addAll(userlogin.getAuthorities());
		
		String arr[] = listAuthorities.get(0).getAuthority().split(";");
		String res = "";
		if(arr.length>2){
			res = arr[2];
		}
		
		return res;
	}
	

	public static String getUserChildLogin() {
		
		Authentication userlogin = SecurityContextHolder.getContext().getAuthentication();
		List<GrantedAuthority> listAuthorities = new ArrayList<GrantedAuthority>();
		listAuthorities.addAll(userlogin.getAuthorities());
		
		String arr[] = listAuthorities.get(0).getAuthority().split(";");
		String res = "";
		if(arr.length>3){
			res = arr[3];
		}
		
		return res;
	}
	
}
