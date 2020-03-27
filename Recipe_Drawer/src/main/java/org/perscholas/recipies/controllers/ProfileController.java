package org.perscholas.recipies.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.perscholas.recipies.model.Profile;
import org.perscholas.recipies.model.Recipe;
import org.perscholas.recipies.model.User;
import org.perscholas.recipies.services.ProfileService;
import org.perscholas.recipies.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {
    @Autowired
    ProfileService service;
    @Autowired
    RecipeService recipeService;

    @GetMapping("/profile")
    public String getProfile(@AuthenticationPrincipal User user, Model model) throws IOException {
        Optional<Profile> profile = service.findByUsername(user.getUsername());
        
        if (profile.isPresent()) {
            user.setProfile(profile.get());
            
            List<Recipe> recipies = recipeService.findRecipeByUsername(user.getUsername());
            System.out.println("Found profile: " + user);
            model.addAttribute("recipies", recipies);
            model.addAttribute("user", user);
        } else {
            System.out.println("Empty profile");
            user.setProfile(new Profile());
            model.addAttribute("user",user);
        }
        return "profile";
    }
    
    @GetMapping("/getStudentPhoto/{id}")
    public void getUserPhoto(HttpServletResponse response, @PathVariable("id") int id) throws Exception {
    	response.setContentType("image/jpeg, image/jpg, image/png");
    	
    	Optional<Profile> ph = service.getPhotoById(id);
    	byte[] image = ph.get().getPicture();
    	Blob p = new SerialBlob(image);
    	StreamUtils.copy(p.getBinaryStream(), response.getOutputStream());
//    	byte[] bytes = ph.getBytes(1, (int) ph.length());
//    	InputStream inputStream = new ByteArrayInputStream(bytes);
//    	IOUtils.copy(inputStream, response.getOutputStream());
    }
    
    @GetMapping("/edit_profile/{id}")
   	public ModelAndView showEditProfileForm(@PathVariable(name="id") int id) {
   		ModelAndView mav = new ModelAndView("edit_profile");
   		Profile profile = service.get(id);
   		mav.addObject("edit_profile", profile);
   		return mav;
   		
   	}
       
	@PostMapping("/save_profile")
	public String saveRecipe(@ModelAttribute Profile profile, @ModelAttribute User user) {
		profile.setUser(user);
		
		service.save(profile);
		return "redirect:/profile";
	}
}