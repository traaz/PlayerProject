package com.example.ProjectPlayers.business.concretes;

import java.util.List;
import java.util.stream.Collectors;


import com.example.ProjectPlayers.core.utilities.mappers.ModelMapperService;
import org.springframework.stereotype.Service;

import com.example.ProjectPlayers.business.abstracts.PositionService;
import com.example.ProjectPlayers.business.response.GetAllPositionResponse;
import com.example.ProjectPlayers.business.response.GetByIdPositionResponse;
import com.example.ProjectPlayers.dataAccess.abstracts.PositionRepository;
import com.example.ProjectPlayers.entities.Position;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PositionManager implements PositionService{
	private PositionRepository positionRepository;
	private ModelMapperService mapperService;

	@Override
	public List<GetAllPositionResponse> getAll() {
		List<Position> positions = positionRepository.findAll();
		List<GetAllPositionResponse> responses = positions.stream()
				.map(position->this.mapperService.forResponse()
						.map(position, GetAllPositionResponse.class)).collect(Collectors.toList());
		return responses;
	}

	@Override
	public GetByIdPositionResponse getByIdResponse(int id) {
		Position position = positionRepository.findById(id).get();
		GetByIdPositionResponse response = this.mapperService.forResponse().map(position, GetByIdPositionResponse.class);
		return response;
	}

}
