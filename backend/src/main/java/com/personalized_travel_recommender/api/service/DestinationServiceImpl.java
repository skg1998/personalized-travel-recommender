package com.personalized_travel_recommender.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalized_travel_recommender.api.dto.DestinationDto;
import com.personalized_travel_recommender.api.entity.Destination;
import com.personalized_travel_recommender.api.repository.DestinationRepository;

@Service
@Transactional
public class DestinationServiceImpl implements DestinationService {

	@Autowired
    private DestinationRepository destinationRepository;

    public List<DestinationDto> getAllDestinations() {
        List<Destination> destinations = destinationRepository.findAll();
        return mapDestinationsToDTOs(destinations);
    }

    public DestinationDto getDestinationById(Long id) {
        Optional<Destination> optionalDestination = destinationRepository.findById(id);
        return optionalDestination.map(this::mapDestinationToDTO).orElse(null);
    }

    public DestinationDto createDestination(DestinationDto destinationDTO) {
        Destination destination = mapDTOToDestination(destinationDTO);
        Destination createdDestination = destinationRepository.save(destination);
        return mapDestinationToDTO(createdDestination);
    }

    public DestinationDto updateDestination(Long id, DestinationDto destinationDTO) {
        Optional<Destination> optionalDestination = destinationRepository.findById(id);
        if (optionalDestination.isPresent()) {
            Destination destination = optionalDestination.get();
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

            Destination updatedDestination = destinationRepository.save(destination);
            return mapDestinationToDTO(updatedDestination);
        }
        return null;
    }

    public boolean deleteDestination(Long id) {
        if (destinationRepository.existsById(id)) {
            destinationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private List<DestinationDto> mapDestinationsToDTOs(List<Destination> destinations) {
        return destinations.stream()
                .map(this::mapDestinationToDTO)
                .collect(Collectors.toList());
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
