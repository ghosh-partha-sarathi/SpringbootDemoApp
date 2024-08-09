package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.exceptions.CustomerAlreadyExistsException;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService
{
	private CustomerRepository customerRepository;
	private AccountRepository accountRepository;

	@Override
	@Transactional
	public Customer createCustomer(Customer customer) throws CustomerAlreadyExistsException {
		Customer createdCustomer = null;

		Optional<Customer> existingCustomerOpt = customerRepository.findByEmail(customer.getEmail());
		if(existingCustomerOpt.isEmpty()){
			createdCustomer = customerRepository.save(customer);
		} else {
			throw new CustomerAlreadyExistsException("Customer with given email id already exists.");
		}
		return createdCustomer;
	}
}
