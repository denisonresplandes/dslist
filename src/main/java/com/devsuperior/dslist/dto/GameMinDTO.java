package com.devsuperior.dslist.dto;

import java.time.Year;

import com.devsuperior.dslist.entities.Game;

import lombok.Getter;

@Getter
public class GameMinDTO {

	private Long id;
	private String title;
	private Year year;
	private String imgUrl;
	private String shortDescription;
	
	public GameMinDTO(Game entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.year = entity.getYear();
		this.imgUrl = entity.getImgUrl();
		this.shortDescription = entity.getShortDescription();
	}
}
