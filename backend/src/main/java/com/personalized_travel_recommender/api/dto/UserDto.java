package com.personalized_travel_recommender.api.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private Long id;
    @Override
	public String toString() {
		return "UserDto [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", addresses=" + addresses + "]";
	}
	private String username;
	
	@NotNull(message = "Email must not be empty")
    private String email;
	
	@NotNull(message = "Password must not be empty")
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private List<AddressDto> addresses;
}
