package org.perscholas.recipies.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.perscholas.recipies.daos.ProfileRepository;
import org.perscholas.recipies.daos.RoleRepository;
import org.perscholas.recipies.daos.UserRepository;
import org.perscholas.recipies.model.Profile;
import org.perscholas.recipies.model.Role;
import org.perscholas.recipies.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repo;
	@Autowired
    private BCryptPasswordEncoder encode;
    @Autowired
    private RoleRepository roleRepo;
    @Autowired
    private ProfileRepository profileRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repo.findByUsername(username);

		user.orElseThrow(() -> new UsernameNotFoundException("User Found: "+username));

		return user.get();
    }
    
    public User getOne(Integer id) {
    	return repo.getOne(id);
    }

    public void addUser(User user) {
		//encode password into hash password
		String pwd = user.getPassword();
		String encryptPwd = encode.encode(pwd);
		user.setPassword(encryptPwd);

		//get permissions and assign
        List<Role> roles = new ArrayList<>();
        Role role;
        Optional<Role> r = roleRepo.findByName("USER");
        if (!r.isPresent()) {
            Role x = new Role();
            x.setName("ROLE_USER");
            role = roleRepo.save(x);
        } else {
            role = r.get();
        }
		roles.add(role);
		user.setRoles(roles);
		
		//save new user
		repo.save(user);
        // create new profile to match user user
		Profile p= new Profile();
		p.setUser(user);
		//save profile
		profileRepo.save(p);
		
    }

}
