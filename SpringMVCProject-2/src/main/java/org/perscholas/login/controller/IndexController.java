package org.perscholas.login.controller;

import java.util.List;

import org.perscholas.login.model.Login;
import org.perscholas.login.model.Profile;
import org.perscholas.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@Autowired
	private LoginService service;
	
	@RequestMapping("/")
	public String redirToHome() {
		return"redirect:/home";
	}
	
//	@RequestMapping("/home")
//	public String viewHomePage(Model model) {
//		List<Login> listLogin = service.listAll();
//		model.addAttribute("listlogin", listLogin);
//		return "home";
//	}
	@RequestMapping("/home")
	public String showImage(Model model, Pageable pageable) {
		final Page<Login> page = service.findpage(pageable);
		List<Login> listLogin = service.listAll();
		model.addAttribute("listlogin", listLogin);
		model.addAttribute("page",page);
		return "home";
		
	}
	
}
