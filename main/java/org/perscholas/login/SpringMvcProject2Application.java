package org.perscholas.login;

import org.perscholas.login.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses= {CategoryRepository.class, LoginRepository.class, ProfileRepository.class, RecipeRepository.class})
public class SpringMvcProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcProject2Application.class, args);
	}

}
