package com.example.ProjectPlayers.business.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTeamRequest {
	
	private int id;
	@NotNull
	@NotBlank
	@Size(min = 3, max =50)
	private String name;

}
