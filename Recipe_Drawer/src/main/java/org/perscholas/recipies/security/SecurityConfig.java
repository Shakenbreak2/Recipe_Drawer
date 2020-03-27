package org.perscholas.recipies.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
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
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private DataSource dataSource;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .authenticationProvider(daoAuthenticationProvider())
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select id, email, enabled, password from user where username = ?")
                .authoritiesByUsernameQuery("select u.username, r.name from user_roles ur inner join user u on ur.user_id = u.id inner join roles r on ur.roles = r.id where u.username = ?");
    }

	public void configure(final HttpSecurity http) throws Exception{
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
            .loginProcessingUrl("/login/authenticate")
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
	public void configure(final WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/resources/**","/static/**","/css/**","/js/**","/images/**");
	}

}