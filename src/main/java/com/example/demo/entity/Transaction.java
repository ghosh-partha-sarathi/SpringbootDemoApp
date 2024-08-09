package com.example.demo.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="transactions")
@NoArgsConstructor
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "account_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
    private Account account;
	
	@NotNull
    private String txnType; // (Debit/Credit)

	@NotNull
    private String txnParty;

	@NotNull
    private String txnMode;  // (NEFT/ATM/UPI etc.)

    private double amount;

    private LocalDate txnTimestamp;
    
	public Transaction(String txnType, String txnParty, String txnMode, double amount) {
		this.txnType = txnType;
		this.txnParty = txnParty;
		this.txnMode = txnMode;
		this.amount = amount;
		this.txnTimestamp = LocalDate.now();
	}

	public String getTxnType() {
		return txnType;
	}

	public String getTxnParty() {
		return txnParty;
	}

	public String getTxnMode() {
		return txnMode;
	}

	public double getAmount() {
		return amount;
	}

	public LocalDate getTxnTimestamp() {
		return txnTimestamp;
	}
	
	@Override
	public String toString() {
		return "Transaction [ txnType=" + txnType + ", txnParty=" + txnParty + ", txnMode=" + txnMode + ", amount="
				+ amount + ", txnTimestamp=" + txnTimestamp + "]";
	}

}