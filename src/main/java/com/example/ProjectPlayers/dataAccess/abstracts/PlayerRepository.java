package com.example.ProjectPlayers.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjectPlayers.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{
	List<Player> findByPositionName(String name);
	List<Player> findByPositionId(int id);

}
