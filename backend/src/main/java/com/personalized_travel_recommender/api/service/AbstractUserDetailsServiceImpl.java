package com.personalized_travel_recommender.api.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.personalized_travel_recommender.api.entity.User;
import com.personalized_travel_recommender.api.exception.UsernameNotFoundException;
import com.personalized_travel_recommender.api.repository.UserRepository;
import com.personalized_travel_recommender.api.security.CustomUserDetails;

@Service
@Transactional
public class AbstractUserDetailsServiceImpl extends AbstractUserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return new CustomUserDetails(user);
    }
}
