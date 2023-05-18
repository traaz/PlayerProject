package com.example.ProjectPlayers.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ProjectPlayers.business.request.CreatePlayerRequest;
import com.example.ProjectPlayers.business.request.UpdatePlayerRequest;
import com.example.ProjectPlayers.business.response.GetAllPlayerResponse;
import com.example.ProjectPlayers.business.response.GetByIdResponse;
import com.example.ProjectPlayers.entities.Player;

public interface PlayerService {
	List<GetAllPlayerResponse> getAll();
	GetByIdResponse getById(int id);
	void add(CreatePlayerRequest createPlayerRequest);
	void update(int id, UpdatePlayerRequest updatePlayerRequest);
	void delete(int id);
}
