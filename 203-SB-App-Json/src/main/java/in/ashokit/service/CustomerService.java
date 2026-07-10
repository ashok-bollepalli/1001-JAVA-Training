package in.ashokit.service;

import java.io.File;

import org.springframework.stereotype.Service;

import in.ashokit.model.Customer;
import tools.jackson.databind.ObjectMapper;

@Service
public class CustomerService {

	public void javaToJson() {

		Customer c1 = new Customer();
		c1.setId(101);
		c1.setName("Ashok");
		c1.setPhno(7979799l);

		ObjectMapper mapper = new ObjectMapper();

		// serialization
		mapper.writeValue(System.out, c1);

		File f = new File("customer.json");
		mapper.writeValue(f, c1);

		System.out.println("JSON Created...");

	}

	public void jsonToJava() {

		ObjectMapper mapper = new ObjectMapper();

		Customer customer = mapper.readValue(new File("customer.json"), Customer.class);

		System.out.println(customer);

	}

}
