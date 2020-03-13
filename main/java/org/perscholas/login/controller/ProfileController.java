package org.perscholas.login.controller;

import org.perscholas.login.model.Login;
import org.perscholas.login.model.Profile;
import org.perscholas.login.service.LoginService;
import org.perscholas.login.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

	@Autowired
	private ProfileService service;
	
	@RequestMapping("/profile{id}")
	public ModelAndView viewProfilePage(@PathVariable(name="id") int id) {
		ModelAndView mav = new ModelAndView("profile");
		Profile profile = service.get(id);
		mav.addObject("profile", profile);
		return mav;
	}
	@RequestMapping("/profile")
	public String showImage(Model model, Pageable pageable) {
		final Page<Profile> page = service.findpage(pageable);
		model.addAttribute("page",page);
		return "profile";
		
	}
	@RequestMapping(value="/save_profile", method=RequestMethod.POST)
	public String saveRegister(@ModelAttribute("login") Profile profile) {
		service.save(profile);
		return "redirect:/profile";
	}
	@RequestMapping("/edit_profile/{id}")
	public ModelAndView showEditProfileForm(@PathVariable(name="id") int id) {
		ModelAndView mav = new ModelAndView("edit_profile");
		Profile profile = service.get(id);
		mav.addObject("edit_profile", profile);
		return mav;
		
	}
	
}
