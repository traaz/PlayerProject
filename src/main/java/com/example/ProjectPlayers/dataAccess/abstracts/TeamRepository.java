package com.example.ProjectPlayers.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjectPlayers.entities.Team;

public interface TeamRepository extends JpaRepository<Team, Integer>{

}
