package kosta.student.service;

import java.util.Scanner;

import kosta.student.manage.StudentManager;
import kosta.student.vo.Student;

/** �������� �߰� */
public class GradeAdd implements StudentService {

	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub
		
		StudentManager sm = new StudentManager();
		
		int num, score;
		
		System.out.print("��ȣ : ");
		num = scan.nextInt();
		System.out.print("���� : ");
		score = scan.nextInt();
		
		
	}

}
