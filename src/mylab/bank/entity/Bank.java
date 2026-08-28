package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;

import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;


public class Bank {
	//계좌 목록
	private List<Account> accounts;

	//다음 계좌번호
	private int nextAccountNumber;


	public Bank() {
		accounts = new ArrayList<>();
		nextAccountNumber = 1000;
	}

	//저축 계좌 생성
	public SavingsAccount createSavingsAccount(String ownerName, double balance, double interestRate) {

		String accountNumber = "AC" + nextAccountNumber;
		nextAccountNumber++;
		
		SavingsAccount account = new SavingsAccount(accountNumber, ownerName, balance, interestRate);
		accounts.add(account);

		return account;
	}

	//체킹 계좌 생성
	public CheckingAccount createCheckingAccount(String ownerName, double balance, double withdrawalLimit) {

		String accountNumber = "AC" + nextAccountNumber;
		nextAccountNumber++;

		CheckingAccount account = new CheckingAccount(accountNumber, ownerName, balance, withdrawalLimit);
		accounts.add(account);

		return account;
	}

	//계좌번호로 계좌 검색
	public Account findAccount(String accountNumber) throws AccountNotFoundException {
				for (Account account : accounts) {
					if(account.getAccountNumber().equals(accountNumber)) {
						return account;
					}
				}

		//계좌를 찾지 못하면 Exception 발생
		throw new AccountNotFoundException("계좌번호 " + accountNumber	+ "에 해당하는 계좌를 찾을 수 없습니다.");
	}

	//입금
	public void deposit(String accountNumber, double amount)
			throws AccountNotFoundException {

		Account account = findAccount(accountNumber);
		account.deposit(amount);
	}

	//출금
	public void withdraw(String accountNumber, double amount)
			throws AccountNotFoundException,
			InsufficientBalanceException {

		Account account = findAccount(accountNumber);
		account.withdraw(amount);
	}

	//계좌 이체
	public void transfer(String fromAccountNumber,
			String toAccountNumber, double amount)
			throws AccountNotFoundException,
			InsufficientBalanceException {

		Account fromAccount = findAccount(fromAccountNumber);
		Account toAccount = findAccount(toAccountNumber);

		fromAccount.withdraw(amount);
		toAccount.deposit(amount);

		System.out.println(amount + "원이 "+ fromAccountNumber + "에서 "+ toAccountNumber + "로 송금되었습니다.");
	}

	//모든 계좌 목록 반환
	public List<Account> getAccounts() {
		return accounts;
	}

	//모든 계좌 정보 출력
	public void displayAllAccounts() {
		System.out.println("=== 모든 계좌 목록 ===");

		for (Account account : accounts) {
			System.out.println(account);
		}

		System.out.println("===================");
	}
}