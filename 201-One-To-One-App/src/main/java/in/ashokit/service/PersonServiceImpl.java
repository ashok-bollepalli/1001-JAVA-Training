package in.ashokit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Passport;
import in.ashokit.entity.Person;
import in.ashokit.repo.PassportRepository;
import in.ashokit.repo.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepo;

	@Autowired
	private PassportRepository passportRepo;

	@Override
	public Passport savePassport(Passport passport) {

		Person person = passport.getPerson();
		Person savedPerson = personRepo.save(person);

		passport.setPerson(savedPerson);

		return passportRepo.save(passport);
	}

	@Override
	public List<Person> getAllPersons() {
		return personRepo.findAll();
	}

	@Override
	public List<Passport> getAllPassports() {
		return passportRepo.findAll();
	}

	@Override
	public Passport getPassport(Integer passportId) {
		return passportRepo.findById(passportId).orElseThrow();
	}

	@Override
	public Person getPerson(Integer personId) {
		return personRepo.findById(personId).orElseThrow();
	}

}
