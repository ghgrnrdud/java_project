package ex1;

import java.util.Scanner;

public class StudentEx1 {
	Scanner keyin = new Scanner(System.in);

	public static void main(String[] args) {
		StudentEx2 student = new StudentEx2();
		StudentEx1 hehe = new StudentEx1();
		
		//student.setName("홍길동");
		System.out.print("이름을 입력해주세요 : ");
		String n = hehe.keyin.next();
		System.out.print("학과를 입력해주세요 : ");
		String nn = hehe.keyin.next();		
		
		student.output();
		student.setName(n);
		student.setId(nn);
		student.output();
		
	}

}
