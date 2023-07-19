package com.example.ProjectPlayers.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.example.ProjectPlayers.entities.Player;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllPositionResponse {
	private int id;
	private String name;
    
}
