package sa.com.saib.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sa.com.saib.config.APISuccessPayload;
import sa.com.saib.models.Account;
import sa.com.saib.services.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;

		@PostMapping("/accounts")
		public ResponseEntity<APISuccessPayload> addAccount(@RequestBody  Account a)
		{
			String result=accountService.addAccount(a);
			
			/*
			 * APISuccessPayload payload=new APISuccessPayload(); payload.setStatus(201);
			 * payload.setHttpStatus(String.valueOf(HttpStatus.CREATED));
			 * payload.setMessage(result); payload.setBody(result);
			 * payload.setSuccess(true); payload.setException(false);
			 */
			HttpStatus status=HttpStatus.CREATED;
			APISuccessPayload payload=APISuccessPayload.build(result, result, status);
			
			ResponseEntity<APISuccessPayload> response=
					new ResponseEntity<>(payload,status);
			return response;
			
		}
		
		@GetMapping("/accounts")
		public ResponseEntity<APISuccessPayload> getAccounts()
		{
			List<Account> accounts=accountService.getAccounts();
			HttpStatus status=HttpStatus.OK;
			APISuccessPayload payload=APISuccessPayload.build(accounts,"Account found successfully",status);
			ResponseEntity<APISuccessPayload> response=
										new ResponseEntity<>(payload, status);
			return response;
			
			
		}
		
		@GetMapping("/accounts/{accountId}")
		public ResponseEntity<APISuccessPayload> getAccountByAccountId(@PathVariable int accountId)
		{
			Account account=accountService.getAccountByAccountId(accountId);
			APISuccessPayload payload=APISuccessPayload.build(account,"Account Found",HttpStatus.OK);
			ResponseEntity<APISuccessPayload> response=
						new ResponseEntity<APISuccessPayload>(payload, HttpStatus.OK);
			return response;
		}
	
	
}
