package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.ashokit.entity.BankAccount;
import in.ashokit.repo.BankAccountRepository;

@Service
public class BankService {

	@Autowired
	private BankAccountRepository bankAccountRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	public void transferMoney(Integer fromAccountId, Integer toAccountId, Double amount) {

		BankAccount fromAccount = bankAccountRepository.findById(fromAccountId)
				.orElseThrow(() -> new RuntimeException("From Account Not Found"));
		
		if(fromAccount.getBalance() < amount ) {
			throw new RuntimeException("Insufficient Balance");
		}		
		
		fromAccount.setBalance(fromAccount.getBalance() - amount);
		bankAccountRepository.save(fromAccount);
		
        System.out.println("Amount debited from: " + fromAccount.getAccountHolderName());
        
        if(true) {
        	throw new RuntimeException("Something went wrong");
        }
		
		BankAccount toAccount = bankAccountRepository.findById(toAccountId)
				.orElseThrow(() -> new RuntimeException("To Account Not Found"));

		toAccount.setBalance(toAccount.getBalance() + amount);
		bankAccountRepository.save(toAccount);
		
        System.out.println("Amount credited to: " + toAccount.getAccountHolderName());		
		
	}
}










