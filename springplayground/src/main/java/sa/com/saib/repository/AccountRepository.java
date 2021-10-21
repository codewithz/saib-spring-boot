package sa.com.saib.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import sa.com.saib.models.Account;

@Repository
public class AccountRepository {
	
	
	
	public String addAccount(Account a)
	{
		System.out.println("In Repository");
		AccountDataHolder.getAccounts().add(a);
		
		//System.out.println(AccountDataHolder.getAccounts());
		return "SUCCESS";
	}
	
	public List<Account> getAccounts()
	{
		List<Account> accounts=AccountDataHolder.getAccounts();
		return accounts;
	}
	
	public Account getAccountByAccountId(int accountId)
	{
		Account account=null;
		List<Account> accountsList=AccountDataHolder.getAccounts();
		
		for(Account a:accountsList)
		{
			if(a.getAccountNumber()==accountId)
			{
				account=a;
				break;
			}
		}
		
		return account;
	}
	
	public String updateAccount(int accountId,Account a)
	{
		String result="";
		Account account=null;
		
		List<Account> accountsList=AccountDataHolder.getAccounts();
		
		for(Account a1:accountsList)
		{
			if(a1.getAccountNumber()==accountId)
			{
				account=a1;
				break;
			}
	 
		}
		if(account!=null)
		{
			accountsList.remove(account);
			accountsList.add(a);
			result="SUCCESS";
		}
		else
		{
			result="FAILURE";
		}
		return result;
	}
	
	public String deleteAccount(int accountId)
	{
		String result="";
		Account account=null;
		
		List<Account> accountsList=AccountDataHolder.getAccounts();
		
		for(Account a1:accountsList)
		{
			if(a1.getAccountNumber()==accountId)
			{
				account=a1;
				break;
			}
	
		}
		if(account!=null)
		{
			accountsList.remove(account);
			result="SUCCESS";
		}
		else
		{
			result="FAILURE";
		}
		return result;
	}


}
