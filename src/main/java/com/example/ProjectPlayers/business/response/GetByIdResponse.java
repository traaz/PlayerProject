package com.example.ProjectPlayers.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdResponse {
	private int id;
	private String name;
	private String surname;
	private String image_url;

}
