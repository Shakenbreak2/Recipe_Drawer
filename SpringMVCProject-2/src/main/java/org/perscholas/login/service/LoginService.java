package org.perscholas.login.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.perscholas.login.model.Login;
import org.perscholas.login.model.MyUserDetails;
import org.perscholas.login.model.Profile;
import org.perscholas.login.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService{

	@Autowired
	private LoginRepository repo;
	
	public List<Login> listAll(){
		return repo.findAll();
	}
	
	public void save(Login login) {
		repo.save(login);
	}
	public Login get(int id) {
		return repo.getOne(id);
		
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
	public Page<Login> findpage(Pageable pageable){
		return repo.findAll(pageable);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Login> user = repo.findByUsername(username);
		
		user.orElseThrow(() -> new UsernameNotFoundException("User Found: "+username));
		
		return user.map(MyUserDetails::new).get();
		
	}
}
