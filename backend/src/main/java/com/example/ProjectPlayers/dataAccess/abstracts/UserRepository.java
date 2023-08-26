package com.example.ProjectPlayers.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProjectPlayers.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByName(String name);

}
