package com.personalized_travel_recommender.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalized_travel_recommender.api.dto.AddressDto;
import com.personalized_travel_recommender.api.dto.DestinationDto;
import com.personalized_travel_recommender.api.dto.ItineraryDTO;
import com.personalized_travel_recommender.api.dto.ReviewDto;
import com.personalized_travel_recommender.api.dto.UserDto;
import com.personalized_travel_recommender.api.entity.Address;
import com.personalized_travel_recommender.api.entity.Destination;
import com.personalized_travel_recommender.api.entity.Itinerary;
import com.personalized_travel_recommender.api.entity.Review;
import com.personalized_travel_recommender.api.entity.User;
import com.personalized_travel_recommender.api.exception.NotFoundException;
import com.personalized_travel_recommender.api.repository.ItineraryRepository;
import com.personalized_travel_recommender.api.repository.ReviewRepository;
import com.personalized_travel_recommender.api.repository.UserRepository;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

	@Autowired
    private ReviewRepository reviewRepository;
	
	@Autowired
	private ItineraryRepository itineraryRepository;
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ItineraryService itineraryService;



    public List<ReviewDto> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return mapReviewsToDto(reviews);
    }

    public ReviewDto getReviewById(Long id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        return optionalReview.map(this::mapReviewToDto).orElse(null);
    }

    public ReviewDto createReview(ReviewDto reviewDto) {
        // Retrieve the corresponding Itinerary and User entities
        Itinerary itinerary = itineraryRepository.findById(reviewDto.getItineraryId())
                .orElseThrow(() -> new NotFoundException("Itinerary not found"));
        User user = userRepository.findById(reviewDto.getUserId())
                .orElseThrow(() -> new NotFoundException("User not found"));

        // Create a new Review entity
        Review review = new Review();
        review.setComment(reviewDto.getComment());
        review.setRating(reviewDto.getRating());
        review.setItinerary(itinerary);
        review.setUser(user);

        // Save the review
        Review savedReview = reviewRepository.save(review);

        // Map the saved review back to a DTO and return it
        return mapReviewToDto(savedReview);
    }


    public ReviewDto updateReview(Long id, ReviewDto reviewDto) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if (optionalReview.isPresent()) {
            Review review = optionalReview.get();
            updateReviewFromDto(review, reviewDto);
            Review updatedReview = reviewRepository.save(review);
            return mapReviewToDto(updatedReview);
        } else {
            return null;
        }
    }

    public boolean deleteReview(Long id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private List<ReviewDto> mapReviewsToDto(List<Review> reviews) {
        return reviews.stream()
                .map(this::mapReviewToDto)
                .collect(Collectors.toList());
    }

    private ReviewDto mapReviewToDto(Review review) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(review.getId());
        reviewDto.setComment(review.getComment());
        reviewDto.setRating(review.getRating());
        reviewDto.setUserId(review.getUser().getId());
        reviewDto.setItineraryId(review.getItinerary().getId());
        return reviewDto;
    }

    private Review mapDtoToReview(ReviewDto reviewDto) {
        // Map ReviewDto to Review entity
        Review review = new Review();
        // Set the properties of the Review entity based on the ReviewDto
        review.setId(reviewDto.getId());
        review.setComment(reviewDto.getComment());
        review.setRating(reviewDto.getRating());
     // Fetch the User entity based on the user ID
        UserDto userDto = userService.getUserById(reviewDto.getUserId());
        User user = mapDtoToUser(userDto);
        review.setUser(user);
        
        // Set the Itinerary entity based on the itinerary ID (assuming you have a similar method to fetch the Itinerary)
        ItineraryDTO itineraryDto = itineraryService.getItineraryById(reviewDto.getItineraryId());
        Itinerary itinerary = mapDTOToItinerary(itineraryDto);
        review.setItinerary(itinerary);
        // Set any other properties as needed
        return review;
    }

    private void updateReviewFromDto(Review review, ReviewDto reviewDto) {
    	review.setComment(reviewDto.getComment());
        review.setRating(reviewDto.getRating());
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
    
    private User mapDtoToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setDateOfBirth(userDto.getDateOfBirth());
        
        List<Address> addresses = new ArrayList<>();
        if (userDto.getAddresses() != null) {
            for (AddressDto addressDto : userDto.getAddresses()) {
                Address address = new Address();
                address.setId(addressDto.getId());
                address.setStreet(addressDto.getStreet());
                address.setCity(addressDto.getCity());
                address.setCountry(addressDto.getCountry());
                // Set any other address properties as needed
                addresses.add(address);
            }
        }
        user.setAddresses(addresses);
        
        return user;
    }

}

