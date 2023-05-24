package com.personalized_travel_recommender.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personalized_travel_recommender.api.entity.Itinerary;

public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {

}
