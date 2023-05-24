package com.personalized_travel_recommender.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
	private Long id;
    private String comment;
    private int rating;
    private Long userId;
    private Long itineraryId;
}
