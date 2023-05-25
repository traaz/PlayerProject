package com.example.ProjectPlayers.webApi;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjectPlayers.business.abstracts.PlayerService;
import com.example.ProjectPlayers.business.request.CreatePlayerRequest;
import com.example.ProjectPlayers.business.request.UpdatePlayerRequest;
import com.example.ProjectPlayers.business.response.GetAllPlayerResponse;
import com.example.ProjectPlayers.business.response.GetByIdResponse;
import com.example.ProjectPlayers.business.response.GetPlayersPositionResponse;
import com.example.ProjectPlayers.business.response.GetPlayersTeamAndPositionResponse;
import com.example.ProjectPlayers.business.response.GetPlayersTeamResponse;
import com.example.ProjectPlayers.entities.Player;

import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/players")
@AllArgsConstructor
public class PlayerController {
	private PlayerService playerService;

	
	@GetMapping("/getall")
	public List<GetAllPlayerResponse> getAll(){
		return playerService.getAll();
	}
	@GetMapping("/get/{id}")
	public GetByIdResponse getById(@PathVariable int id) {
		return playerService.getById(id);
	}
	@PostMapping()
	public void add(@RequestBody CreatePlayerRequest createPlayerRequest) {
		playerService.add(createPlayerRequest);
	}
	@PutMapping("/{id}")
	public void update(@PathVariable int id, @RequestBody UpdatePlayerRequest updatePlayerRequest) {
		playerService.update(id, updatePlayerRequest);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		playerService.delete(id);
	}
	/*@GetMapping("{position}")
	public List<GetPlayersPositionResponse> getByPlayersPositionName(@PathVariable String position) {
		return playerService.getPlayersPositionNameResponse(position);
		
	}*/
	@GetMapping("/position/{id}")
	public List<GetPlayersPositionResponse> getByPlayersPositionId(@PathVariable int id) {
		return playerService.getPlayersPositionIdResponse(id);
		
	}
	/*@GetMapping("/team/{team}")
	public List<GetPlayersTeamResponse> getPlayersTeamName(@PathVariable String team){
		return playerService.getPlayersTeamNameResponse(team);
	}*/
	@GetMapping("/team/{id}")
	public List<GetPlayersTeamResponse> getPlayersTeamId(@PathVariable int id){
		return playerService.getPlayersTeamIdResponse(id);
	}
	@GetMapping("team/{id}/{position}")
	public List<GetPlayersTeamAndPositionResponse> getPlayersTeamAndPositionResponse(@PathVariable int id, @PathVariable String position){
		return playerService.getPlayersTeamAndPositionResponse(id, position);
	}
	
}
