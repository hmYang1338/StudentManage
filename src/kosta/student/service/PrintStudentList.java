package kosta.student.service;

import java.util.Scanner;

import kosta.student.manage.StudentManager;

/** 학생리스트 출력 */
public class PrintStudentList implements StudentService {

	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub
		
		StudentManager sm = new StudentManager();
		System.out.println("1>이름순 오름차순 2>성적순 내림차순 3>반별리스트 출력");
		
		int num = scan.nextInt();
		if(num == 1){
			System.out.println("이름순 오름차순 정렬");
			System.out.println(sm.nameAsc());
		} else if (num == 2){
			System.out.println("성적순 내림차순 정렬");
			System.out.println(sm.scoreDesc());
		} else if (num == 3){
			System.out.println("반별리스트 출력");
			System.out.println(sm.banList());
		}
		
		
	}
}
