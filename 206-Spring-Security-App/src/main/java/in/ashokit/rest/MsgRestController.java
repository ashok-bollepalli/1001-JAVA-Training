package in.ashokit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {

	@GetMapping("/welcome")
	public String welcomeMsg() {
		return "Welcome to REST APIs";
	}

	@GetMapping("/greet")
	public String greet() {
		return "Good afternoon";
	}

	@GetMapping("/contact")
	public String contact() {
		return "Whatsapp : 9985396677";
	}

}
