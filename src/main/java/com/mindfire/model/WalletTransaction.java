package com.mindfire.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the wallet_transactions database table.
 * 
 */
@Entity
@Table(name="wallet_transactions")
@NamedQuery(name="WalletTransaction.findAll", query="SELECT w FROM WalletTransaction w")
public class WalletTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="transaction_id")
	private Integer transactionId;

	private double amount;

	private String mode;

	@Column(name="transcation_time")
	private Timestamp transcationTime;

	private String type;

	@Column(name="wallet_id")
	private String walletId;

	public WalletTransaction() {
	}

	public Integer getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getMode() {
		return this.mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Timestamp getTranscationTime() {
		return this.transcationTime;
	}

	public void setTranscationTime(Timestamp transcationTime) {
		this.transcationTime = transcationTime;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWalletId() {
		return this.walletId;
	}

	public void setWalletId(String walletId) {
		this.walletId = walletId;
	}

}