package com.personalized_travel_recommender.api.RecommendationSystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.personalized_travel_recommender.api.dto.ItineraryDTO;
import com.personalized_travel_recommender.api.dto.RecommendationRequest;

public class RecommendationBuilder {
	
	@Autowired
	private RecommendationStrategy strategy;

    public RecommendationBuilder setStrategy(RecommendationStrategy strategy) {
        this.strategy = strategy;
        return this;
    }

    public List<ItineraryDTO> generateRecommendations(RecommendationRequest input) {
        return strategy.generateRecommendations(input);
    }
}
