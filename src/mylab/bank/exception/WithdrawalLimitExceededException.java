package mylab.bank.exception;

public class WithdrawalLimitExceededException extends InsufficientBalanceException {
	//출금한도
	private double withdrawalLimit;

	//생성자 만들기
	public WithdrawalLimitExceededException(String errorMessage,
			double currentBalance, double withdrawalLimit) {
		super(errorMessage, currentBalance);
		this.withdrawalLimit = withdrawalLimit;
	}

	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}
}