package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Transaction;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService
{
	private TransactionRepository transactionRepository;
	private AccountRepository accountRepository;

	@Override
	@Transactional
	public Transaction withdrawMoney(String accountId, Transaction transaction) throws Exception {
		Transaction savedTransaction = null;
		try {
			savedTransaction = transactionRepository.save(transaction);
		} catch (Exception exp) {
			throw new Exception(exp.getCause());
		}
		return savedTransaction;
	}

	@Override
	@Transactional
	public Transaction depositMoney(String accountId, Transaction transaction) throws Exception {
		Transaction savedTransaction = null;
		try {
			Account curAccountObj = accountRepository.getById(accountId);
			curAccountObj.setBalance(curAccountObj.getBalance()+transaction.getAmount());
			accountRepository.save(curAccountObj);
			savedTransaction = transactionRepository.save(transaction);
		} catch (Exception exp) {
			throw new Exception(exp.getCause());
		}
		return savedTransaction;
	}

	@Override
	@Transactional
	public Transaction transferAmount(String accountId, Transaction transaction) throws Exception {
		Transaction savedTransaction = null;
		try {
			savedTransaction = transactionRepository.save(transaction);
		} catch (Exception exp) {
			System.err.println("Transfer amount failed.");
			throw new Exception(exp.getCause());
		}
		return savedTransaction;
	}

	@Override
	@Transactional
	public List<Transaction> getLatestTransactions(String accountId, int limit) throws Exception {
		List<Transaction> latestTransactionList = null;
		try {
			latestTransactionList = transactionRepository
					.findTop10ByAccountIdOrderByTxnTimestampDesc(accountId);
		} catch (Exception exp) {
			System.err.println("Failed to retrieve latest transaction details.");
			throw new Exception(exp.getCause());
		}
		return latestTransactionList;
	}
}
