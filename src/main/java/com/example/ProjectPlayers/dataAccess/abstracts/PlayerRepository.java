package com.example.ProjectPlayers.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjectPlayers.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{

}
