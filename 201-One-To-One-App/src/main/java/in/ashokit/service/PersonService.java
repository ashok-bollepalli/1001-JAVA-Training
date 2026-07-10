package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.Passport;
import in.ashokit.entity.Person;

public interface PersonService {

	public Passport savePassport(Passport passport);

	public List<Person> getAllPersons();

	public List<Passport> getAllPassports();

	public Passport getPassport(Integer passportId);

	public Person getPerson(Integer personId);

}
