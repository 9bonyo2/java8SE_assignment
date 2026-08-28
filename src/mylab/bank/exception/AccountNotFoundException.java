package mylab.bank.exception;

public class AccountNotFoundException extends Exception {

	//생성자 만들기
	public AccountNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}