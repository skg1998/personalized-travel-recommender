package com.personalized_travel_recommender.api.service;

import java.util.List;

import com.personalized_travel_recommender.api.dto.ItineraryDTO;
import com.personalized_travel_recommender.api.dto.RecommendationRequest;

public interface RecommendationService {
	public List<ItineraryDTO> generateRecommendations(RecommendationRequest input);
}
