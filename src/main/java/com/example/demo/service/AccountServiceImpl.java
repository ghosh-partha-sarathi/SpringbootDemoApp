package com.example.demo.service;

import com.example.demo.dto.CreateNewAccount;
import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService
{
	private AccountRepository accountRepository;
	private CustomerRepository customerRepository;
	private TransactionRepository transactionRepository;
	@Override
	public double getAccountBalance(String accountId) {
		return 0;
	}

	@Override
	@Transactional
	public Account createNewAccount(CreateNewAccount newAccount){
		String accountId = newAccount.accountId();
		long customerId = newAccount.customerId();
		Optional<Customer> customerOpt = customerRepository.findById(customerId);
		if(customerOpt.isEmpty()) {
			System.out.println("Customer with given id does not exist.");
			return null;
		}

		Optional<Account> accountOpt = accountRepository.findById(accountId);
		if(!accountOpt.isEmpty()){
			System.out.println("Account with given id already exists");
			return null;
		}

		Account createdAccount = accountRepository.save(new Account(newAccount.accountId(), newAccount.openingBalance()));
		return createdAccount;
	}
}
