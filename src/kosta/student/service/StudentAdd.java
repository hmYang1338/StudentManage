package kosta.student.service;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import kosta.student.exceptions.MyException;
import kosta.student.manage.StudentManager;
import kosta.student.vo.Student;

/** 학생정보 추가 */
public class StudentAdd implements StudentService {
	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger("StudentProject--kosta.student");
		logger.info("2. StudentAddService");
		try{
			
			int num, age, score, year;
			double height;
			String name, addr, gender, ban;
			
			System.out.print("번호 : ");
			num = scan.nextInt();
			scan.nextLine();
			
			System.out.print("이름 : ");
			name = scan.nextLine();
			
			System.out.print("주소 : ");
			addr = scan.nextLine();
			
			System.out.print("성별 : ");
			gender = scan.nextLine();
			
			System.out.print("반 : ");
			ban = scan.nextLine();
			
			System.out.print("키 : ");
			height = scan.nextInt();
			
			System.out.print("나이 : ");
			age = scan.nextInt();
			
			System.out.print("성적 : ");
			score = scan.nextInt();
			
			System.out.print("학년 : ");
			year = scan.nextInt();
			
			boolean c = StudentManager.add(new Student(num, name, addr, ban, gender, age, height, score, year));
			
			if(c){
				System.out.println("학생등록 완료");
			}else {
				System.out.println("학생등록 실패");
			}
		} catch (InputMismatchException e){
			throw new MyException("숫자를 정확히 입력하세요");
		}
	}
	
} // end of class
