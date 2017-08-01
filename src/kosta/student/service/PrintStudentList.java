package kosta.student.service;

import java.util.Scanner;

import kosta.student.manage.StudentManager;

public class PrintStudentList implements StudentService {

	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub
		
		StudentManager sm = new StudentManager();
		
		System.out.println("1>이름순 오름차순 2>성적순 내림차순");
		int num = scan.nextInt();
		if(num == 1){
			System.out.println("이름순 오름차순 정렬");
			sm.list();
		} else if (num == 2){
			System.out.println("성적순 내림차순 정렬");
			
		}
		
		
	}
}
