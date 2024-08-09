package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.entity.ResponseEntity;
import com.example.demo.exceptions.CustomerAlreadyExistsException;
import com.example.demo.service.AccountService;
import com.example.demo.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController<T> {
	private CustomerService customerService;
	private AccountService accountService;

	@RequestMapping(method = RequestMethod.POST, path = "/create")
	public ResponseEntity<T> createCustomer(@Valid @RequestBody Customer customer,
													BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			System.out.println("Total count of errors are = "+bindingResult.getErrorCount());
			return new ResponseEntity(400, "FAILURE", "Validation failed.", null);
		}

		try {
			Customer createdCustomer = customerService.createCustomer(customer);
			return new ResponseEntity(200, "SUCCESS", "Customer successfully created.", createdCustomer);
		} catch(CustomerAlreadyExistsException customerAlreadyExistsException) {
			String msg=customerAlreadyExistsException.getMessage();
			System.out.println(msg);
			return new ResponseEntity(400, "FAILED", "Duplicate record.", customerAlreadyExistsException.getMessage());
		} catch(Exception exp) {
			exp.printStackTrace();
			return new ResponseEntity(500, "FAILED", "Internal server error.", exp.getMessage());
		}
	}
}
