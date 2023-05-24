package com.personalized_travel_recommender.api.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "destination")
public class Destination {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String locationName;
    
    @ManyToOne
    @JoinColumn(name = "itinerary_id")
    private Itinerary itinerary;
    
    @ElementCollection
    private List<String> videosAndImagesLink;

    @ElementCollection
    private List<String> hotels;

    @ElementCollection
    private List<String> restaurants;

    @Column(nullable = false)
    private String famousFor;

    private double totalSpend;

    private String bestTimeToVisit;

    private int minimumTimeSpend;

    @ElementCollection
    private List<String> tags;

    private int totalTimeSpend;

    private double totalSpendMoney;

    private String weatherDetail;

    private String occasion;

    @ElementCollection
    private List<String> bestFor;

}
