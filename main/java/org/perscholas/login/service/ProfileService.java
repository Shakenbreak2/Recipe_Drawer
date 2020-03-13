package org.perscholas.login.service;

import java.util.List;

import org.perscholas.login.model.Profile;
import org.perscholas.login.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {


	@Autowired
	private ProfileRepository repo;
	
	public List<Profile> listAll(){
		return repo.findAll();
	}
	
	public void save(Profile profile) {
		repo.save(profile);
	}
	public Profile get(int id) {
		return repo.getOne(id);
		
	}
	public void delete(int id) {
		repo.deleteById(id);
	}

	public Page<Profile> findpage(Pageable pageable){
		return repo.findAll(pageable);
	}
	
}
