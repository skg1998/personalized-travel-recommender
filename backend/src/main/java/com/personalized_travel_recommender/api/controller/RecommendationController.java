package com.personalized_travel_recommender.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personalized_travel_recommender.api.dto.ItineraryDTO;
import com.personalized_travel_recommender.api.dto.RecommendationRequest;
import com.personalized_travel_recommender.api.service.RecommendationService;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping("/api/v1/recommendations")
public class RecommendationController {
	
	@Autowired
    private RecommendationService recommendationService;
    
    @PostMapping("/")
    public ResponseEntity<List<ItineraryDTO>> getRecommendations(@RequestBody RecommendationRequest input) {
        List<ItineraryDTO> recommendations = recommendationService.generateRecommendations(input);
        return new ResponseEntity<>(recommendations, HttpStatus.OK);
    }
}

