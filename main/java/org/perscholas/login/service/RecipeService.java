package org.perscholas.login.service;

import java.util.List;

import org.perscholas.login.model.Profile;
import org.perscholas.login.model.Recipe;
import org.perscholas.login.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
	
	@Autowired
	private RecipeRepository repo;
	
	public List<Recipe> listAll(){
		return repo.findAll();
	}
	
	public void save(Recipe recipe) {
		repo.save(recipe);
	}
	public Recipe get(int id) {
		return repo.getOne(id);
		
	}
	public void delete(int id) {
		repo.deleteById(id);
	}

	public Page<Recipe> findpage(Pageable pageable){
		return repo.findAll(pageable);
	}
}
