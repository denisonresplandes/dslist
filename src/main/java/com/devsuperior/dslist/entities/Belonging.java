package com.devsuperior.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "belonging")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Belonging {

	@EmbeddedId
	@EqualsAndHashCode.Include
	private BelongingPK id;
	/*
	 * position of the game in the list.
	 * */
	private Integer position;
	
	{ this.id = new BelongingPK(); }
	
	public Belonging(Game game, GameList gameList, Integer position) {
		this.id.setGame(game);
		this.id.setGameList(gameList);
		this.position = position;
	}
}
