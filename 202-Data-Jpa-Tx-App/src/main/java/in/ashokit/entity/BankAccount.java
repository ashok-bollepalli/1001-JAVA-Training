package in.ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountId;

	private String accountHolderName;

	private Double balance;

	public BankAccount() {
		// TODO Auto-generated constructor stub
	}

	public BankAccount(String accountHolderName, Double balance) {
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}

}
