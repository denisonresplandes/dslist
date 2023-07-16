package com.devsuperior.dslist.exceptions.handlers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.devsuperior.dslist.exceptions.ResourceNotFoundException;
import com.devsuperior.dslist.exceptions.messages.ErrorMessage;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseBody
	public ResponseEntity<ErrorMessage> handleResourceNotFoundException(ResourceNotFoundException e) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND.value(), 
				LocalDateTime.now(), e.getMessage());
		return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	}
}
