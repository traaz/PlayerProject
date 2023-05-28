package com.example.ProjectPlayers.business.rules;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.ProjectPlayers.dataAccess.abstracts.PlayerRepository;
import com.example.ProjectPlayers.dataAccess.abstracts.TeamRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PlayerBusinessRules {
	private PlayerRepository repository;
	public void checkIfTeamIdExists(int id) {
		if(!this.repository.existsByTeamId(id)) {
			
			throw new DataIntegrityViolationException("There is no team. Please check team area.");
		}
	}
	
	public void checkIfPositionIdExists(int id) {
		if(!this.repository.existsByPositionId(id)) {
			
			throw new DataIntegrityViolationException("There is no position. Please check position area.");
		}
	}
	
	


}
