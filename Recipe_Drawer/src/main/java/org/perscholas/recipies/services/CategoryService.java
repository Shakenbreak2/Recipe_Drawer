package org.perscholas.recipies.services;

import java.util.List;

import org.perscholas.recipies.daos.CategoryRepository;
import org.perscholas.recipies.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository catRepo;
	
	public List<Category> findAll(){
		return catRepo.findAll();
	}
}
