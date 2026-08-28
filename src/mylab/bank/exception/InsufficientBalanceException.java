package mylab.bank.exception;


public class InsufficientBalanceException extends Exception {
	//현재잔액
	private double currentBalance;

	//생성자 만들기
	public InsufficientBalanceException(String errorMessage, double currentBalance) {
		super(errorMessage);
		this.currentBalance = currentBalance;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}
}