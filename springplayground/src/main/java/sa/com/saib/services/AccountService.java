package sa.com.saib.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
		try {
		List<Account> accounts=accountRepository.getAccounts();
		if(accounts.size()>0)
		{
		return accounts;
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No Accounts Found");
		}
		}
		catch (Exception e) {
			if(e instanceof ResponseStatusException) {
				throw e;
			}
			else
			{
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
			}
		}
	}
	
	public Account getAccountByAccountId(int accountId)
	{
		try {
		Account account=accountRepository.getAccountByAccountId(accountId);
		if(account!=null) {
		return account;
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account doesn't exist");
		}
		}
		catch (Exception e) {
			if(e instanceof ResponseStatusException) {
				throw e;
			}
			else
			{
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
			}
		}
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
