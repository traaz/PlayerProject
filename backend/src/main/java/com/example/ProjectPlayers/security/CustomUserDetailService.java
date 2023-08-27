package com.example.ProjectPlayers.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ProjectPlayers.dataAccess.abstracts.UserRepository;
import com.example.ProjectPlayers.entities.User;

import lombok.AllArgsConstructor;

@Service

public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByName(username);
		if (user == null) {
		      throw new UsernameNotFoundException("No user found");
		    }
		return new CustomUserDetail(user);
	}

}
