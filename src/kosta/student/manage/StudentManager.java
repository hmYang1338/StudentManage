package kosta.student.manage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;


import kosta.student.vo.Student;

/*
 * Student ���� ������ ó���ϴ� Ŭ����
 * ����� �Ұ��� - ��ȯ�����
 */
/** Student ������ ó�� */
public class StudentManager {
	// Java 7
	// Java 8
	private static List<Student> list = new LinkedList<>();
	
	static {
		Logger logger = Logger.getLogger("StudentProject--kosta.student");
		logger.info("3. StudentManager");
		list.add(new Student(1, "ȫ�浿", "����", "A", "��", 20, 180, 90, 1));
		list.add(new Student(2, "���缮", "���", "A", "��", 30, 170, 70, 2));
		list.add(new Student(3, "�鼳��", "����", "B", "��", 25, 160, 80, 1));
		list.add(new Student(4, "���ָ�", "�泲", "C", "��", 34, 156, 50, 3));
		list.add(new Student(5, "����", "����", "C", "��", 60, 190, 40, 1));
		list.add(new Student(6, "�־ֶ�", "���", "A", "��", 40, 165, 40, 4));
		list.add(new Student(7, "������", "����", "B", "��", 30, 185, 30, 1));
		list.add(new Student(8, "�ڳ���", "�泲", "A", "��", 10, 160, 60, 2));
		list.add(new Student(9, "������", "���", "B", "��", 44, 165, 90, 3));
	}
	
