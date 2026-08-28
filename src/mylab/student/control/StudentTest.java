package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {
	public static void main(String[] args) {
		//예외발생구간
		try {Student student = new Student();
		
		//setter 메서드 호출해서 Student 값을 변경 요청
		//김민수 / 컴퓨터공학 / 3학년
        student.setStudentId(2026001);
        student.setName("김민수");
        student.setMajor("컴퓨터공학");
        student.setGrade(3);
        
        System.out.println(student.getName() + "/" + student.getMajor() + "/" + student.getGrade()+"학년");
        
        System.out.println("5학년으로 변경");
        student.setGrade(5);        
        
        
		} catch(InvalidGradeException exp) {
			System.out.println(exp.getMessage());
		}

	}
	
}
