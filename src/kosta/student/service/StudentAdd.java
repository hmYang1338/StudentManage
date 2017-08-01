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
		
		System.out.println("��ȣ : ");
		num = scan.nextInt();
		scan.nextLine();
		System.out.println("�̸� : ");
		name = scan.nextLine();
		System.out.println("�ּ� : ");
		addr = scan.nextLine();
		System.out.println("���� : ");
		gender = scan.nextLine();
		System.out.println("�� : ");
		ban = scan.nextLine();
		System.out.println("Ű : ");
		height = scan.nextInt();
		scan.nextLine();
		System.out.println("���� : ");
		age = scan.nextInt();
		scan.nextLine();
		System.out.println("���� : ");
		score = scan.nextInt();
		scan.nextLine();
		System.out.println("�г� : ");
		year = scan.nextInt();
		
		String c = sm.studentAdd(new Student(num, name, addr, gender, ban, height, age, score, year));
		System.out.println(c);
	}
	
} // end of class
