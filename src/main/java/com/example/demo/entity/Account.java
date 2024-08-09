package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="accounts")
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	
	@Id
	@NotNull
    private String id;
	
    private double balance;

//	@OneToOne(mappedBy = "customers")
//	private Customer customer;
    
	public Account(String accountId) {
		this.id = accountId;
		this.balance = 0.0;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Account [accountId=" + id + ", balance=" + balance + "]";
	}
}