package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Passport;
import in.ashokit.entity.Person;
import in.ashokit.model.ApiResponse;
import in.ashokit.service.PersonService;

@RestController
public class PersonRestController {

	@Autowired
	private PersonService personService;

	@PostMapping("/passport")
	public ResponseEntity<ApiResponse<Passport>> savePassport(@RequestBody Passport p) {

		Passport savePassport = personService.savePassport(p);

		ApiResponse<Passport> response = new ApiResponse<>();
		response.setStatusCode(201);
		response.setMessage("Passport Saved");
		response.setData(savePassport);

		return new ResponseEntity<>(response, HttpStatus.CREATED);

	}

	@GetMapping("/passport/{passportId}")
	public ResponseEntity<ApiResponse<Passport>> getPassport(@PathVariable Integer passportId) {

		Passport passport = personService.getPassport(passportId);

		ApiResponse<Passport> response = new ApiResponse<>();
		response.setStatusCode(200);
		response.setMessage("Passport fetched");
		response.setData(passport);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/person/{personId}")
	public ResponseEntity<ApiResponse<Person>> getPerson(@PathVariable Integer personId) {

		Person person = personService.getPerson(personId);

		ApiResponse<Person> response = new ApiResponse<>();
		response.setStatusCode(200);
		response.setMessage("person fetched");
		response.setData(person);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
