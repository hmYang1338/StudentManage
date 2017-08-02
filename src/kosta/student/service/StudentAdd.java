package kosta.student.service;

import java.util.Scanner;

import kosta.student.manage.StudentManager;
import kosta.student.vo.Student;

/** �л����� �߰� */
public class StudentAdd implements StudentService {
	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub
		
		StudentManager sm = new StudentManager();
		
		int num, age, score, year;
		double height;
		String name, addr, gender, ban;
		
		System.out.print("��ȣ : ");
		num = scan.nextInt();
		scan.nextLine();
		System.out.print("�̸� : ");
		name = scan.nextLine();
		System.out.print("�ּ� : ");
		addr = scan.nextLine();
		System.out.print("���� : ");
		gender = scan.nextLine();
		System.out.print("�� : ");
		ban = scan.nextLine();
		System.out.print("Ű : ");
		height = scan.nextInt();
		scan.nextLine();
		System.out.print("���� : ");
		age = scan.nextInt();
		scan.nextLine();
		System.out.print("���� : ");
		score = scan.nextInt();
		scan.nextLine();
		System.out.print("�г� : ");
		year = scan.nextInt();
		
		boolean c = sm.add(new Student(num, name, addr, gender, ban, height, age, score, year));
		
		if(c){
			System.out.println("�л���� �Ϸ�");
		}else {
			System.out.println("�л���� ����");
		}

	}
	
} // end of class
