package com.personalized_travel_recommender.api.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationRequest {
	private boolean isGroupTrip;
    private String occasion;
    private List<String> bestFor;
    private String weather;
    private String location;
    private String famousFor;
    private List<String> tags;
    private boolean highRating;
    private boolean mostSearchedByUsers;
}
