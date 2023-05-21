package com.personalized_travel_recommender.api.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItineraryDto {
    private Long id;
    private String title;
    private List<DestinationDto> destinations;
}
