package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.exceptions.ResourceNotFoundException;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository repository;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<GameMinDTO> games = repository.findAll()
			.stream()
			.map(GameMinDTO::new).toList();
		return games;
	}
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game game = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Game not found!"));
		return new GameDTO(game);
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId) {
		List<GameMinDTO> list = repository.searchByList(listId).stream()
			.map(GameMinDTO::new).toList();
		if (!list.isEmpty())
			return list;
		else 
			throw new ResourceNotFoundException("Game List not found!");
	}
}
