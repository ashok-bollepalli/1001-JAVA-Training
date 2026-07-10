package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer>{

}
