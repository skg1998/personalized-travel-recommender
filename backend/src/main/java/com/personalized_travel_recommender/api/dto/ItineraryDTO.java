package com.personalized_travel_recommender.api.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItineraryDTO {
    private Long id;
    private String title;
    private List<DestinationDto> destinations; 
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<String> activities;
    private List<String> transportation;
    private List<String> accommodation;
    private String description;
    private int totalTimeSpent;
    private double totalSpendMoney;
    private String travelGroup;
    private String weatherDetail;
    private String occasion;
    private List<String> bestFor;
}
