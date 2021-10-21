package sa.com.saib.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sa.com.saib.models.Account;

@RestController

public class HelloController {

	
	@RequestMapping(path="/hello",method=RequestMethod.GET)
	public String sayHello()
	{
		return "Hello SAIB";
	}
	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "Welcome to SAIB";
	}

	@GetMapping("/names")
	public List<String> getCountries()
	{
		List<String> countries=new ArrayList<>();
		countries.add("Saudi Arabia");
		countries.add("UAE");
		countries.add("Oman");
		countries.add("Qatar");
		countries.add("Bahrain");
		countries.add("Kuwait");
		
		return countries;
	}
	
	@GetMapping("/myAccount")
	public Account getAccount()
	{
		Account a=new Account();
		a.setAccountNumber(100001);
		a.setName("Zartab Nakhwa");
		a.setBalace(10000);
		a.setNationality("Indian");
		a.setCreditLimit(1000000);
		a.setAccountCreationDate(LocalDate.of(2020,10,25));
		
		return a;
	
	}
	
	@GetMapping("/users/{id}")
	public String testPathVariable(@PathVariable int id)
	{
		String message="User at ID #"+id+" is Tom Smith";
		return message;
	}
	
	@GetMapping("/sayHello")
	public String testRequestParameter(@RequestParam String name)
	{
		return "Hello "+name.toUpperCase();
	}
	
}
