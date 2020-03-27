package org.perscholas.recipies.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.perscholas.recipies.daos.RecipeRepository;
import org.perscholas.recipies.daos.UserRepository;
import org.perscholas.recipies.model.Category;
import org.perscholas.recipies.model.Recipe;
import org.perscholas.recipies.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

	@Autowired
	UserRepository userRepo;
	@Autowired
	RecipeRepository recipeRepo;
	
	public void addRecipe(Recipe recipe, Integer id) {
		Optional<User> user = userRepo.findById(id);
		User u = null;
		
		if(!user.isPresent()) {
			System.out.println("User not found by: "+id);
		}else {
			u= user.get();
		}
		
		recipe.setUser(u);
		
		recipeRepo.save(recipe);
	}
	
	public List<Recipe> findAll(){
		return recipeRepo.findAll();
		
	}
	
	public List<Recipe> findRecipeByUsername(String username){
		List<Recipe> recipies= recipeRepo.findAllByUsername(username);
		return recipies;
	}
	
	public Recipe get(Integer id) {
		return recipeRepo.getOne(id);		
	}

	public void save(Recipe recipe) {
		recipeRepo.save(recipe);
		
	}

	public void delete(int id) {
		recipeRepo.deleteById(id);
	}

	public Optional<Recipe> getPhotoById(int id) {
		
		return recipeRepo.getPhotoById(id);
	}
}
