package kosta.student.service;

import java.util.Scanner;

import kosta.student.manage.StudentManager;
import kosta.student.vo.Student;


public class StudentAdd implements StudentService {
	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub
		
		StudentManager sm = new StudentManager();
		
		int num, age, score, year;
		double height;
		String name, addr, gender, ban;
		
		System.out.println("번호 : ");
		num = scan.nextInt();
		scan.nextLine();
		System.out.println("이름 : ");
		name = scan.nextLine();
		System.out.println("주소 : ");
		addr = scan.nextLine();
		System.out.println("성별 : ");
		gender = scan.nextLine();
		System.out.println("반 : ");
		ban = scan.nextLine();
		System.out.println("키 : ");
		height = scan.nextInt();
		scan.nextLine();
		System.out.println("나이 : ");
		age = scan.nextInt();
		scan.nextLine();
		System.out.println("성적 : ");
		score = scan.nextInt();
		scan.nextLine();
		System.out.println("학년 : ");
		year = scan.nextInt();
		
		String c = sm.studentAdd(new Student(num, name, addr, gender, ban, height, age, score, year));
		System.out.println(c);
	}
	
} // end of class
