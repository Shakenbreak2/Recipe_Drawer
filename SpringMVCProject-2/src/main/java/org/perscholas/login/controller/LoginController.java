package org.perscholas.login.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.perscholas.login.model.Login;
import org.perscholas.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.ModelAndViewResolver;

@Controller
public class LoginController {
	@Autowired
	private LoginService service;
	
	@RequestMapping("/login")
	public String showLoginPage(Model model) {
		Login login = new Login();
		model.addAttribute("login", login);
		return "login";
	}
	@RequestMapping("/register")
	public String showRegisterForm(Model model) {
		Login login = new Login();
		model.addAttribute("login", login);
		return "register";
	}
	@GetMapping("/verify")
	public String verifyLoginForm() {
		
		return "redirect:profile";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveRegister(@ModelAttribute("login") Login login) {
		service.save(login);
		return "redirect:/home";
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
