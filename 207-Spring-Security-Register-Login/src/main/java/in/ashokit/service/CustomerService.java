package in.ashokit.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Customer;
import in.ashokit.repo.CustomerRepo;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

	private CustomerRepo repo;

	private PasswordEncoder pwdEncoder;

	private AuthenticationManager authManager;

	public Customer saveCustomer(Customer customer) {

		String encodedPwd = pwdEncoder.encode(customer.getPwd());

		customer.setPwd(encodedPwd);

		return repo.save(customer);
	}

	public Customer login(Customer customer) {

		UsernamePasswordAuthenticationToken token = 
				new UsernamePasswordAuthenticationToken(customer.getEmail(), customer.getPwd());

		try {
			Authentication authentication = authManager.authenticate(token);
			if (authentication.isAuthenticated()) {
				return repo.findByEmail(customer.getEmail());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
