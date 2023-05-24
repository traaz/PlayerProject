package com.example.ProjectPlayers.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdPositionResponse {
	private int id;
	private String name;

}
