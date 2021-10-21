package sa.com.saib.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sa.com.saib.models.Account;
import sa.com.saib.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	public String addAccount(Account a)
	{
		System.out.println("In Service Layer");
		//Validation 
		//Add the account number
		Random r=new Random();
		int accountNumber=r.nextInt(100000);
		a.setAccountNumber(accountNumber);
		System.out.println(a);
		
		String result=accountRepository.addAccount(a);
		
		return result;
		
	}
	
	public List<Account> getAccounts()
	{
		List<Account> accounts=accountRepository.getAccounts();
		return accounts;
	}
	
	public Account getAccountByAccountId(int accountId)
	{
		Account account=accountRepository.getAccountByAccountId(accountId);
		return account;
	}
	
	public String updateAccount(int accountId,Account a)
	{
		String result=accountRepository.updateAccount(accountId, a);
		return result;
	}
	
	public String deleteAccount(int accountId)
	{
		String result=accountRepository.deleteAccount(accountId);
		return result;
	}

}
