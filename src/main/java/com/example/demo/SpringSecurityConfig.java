package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.model.service.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JpaUserDetailsService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "/images/**", "/listar").permitAll()
				/*
				 * .antMatchers("/ver/**").hasAnyRole("USER")
				 * .antMatchers("/uploads/**").hasAnyRole("USER")
				 * .antMatchers("/form/**").hasAnyRole("ADMIN")
				 * .antMatchers("/eliminar/**").hasAnyRole("ADMIN")
				 * .antMatchers("/factura/**").hasAnyRole("ADMIN")
				 */
				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
				.logout()
				.permitAll()
				.and()
				.exceptionHandling()
				.accessDeniedPage("/error_403");

	}

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {

		build.jdbcAuthentication().passwordEncoder(passwordEncoder);
	}
}
