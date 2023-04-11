package com.nay.springboot.restcruddemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	@Bean
	public UserDetailsManager userDetailManager(DataSource dataSource) {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

		jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id,pw,active from members where user_id=?");

		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id=?");

		return jdbcUserDetailsManager;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(configurer -> configurer.requestMatchers("/").authenticated()
				.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET, "/capi/customers").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET, "/capi/customers/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/capi/customers").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/capi/customers").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/capi/customers/**").hasRole("ADMIN")
				);
				/*.formLogin(form -> 
				form
						.successHandler(customAuthenticationSuccessHandler)
						.permitAll()*/
		http.httpBasic();
		http.csrf().disable();

		return http.build();

	}

	/*
	 * @Bean public InMemoryUserDetailsManager userDetailManager() { UserDetails
	 * john=User.builder().username("John").password("{noop}test123").roles(
	 * "EMPLOYEE").build();
	 * 
	 * UserDetails
	 * mary=User.builder().username("mary").password("{noop}test123").roles(
	 * "EMPLOYEE","MANAGER").build();
	 * 
	 * UserDetails
	 * susan=User.builder().username("susan").password("{noop}test123").roles(
	 * "EMPLOYEE","MANAGER","ADMIN").build();
	 * 
	 * return new InMemoryUserDetailsManager(john,mary,susan);
	 * 
	 * }
	 */

}
