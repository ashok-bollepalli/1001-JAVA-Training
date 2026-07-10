package in.ashokit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.dto.ApiResponse;
import in.ashokit.dto.CityDto;
import in.ashokit.dto.CountryDto;
import in.ashokit.dto.QuoteApiResponse;
import in.ashokit.dto.ResetPwdDto;
import in.ashokit.dto.StateDto;
import in.ashokit.dto.UserDto;
import in.ashokit.service.UserService;

@RestController
public class UserRestController {

	@Autowired
	private UserService userService;

	@GetMapping("/countries")
	public ResponseEntity<ApiResponse<List<CountryDto>>> getCountries() {

		List<CountryDto> countries = userService.getCountries();

		ApiResponse<List<CountryDto>> response = new ApiResponse<>();

		response.setStatusCode(200);
		response.setMessage("Countries Fetched");
		response.setData(countries);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping("/states/{countryId}")
	public ResponseEntity<ApiResponse<List<StateDto>>> getStates(@PathVariable Integer countryId) {

		List<StateDto> states = userService.getStates(countryId);

		ApiResponse<List<StateDto>> response = new ApiResponse<>();
		response.setStatusCode(200);
		response.setMessage("states Fetched");
		response.setData(states);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/cities/{stateId}")
	public ResponseEntity<ApiResponse<List<CityDto>>> getCities(@PathVariable Integer stateId) {

		List<CityDto> cities = userService.getCities(stateId);

		ApiResponse<List<CityDto>> response = new ApiResponse<>();

		response.setStatusCode(200);
		response.setMessage("Fetched cities");
		response.setData(cities);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/user/{email}")
	public ResponseEntity<ApiResponse<UserDto>> getUser(@PathVariable String email) {

		UserDto userDto = userService.getUserByEmail(email);

		ApiResponse<UserDto> response = new ApiResponse<>();
		response.setStatusCode(200);
		response.setMessage("User Fetched");
		response.setData(userDto);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@PostMapping("/user")
	public ResponseEntity<ApiResponse<UserDto>> registration(@RequestBody UserDto userDto) {

		UserDto registeredUser = userService.registerUser(userDto);

		ApiResponse<UserDto> response = new ApiResponse<>();
		response.setStatusCode(201);
		response.setMessage("User Registered");
		response.setData(registeredUser);

		return new ResponseEntity<>(response, HttpStatus.CREATED);

	}

	@PostMapping("/login")
	public ResponseEntity<ApiResponse<UserDto>> userLogin(@RequestBody UserDto userDto) {

		UserDto loggedInuser = userService.login(userDto.getEmail(), userDto.getPwd());

		ApiResponse<UserDto> response = new ApiResponse<>();
		response.setStatusCode(200);
		response.setMessage("User Login Check Successfully");
		response.setData(loggedInuser);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@PostMapping("/reset-pwd")
	public ResponseEntity<ApiResponse<UserDto>> login(@RequestBody ResetPwdDto resetpwdDto) {

		UserDto user = userService.resetPwd(resetpwdDto);

		ApiResponse<UserDto> response = new ApiResponse<>();

		response.setMessage("User pwd Update");
		response.setStatusCode(200);
		response.setData(user);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/quote")
	public ResponseEntity<ApiResponse<QuoteApiResponse>> getQuote() {

		QuoteApiResponse randomQuote = userService.getRandomQuote();

		ApiResponse<QuoteApiResponse> response = new ApiResponse<>();

		response.setStatusCode(200);
		response.setMessage("Quote Fetched");
		response.setData(randomQuote);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
