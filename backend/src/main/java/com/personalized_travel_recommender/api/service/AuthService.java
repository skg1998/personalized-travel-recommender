package com.personalized_travel_recommender.api.service;

import com.personalized_travel_recommender.api.dto.UserDto;

public interface AuthService {
	public void registerUser(UserDto userDto);
	public String loginUser(String username, String password);
}
