package kosta.student.service;

import java.util.Scanner;

import kosta.student.manage.StudentManager;

public class Statistics implements StudentService {

	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub
		
		StudentManager sm = new StudentManager();
		int num = scan.nextInt();
		System.out.println("1>���� �׷�ȭ 2>�ݺ� ���� ��� 3>�ּҺ� ���� ��� 4>�г⺰ Ű ���");
		switch (num) {
		case 1:
			System.out.println("1> ���� �׷�ȭ");
			System.out.println(sm.genderGroup());
			break;
		case 2:
			System.out.println("2> �ݺ� ���� ���");
			System.out.println(sm.avgBan());
			break;
		case 3:
			System.out.println("3> �ּҺ� ���� ���");
			System.out.println(sm.avgAddr());
			break;
		case 4:
			System.out.println("4> �г⺰ Ű ���");
			System.out.println(sm.avgHeight());
			break;

		default:
			break;
		}
	}
}

