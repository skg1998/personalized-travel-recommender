package com.personalized_travel_recommender.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalized_travel_recommender.api.dto.DestinationDto;
import com.personalized_travel_recommender.api.dto.ItineraryDTO;
import com.personalized_travel_recommender.api.entity.Destination;
import com.personalized_travel_recommender.api.entity.Itinerary;
import com.personalized_travel_recommender.api.repository.ItineraryRepository;

@Service
@Transactional
public class ItineraryServiceImpl implements ItineraryService {

	@Autowired
    private ItineraryRepository itineraryRepository;

    public List<ItineraryDTO> getAllItineraries() {
        List<Itinerary> itineraries = itineraryRepository.findAll();
        return mapItinerariesToDTOs(itineraries);
    }

    public ItineraryDTO getItineraryById(Long id) {
        Optional<Itinerary> optionalItinerary = itineraryRepository.findById(id);
        return optionalItinerary.map(this::mapItineraryToDTO).orElse(null);
    }

    public ItineraryDTO createItinerary(ItineraryDTO itineraryDTO) {
        Itinerary itinerary = mapDTOToItinerary(itineraryDTO);
        itinerary = itineraryRepository.save(itinerary);
        return mapItineraryToDTO(itinerary);
    }

    public ItineraryDTO updateItinerary(Long id, ItineraryDTO updatedItineraryDTO) {
        Optional<Itinerary> optionalItinerary = itineraryRepository.findById(id);
        if (optionalItinerary.isPresent()) {
            Itinerary itinerary = optionalItinerary.get();
            itinerary.setTitle(updatedItineraryDTO.getTitle());
            itinerary.setAccommodation(updatedItineraryDTO.getAccommodation());
            itinerary.setActivities(updatedItineraryDTO.getActivities());
            itinerary.setBestFor(updatedItineraryDTO.getBestFor());
            itinerary.setStartDate(updatedItineraryDTO.getStartDate());
            itinerary.setEndDate(updatedItineraryDTO.getEndDate());
            itinerary.setOccasion(updatedItineraryDTO.getOccasion());
            itinerary.setTotalSpendMoney(updatedItineraryDTO.getTotalSpendMoney());
            itinerary.setWeatherDetails(updatedItineraryDTO.getWeatherDetail());
            itinerary.setTravelGroup(updatedItineraryDTO.getTravelGroup());
            itinerary.setTransportation(updatedItineraryDTO.getTransportation());
            itinerary.setTotalTimeSpend(updatedItineraryDTO.getTotalTimeSpent());
            itinerary.setDescription(itinerary.getDescription());
            itinerary = itineraryRepository.save(itinerary);
            return mapItineraryToDTO(itinerary);
        } else {
            return null;
        }
    }

    public boolean deleteItinerary(Long id) {
        Optional<Itinerary> optionalItinerary = itineraryRepository.findById(id);
        if (optionalItinerary.isPresent()) {
            itineraryRepository.delete(optionalItinerary.get());
            return true;
        } else {
            return false;
        }
    }

    private ItineraryDTO mapItineraryToDTO(Itinerary itinerary) {
        ItineraryDTO itineraryDTO = new ItineraryDTO();
        itineraryDTO.setId(itinerary.getId());
        itineraryDTO.setTitle(itinerary.getTitle());
        itineraryDTO.setAccommodation(itinerary.getAccommodation());
        itineraryDTO.setActivities(itinerary.getActivities());
        itineraryDTO.setBestFor(itinerary.getBestFor());
        
        List<DestinationDto> destinationDtos = itinerary.getDestinations()
        		.stream()
        		.map(destination -> mapDestinationToDTO(destination))
        		.collect(Collectors.toList());
        		
        itineraryDTO.setDestinations(destinationDtos);
        itineraryDTO.setStartDate(itinerary.getStartDate());
        itineraryDTO.setEndDate(itinerary.getEndDate());
        itineraryDTO.setOccasion(itinerary.getOccasion());
        itineraryDTO.setTotalSpendMoney(itinerary.getTotalSpendMoney());
        itineraryDTO.setWeatherDetail(itinerary.getWeatherDetails());
        itineraryDTO.setTravelGroup(itinerary.getTravelGroup());
        itineraryDTO.setTransportation(itinerary.getTransportation());
        itineraryDTO.setTotalTimeSpent(itinerary.getTotalTimeSpend());
        itineraryDTO.setDescription(itinerary.getDescription());
        return itineraryDTO;
    }

