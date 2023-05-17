package com.example.ProjectPlayers.business.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlayerRequest {
	private String name;
	private String surname;
	private String image_url;
	

}
