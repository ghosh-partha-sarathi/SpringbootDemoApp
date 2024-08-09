package com.example.demo.service;

import com.example.demo.dto.CreateNewAccount;
import com.example.demo.entity.Account;

public interface AccountService
{
	double getAccountBalance(String accountId);
	Account createNewAccount(CreateNewAccount newAccount);
}
