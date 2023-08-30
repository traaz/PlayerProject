package com.example.ProjectPlayers.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ProjectPlayers.business.abstracts.UserService;
import com.example.ProjectPlayers.core.utilities.exceptions.BadCredentialsException;
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
	public ResponseEntity<String>  addUser(User user) {
		User checkUser = repository.findByName(user.getName());
		if(checkUser != null) {
			return new ResponseEntity<String>("Kullanici Mevcut", HttpStatus.BAD_REQUEST);
		}else {
			user.setPassword(encoder.encode(user.getPassword()));
			repository.save(user);
			return new ResponseEntity<String>("Kullanici Eklendi", HttpStatus.OK);

		}
		
	}
	@Override
	public List<User> getAll() {
		return repository.findAll();
	}
	@Override
	public void login(User user) {
		 Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	                user.getName(), user.getPassword()));
	        if(authentication != null) {
	        	SecurityContextHolder.getContext().setAuthentication(authentication);
		      //  return "Giriş Başarılı";
	        }else {
	        	new BadCredentialsException("Giriş Hatalı");
	        }
	}

}
