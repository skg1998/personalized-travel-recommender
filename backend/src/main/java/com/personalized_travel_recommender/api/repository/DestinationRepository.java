package com.personalized_travel_recommender.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personalized_travel_recommender.api.entity.Destination;

public interface DestinationRepository extends JpaRepository<Destination, Long>{

}
