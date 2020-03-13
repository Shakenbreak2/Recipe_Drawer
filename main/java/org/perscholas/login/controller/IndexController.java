package org.perscholas.login.controller;

import java.util.List;

import org.perscholas.login.model.Login;
import org.perscholas.login.model.Profile;
import org.perscholas.login.model.Recipe;
import org.perscholas.login.service.LoginService;
import org.perscholas.login.service.RecipeService;
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
	@Autowired
	private RecipeService Rservice;
	
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
		final Page<Recipe> page = Rservice.findpage(pageable);
		List<Recipe> recipelist = Rservice.listAll();
		model.addAttribute("recipelist", recipelist);
		model.addAttribute("page",page);
		return "home";
		
	}
	
}
