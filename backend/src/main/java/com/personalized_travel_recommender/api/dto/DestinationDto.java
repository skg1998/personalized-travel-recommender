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
public class DestinationDto {
	private Long id;
    private String locationName;
    private Long itineraryId;
    private List<String> videosAndImagesLink;
    private List<String> hotels;
    private List<String> restaurants;
    private String famousFor;
    private double totalSpend;
    private String bestTimeToVisit;
    private int minimumTimeSpend;
    private List<String> tags;
    private int totalTimeSpend;
    private double totalSpendMoney;
    private String weatherDetail;
    private String occasion;
    private List<String> bestFor;
}
