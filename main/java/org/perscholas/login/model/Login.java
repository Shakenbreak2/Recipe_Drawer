package org.perscholas.login.model;




import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Entity
@Table(name="users")
public class Login{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@NotNull
    @Size(max = 65)
	private String username;
	@NotNull
    @Size(max = 128)
	private String password;
	@NotNull
    @Email
    @Size(max = 100)
    @Column(unique = true)
	private String email;
	
	private boolean active;
	
	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(
			name="user_role",
			joinColumns= {@JoinColumn(name="USER_ID", referencedColumnName="ID")},
			inverseJoinColumns= {@JoinColumn(name="ROLE_ID", referencedColumnName="ID")}
			)
	private List<Roles> roles;
	
    
    @OneToOne(mappedBy="login", cascade=CascadeType.ALL)
    private Profile profile;
	
	public Login() {
		this.active=true;
		// TODO Auto-generated constructor stub
	}

	public Login(int id, @NotNull @Size(max = 65) String username, @NotNull @Size(max = 128) String password,
			@NotNull @Email @Size(max = 100) String email, boolean active,
			Profile profile) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.active = active;
		this.profile = profile;
		this.active=true;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the roles
	 */
	public String getRoles() {
		String role = roles.toString();
		return role;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the profile
	 */
	public Profile getProfile() {
		return profile;
	}

	/**
	 * @param profile the profile to set
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	
	
}
