package com.personalized_travel_recommender.api.service;

import java.util.List;

import com.personalized_travel_recommender.api.dto.ItineraryDTO;

public interface ItineraryService {
	public List<ItineraryDTO> getAllItineraries();
	public ItineraryDTO getItineraryById(Long id);
	public ItineraryDTO createItinerary(ItineraryDTO itineraryDTO);
	public ItineraryDTO updateItinerary(Long id, ItineraryDTO updatedItineraryDTO);
	public boolean deleteItinerary(Long id);
}
