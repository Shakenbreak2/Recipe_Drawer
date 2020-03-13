package org.perscholas.login.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.perscholas.login.model.Login;
import org.perscholas.login.model.Profile;
import org.perscholas.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.ModelAndViewResolver;

@Controller
public class LoginController {
	@Autowired
	private LoginService service;
	
	@RequestMapping(value= {"/login"})
	public ModelAndView showLoginPage() {
		ModelAndView mav = new ModelAndView();
		Login login = new Login();
		mav.addObject("login", login);// resource/templates/login.html
		return mav;
	}
	
	@RequestMapping(value= {"/register"})
	public ModelAndView showRegisterPage() {
		ModelAndView mav = new ModelAndView();
		Login login = new Login();
		mav.addObject("register", login);// resource/templates/register.html
		return mav;
	}
	
	@RequestMapping(value={"/verify"}, method=RequestMethod.POST)
	public String verifyLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
		System.out.println("Inside verifyLogin");
		
		UserDetails details = service.loadUserByUsername(username);
		
		
			if(service.verify(details.getPassword(), password)) {
				System.out.println("login pass");
				return "/profile";
			}else {
				System.out.println("login failed");
				return "login";
			}
			
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveRegister(@ModelAttribute("login") Login login) {
		service.regsave(login);
		return "redirect:/profile";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name="id") int id) {
		ModelAndView mav = new ModelAndView("edit_user");
		Login login = service.get(id);
		mav.addObject("edit_user", login);
		return mav;
		
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable(name="id") int id) {
		service.delete(id);
		return "redirect:/home";
	}
	
}
