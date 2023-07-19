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
public class UpdatePlayerRequest {
	private int id;
	@NotNull
	@NotBlank
	@Size(min = 3, max =50)
	private String name;
	@NotNull
	@NotBlank
	@Size(min = 3, max =50)
	private String surname;
	private String image_url;
	@NotNull
	@NotBlank
	private int teamId;
	@NotNull
	@NotBlank
	private int positionId;

}
