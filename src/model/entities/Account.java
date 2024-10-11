package model.entities;

import model.exceptions.DomainExeptions;

public class Account {
	private Integer number;
	private String Holder;
	private Double balance;
	private Double withdrawLimit;

	public Account() {

	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.Holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return Holder;
	}

	public void setHolder(String holder) {
		Holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public void deposit(Double amount) {
		balance += amount;

	}

	public void withdraw(Double amount) {
		exeptions(amount);
		balance -= amount;
	}

	private void exeptions(Double amount) {
		if (getBalance() < amount) {
			throw new DomainExeptions("saque maior que a conta bancaria");
		}
		if (getWithdrawLimit() < amount) {
			throw new DomainExeptions("saque alto de mais");
		}

	}
}
