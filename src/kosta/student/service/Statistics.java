package kosta.student.service;

import java.util.Scanner;

import kosta.student.manage.StudentManager;

/** 통계 */
public class Statistics implements StudentService {

	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub
		
		System.out.println("1>성별 그룹화 | 2>반별 성적 평균 | 3>주소별 성적 평균 | 4>학년별 키 평균");
	
		int num = scan.nextInt();
		switch (num) {
		case 1:
			System.out.println("1> 성별 그룹화");
			System.out.println(StudentManager.genderGroup());
			break;
		case 2:
			System.out.println("2> 반별 성적 평균");
			System.out.println(StudentManager.avgBan());
			break;
		case 3:
			System.out.println("3> 주소별 성적 평균");
			System.out.println(StudentManager.avgAddr());
			break;
		case 4:
			System.out.println("4> 학년별 키 평균");
			System.out.println(StudentManager.avgHeight());
			break;

		default:
			break;
		}
	}
}

