package kosta.student.test;

import java.util.Scanner;

import kosta.student.service.GradeAdd;
import kosta.student.service.PrintStudentInfo;
import kosta.student.service.PrintStudentList;
import kosta.student.service.Statistics;
import kosta.student.service.StudentAdd;
import kosta.student.service.StudentService;

// 1. �л����� �߰�(��ȣ/�̸�/�ּ�/����/��/Ű/����/����/�г�)
// 2. �������� �߰�(��ȣ, �����Է�)
// 3. �л� ����Ʈ ���
//		3.1 �̸��� �������� ����
//		3.2 ������ �������� ����
//		3.3 �ݺ� ����Ʈ ���
// 4. �л� ���� �˻�
//		4.1 �ּ� �˻�
//		4.2 �̸� �˻�
// 5. ���
//		5.1 ������ �׷�ȭ
//		5.2 �ݺ� ���� ���
//		5.3 �ּҺ� ���� ���
//		5.4 �г⺰ Ű ���
// 0. ����
// �������̽� ���� �ѹ��ϰ�
// ���� ���� ������ ����� ���� Ŭ������ ����
// scanner�� �ѹ��� - �Ű������� �Ѱܶ�
// ����꿡 commit & push
// �ּ�ó�� (javadoc)

public class StudentManageTest {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		StudentService  s = null;
		int selectNum=0;
		while(true){
			System.out.println("====================================================");
			System.out.println("1.�л����� �߰�  2.�������� �߰�  3.�л� ����Ʈ ���");
			System.out.println("4.�л����� �˻�  5.���           0.����            ");
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
