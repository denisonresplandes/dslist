package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.exceptions.ResourceNotFoundException;
import com.devsuperior.dslist.repositories.GameListRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository repository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameListDTO> list = repository.findAll().stream()
			.map(GameListDTO::new).toList();
		return list;
	}
	
	@Transactional(readOnly = true)
	public GameListDTO findById(Long id) {
		GameList gameList = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Game List not found!"));
		return new GameListDTO(gameList);
	}
}
