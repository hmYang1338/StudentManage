package kosta.student.manage;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import kosta.student.vo.Student;

/*
 * Student ���� ������ ó���ϴ� Ŭ����
 * ����� �Ұ��� - ��ȯ�����
 */
public class StudentManager {
	// Java 7
	// Java 8
	private static List<Student> list;
	static{
		
	}
	public StudentManager() {
		// TODO Auto-generated constructor stub
		if(list == null)
			list = new LinkedList<>();
	}

	/** �л����� �߰� */ 
	public static String studentAdd(Student s){
		list.add(s);
		return "�л����� �߰�����";
	}
	
	/** ������ �������� */
	public static String list(){
		String c="";
		Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getScore() - o2.getScore();
			}
		});
		Iterator<Student> it = list.iterator();
		while(it.hasNext()){
			Student s = it.next();
			c = s.getNum()+" "+s.getName()+" "+s.getAddr()+" "+s.getGender()+
					" "+s.getBan()+" "+s.getHeight()+" "+s.getAge()+" "+s.getScore()+" "+s.getYear();
		}
		return c;
	}
	
	/** �л����� �˻� - �ּҷ�*/
	public String searchAddr(String name) {
		String a="";
		Iterator<Student> it = list.iterator();
		while(it.hasNext()){
			Student s = it.next();
			if(s.getAddr().equals(name))
				a = s.toString();
		}
		return a;
	}
	
	/** �л����� �˻� - �̸�����*/
	public String searchName(String name) {
		String a="";
		Iterator<Student> it = list.iterator();
		while(it.hasNext()){
			Student s = it.next();
			if(s.getName().equals(name))
				a = s.toString();
		}
		return a;
	}
	
	/** ������ �׷�ȭ */ 
	public static Map<String, List<Student>> genderGroup() {
		Map<String, List<Student>> map = list.stream()
				.collect(Collectors.groupingBy( t -> t.getGender() ));
				List<Student> list1 = map.get("��");
				List<Student> list2 = map.get("��");
		return map;
	}
	
	/** �ݺ� ���� ��� */
	public static Map<String, Double> avgBan() {
		Map<String, Double> map = list.stream()
				.collect(
						Collectors.groupingBy(t->t.getBan(), 
								Collectors.averagingInt(t->t.getScore())));
		double d1 = map.get("A");
		double d2 = map.get("B");
		double d3 = map.get("C");
		return map;
	}
	
	/** �ּҺ� ���� ��� */
	public static Map<String, Double> avgAddr()	{
		Map<String, Double> map = list.stream()
				.collect(
						Collectors.groupingBy(t->t.getAddr(), 
								Collectors.averagingInt(t->t.getScore())));
		double d1 = map.get("����");
		double d2 = map.get("���");
		double d3 = map.get("�泲");
		return map;
	}
	
	/** �г⺰ Ű ��� */
	public static Map<Integer, Double> avgHeight() {
		Map<Integer, Double> map = list.stream()
				.collect(
						Collectors.groupingBy(t->t.getYear(), 
								Collectors.averagingDouble(t->t.getHeight())));
		double d1 = map.get(1);
		double d2 = map.get(2);
		double d3 = map.get(3);
		double d4 = map.get(4);
		return map;
	}
	
	

} // end of class
