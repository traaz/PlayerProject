package com.example.ProjectPlayers.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Override
	public String addUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		repository.save(user);
		return "User Add";
	}

}
