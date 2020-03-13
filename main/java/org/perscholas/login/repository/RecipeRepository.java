package org.perscholas.login.repository;

import org.perscholas.login.model.Profile;
import org.perscholas.login.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer>{

}
