package com.example.ProjectPlayers.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ProjectPlayers.business.request.CreatePlayerRequest;
import com.example.ProjectPlayers.business.request.UpdatePlayerRequest;
import com.example.ProjectPlayers.business.response.GetAllPlayerResponse;
import com.example.ProjectPlayers.business.response.GetByIdResponse;
import com.example.ProjectPlayers.business.response.GetPlayersPositionResponse;
import com.example.ProjectPlayers.business.response.GetPlayersTeamAndPositionResponse;
import com.example.ProjectPlayers.business.response.GetPlayersTeamResponse;
import com.example.ProjectPlayers.entities.Player;

public interface PlayerService {
	List<GetAllPlayerResponse> getAll();
	GetByIdResponse getById(int id);
	void add(CreatePlayerRequest createPlayerRequest);
	void update(int id, UpdatePlayerRequest updatePlayerRequest);
	void delete(int id);
//	List<GetPlayersPositionResponse> getPlayersPositionNameResponse(String position);
	List<GetPlayersPositionResponse> getPlayersPositionIdResponse(int id);
//	List<GetPlayersTeamResponse> getPlayersTeamNameResponse(String team);
	List<GetPlayersTeamResponse> getPlayersTeamIdResponse(int id);
	List<GetPlayersTeamAndPositionResponse> getPlayersTeamAndPositionResponse(int id, String position);


}
