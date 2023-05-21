package com.personalized_travel_recommender.api.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DestinationDto {
	private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private List<String> tags;
}
