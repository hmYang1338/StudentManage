package kosta.student.service;

import java.util.Scanner;

import kosta.student.manage.StudentManager;
import kosta.student.vo.Student;

/** 성적정보 추가 */
public class GradeAdd implements StudentService {

	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub
		
		StudentManager sm = new StudentManager();
		
		int num, score;
		
		System.out.print("번호 : ");
		num = scan.nextInt();
		System.out.print("성적 : ");
		score = scan.nextInt();
		
		
	}

}
