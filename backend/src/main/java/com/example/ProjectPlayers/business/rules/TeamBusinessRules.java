package com.example.ProjectPlayers.business.rules;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.ProjectPlayers.core.utilities.exceptions.BusinessException;
import com.example.ProjectPlayers.dataAccess.abstracts.TeamRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeamBusinessRules {
	private TeamRepository repository;
	public void checkIfTeamNameExists(String name) {
		if(this.repository.existsByName(name)) {
			throw new BusinessException("Team already exists");
		}
	}
	public void checkIfTeamIdExists(int id) {
		if(!this.repository.existsById(id)) {
			
			throw new DataIntegrityViolationException("There is no team. Please check team area.");
		}
	}

}
