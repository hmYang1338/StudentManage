package kosta.student.service;

import java.util.Scanner;

import kosta.student.manage.StudentManager;

/** ��� */
public class Statistics implements StudentService {

	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub
		
		System.out.println("1>���� �׷�ȭ | 2>�ݺ� ���� ��� | 3>�ּҺ� ���� ��� | 4>�г⺰ Ű ���");
	
		int num = scan.nextInt();
		switch (num) {
		case 1:
			System.out.println("1> ���� �׷�ȭ");
			System.out.println(StudentManager.genderGroup());
			break;
		case 2:
			System.out.println("2> �ݺ� ���� ���");
			System.out.println(StudentManager.avgBan());
			break;
		case 3:
			System.out.println("3> �ּҺ� ���� ���");
			System.out.println(StudentManager.avgAddr());
			break;
		case 4:
			System.out.println("4> �г⺰ Ű ���");
			System.out.println(StudentManager.avgHeight());
			break;

		default:
			break;
		}
	}
}

