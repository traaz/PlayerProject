package com.example.ProjectPlayers.business.rules;

import org.springframework.stereotype.Service;

import com.example.ProjectPlayers.dataAccess.abstracts.TeamRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeamBusinessRules {
	private TeamRepository repository;
	public void checkIfTeamNameExists(String name) {
		if(this.repository.existsByName(name)) {
			throw new RuntimeException("Team already exists");
		}
	}

}
