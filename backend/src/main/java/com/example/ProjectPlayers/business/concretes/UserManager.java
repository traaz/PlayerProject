package com.example.ProjectPlayers.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ProjectPlayers.business.abstracts.UserService;
import com.example.ProjectPlayers.dataAccess.abstracts.UserRepository;
import com.example.ProjectPlayers.entities.User;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UserManager implements UserService{
	@Autowired
	private UserRepository repository;
	@Autowired
    private PasswordEncoder encoder;
	@Autowired
    private AuthenticationManager authenticationManager;
	@Override
	public String addUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		repository.save(user);
		return "User Add";
	}
	@Override
	public List<User> getAll() {
		return repository.findAll();
	}
	@Override
	public String login(User user) {
		 Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	                user.getName(), user.getPassword()));
	        if(authentication != null) {
	        	SecurityContextHolder.getContext().setAuthentication(authentication);
		        return "User Log-in";
	        }else {
	        	return "User Not Found";
	        }
	}

}
