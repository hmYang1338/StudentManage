package kosta.student.service;

import java.util.Scanner;

import kosta.student.manage.StudentManager;

/** �л����� �˻� */
public class PrintStudentInfo implements StudentService {

	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub
		
		StudentManager sm = new StudentManager();
		System.out.println("1>�ּҰ˻� 2>�̸��˻�");
		
		int num = scan.nextInt();
		if(num == 1){
			System.out.println("1> �ּҰ˻�");
			System.out.println(sm.searchAddr(scan.nextLine()));
		} else if (num == 2){
			System.out.println("2> �̸��˻�");
			System.out.println(sm.searchName(scan.nextLine()));
		}
	}

} // end of class
