package com.personalized_travel_recommender.api.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "itinerary")
public class Itinerary {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "itinerary", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Destination> destinations = new ArrayList<>();
    
    @Column(nullable = false)
    private LocalDateTime startDate;
    
    @Column(nullable = false)
    private LocalDateTime endDate;
    
    @ElementCollection
    private List<String> activities;
    
    @ElementCollection
    private List<String> transportation;
    
    @ElementCollection
    private List<String> accommodation;
    
    private int totalTimeSpend;
    
    private double totalSpendMoney;
    
    private String description;
    
    private String travelGroup;
    
    private String weatherDetails;
    
    private String occasion;
    
    @ElementCollection
    private List<String> bestFor;
}

