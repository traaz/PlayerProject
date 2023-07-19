package com.example.ProjectPlayers.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjectPlayers.business.abstracts.PlayerService;
import com.example.ProjectPlayers.business.abstracts.PositionService;
import com.example.ProjectPlayers.business.response.GetAllPositionResponse;
import com.example.ProjectPlayers.business.response.GetByIdPositionResponse;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/positions")
@AllArgsConstructor
public class PositionController {
	private PositionService positionService;
	
	@GetMapping("/getall")
	public List<GetAllPositionResponse> getAll(){
		return positionService.getAll();
	}
	@GetMapping("{id}")
	public GetByIdPositionResponse getById(@PathVariable int id) {
		return positionService.getByIdResponse(id);
	}
}
