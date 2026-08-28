package mylab.bank.control;

import mylab.bank.entity.Bank;
import mylab.bank.entity.CheckingAccount;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class BankDemo {

	public static void main(String[] args) {
		Bank bank = new Bank();

		//계좌 생성
		System.out.println("=== 계좌 생성 ===");
		SavingsAccount savings1 =	bank.createSavingsAccount("홍길동", 10000, 3.0);
		System.out.println(	"Saving(저축) 계좌가 생성되었습니다: " + savings1);
		CheckingAccount checking =	bank.createCheckingAccount("김철수", 20000, 5000);
		System.out.println("체킹 계좌가 생성되었습니다: " + checking);
		SavingsAccount savings2 =bank.createSavingsAccount("이영희", 30000, 2.0);
		System.out.println("저축 계좌가 생성되었습니다: " + savings2);

		//모든 계좌 출력
		bank.displayAllAccounts();

		//입금, 출금, 이자 적용, 계좌 이체 테스트
		try {
			System.out.println("=== 입금/출금 테스트 ===");

			bank.deposit("AC1000", 5000);
			bank.withdraw("AC1001", 3000);

			System.out.println("=== 이자 적용 테스트 ===");

			savings1.applyInterest();

			System.out.println("=== 계좌 이체 테스트 ===");

			bank.transfer("AC1002", "AC1001", 5000);

			bank.displayAllAccounts();

		}catch(AccountNotFoundException exp) {
			System.out.println(
					"예외 발생: " + exp.getMessage());

		}catch(WithdrawalLimitExceededException exp) {
			System.out.println("예외 발생: " + exp.getMessage()+ exp.getWithdrawalLimit() + "원");

		}catch(InsufficientBalanceException exp) {
			System.out.println("예외 발생: " + exp.getMessage()+ exp.getCurrentBalance() + "원");
		}

		//출금 한도 초과 테스트
		try {
			bank.withdraw("AC1001", 6000);

		}catch(AccountNotFoundException exp) {
			System.out.println("예외 발생: " + exp.getMessage());

		}catch(WithdrawalLimitExceededException exp) {
			System.out.println("예외 발생: " + exp.getMessage()+ exp.getWithdrawalLimit() + "원");

		}catch(InsufficientBalanceException exp) {
			System.out.println("예외 발생: " + exp.getMessage()+ exp.getCurrentBalance() + "원");
		}

		//계좌 이체 시 출금 한도 초과 테스트
		try {
			bank.transfer("AC1001", "AC1000", 6000);

		}catch(AccountNotFoundException exp) {
			System.out.println("예외 발생: " + exp.getMessage());

		}catch(WithdrawalLimitExceededException exp) {
			System.out.println("예외 발생: " + exp.getMessage()+ exp.getWithdrawalLimit() + "원");

		}catch(InsufficientBalanceException exp) {
			System.out.println("예외 발생: " + exp.getMessage()+ exp.getCurrentBalance() + "원");
		}

		//존재하지 않는 계좌 검색 테스트
		try {
			bank.findAccount("AC9999");

		}catch(AccountNotFoundException exp) {
			System.out.println("예외 발생: " + exp.getMessage());
		}
	}
}