package org.perscholas.login.repository;

import java.util.Optional;

import org.perscholas.login.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{
	
	Optional<Login> findByUsername(String username);

}
