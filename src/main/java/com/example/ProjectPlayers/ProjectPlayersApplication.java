package com.example.ProjectPlayers;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.ProjectPlayers.core.utilities.exceptions.BusinessException;
import com.example.ProjectPlayers.core.utilities.exceptions.ProblemDetails;

@SpringBootApplication
@RestControllerAdvice
public class ProjectPlayersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectPlayersApplication.class, args);
	}
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessExcepiton(BusinessException businessException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		return problemDetails;
	}
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ProblemDetails handleBusinessExcepiton(DataIntegrityViolationException dataIntegrityVioalationException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(dataIntegrityVioalationException.getMessage());
		return problemDetails;
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
