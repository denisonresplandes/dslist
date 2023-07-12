package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository repository;
	
	public List<GameMinDTO> findAll() {
		List<GameMinDTO> games = repository.findAll()
			.stream()
			.map(GameMinDTO::new).toList();
		return games;
	}
	
	public GameMinDTO findById(Long id) {
		Game game = repository.findById(id)
			.orElseThrow(() -> new RuntimeException("Game not found!"));
		return new GameMinDTO(game);
	}
}
