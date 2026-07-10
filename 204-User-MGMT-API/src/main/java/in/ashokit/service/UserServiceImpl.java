package in.ashokit.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.ashokit.dto.CityDto;
import in.ashokit.dto.CountryDto;
import in.ashokit.dto.QuoteApiResponse;
import in.ashokit.dto.ResetPwdDto;
import in.ashokit.dto.StateDto;
import in.ashokit.dto.UserDto;
import in.ashokit.entity.CityEntity;
import in.ashokit.entity.CountryEntity;
import in.ashokit.entity.StateEntity;
import in.ashokit.entity.UserEntity;
import in.ashokit.mapper.CityMapper;
import in.ashokit.mapper.CountryMapper;
import in.ashokit.mapper.StateMapper;
import in.ashokit.mapper.UserMapper;
import in.ashokit.repo.CityRepo;
import in.ashokit.repo.CountryRepo;
import in.ashokit.repo.StateRepo;
import in.ashokit.repo.UserRepo;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private CountryRepo countryRepo;

	private StateRepo stateRepo;

	private CityRepo cityRepo;

	private UserRepo userRepo;
	
	private EmailService emailService;

	@Override
	public List<CountryDto> getCountries() {
		
		List<CountryEntity> countries = countryRepo.findAll();
		
		return countries.stream()
						 .map(country -> CountryMapper.convertToDto(country))
						 .toList();
	}

	@Override
	public List<StateDto> getStates(Integer countryId) {
		
		List<StateEntity> states = stateRepo.findByCountryCountryId(countryId);
		
		return states.stream()
					 .map(state -> StateMapper.convertToDto(state))
					 .toList();
	}

	@Override
	public List<CityDto> getCities(Integer stateId) {
		
		List<CityEntity> cities = cityRepo.findByStateStateId(stateId);
		
		return cities.stream()
					 .map(city -> CityMapper.convertToDto(city))
					 .toList();
	}

	@Override
	public UserDto getUserByEmail(String email) {

		Optional<UserEntity> byEmail = userRepo.findByEmail(email);

		if (byEmail.isPresent()) {
			return UserMapper.convertToDto(byEmail.get());
		}

		return null;

	}

	@Override
	public UserDto registerUser(UserDto userDto) {
		
		String randomPwd = generateRandomPwd();
		
		userDto.setPwd(randomPwd);
		userDto.setPwdUpdated("NO");
		
		
		CountryEntity countryEntity = countryRepo.findById(userDto.getCountryId()).orElseThrow();
		StateEntity stateEntity = stateRepo.findById(userDto.getStateId()).orElseThrow();
		CityEntity cityEntity = cityRepo.findById(userDto.getCityId()).orElseThrow();
		
		UserEntity userEntity = UserMapper.covertToEntity(userDto);
		
		userEntity.setCountry(countryEntity);
		userEntity.setState(stateEntity);
		userEntity.setCity(cityEntity);
		
		UserEntity savedUser = userRepo.save(userEntity);

		String subject = "Your Account Created";
		String body = "Your Temporary Login Pwd : " + randomPwd;

		emailService.sendEmail(userDto.getEmail(), subject, body);
		
		return UserMapper.convertToDto(savedUser);
	}

	@Override
	public UserDto login(String email, String pwd) {

		Optional<UserEntity> byEmailAndPwd = userRepo.findByEmailAndPwd(email, pwd);

		if (byEmailAndPwd.isPresent()) {
			UserEntity userEntity = byEmailAndPwd.get();
			return UserMapper.convertToDto(userEntity);
		}

		return null;
	}

	@Override
	public UserDto resetPwd(ResetPwdDto resetPwdDto) {
		
		Optional<UserEntity> byEmail = userRepo.findByEmail(resetPwdDto.getEmail());
		
		if(byEmail.isPresent()) {
			UserEntity userEntity = byEmail.get();
			userEntity.setPwd(resetPwdDto.getNewPwd());
			userEntity.setPwdUpdated("YES");
			
			UserEntity updatedUser = userRepo.save(userEntity); //UPDATE
			
			return UserMapper.convertToDto(updatedUser);
		}
		
		return null;
	}

	@Override
	public QuoteApiResponse getRandomQuote() {
		
		String apiUrl = "https://dummyjson.com/quotes/random";
		
		RestTemplate rt = new RestTemplate();
		
		ResponseEntity<QuoteApiResponse> forEntity =
				rt.getForEntity(apiUrl, QuoteApiResponse.class);
		
		QuoteApiResponse quoteApiResponse = forEntity.getBody();
		
		return quoteApiResponse;
	}

	private String generateRandomPwd() {
		
		StringBuilder sb = new StringBuilder(6);
		
		Random random = new Random();
		
		String chars = "ABCDEFGHIJKLMNPQRSTUVWXYZ123456789";

		for(int i = 0; i< 6; i++) {
			int randomIndex = random.nextInt(chars.length());
			char ch = chars.charAt(randomIndex);
			sb.append(ch);			
		}
		
		return sb.toString();
		
	}
	
}












