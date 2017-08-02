package kosta.student.service;

import java.util.Scanner;

import kosta.student.manage.StudentManager;
import kosta.student.vo.Student;

/** 학생정보 추가 */
public class StudentAdd implements StudentService {
	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub
		
		StudentManager sm = new StudentManager();
		
		int num, age, score, year;
		double height;
		String name, addr, gender, ban;
		
		System.out.print("번호 : ");
		num = scan.nextInt();
		scan.nextLine();
		System.out.print("이름 : ");
		name = scan.nextLine();
		System.out.print("주소 : ");
		addr = scan.nextLine();
		System.out.print("성별 : ");
		gender = scan.nextLine();
		System.out.print("반 : ");
		ban = scan.nextLine();
		System.out.print("키 : ");
		height = scan.nextInt();
		scan.nextLine();
		System.out.print("나이 : ");
		age = scan.nextInt();
		scan.nextLine();
		System.out.print("성적 : ");
		score = scan.nextInt();
		scan.nextLine();
		System.out.print("학년 : ");
		year = scan.nextInt();
		
		boolean c = sm.add(new Student(num, name, addr, gender, ban, height, age, score, year));
		
		if(c){
			System.out.println("학생등록 완료");
		}else {
			System.out.println("학생등록 실패");
		}

	}
	
} // end of class
