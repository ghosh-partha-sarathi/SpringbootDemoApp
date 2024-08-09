package com.example.demo.controller;

import com.example.demo.dto.CreateNewAccount;
import com.example.demo.entity.Account;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.ResponseEntity;
import com.example.demo.service.AccountService;
import com.example.demo.service.AccountServiceImpl;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController<T> {
	private AccountService accountService;	
	
	public AccountController() 
	{
		this.accountService = new AccountServiceImpl();
	}

	@PostMapping("/create")
	public ResponseEntity<T> createAccount(@RequestBody CreateNewAccount newAccount) {
		Account createdAccount=null;
		try {
			return new ResponseEntity(200, "SUCCESS", "New account created successfully.", createdAccount);
		} catch(Exception exp) {
			exp.printStackTrace();
			return new ResponseEntity(500, "FAILED", "Internal server error.", null);
		}
	}

	@GetMapping("/balance/{accountId}")
	public ResponseEntity<Double> getBalance(@PathVariable("accountId") String accountId) {
		try {
			Double balance = accountService.getAccountBalance(accountId);
			return new ResponseEntity<Double>(200, "SUCCESS", "Successfully retrieved account balance.", balance);
		} catch(Exception exp) {
			exp.printStackTrace();
			return new ResponseEntity<Double>(500, "FAILED", "Internal server error.", 0.0);
		}
	}
}
