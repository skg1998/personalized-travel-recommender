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

import com.personalized_travel_recommender.api.dto.DestinationDto;
import com.personalized_travel_recommender.api.service.DestinationService;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping("/api/v1/destinations")
public class DestinationController {
	@Autowired
    private DestinationService destinationService;

    @GetMapping
    public ResponseEntity<List<DestinationDto>> getAllDestinations() {
        List<DestinationDto> destinations = destinationService.getAllDestinations();
        return ResponseEntity.ok(destinations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DestinationDto> getDestinationById(@PathVariable Long id) {
        DestinationDto destination = destinationService.getDestinationById(id);
        if (destination == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(destination);
    }

    @PostMapping
    public ResponseEntity<DestinationDto> createDestination(@RequestBody DestinationDto destinationDTO) {
        DestinationDto createdDestination = destinationService.createDestination(destinationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDestination);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DestinationDto> updateDestination(@PathVariable Long id, @RequestBody DestinationDto destinationDTO) {
        DestinationDto updatedDestination = destinationService.updateDestination(id, destinationDTO);
        if (updatedDestination == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedDestination);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDestination(@PathVariable Long id) {
        boolean deleted = destinationService.deleteDestination(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}

