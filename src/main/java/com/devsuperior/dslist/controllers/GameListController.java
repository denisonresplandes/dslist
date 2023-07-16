package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;

@RestController
@RequestMapping("/lists")
public class GameListController {

	@Autowired
	private GameListService service;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameListDTO> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GameListDTO> findById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
	}
	
	@GetMapping("/{listId}/games")
	public ResponseEntity<List<GameMinDTO>> findByList(@PathVariable Long listId) {
		return ResponseEntity.status(HttpStatus.FOUND).body(gameService.findByList(listId));
	}
}
