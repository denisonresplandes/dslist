package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameService;

@RestController
@RequestMapping("/games")
public class GameController {

	@Autowired
	private GameService service;
	
	@GetMapping	
	public List<GameMinDTO> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GameDTO> findByID(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
	}
}
