package com.example.ProjectPlayers.webApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjectPlayers.business.abstracts.PlayerService;
import com.example.ProjectPlayers.business.request.CreatePlayerRequest;
import com.example.ProjectPlayers.business.response.GetAllPlayerResponse;
import com.example.ProjectPlayers.business.response.GetByIdResponse;
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
	@GetMapping("/{id}")
	public GetByIdResponse getById(@PathVariable int id) {
		return playerService.getById(id);
	}
	@PostMapping()
	public void add(@RequestBody CreatePlayerRequest createPlayerRequest) {
		playerService.add(createPlayerRequest);
	}
}
