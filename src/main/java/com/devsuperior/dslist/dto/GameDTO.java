package com.devsuperior.dslist.dto;

import java.time.Year;

import org.springframework.beans.BeanUtils;

import com.devsuperior.dslist.entities.Game;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameDTO {
	
	private Long id;
	private String title;
	private Year year;
	private String genre;
	private String platforms;
	private Double score;
	private String imgUrl;	
	private String shortDescription;
	private String longDescription;
	
	public GameDTO(Game entity) {
		BeanUtils.copyProperties(entity, this);
	}
}
