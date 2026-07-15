package in.ashokit.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Customer;
import in.ashokit.service.CustomerService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CustomerRestController {

	private CustomerService customerService;

	@PostMapping("/register")
	public ResponseEntity<Customer> register(@RequestBody Customer customer) {

		Customer savedCustomer = customerService.saveCustomer(customer);

		return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Customer customer) {

		Customer loggedInCustomer = customerService.login(customer);

		if (loggedInCustomer != null) {
			return new ResponseEntity<>(loggedInCustomer, HttpStatus.OK);
		}

		return new ResponseEntity<>("Invalid Credentials", HttpStatus.UNAUTHORIZED);
	}

}
