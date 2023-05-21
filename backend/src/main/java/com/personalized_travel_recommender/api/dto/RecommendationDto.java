package com.personalized_travel_recommender.api.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationDto {
	private Long id;
    private String destinationName;
    private String recommendationText;
    private int rating;
}
