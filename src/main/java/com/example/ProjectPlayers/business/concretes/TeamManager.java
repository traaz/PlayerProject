package com.example.ProjectPlayers.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ProjectPlayers.business.abstracts.TeamService;
import com.example.ProjectPlayers.business.response.GetAllPositionResponse;
import com.example.ProjectPlayers.business.response.GetAllTeamResponse;
import com.example.ProjectPlayers.business.response.GetByIdTeamResponse;
import com.example.ProjectPlayers.core.utilities.mappers.ModelMapperService;
import com.example.ProjectPlayers.dataAccess.abstracts.TeamRepository;
import com.example.ProjectPlayers.entities.Team;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeamManager implements TeamService{
	private TeamRepository teamRepository;
	private ModelMapperService  mapperService;

	@Override
	public List<GetAllTeamResponse> getAll() {
		List<Team> teams = teamRepository.findAll();
		List<GetAllTeamResponse> responses = teams.stream()
				.map(team->this.mapperService.forResponse()
						.map(team, GetAllTeamResponse.class)).collect(Collectors.toList());
		return responses;
	}

	@Override
	public GetByIdTeamResponse getByIdTeam(int id) {
		Team team = teamRepository.findById(id).get();
		GetByIdTeamResponse response = this.mapperService.forResponse().map(team, GetByIdTeamResponse.class);
		return  response;
	}

}
