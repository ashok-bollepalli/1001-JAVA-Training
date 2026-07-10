package in.ashokit.service;

import java.util.List;

import in.ashokit.dto.CityDto;
import in.ashokit.dto.CountryDto;
import in.ashokit.dto.QuoteApiResponse;
import in.ashokit.dto.ResetPwdDto;
import in.ashokit.dto.StateDto;
import in.ashokit.dto.UserDto;

public interface UserService {

	public List<CountryDto> getCountries();

	public List<StateDto> getStates(Integer countryId);

	public List<CityDto> getCities(Integer stateId);

	public UserDto getUserByEmail(String email);

	public UserDto registerUser(UserDto userDto);

	public UserDto login(String email, String pwd);

	public UserDto resetPwd(ResetPwdDto resetPwdDto);

	public QuoteApiResponse getRandomQuote();

}




