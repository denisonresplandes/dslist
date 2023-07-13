package com.devsuperior.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * This class represents the ID for the association class (Belonging) 
 * between Game and GameList entities.
 * */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
public class BelongingPK {
	/*
	 * foreign keys for Game and Game List entities.
	 * */

	@ManyToOne
	@JoinColumn(name = "game_id")
	@EqualsAndHashCode.Include
	private Game game;
	
	@ManyToOne
	@JoinColumn(name = "game_list_id")
	@EqualsAndHashCode.Include
	private GameList gameList;
	
}
