package kosta.student.service;

import java.util.Scanner;

import kosta.student.manage.StudentManager;

public class PrintStudentList implements StudentService {

	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub
		
		StudentManager sm = new StudentManager();
		
		System.out.println("1>�̸��� �������� 2>������ ��������");
		int num = scan.nextInt();
		if(num == 1){
			System.out.println("�̸��� �������� ����");
			sm.list();
		} else if (num == 2){
			System.out.println("������ �������� ����");
			
		}
		
		
	}
}
