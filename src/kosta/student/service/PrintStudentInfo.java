package kosta.student.service;

import java.util.Scanner;

import kosta.student.manage.StudentManager;
import kosta.student.vo.Student;

/** 학생정보 검색 */
public class PrintStudentInfo implements StudentService {

	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub
		
		System.out.println("1>주소검색 2>이름검색");
		
		int num = scan.nextInt();
		if(num == 1){
			System.out.println("1> 주소검색");
			String addr = scan.nextLine();
			System.out.println(StudentManager.searchAddr8(addr));
		} else if (num == 2){
			System.out.println("2> 이름검색");
			String name = scan.nextLine();
			System.out.println(StudentManager.searchName8(name));
		}
		
		switch (scan.nextInt()) {
		case 1:
			System.out.println("주소 : ");
			String addr = scan.nextLine();
			Student s1 = StudentManager.search8((s) -> s.getAddr().equals(addr));
			break;
		case 2:
			System.out.println("이름 : ");
			String name = scan.nextLine();
			Student s2 = StudentManager.search8((s) -> s.getName().equals(name));
			break;
		}
	
	}

} // end of class
