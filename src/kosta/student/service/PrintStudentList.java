package kosta.student.service;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kosta.student.manage.StudentManager;
import kosta.student.vo.Student;

/** 학생리스트 출력 */
public class PrintStudentList implements StudentService {

	@Override
	public void execute(Scanner scan) {
		// TODO Auto-generated method stub

		System.out.println("1>이름순 오름차순 | 2>성적순 내림차순 | 3>반별리스트 출력");
		/*
		 * int num = scan.nextInt(); if(num == 1){
		 * System.out.println("이름순 오름차순 정렬");
		 * System.out.println(StudentManager.nameAsc()); } else if (num == 2){
		 * System.out.println("성적순 내림차순 정렬");
		 * System.out.println(StudentManager.scoreDesc()); } else if (num == 3){
		 * System.out.println("반별리스트 출력");
		 * System.out.println(StudentManager.banList()); }
		 */
		switch (scan.nextInt()) {
		case 0:
			return;
		case 1:
			List<Student> list = StudentManager.select7(new Comparator<Student>() {

				@Override
				public int compare(Student o1, Student o2) {
					// TODO Auto-generated method stub
					return o1.getName().compareTo(o2.getName());
				}
			});
			print(list);
			break;
		case 2:
			// 7
			/*
			 * List<Student> list2 = StudentManager.select7(new
			 * Comparator<Student>() {
			 * 
			 * @Override public int compare(Student o1, Student o2) { // TODO
			 * Auto-generated method stub return o2.getScore() - o1.getScore();
			 * } });
			 */

			// 8
			List<Student> list2 = StudentManager.select8((o1, o2) -> o2.getScore() - o1.getScore());
			print(list2);
			break;
		case 3:
			// Map<String, List<Student>> map = StudentManager.selectGroup7();
			Map<String, List<Student>> map = StudentManager.selectGroup8();
			print(map);
			break;
			
		}
	}

	public void print(List<Student> list) {
		Iterator<Student> it = list.iterator();

		System.out.println("학생 리스트 출력");
		while (it.hasNext()) {
			Student s = it.next();
			System.out.println(s);
		}
	}

	public void print(Map<String, List<Student>> map) {
		Iterator<String> it = map.keySet().iterator();
		// map.entrySet().iterator();

		System.out.println("학생 반별 리스트 출력");
		while (it.hasNext()) {
			String ban = it.next();
			System.out.println(ban + " : " + map.get(ban).size());
		}
	}

}
