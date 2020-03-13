package org.perscholas.login.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.perscholas.login.model.Login;
import org.perscholas.login.model.MyUserDetails;
import org.perscholas.login.model.Profile;
import org.perscholas.login.model.Roles;
import org.perscholas.login.repository.LoginRepository;
import org.perscholas.login.repository.ProfileRepository;
import org.perscholas.login.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService{

	@Autowired
	private LoginRepository repo;
	@Autowired
	private RolesRepository rolesR;
	@Autowired
	private ProfileRepository pR;
	
	
	@Autowired
	private BCryptPasswordEncoder encode;
	
	public List<Login> listAll(){
		return repo.findAll();
	}
	
	public void regsave(Login login){
		//encode password into hash password
		String pwd = login.getPassword();
		String encryptPwd = encode.encode(pwd);
		login.setPassword(encryptPwd);
		
		//get permissions and assign
		List<Roles> role = new ArrayList<Roles>();
		Roles r= rolesR.getOne(1);
		role.add(r);
		login.setRoles(role);
		
		//create new profile to match user login
		Profile p= new Profile();
		p.setLogin(login);
		//save profile
		pR.save(p);
		//save new user
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

	public boolean verify(String details, String password) {
		String s =details;
		if(encode.matches(password, s)){
			System.out.println("passwords match");
			return true;
		}else {
			System.out.println("password don't match");
			return false;
		}
	}
}
