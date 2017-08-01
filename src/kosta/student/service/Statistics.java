package kosta.student.service;

import java.util.Scanner;

import kosta.student.manage.StudentManager;

public class Statistics implements StudentService {

	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub
		
		StudentManager sm = new StudentManager();
		int num = scan.nextInt();
		System.out.println("1>성별 그룹화 2>반별 성적 평균 3>주소별 성적 평균 4>학년별 키 평균");
		switch (num) {
		case 1:
			System.out.println("1> 성별 그룹화");
			System.out.println(sm.genderGroup());
			break;
		case 2:
			System.out.println("2> 반별 성적 평균");
			System.out.println(sm.avgBan());
			break;
		case 3:
			System.out.println("3> 주소별 성적 평균");
			System.out.println(sm.avgAddr());
			break;
		case 4:
			System.out.println("4> 학년별 키 평균");
			System.out.println(sm.avgHeight());
			break;

		default:
			break;
		}
	}
}

