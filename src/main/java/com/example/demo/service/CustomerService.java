package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.exceptions.CustomerAlreadyExistsException;

public interface CustomerService
{
	Customer createCustomer(Customer customer) throws CustomerAlreadyExistsException;
}
