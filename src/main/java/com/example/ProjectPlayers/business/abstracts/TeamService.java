package com.example.ProjectPlayers.business.abstracts;

import java.util.List;

import com.example.ProjectPlayers.business.request.CreateTeamRequest;
import com.example.ProjectPlayers.business.request.UpdatePlayerRequest;
import com.example.ProjectPlayers.business.request.UpdateTeamRequest;
import com.example.ProjectPlayers.business.response.GetAllTeamResponse;
import com.example.ProjectPlayers.business.response.GetByIdTeamResponse;

public interface TeamService {
	List<GetAllTeamResponse> getAll();
	GetByIdTeamResponse getByIdTeam(int id);
	void add(CreateTeamRequest createTeamRequest);
	void delete(int id);
    void update(int id, UpdateTeamRequest updateTeamRequest);

}
