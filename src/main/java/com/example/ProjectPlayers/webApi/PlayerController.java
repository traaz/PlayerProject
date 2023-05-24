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
	@GetMapping("{position}")
	public List<GetPlayersPositionResponse> getByPlayersPosition(@PathVariable String position) {
		return playerService.getPlayersPositionResponse(position);
		
	}
	@GetMapping("/position/{id}")
	public List<GetPlayersPositionResponse> getByPlayersPosition(@PathVariable int id) {
		return playerService.getPlayersPositionResponse(id);
		
	}
	
}
