package sa.com.saib.models;

import java.time.LocalDate;

public class Account {
	
	private int accountNumber;
	private String name;
	private String nationality;
	private double balace;
	private double creditLimit;
	private LocalDate accountCreationDate;
	
	public Account() {
		super();
	}

	public Account(String name, String nationality, double balace, double creditLimit, LocalDate accountCreationDate) {
		super();
		this.name = name;
		this.nationality = nationality;
		this.balace = balace;
		this.creditLimit = creditLimit;
		this.accountCreationDate = accountCreationDate;
	}

	public Account(int accountNumber, String name, String nationality, double balace, double creditLimit,
			LocalDate accountCreationDate) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.nationality = nationality;
		this.balace = balace;
		this.creditLimit = creditLimit;
		this.accountCreationDate = accountCreationDate;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public double getBalace() {
		return balace;
	}

	public void setBalace(double balace) {
		this.balace = balace;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public LocalDate getAccountCreationDate() {
		return accountCreationDate;
	}

	public void setAccountCreationDate(LocalDate accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", nationality=" + nationality
				+ ", balace=" + balace + ", creditLimit=" + creditLimit + ", accountCreationDate=" + accountCreationDate
				+ "]";
	}
	
	
	
	

}
