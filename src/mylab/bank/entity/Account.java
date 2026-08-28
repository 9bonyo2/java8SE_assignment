package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

//추상 클래스
public abstract class Account {
	private String accountNumber;
	private String ownerName;
	private double balance;

	//기본생성자
	public Account() {
		
	}

	//생성자 중복정의(오버로딩)
	public Account(String accountNumber, String ownerName, double balance) {
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public double getBalance() {
		return balance;
	}

	//입금
	public void deposit(double amount) {
		//this.balance = this.balance + amount;
		this.balance += amount;

		System.out.println(amount + "원이 입금되었습니다. 현재 잔액: "+ this.balance + "원");
	}

	//출금
	public void withdraw(double amount) throws InsufficientBalanceException {
		if(amount > balance) {
			//Exception을 강제로 발생시킴
			throw new InsufficientBalanceException("잔액이 부족합니다. 현재 잔액은 ", this.balance);
		}

		this.balance -= amount;

		System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + this.balance + "원");
	}

	@Override
	public String toString() {
		return "계좌번호: " + accountNumber + ", 소유자: " + ownerName + ", 잔액: " + balance + "원";
	}
}