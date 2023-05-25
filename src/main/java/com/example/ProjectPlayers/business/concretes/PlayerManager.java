package com.example.ProjectPlayers.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ProjectPlayers.business.abstracts.PlayerService;
import com.example.ProjectPlayers.business.request.CreatePlayerRequest;
import com.example.ProjectPlayers.business.request.UpdatePlayerRequest;
import com.example.ProjectPlayers.business.response.GetAllPlayerResponse;
import com.example.ProjectPlayers.business.response.GetByIdResponse;
import com.example.ProjectPlayers.business.response.GetPlayersPositionResponse;
import com.example.ProjectPlayers.business.response.GetPlayersTeamAndPositionResponse;
import com.example.ProjectPlayers.business.response.GetPlayersTeamResponse;
import com.example.ProjectPlayers.core.utilities.mappers.ModelMapperService;
import com.example.ProjectPlayers.dataAccess.abstracts.PlayerRepository;
import com.example.ProjectPlayers.entities.Player;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PlayerManager implements PlayerService{
	private PlayerRepository playerRepository;
	private ModelMapperService mapperService;

	@Override
	public List<GetAllPlayerResponse> getAll() {
		List<Player> players = playerRepository.findAll();
		List<GetAllPlayerResponse> responses = players.stream()
				.map(player->this.mapperService.forResponse()
						.map(player, GetAllPlayerResponse.class)).collect(Collectors.toList());
		return responses;
	}

	@Override
	public GetByIdResponse getById(int id) {
		Player player = playerRepository.findById(id).get();
		GetByIdResponse response = this.mapperService.forResponse().map(player, GetByIdResponse.class);
		return response;
	}

	@Override
	public void add(CreatePlayerRequest createPlayerRequest) {
		
		Player player = this.mapperService.forRequest().map(createPlayerRequest, Player.class);
		this.playerRepository.save(player);
	}

	@Override
	public void update(int id, UpdatePlayerRequest updatePlayerRequest) {
		Player player = playerRepository.findById(id).get();
		player = this.mapperService.forRequest().map(updatePlayerRequest, Player.class);
		this.playerRepository.save(player);
		
	}

	@Override
	public void delete(int id) {
		playerRepository.deleteById(id);
		
	}

	@Override
	public List<GetPlayersPositionResponse> getPlayersPositionNameResponse(String position) {
		List<Player> players = playerRepository.findByPositionName(position);
		
		//return players;
		
		List<GetPlayersPositionResponse> responses = players.stream()
				.map(player->this.mapperService.forResponse()
						.map(player, GetPlayersPositionResponse.class)).collect(Collectors.toList());
		
		return responses;
	}

	@Override
	public List<GetPlayersPositionResponse> getPlayersPositionIdResponse(int id) {
		List<Player> players = playerRepository.findByPositionId(id);
		
		List<GetPlayersPositionResponse> responses = players.stream()
				.map(player->this.mapperService.forResponse()
						.map(player, GetPlayersPositionResponse.class)).collect(Collectors.toList());
		
		return responses;
	}

	@Override
	public List<GetPlayersTeamResponse> getPlayersTeamNameResponse(String team) {
		List<Player> players = playerRepository.findByTeamName(team);
		List<GetPlayersTeamResponse> responses = players.stream().map(player->this.mapperService.forResponse().map(player, GetPlayersTeamResponse.class)).collect(Collectors.toList());
		return responses;
	}

	@Override
	public List<GetPlayersTeamResponse> getPlayersTeamIdResponse(int id) {
		List<Player> players = playerRepository.findByTeamId(id);
		List<GetPlayersTeamResponse> responses = players.stream().map(player->this.mapperService.forResponse().map(player, GetPlayersTeamResponse.class)).collect(Collectors.toList());
		return responses;
	}

	@Override
	public List<GetPlayersTeamAndPositionResponse> getPlayersTeamAndPositionResponse(int id, String position) {
		List<Player> players = playerRepository.findByTeamIdAndPositionName(id, position);
		List<GetPlayersTeamAndPositionResponse> responses = players.stream().map(player->this.mapperService.forResponse().map(player, GetPlayersTeamAndPositionResponse.class)).collect(Collectors.toList());
		return responses;
	}

}
