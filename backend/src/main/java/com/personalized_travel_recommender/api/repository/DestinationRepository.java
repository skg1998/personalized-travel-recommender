package com.personalized_travel_recommender.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personalized_travel_recommender.api.entity.Destination;
import com.personalized_travel_recommender.api.entity.Itinerary;

public interface DestinationRepository extends JpaRepository<Destination, Long>{

	List<Itinerary> findByLocationName(String location);

}
