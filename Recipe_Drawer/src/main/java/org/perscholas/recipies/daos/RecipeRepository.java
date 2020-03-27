package org.perscholas.recipies.daos;

import java.util.List;
import java.util.Optional;

import org.perscholas.recipies.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer>{
	@Query("select r from Recipe r where r.user.username = ?1")
	List<Recipe> findAllByUsername(String username);

	Optional<Recipe> getPhotoById(int id);
	
}
