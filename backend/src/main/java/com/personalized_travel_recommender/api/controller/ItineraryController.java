package com.personalized_travel_recommender.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personalized_travel_recommender.api.dto.ItineraryDTO;
import com.personalized_travel_recommender.api.service.ItineraryService;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping("/api/v1/itineraries")
public class ItineraryController {

	@Autowired
    private ItineraryService itineraryService;

    @GetMapping
    public ResponseEntity<List<ItineraryDTO>> getAllItineraries() {
        List<ItineraryDTO> itineraries = itineraryService.getAllItineraries();
        return ResponseEntity.ok(itineraries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItineraryDTO> getItineraryById(@PathVariable("id") Long id) {
        ItineraryDTO itinerary = itineraryService.getItineraryById(id);
        if (itinerary != null) {
            return ResponseEntity.ok(itinerary);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ItineraryDTO> createItinerary(@RequestBody ItineraryDTO itinerary) {
        ItineraryDTO createdItinerary = itineraryService.createItinerary(itinerary);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItinerary);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItineraryDTO> updateItinerary(
            @PathVariable("id") Long id,
            @RequestBody ItineraryDTO itinerary) {
        ItineraryDTO updatedItinerary = itineraryService.updateItinerary(id, itinerary);
        if (updatedItinerary != null) {
            return ResponseEntity.ok(updatedItinerary);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItinerary(@PathVariable("id") Long id) {
        boolean deleted = itineraryService.deleteItinerary(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

