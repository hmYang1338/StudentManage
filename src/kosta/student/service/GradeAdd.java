package kosta.student.service;

import java.util.Scanner;

import kosta.student.manage.StudentManager;

public class GradeAdd implements StudentService {

	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub
		
		StudentManager sm = new StudentManager();
		
		int num, score;
		
		System.out.println("��ȣ : ");
		num = scan.nextInt();
		System.out.println("���� : ");
		score = scan.nextInt();
		
		
	}

}
