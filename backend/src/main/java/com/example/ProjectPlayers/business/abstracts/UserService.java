package com.example.ProjectPlayers.business.abstracts;

import java.util.List;

import com.example.ProjectPlayers.entities.User;

public interface UserService {
	String addUser(User user);
	List<User> getAll();
	String login(User user);

}
