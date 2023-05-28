package com.personalized_travel_recommender.api.RecommendationSystem;

import java.util.List;

import com.personalized_travel_recommender.api.dto.ItineraryDTO;
import com.personalized_travel_recommender.api.dto.RecommendationRequest;

public interface RecommendationStrategy {
	List<ItineraryDTO> generateRecommendations(RecommendationRequest input);
}
