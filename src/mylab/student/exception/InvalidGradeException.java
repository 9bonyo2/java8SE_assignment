package mylab.student.exception;

//학년 값이 1~4를 벗어났을 때 예외 처리
public class InvalidGradeException extends Exception {

	//생성자 만들기
	public InvalidGradeException(String errorMessage) {
		super(errorMessage);
	}
	
}
