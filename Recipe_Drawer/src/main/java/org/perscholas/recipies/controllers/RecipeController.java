package org.perscholas.recipies.controllers;

import java.sql.Blob;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;

import org.perscholas.recipies.model.Category;
import org.perscholas.recipies.model.Profile;
import org.perscholas.recipies.model.Recipe;
import org.perscholas.recipies.model.User;
import org.perscholas.recipies.services.CategoryService;
import org.perscholas.recipies.services.RecipeService;
import org.perscholas.recipies.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RecipeController {

	@Autowired
	RecipeService service;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CategoryService catService;
	
	@GetMapping("/new_recipe/{id}")
    public String showAddRecipe(Model model, @PathVariable Integer id) {
        Recipe recipe = new Recipe();
        User user = userService.getOne(id);
        List<Category> categories = catService.findAll();
        model.addAttribute("recipe", recipe);
        model.addAttribute("user", user);
        model.addAttribute("categories",categories);
        return "new_recipe";
    }

    @PostMapping("/new_recipe/")
    public String addRecipe(@ModelAttribute Recipe recipe, @ModelAttribute User user) {
        service.addRecipe(recipe, user.getId());
        return "redirect:/profile";
    }
    
    @RequestMapping("/recipe_list")
    public String showRecipeList(Model model) {
    	List<Recipe> recipies = service.findAll();
    	List<Category> categories = catService.findAll();
    	model.addAttribute("recipies", recipies);
    	model.addAttribute("categories", categories);
        return "recipe_list";
    }
    
   
    @GetMapping("/recipe/{id}")
    public String recipe(Model model, @PathVariable Integer id) {
    	Recipe recipies = service.get(id);
    	model.addAttribute("recipe", recipies);
        return "recipe";
    }
    
    @GetMapping("/edit_recipe/{id}")
	public ModelAndView showEditProfileForm(@PathVariable(name="id") int id) {
		ModelAndView mav = new ModelAndView("edit_recipe");
		Recipe recipe = service.get(id);
		mav.addObject("edit_recipe", recipe);
		return mav;
		
	}
    
    @PostMapping("/save_recipe")
    public String saveRecipe(@ModelAttribute Recipe recipe) {
    	service.save(recipe);
    	return "redirect:/profile";
    }
	@RequestMapping("/delete_recipe/{id}")
	public String deleteRecipe(@PathVariable(name="id") int id) {
		service.delete(id);
		return "redirect:/profile";
	}
	
	@GetMapping("/getRecipePhoto/{id}")
    public void getUserPhoto(HttpServletResponse response, @PathVariable("id") int id) throws Exception {
    	response.setContentType("image/jpeg, image/jpg, image/png");
    	
    	Optional<Recipe> ph = service.getPhotoById(id);
    	byte[] image = ph.get().getPicture();
    	Blob p = new SerialBlob(image);
    	StreamUtils.copy(p.getBinaryStream(), response.getOutputStream());
//    	byte[] bytes = ph.getBytes(1, (int) ph.length());
//    	InputStream inputStream = new ByteArrayInputStream(bytes);
//    	IOUtils.copy(inputStream, response.getOutputStream());
    }
}
