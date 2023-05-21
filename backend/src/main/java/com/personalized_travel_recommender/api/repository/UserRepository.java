package com.personalized_travel_recommender.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personalized_travel_recommender.api.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String username);
}
