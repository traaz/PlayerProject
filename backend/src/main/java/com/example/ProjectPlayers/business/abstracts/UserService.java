package com.example.ProjectPlayers.business.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.ProjectPlayers.entities.User;

public interface UserService {
	ResponseEntity<String>  addUser(User user);
	List<User> getAll();
	void login(User user);

}
