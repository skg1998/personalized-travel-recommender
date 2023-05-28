package com.personalized_travel_recommender.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.personalized_travel_recommender.api.RecommendationSystem.LocationBasedRecommendationStrategy;
import com.personalized_travel_recommender.api.RecommendationSystem.RecommendationBuilder;
import com.personalized_travel_recommender.api.RecommendationSystem.RecommendationStrategy;

@Configuration
public class RecommendationConfig {
	@Bean
    public RecommendationBuilder recommendationBuilder() {
        return new RecommendationBuilder();
    }
	
	@Bean
    public RecommendationStrategy recommendationStrategy() {
        return (RecommendationStrategy) new LocationBasedRecommendationStrategy();
    }

}
