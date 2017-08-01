package kosta.student.test;

import java.util.Scanner;

import kosta.student.service.GradeAdd;
import kosta.student.service.PrintStudentInfo;
import kosta.student.service.PrintStudentList;
import kosta.student.service.Statistics;
import kosta.student.service.StudentAdd;
import kosta.student.service.StudentService;

// 1. 학생정보 추가(번호/이름/주소/성별/반/키/나이/성적/학년)
// 2. 성적정보 추가(번호, 성적입력)
// 3. 학생 리스트 출력
//		3.1 이름순 오름차순 정렬
//		3.2 성적순 내림차순 정렬
//		3.3 반별 리스트 출력
// 4. 학생 정보 검색
//		4.1 주소 검색
//		4.2 이름 검색
// 5. 통계
//		5.1 성별별 그룹화
//		5.2 반별 성적 평균
//		5.3 주소별 성적 평균
//		5.4 학년별 키 평균
// 0. 종료
// 인터페이스 선언 한번하고
// 구현 받은 각각의 기능을 가진 클래스를 생성
// scanner는 한번만 - 매개변수로 넘겨라
// 깃허브에 commit & push
// 주석처리 (javadoc)

public class StudentManageTest {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		StudentService  s = null;
		int selectNum=0;
		while(true){
			System.out.println("====================================================");
			System.out.println("1.학생정보 추가  2.성적정보 추가  3.학생 리스트 출력");
			System.out.println("4.학생정보 검색  5.통계           0.종료            ");
			System.out.println("====================================================");
			selectNum = scan.nextInt();
			
			switch (selectNum) {
			case 1:
				s = new StudentAdd();
				s.execute(scan);
				break;
			case 2:
				s = new GradeAdd();
				s.execute(scan);
				break;
			case 3:
				s = new PrintStudentList();
				s.execute(scan);
				break;
			case 4:
				s = new PrintStudentInfo();
				s.execute(scan);
				break;
			case 5:
				s = new Statistics();
				s.execute(scan);
				break;
			case 0:
				System.exit(0);
				break;
			default:
				break;
			}
			
		}

	} // end of main
} // end of class
