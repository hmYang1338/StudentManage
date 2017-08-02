package kosta.student.service;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import kosta.student.exceptions.MyException;
import kosta.student.manage.StudentManager;
import kosta.student.vo.Student;

/** �л����� �߰� */
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
			
			System.out.print("��ȣ : ");
			num = scan.nextInt();
			scan.nextLine();
			
			System.out.print("�̸� : ");
			name = scan.nextLine();
			
			System.out.print("�ּ� : ");
			addr = scan.nextLine();
			
			System.out.print("���� : ");
			gender = scan.nextLine();
			
			System.out.print("�� : ");
			ban = scan.nextLine();
			
			System.out.print("Ű : ");
			height = scan.nextInt();
			
			System.out.print("���� : ");
			age = scan.nextInt();
			
			System.out.print("���� : ");
			score = scan.nextInt();
			
			System.out.print("�г� : ");
			year = scan.nextInt();
			
			boolean c = StudentManager.add(new Student(num, name, addr, ban, gender, age, height, score, year));
			
			if(c){
				System.out.println("�л���� �Ϸ�");
			}else {
				System.out.println("�л���� ����");
			}
		} catch (InputMismatchException e){
			throw new MyException("���ڸ� ��Ȯ�� �Է��ϼ���");
		}
	}
	
} // end of class
