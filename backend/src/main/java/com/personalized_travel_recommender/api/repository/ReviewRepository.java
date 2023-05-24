package com.personalized_travel_recommender.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personalized_travel_recommender.api.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
