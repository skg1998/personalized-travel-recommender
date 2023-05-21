package com.personalized_travel_recommender.api.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.personalized_travel_recommender.api.exception.UsernameNotFoundException;

public abstract class AbstractUserDetailsService implements UserDetailsService{
	public abstract UserDetails loadUserByUsername(String username) throws UsernameNotFoundException; 
}
