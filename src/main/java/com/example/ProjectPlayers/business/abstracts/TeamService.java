package com.example.ProjectPlayers.business.abstracts;

import java.util.List;

import com.example.ProjectPlayers.business.response.GetAllTeamResponse;
import com.example.ProjectPlayers.business.response.GetByIdTeamResponse;

public interface TeamService {
	List<GetAllTeamResponse> getAll();
	GetByIdTeamResponse getByIdTeam(int id);

}
