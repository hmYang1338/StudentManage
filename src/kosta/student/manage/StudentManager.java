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
import java.util.stream.Collectors;

import javax.annotation.processing.Completions;

import kosta.student.vo.Student;

/*
 * Student 관련 데이터 처리하는 클래스
 * 입출력 불가능 - 반환형사용
 */
/** Student 데이터 처리 */
public class StudentManager {
	// Java 7
	// Java 8
	private static List<Student> list = new LinkedList<>();;
		
	/** 학생정보 추가 */ 
	public Boolean add(Student s){
		
		return list.add(s);
	}
	
	/** 성적정보 추가 */
	public static boolean scoreAdd(Student s){
		
		return list.add(s);
	}
	
	/** 이름순 오름차순 */
	public static List<Student> nameAsc(){
		Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		});
		Iterator<Student> it = list.iterator();
		while(it.hasNext()){
			Student s = it.next();
		}
		return list;
	}
	public static List<Student> nameAsc8() {
		Collections.sort(list, (o1, o2) -> o1.getName().compareTo(o2.getName()));
		return list;
	}
	
	/** 성적순 내림차순 */
	public static List<Student> scoreDesc(){
		Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o2.getScore() - o1.getScore();
			}
		});
		Iterator<Student> it = list.iterator();
		while(it.hasNext()){
			Student s = it.next();
		}
		return list;
	}
	public static List<Student> scoreDesc8() {
		Collections.sort(list, (o1, o2) -> o2.getScore()-o1.getScore());
		return list;
	}
	
	
	/** 반별 리스트 출력 */
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
	public static List<Student> search88(Predicate<Student> predicate) {
		return list.stream().filter(predicate).collect(Collectors.toList());
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
	public static Student searchAddr8(String name) {
		return list.stream().filter( s -> s.getAddr().equals(name)).findAny().get();
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
	public static Student searchName8(String name) {
		return list.stream().filter( s -> s.getName().equals(name)).findAny().get();
	}
	
	public static Map<String, List<Student>> selectGroup8(){
		return list.stream().collect(Collectors.groupingBy(s -> s.getBan()));
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
