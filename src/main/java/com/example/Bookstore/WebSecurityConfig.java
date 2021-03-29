package com.example.Bookstore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests()
//				.antMatchers("/", "/home").permitAll()
//				.anyRequest().authenticated()
//				.and()
//			.formLogin()
//				.loginPage("/login")
//				.permitAll()
//				.and()
//			.logout()
//				.permitAll();
//	}
//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//	UserDetails user = User.withDefaultPasswordEncoder()
//	.username("user")
//	.password("password")
//	.roles("USER")
//	.build();
//	List<UserDetails> users = new ArrayList();
//	users.add(user);
//	return new InMemoryUserDetailsManager(users);
//	}
//}
@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
	    return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
	    auth.inMemoryAuthentication()
	        .withUser("user1")
	        .password("password1")
	        .roles("ADMIN")
	        .and()
	        .withUser("user2")
	        .password("password1")
	        .roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
	    http.authorizeRequests()
	        .antMatchers("/user").hasAnyRole("ADMIN", "USER")
	        .antMatchers("/admin").hasRole("ADMIN")
	        .antMatchers("/").permitAll()
	        .and()
	        .formLogin()
	        .defaultSuccessUrl("/booklist", true)
	        .permitAll()
	        .and()
	        .logout()
	        .permitAll();
	        
	}

}