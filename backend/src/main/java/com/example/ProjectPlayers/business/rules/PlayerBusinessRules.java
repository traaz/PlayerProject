package com.example.ProjectPlayers.business.rules;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.ProjectPlayers.core.utilities.exceptions.BusinessException;
import com.example.ProjectPlayers.dataAccess.abstracts.PlayerRepository;
import com.example.ProjectPlayers.dataAccess.abstracts.TeamRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PlayerBusinessRules {
	private PlayerRepository repository;

	
	public void checkIfPositionIdExists(int id) {
		if(!this.repository.existsByPositionId(id)) {
			
			throw new DataIntegrityViolationException("There is no position. Please check position area.");
		}
	}
	public void checkIfPlayerExists(String name, String surname, int id) {
		if(this.repository.existsByNameAndSurnameAndTeamId(name, surname, id)) {
			throw new BusinessException("Player already exists");
		}
	}
	
	


}
