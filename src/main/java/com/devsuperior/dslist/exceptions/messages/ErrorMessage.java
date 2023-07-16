package com.devsuperior.dslist.exceptions.messages;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorMessage {
	
	private Integer statusCode;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dateTime;
	private String message;
}
