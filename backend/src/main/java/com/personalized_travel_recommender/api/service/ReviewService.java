package com.personalized_travel_recommender.api.service;

import java.util.List;

import com.personalized_travel_recommender.api.dto.ReviewDto;

public interface ReviewService {
	public List<ReviewDto> getAllReviews();
	public ReviewDto getReviewById(Long id);
	public ReviewDto createReview(ReviewDto reviewDto);
	public ReviewDto updateReview(Long id, ReviewDto reviewDto);
	public boolean deleteReview(Long id);
}
