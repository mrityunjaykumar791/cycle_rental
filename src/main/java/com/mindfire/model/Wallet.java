package com.mindfire.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the wallets database table.
 * 
 */
@Entity
@Table(name="wallets")
@NamedQuery(name="Wallet.findAll", query="SELECT w FROM Wallet w")
public class Wallet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="wallet_id")
	private Integer walletId;

	private double balance;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Wallet() {
	}

	public Integer getWalletId() {
		return this.walletId;
	}

	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}