package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Transaction;

public interface TransactionService
{
	Transaction withdrawMoney(String accountId, Transaction transaction) throws Exception;
	Transaction depositMoney(String accountId, Transaction transaction) throws Exception;
	Transaction transferAmount(String accountId, Transaction transaction) throws Exception;
	List<Transaction> getLatestTransactions(String accountId, int limit) throws Exception;
}
