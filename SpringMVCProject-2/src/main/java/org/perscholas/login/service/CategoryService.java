package org.perscholas.login.service;

import java.util.List;

import org.perscholas.login.model.Category;
import org.perscholas.login.model.Profile;
import org.perscholas.login.model.Recipe;
import org.perscholas.login.repository.CategoryRepository;
import org.perscholas.login.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repo;
	
	public List<Category> listAll(){
		return repo.findAll();
	}
	
	public void save(Category category) {
		repo.save(category);
	}
	public Category get(int id) {
		return repo.getOne(id);
		
	}
	public void delete(int id) {
		repo.deleteById(id);
	}

}
