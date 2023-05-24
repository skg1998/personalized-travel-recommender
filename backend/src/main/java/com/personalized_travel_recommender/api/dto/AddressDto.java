package com.personalized_travel_recommender.api.dto;

import lombok.Data;

@Data
public class AddressDto {
	private Long Id;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
}
