package kosta.student.service;

import java.util.Scanner;

import kosta.student.manage.StudentManager;

/** �л�����Ʈ ��� */
public class PrintStudentList implements StudentService {

	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub
		
		StudentManager sm = new StudentManager();
		System.out.println("1>�̸��� �������� 2>������ �������� 3>�ݺ�����Ʈ ���");
		
		int num = scan.nextInt();
		if(num == 1){
			System.out.println("�̸��� �������� ����");
			System.out.println(sm.nameAsc());
		} else if (num == 2){
			System.out.println("������ �������� ����");
			System.out.println(sm.scoreDesc());
		} else if (num == 3){
			System.out.println("�ݺ�����Ʈ ���");
			System.out.println(sm.banList());
		}
		
		
	}
}
