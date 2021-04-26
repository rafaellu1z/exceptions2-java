package model.entities;

import model.exceptions.AccountException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance = 0.0;
	private Double withdrawLimit;
	
	public Account() {
	}
	
	public Account(Integer number, String holder, Double initialBalance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.withdrawLimit = withdrawLimit;
		deposit(initialBalance);
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	public void withdraw(double amount) {
		if (amount > this.balance) {
			throw new AccountException("Not enough balance");
		} 
		if (amount > this.withdrawLimit) {
			throw new AccountException("The amount exceeds withdraw limit");
		}
		this.balance -= amount;
	}
	
}
