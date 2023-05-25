package com.example.ProjectPlayers.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjectPlayers.business.abstracts.TeamService;
import com.example.ProjectPlayers.business.response.GetAllTeamResponse;
import com.example.ProjectPlayers.business.response.GetByIdTeamResponse;
import com.example.ProjectPlayers.entities.Team;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/teams")
@AllArgsConstructor
public class TeamController {
	private TeamService teamService;
	
	@GetMapping("/getall")
	public List<GetAllTeamResponse> getAll(){
		return teamService.getAll();
	}
	@GetMapping("{id}")
	public GetByIdTeamResponse getById(@PathVariable int id){
		return teamService.getByIdTeam(id);
	}

}
