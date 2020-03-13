package org.perscholas.login.controller;

import java.util.List;
import java.util.Map;

import org.perscholas.login.model.Login;
import org.perscholas.login.model.Profile;
import org.perscholas.login.model.Recipe;
import org.perscholas.login.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class RecipeController {
	
	@Autowired
	private RecipeService service;
	
	
	
	@RequestMapping("/recipe_list")
	public ModelAndView viewRecipeListPage() {
		ModelAndView mav = new ModelAndView();
		List<Recipe> recipeList = service.listAll();
		mav.addObject("recipeList", recipeList);
		return mav;
	}
	
//	@GetMapping("/recipe_list")
//	public String showImage(Model model, Pageable pageable) {
//		final Page<Recipe> page = service.findpage(pageable);
//		model.addAttribute("page",page);
//		return "recipe_list";
//		
//	}
	
//	@RequestMapping("/recipe/{id}")
//	public ModelAndView viewProfilePage(@PathVariable(name="id") int id) {
//		ModelAndView mav = new ModelAndView("recipe");
//		Recipe recipe = service.get(id);
//		mav.addObject("recipe", recipe);
//		return mav;
//	}
	
	@GetMapping("/recipe/{id}")
	public ModelAndView showRecipeImage(Pageable pageable, @PathVariable(name="id") int id) {
		ModelAndView mav = new ModelAndView("recipe");
		final Page<Recipe> page = service.findpage(pageable);
		Recipe recipe= service.get(id);
		mav.addObject("recipe", recipe);
		mav.addObject("pic", page);
		return mav;
		
	}
	
	@RequestMapping(value="/save_recipe", method=RequestMethod.POST)
	public String saveRegister(@ModelAttribute("recipe") Recipe recipe) {
		service.save(recipe);
		return "redirect:/profile";
	}
	
	@RequestMapping("/edit_recipe/{id}")
	public ModelAndView showEditProfileForm(@PathVariable(name="id") int id) {
		ModelAndView mav = new ModelAndView("edit_recipe");
		Recipe recipe = service.get(id);
		mav.addObject("edit_recipe", recipe);
		return mav;
		
	}
	@RequestMapping("/delete_recipe/{id}")
	public String deleteRecipe(@PathVariable(name="id") int id) {
		service.delete(id);
		return "redirect:/profile";
	}
	
}
