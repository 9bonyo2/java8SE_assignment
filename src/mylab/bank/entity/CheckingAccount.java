package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {

	private double withdrawalLimit;

	public CheckingAccount() {
	}

	public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
		super(accountNumber, ownerName, balance);
		this.withdrawalLimit = withdrawalLimit;
	}

	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}

	public void setWithdrawalLimit(double withdrawalLimit) {
		this.withdrawalLimit = withdrawalLimit;
	}

	//출금
	@Override
	public void withdraw(double amount)
			throws InsufficientBalanceException {

		if(amount > withdrawalLimit) {
			//예외 강제 발생시킴
			throw new WithdrawalLimitExceededException("출금 한도를 초과했습니다. 한도: ", getBalance(), this.withdrawalLimit);
		}

		super.withdraw(amount);
	}

	@Override
	public String toString() {
		return super.toString()	+ ", 출금 한도: " + withdrawalLimit + "원";
	}
}