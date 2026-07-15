package in.ashokit.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import in.ashokit.entity.Customer;
import in.ashokit.repo.CustomerRepo;

@Component
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private CustomerRepo repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Customer c = repo.findByEmail(email);
		return new User(c.getEmail(), c.getPwd(), Collections.emptyList());
	}

}