    private List<ItineraryDTO> mapItinerariesToDTOs(List<Itinerary> itineraries) {
        List<ItineraryDTO> itineraryDTOs = new ArrayList<>();
        for (Itinerary itinerary : itineraries) {
            itineraryDTOs.add(mapItineraryToDTO(itinerary));
        }
        return itineraryDTOs;
    }

    private Itinerary mapDTOToItinerary(ItineraryDTO itineraryDTO) {
        Itinerary itinerary = new Itinerary();
        itinerary.setId(itineraryDTO.getId());
        itinerary.setTitle(itineraryDTO.getTitle());
        itinerary.setAccommodation(itineraryDTO.getAccommodation());
        itinerary.setActivities(itineraryDTO.getActivities());
        itinerary.setBestFor(itineraryDTO.getBestFor());
        
        List<Destination> destinations = itineraryDTO.getDestinations()
        		.stream()
        		.map(destinationDTO -> {
        			return mapDTOToDestination(destinationDTO);
        		}).collect(Collectors.toList());
        
        itinerary.setDestinations(destinations);
        itinerary.setStartDate(itineraryDTO.getStartDate());
        itinerary.setEndDate(itineraryDTO.getEndDate());
        itinerary.setOccasion(itineraryDTO.getOccasion());
        itinerary.setTotalSpendMoney(itineraryDTO.getTotalSpendMoney());
        itinerary.setWeatherDetails(itineraryDTO.getWeatherDetail());
        itinerary.setTravelGroup(itineraryDTO.getTravelGroup());
        itinerary.setTransportation(itineraryDTO.getTransportation());
        itinerary.setTotalTimeSpend(itineraryDTO.getTotalTimeSpent());
        itinerary.setDescription(itinerary.getDescription());
        return itinerary;
    }
    
    private DestinationDto mapDestinationToDTO(Destination destination) {
        DestinationDto destinationDTO = new DestinationDto();
        destinationDTO.setId(destination.getId());
        destinationDTO.setLocationName(destination.getLocationName());
        destinationDTO.setVideosAndImagesLink(destination.getVideosAndImagesLink());
        destinationDTO.setHotels(destination.getHotels());
        destinationDTO.setRestaurants(destination.getRestaurants());
        destinationDTO.setFamousFor(destination.getFamousFor());
        destinationDTO.setTotalSpend(destination.getTotalSpend());
        destinationDTO.setBestTimeToVisit(destination.getBestTimeToVisit());
        destinationDTO.setMinimumTimeSpend(destination.getMinimumTimeSpend());
        destinationDTO.setTags(destination.getTags());
        destinationDTO.setTotalTimeSpend(destination.getTotalTimeSpend());
        destinationDTO.setTotalSpendMoney(destination.getTotalSpendMoney());
        destinationDTO.setWeatherDetail(destination.getWeatherDetail());
        destinationDTO.setOccasion(destination.getOccasion());
        destinationDTO.setBestFor(destination.getBestFor());
        return destinationDTO;
    }

    private Destination mapDTOToDestination(DestinationDto destinationDTO) {
        Destination destination = new Destination();
        destination.setLocationName(destinationDTO.getLocationName());
        destination.setVideosAndImagesLink(destinationDTO.getVideosAndImagesLink());
        destination.setHotels(destinationDTO.getHotels());
        destination.setRestaurants(destinationDTO.getRestaurants());
        destination.setFamousFor(destinationDTO.getFamousFor());
        destination.setTotalSpend(destinationDTO.getTotalSpend());
        destination.setBestTimeToVisit(destinationDTO.getBestTimeToVisit());
        destination.setMinimumTimeSpend(destinationDTO.getMinimumTimeSpend());
        destination.setTags(destinationDTO.getTags());
        destination.setTotalTimeSpend(destinationDTO.getTotalTimeSpend());
        destination.setTotalSpendMoney(destinationDTO.getTotalSpendMoney());
        destination.setWeatherDetail(destinationDTO.getWeatherDetail());
        destination.setOccasion(destinationDTO.getOccasion());
        destination.setBestFor(destinationDTO.getBestFor());
        return destination;
    }
}

