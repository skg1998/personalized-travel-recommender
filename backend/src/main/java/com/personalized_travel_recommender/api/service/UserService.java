package com.personalized_travel_recommender.api.service;

import java.util.List;

import com.personalized_travel_recommender.api.dto.UserDto;

public interface UserService {
	public List<UserDto> getAllUsers();
	public UserDto getUserById(Long id);
	public UserDto createUser(UserDto userDto);
	public UserDto updateUser(Long id, UserDto userDto);
	public boolean deleteUser(Long id);
}
