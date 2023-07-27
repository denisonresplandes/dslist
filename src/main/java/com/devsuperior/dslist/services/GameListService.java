package com.devsuperior.dslist.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.exceptions.ResourceNotFoundException;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository repository;
	
	@Autowired
	private GameRepository gameRepository;
	
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
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = new LinkedList<>(gameRepository.searchByList(listId));
		GameMinProjection gameProjection = list.remove(sourceIndex);
		list.add(destinationIndex, gameProjection);
		int min = Math.min(sourceIndex, destinationIndex);
		int max = Math.max(sourceIndex, destinationIndex);
		
		for (int index = min; index <= max; index++) {
			repository.updateBelongingPosition(listId, list.get(index).getId(), index);
		}
	}
}
