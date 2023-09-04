package com.example.ProjectPlayers;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.ProjectPlayers.core.utilities.exceptions.BadCredentialsException;
import com.example.ProjectPlayers.core.utilities.exceptions.BusinessException;

import com.example.ProjectPlayers.core.utilities.exceptions.ProblemDetails;
import com.example.ProjectPlayers.core.utilities.exceptions.ValidationProblemDetails;

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
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationExcepiton(MethodArgumentNotValidException methodArgumentNotValidException) {
		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
		validationProblemDetails.setMessage("VALIDATION.EXCEPTION");
		validationProblemDetails.setValidationErrors(new HashMap<String, String>());
		for(FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return validationProblemDetails;
	}
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.FORBIDDEN)
	public ProblemDetails badcredentialException(org.springframework.security.authentication.BadCredentialsException badcredentialsExceptions) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage("Hatalı Giriş");
		return problemDetails;
	}

	
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
