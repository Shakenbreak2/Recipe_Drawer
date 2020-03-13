package org.perscholas.login.config;

import org.perscholas.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(new PasswordEncoder() {
				
				@Override
				public String encode(CharSequence rawPassword) {
					String newPassword = bCryptPasswordEncoder.encode(rawPassword);
					return newPassword;
				}

				@Override
				public boolean matches(CharSequence rawPassword, String encodedPassword) {
					if(bCryptPasswordEncoder.matches(rawPassword, encodedPassword)) {
						return true;
					}else
						return false;
				}
				
			});
			
		
	}
	
	public void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers("/edit_user").hasRole("ADMIN")
			.antMatchers("/profile/**").hasAnyRole("ADMIN","USER")
			.antMatchers("/login").permitAll()
			.antMatchers("/").permitAll()
			.anyRequest().permitAll()
			.and()
			
			.csrf().disable()
			.formLogin()
			.loginPage("/login")
			.failureUrl("/login?error=true")
			.defaultSuccessUrl("/profile")
			.usernameParameter("username")
			.passwordParameter("password")
			.and()
			
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/home").and()
			.exceptionHandling()
			.accessDeniedPage("/access-denied");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/resources/**","/static/**","/css/**","/js/**","/images/**");
	}
	
}