	/** �л����� �߰� */ 
	public static Boolean add(Student s){
		return list.add(s);
	}
	/** �̸��� �������� */
	public static List<Student> nameAsc(){
		Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		});
		return list;
	}
	public static List<Student> nameAsc8() {
		Collections.sort(list, (o1, o2) -> o1.getName().compareTo(o2.getName()));
		return list;
	}
	
	/** ������ �������� */
	public static List<Student> scoreDesc(){
		Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o2.getScore() - o1.getScore();
			}
		});
		
		return list;
	}
	public static List<Student> scoreDesc8() {
		Collections.sort(list, (o1, o2) -> o2.getScore()-o1.getScore());
		return list;
	}
	
	
	/** �ݺ� ����Ʈ ��� */
	public static Map<String, List<Student>> banList(){
		Map<String, List<Student>> map = new HashMap<>();
		Iterator<Student> it = list.iterator();
		while(it.hasNext()){
			Student s = it.next();
			if(map.containsKey(s.getBan())){
				List<Student> list = map.get(s.getBan());
				list.add(s);
			}
			else{
				List<Student> list = new ArrayList<>();
				list.add(s);
				map.put(s.getBan(), list);
			}
		}
		return map;
	}
	public static List<Student> search08(Predicate<Student> predicate) {
		return list.stream().filter(predicate).collect(Collectors.toList());
	}
	
	/** �л����� �˻� - �ּҷ�*/
	public static String searchAddr(String name) {
		String a="";
		Iterator<Student> it = list.iterator();
		while(it.hasNext()){
			Student s = it.next();
			if(s.getAddr().equals(name))
				a = s.toString();
		}
		return a;
	}
	public static Student searchAddr08(String addr) {
		return list.stream().filter( s -> s.getAddr().equals(addr)).findAny().get();
	}
	
	
	/** �л����� �˻� - �̸�����*/
	public static String searchName(String name) {
		String a="";
		Iterator<Student> it = list.iterator();
		while(it.hasNext()){
			Student s = it.next();
			if(s.getName().equals(name))
				a = s.toString();
		}
		return a;
	}
	public static Student searchName08(String name) {
		return list.stream().filter( s -> s.getName().equals(name)).findAny().get();
	}
	
	public static Map<String, List<Student>> selectGroup08(){
		return list.stream().collect(Collectors.groupingBy(s -> s.getBan()));
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
	public static Map<String, Double> avgBan(){
		Map<String, Double> map = new HashMap<>();
		Iterator<Student> it = list.iterator();
		while(it.hasNext()){
			Student s = it.next();
			// �ʿ� Ű���� �ִ��� ���� Ȯ��
			// (�ش� ���� �ʿ� �ִ��� Ȯ��)
			if(map.containsKey(s.getBan())){
				// ���� ���� ����
				map.replace(s.getBan(), map.get(s.getBan())+s.gettotal()/list.size());
			}else{
				// ���� �߰�
				map.put(s.getBan(), s.gettotal()/list.size());
			}
		}
		return map;
	}
	public static Map<String, Double> avgBan8() {
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


	
	
	

	// ��� -------------------------------------------------------------------------
	// ����Ʈ ���(�̸�/����)
	public static List<Student> select7(Comparator<Student> comparator) {
		Collections.sort(list, comparator);
		return list;
	}
	// ����Ʈ ���(�̸�/����)
	public static List<Student> select8(Comparator<Student> comparator) {
		return list.stream().sorted(comparator).collect(Collectors.toList());
	}
	
	// �ݺ� ����Ʈ ��� 7
	public static Map<String, List<Student>> selectGroup7() {
		// <��, �ݺ� ����Ʈ>
		Map<String, List<Student>> map = new HashMap<>();
		
		Iterator<Student> it = list.iterator();
		
		while(it.hasNext()) {
			Student s = it.next();
			
			// �ʿ� ���� ������..
			if(map.containsKey(s.getBan())) {
				List<Student> list = map.get(s.getBan());
				System.out.println("�ִ�" + s.getNum());
				list.add(s);
			}
			
			// �ʿ� ���� ������..
			else {
				List<Student> list = new ArrayList<>();
				
				System.out.println("����" + s.getNum());
				list.add(s);
				map.put(s.getBan(), list);
			}
		}
		
		return map;
	}
	
	// �ݺ� ����Ʈ ��� 8
	public static Map<String, List<Student>> selectGroup8() {
		/*Map<String, List<Student>> map = new HashMap<>();
		
		map = list.stream().collect(Collectors.groupingBy(s -> s.getBan()));
		
		return map;*/
		
		return list.stream().collect(Collectors.groupingBy(s -> s.getBan()));
	}
	
	// �˻� -------------------------------------------------------------------------
	/**
	 * �̸����� �˻� 
	 * @param name �˻��� �̸�
	 * @return �˻��� �л� ����
	 */
	public static Student searchName8(String name) {
		/*Optional<Student> op = list.stream().filter(s -> s.getName().equals(name)).findAny();
		Student s = op.get();
		return s;*/
		
		return list.stream().filter(s -> s.getName().equals(name)).findAny().get();
	}
	
	/**
	 * �ּҷ� �˻� 
	 * @param addr �˻��� �ּ�
	 * @return �˻��� �л� ����
	 */
	public static Student searchAddr8(String addr) {
		/*Optional<Student> op = list.stream().filter(s -> s.getAddr().equals(addr)).findAny();
		Student s = op.get();
		return s;*/
		
		return list.stream().filter(s -> s.getAddr().equals(addr)).findAny().get();
	}
	
	/**
	 * �˻� 
	 * @param predicate ���͸� ���� 
	 * @return �˻��� �л� ����
	 */
	public static Student search8(Predicate<Student> predicate) {
		/*Optional<Student> op = list.stream().filter(predicate).findAny();
		Student s = op.get();
		return s;*/
		
		return list.stream().filter(predicate).findAny().get();
	}
	
	/**
	 * �˻� 
	 * @param predicate ���͸� ���� 
	 * @return �˻��� �л� ����Ʈ
	 */
	public static List<Student> search88(Predicate<Student> predicate) {
		/*List<Student> list = list.stream().filter(predicate).collect(Collectors.toList());
		return list;*/
		
		return list.stream().filter(predicate).collect(Collectors.toList());
	}
	

} // end of class
