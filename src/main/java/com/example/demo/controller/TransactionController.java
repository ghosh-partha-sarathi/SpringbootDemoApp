package com.example.demo.controller;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Transaction;
import com.example.demo.entity.ResponseEntity;
import com.example.demo.service.TransactionService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/v1/transaction")
@AllArgsConstructor
public class TransactionController<T> {
	private TransactionService transactionService;
	
	@RequestMapping(method = RequestMethod.POST, path = "/withdraw/{accountId}")
	public ResponseEntity<Transaction> withdrawMoney( @PathVariable("accountId") String accountId,
												   @Valid @ModelAttribute("transaction")Transaction transaction,
												   BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			System.out.println("Total count of errors are = "+bindingResult.getErrorCount());
			return new ResponseEntity<Transaction>(400, "FAILURE", "Validation failed.", null);
		}
		
		try {
			Transaction txn = transactionService.withdrawMoney(accountId, transaction);
			return new ResponseEntity<Transaction>(200, "SUCCESS", "Withdrawal successful.", txn);
		} catch(Exception exp) {
			exp.printStackTrace();
			return new ResponseEntity<Transaction>(500, "FAILED", "Internal server error.", null);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/deposit/{accountId}")
	public ResponseEntity<Transaction> depositMoney( @PathVariable("accountId") String accountId,
													 @Valid @RequestBody Transaction transaction,
													 BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			System.out.println("Total count of errors are = "+bindingResult.getErrorCount());
			return new ResponseEntity<Transaction>(400, "FAILURE", "Validation failed.", null);
		}
		
		try {
			Transaction txn = transactionService.depositMoney(accountId, transaction);
			return new ResponseEntity<Transaction>(200, "SUCCESS", "Amount successfully deposited.", txn);
		} catch(Exception exp) {
			exp.printStackTrace();
			return new ResponseEntity<Transaction>(500, "FAILED", "Internal server error.", null);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/transfer/{accountId}")
	public ResponseEntity<Transaction> transferMoney( @PathVariable("accountId") String accountId,
													  @Valid @ModelAttribute("transaction")Transaction transaction,
													  BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			System.out.println("Total count of errors are = "+bindingResult.getErrorCount());
			return new ResponseEntity<Transaction>(400, "FAILURE", "Validation failed.", null);
		}
		
		try {
			Transaction txn = transactionService.transferAmount(accountId, transaction);
			return new ResponseEntity<Transaction>(200, "SUCCESS", "Amount successfully transferred.", txn);
		} catch(Exception exp) {
			exp.printStackTrace();
			return new ResponseEntity<Transaction>(500, "FAILED", "Internal server error.", null);
		}	
	}
		
	@GetMapping("/latest/{accountId}" )
	public ResponseEntity<T> showLatestTransactions( @PathVariable("accountId") String accountId)
	{
		try {
			int limit = 10;
			List<Transaction> listTransaction = transactionService.getLatestTransactions(accountId, limit);
			if(!listTransaction.isEmpty() && listTransaction.size()>0) {
				return (ResponseEntity<T>) new ResponseEntity<List<Transaction>>(200, "SUCCESS", "Latest transaction details received successfully.", listTransaction);
			} else {
				return new ResponseEntity<T>(300, "FAILED", "No transaction records found for given account number.", null);
			}
		} catch(Exception exp) {
			exp.printStackTrace();
			return new ResponseEntity<T>(500, "FAILED", "Internal server error.", null);
		}		
	}
}
