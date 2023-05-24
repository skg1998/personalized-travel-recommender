package com.personalized_travel_recommender.api.service;

import java.util.List;

import com.personalized_travel_recommender.api.dto.DestinationDto;

public interface DestinationService {
	public List<DestinationDto> getAllDestinations();
	public DestinationDto getDestinationById(Long id);
	public DestinationDto createDestination(DestinationDto destinationDTO);
	public DestinationDto updateDestination(Long id, DestinationDto destinationDTO);
	public boolean deleteDestination(Long id);
	
}
