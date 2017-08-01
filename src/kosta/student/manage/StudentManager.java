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
 * Student 관련 데이터 처리하는 클래스
 * 입출력 불가능 - 반환형사용
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

	/** 학생정보 추가 */ 
	public static String studentAdd(Student s){
		list.add(s);
		return "학생정보 추가성공";
	}
	
	/** 성적순 내림차순 */
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
	
	/** 학생정보 검색 - 주소로*/
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
	
	/** 학생정보 검색 - 이름으로*/
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
	
	/** 성별별 그룹화 */ 
	public static Map<String, List<Student>> genderGroup() {
		Map<String, List<Student>> map = list.stream()
				.collect(Collectors.groupingBy( t -> t.getGender() ));
				List<Student> list1 = map.get("남");
				List<Student> list2 = map.get("여");
		return map;
	}
	
	/** 반별 성적 평균 */
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
	
	/** 주소별 성적 평균 */
	public static Map<String, Double> avgAddr()	{
		Map<String, Double> map = list.stream()
				.collect(
						Collectors.groupingBy(t->t.getAddr(), 
								Collectors.averagingInt(t->t.getScore())));
		double d1 = map.get("서울");
		double d2 = map.get("경기");
		double d3 = map.get("충남");
		return map;
	}
	
	/** 학년별 키 평균 */
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
