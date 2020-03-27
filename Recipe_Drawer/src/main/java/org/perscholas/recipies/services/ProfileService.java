package org.perscholas.recipies.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Blob;
import java.util.Optional;

import org.perscholas.recipies.daos.ProfileRepository;
import org.perscholas.recipies.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class ProfileService {
    @Autowired
    ProfileRepository repository;
    
    public JdbcTemplate jdbcTemp;
    
    public Optional<Profile> getPhotoById(int id) {
//    	String query="select photo from profile where id=?";
//    	Blob photo = jdbcTemp.queryForObject(query, new Object[] {id},Blob.class);
    	//Blob photo = repository.getPhotoById(id);
    	return repository.getPhotoById(id);
    }

    public Profile save(Profile profile) {
        return repository.save(profile);
    }

    public Profile get(Integer id) {
        return repository.getOne(id);
    }

    public Optional<Profile> findByUsername(String username) {
        return repository.findByUsername(username);
    }
    
 
}