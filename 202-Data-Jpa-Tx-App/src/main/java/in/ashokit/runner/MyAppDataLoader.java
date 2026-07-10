package in.ashokit.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import in.ashokit.entity.BankAccount;
import in.ashokit.repo.BankAccountRepository;
import in.ashokit.service.BankService;

@Component
public class MyAppDataLoader implements CommandLineRunner {

	@Autowired
	private BankAccountRepository bankAccountRepo;

	@Autowired
	private BankService bankService;

	@Override
	public void run(String... args) throws Exception {

		BankAccount acc1 = new BankAccount("Ashok", 50000.00);
		BankAccount acc2 = new BankAccount("John", 10000.00);

		bankAccountRepo.save(acc1);
		bankAccountRepo.save(acc2);

		System.out.println("Before Transaction:");
		List<BankAccount> beforeList = bankAccountRepo.findAll();
		beforeList.forEach(System.out::println);

		try {
			bankService.transferMoney(1, 2, 5000.00);
		} catch (Exception e) {
			System.out.println("Exception Message: " + e.getMessage());
		}

		System.out.println("After Transaction:");

		int pageNumber = 1;
		int pageSize = 3;

		PageRequest of = PageRequest.of(pageNumber - 1, pageSize);

		Page<BankAccount> all = bankAccountRepo.findAll(of);
		List<BankAccount> afterList = all.getContent();

		afterList.forEach(System.out::println);

	}
}
