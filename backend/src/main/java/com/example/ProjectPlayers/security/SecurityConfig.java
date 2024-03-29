package com.example.ProjectPlayers.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity

public class SecurityConfig {
	
	@Autowired
	private JwtFilter jwtFilter;
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		return http.csrf().disable()
				 .authorizeHttpRequests()
	               .antMatchers("/user/**")
	               .permitAll()
	               .antMatchers("/players/**")
	               .authenticated()
	               .antMatchers("/teams/**")
	               .permitAll()
	               .antMatchers("/positons/**")
	               .permitAll()
	               .and()
	               .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
			//.antMatchers("/teams/**").permitAll()
			//.antMatchers("/players/**").permitAll()
		//	.and().formLogin()
			.build();
		
	}
	@Bean
	public UserDetailsService userDetailService() {
		return new CustomUserDetailService();
	}
	
    @Bean
    public PasswordEncoder encoder() {
    	return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserDetailsService userDetailService) {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailService); 
        auth.setPasswordEncoder(encoder()); 
        return auth;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}
