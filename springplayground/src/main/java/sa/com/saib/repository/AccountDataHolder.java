package sa.com.saib.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import sa.com.saib.models.Account;

public class AccountDataHolder {
	
	static List<Account> accounts=new ArrayList<>();

	public static List<Account> getAccounts() {
		return accounts;
	}
	
	static {
		
		Account a1=new Account(100001,"Tom", "US", 100000, 100000, LocalDate.of(2021, 10, 10));
		Account a2=new Account(100002,"Abdulaziz", "Saudi", 200000, 1000000, LocalDate.of(2020, 05, 23));
		Account a3=new Account(100003,"Saad", "Saudi", 23012, 500000, LocalDate.of(2019, 01, 04));
		
		accounts.add(a1);
		accounts.add(a2);
		accounts.add(a3);
	}

	
	
	
}
