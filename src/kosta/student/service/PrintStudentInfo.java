package kosta.student.service;

import java.util.Scanner;

import kosta.student.manage.StudentManager;

/** 학생정보 검색 */
public class PrintStudentInfo implements StudentService {

	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub
		
		StudentManager sm = new StudentManager();
		System.out.println("1>주소검색 2>이름검색");
		
		int num = scan.nextInt();
		if(num == 1){
			System.out.println("1> 주소검색");
			System.out.println(sm.searchAddr(scan.nextLine()));
		} else if (num == 2){
			System.out.println("2> 이름검색");
			System.out.println(sm.searchName(scan.nextLine()));
		}
	}

} // end of class
