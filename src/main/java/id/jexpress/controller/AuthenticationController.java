package id.jexpress.controller;

import id.jexpress.model.User;
import id.jexpress.service.UserService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public void login() {

	}

	@RequestMapping(value = "/registrasi", method = RequestMethod.GET)
	public ModelAndView init(@ModelAttribute User user) {
		System.out.println("registrasi new");
		Map<String, Object> model = new HashMap<String, Object>();
		
		return new ModelAndView("userRegistration", model);
	}

	@RequestMapping(value = "/registrasi", method = RequestMethod.POST)
	public ModelAndView registrasi(@ModelAttribute User user,
			BindingResult errors) {
		System.out.println("submit registrasi");
		try {
			userService.insertUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/login");
	}

	@RequestMapping(value = "/forget", method = RequestMethod.GET)
	public ModelAndView initForget(@ModelAttribute User user) {
		System.out.println("forget");
		return new ModelAndView("forgetPassword");
	}
	
	@RequestMapping(value = "/forget", method = RequestMethod.POST)
	public ModelAndView submitForget(@ModelAttribute User user,
			BindingResult errors) {
		System.out.println("submit forget");
		
		return new ModelAndView("redirect:/login");
	}

}
