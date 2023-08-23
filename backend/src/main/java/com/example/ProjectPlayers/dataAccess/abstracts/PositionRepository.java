package com.example.ProjectPlayers.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.ProjectPlayers.entities.Position;


public interface PositionRepository  extends JpaRepository<Position, Integer>{

}
