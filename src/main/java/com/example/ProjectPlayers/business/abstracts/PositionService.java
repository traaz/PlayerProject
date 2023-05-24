package com.example.ProjectPlayers.business.abstracts;
import java.util.List;

import com.example.ProjectPlayers.business.response.GetAllPositionResponse;
import com.example.ProjectPlayers.business.response.GetByIdPositionResponse;


public interface PositionService {
	List<GetAllPositionResponse> getAll();
	GetByIdPositionResponse getByIdResponse(int id);
	
}
