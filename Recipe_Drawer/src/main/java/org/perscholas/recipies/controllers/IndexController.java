package org.perscholas.recipies.controllers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.perscholas.recipies.model.Recipe;
import org.perscholas.recipies.services.ProfileService;
import org.perscholas.recipies.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@Autowired
	RecipeService service;
	@Autowired
	ProfileService profileService;
	
    @RequestMapping("/")
    public String index() {
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String home(Model model) {
    	List<Recipe> recipies = service.findAll();
    	model.addAttribute("recipies", recipies);
        return "home";
    }
    
    @RequestMapping("/FAQ")
    public String FAQ() {
    	return "FAQ";
    }
   
}