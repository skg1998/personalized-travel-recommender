package com.personalized_travel_recommender.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalized_travel_recommender.api.RecommendationSystem.GroupTripRecommendationStrategy;
import com.personalized_travel_recommender.api.RecommendationSystem.OccasionBasedRecommendationStrategy;
import com.personalized_travel_recommender.api.RecommendationSystem.RecommendationBuilder;
import com.personalized_travel_recommender.api.RecommendationSystem.RecommendationStrategy;
import com.personalized_travel_recommender.api.dto.ItineraryDTO;
import com.personalized_travel_recommender.api.dto.RecommendationRequest;

@Service
@Transactional
public class RecommendationServiceImpl implements RecommendationService {
	
	@Autowired
	private RecommendationBuilder recommendationBuilder;

    public List<ItineraryDTO> generateRecommendations(RecommendationRequest input) {
        return recommendationBuilder.generateRecommendations(input);
    }
    
    public void setStrategy(RecommendationStrategy strategy) {
    	recommendationBuilder.setStrategy(strategy);
    }
}
