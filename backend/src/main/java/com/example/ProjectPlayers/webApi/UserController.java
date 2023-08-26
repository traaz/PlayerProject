package com.example.ProjectPlayers.webApi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjectPlayers.business.abstracts.UserService;
import com.example.ProjectPlayers.entities.User;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/add")
	public String add(@RequestBody  User user) {
		return userService.addUser(user);
	}
	
}
