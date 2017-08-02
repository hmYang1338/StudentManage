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
 * Student 관련 데이터 처리하는 클래스
 * 입출력 불가능 - 반환형사용
 */
/** Student 데이터 처리 */
public class StudentManager {
	// Java 7
	// Java 8
	private static List<Student> list = new LinkedList<>();
	
	static {
		Logger logger = Logger.getLogger("StudentProject--kosta.student");
		logger.info("3. StudentManager");
		list.add(new Student(1, "홍길동", "서울", "A", "남", 20, 180, 90, 1));
		list.add(new Student(2, "유재석", "경기", "A", "남", 30, 170, 70, 2));
		list.add(new Student(3, "백설희", "서울", "B", "여", 25, 160, 80, 1));
		list.add(new Student(4, "김주만", "충남", "C", "남", 34, 156, 50, 3));
		list.add(new Student(5, "고동만", "서울", "C", "남", 60, 190, 40, 1));
		list.add(new Student(6, "최애라", "경기", "A", "여", 40, 165, 40, 4));
		list.add(new Student(7, "정준하", "서울", "B", "남", 30, 185, 30, 1));
		list.add(new Student(8, "박나래", "충남", "A", "여", 10, 160, 60, 2));
		list.add(new Student(9, "송혜교", "경기", "B", "여", 44, 165, 90, 3));
	}
	
	/** 학생정보 추가 */ 
	public static Boolean add(Student s){
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
	public static List<Student> search08(Predicate<Student> predicate) {
		return list.stream().filter(predicate).collect(Collectors.toList());
	}
	
	/** 학생정보 검색 - 주소로*/
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
	
	
	/** 학생정보 검색 - 이름으로*/
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
	
	/** 성별별 그룹화 */ 
	public static Map<String, List<Student>> genderGroup() {
		Map<String, List<Student>> map = list.stream()
				.collect(Collectors.groupingBy( t -> t.getGender() ));
		List<Student> list1 = map.get("남");
		List<Student> list2 = map.get("여");
		return map;
	}
	
	/** 반별 성적 평균 */
	public static Map<String, Double> avgBan(){
		Map<String, Double> map = new HashMap<>();
		Iterator<Student> it = list.iterator();
		while(it.hasNext()){
			Student s = it.next();
			// 맵에 키값이 있는지 여부 확인
			// (해당 반이 맵에 있는지 확인)
			if(map.containsKey(s.getBan())){
				// 기존 합이 변경
				map.replace(s.getBan(), map.get(s.getBan())+s.gettotal()/list.size());
			}else{
				// 새로 추가
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


	
	
	

	// 출력 -------------------------------------------------------------------------
	// 리스트 출력(이름/성적)
	public static List<Student> select7(Comparator<Student> comparator) {
		Collections.sort(list, comparator);
		return list;
	}
	// 리스트 출력(이름/성적)
	public static List<Student> select8(Comparator<Student> comparator) {
		return list.stream().sorted(comparator).collect(Collectors.toList());
	}
	
	// 반별 리스트 출력 7
	public static Map<String, List<Student>> selectGroup7() {
		// <반, 반별 리스트>
		Map<String, List<Student>> map = new HashMap<>();
		
		Iterator<Student> it = list.iterator();
		
		while(it.hasNext()) {
			Student s = it.next();
			
			// 맵에 반이 있으면..
			if(map.containsKey(s.getBan())) {
				List<Student> list = map.get(s.getBan());
				System.out.println("있다" + s.getNum());
				list.add(s);
			}
			
			// 맵에 반이 없으면..
			else {
				List<Student> list = new ArrayList<>();
				
				System.out.println("없다" + s.getNum());
				list.add(s);
				map.put(s.getBan(), list);
			}
		}
		
		return map;
	}
	
	// 반별 리스트 출력 8
	public static Map<String, List<Student>> selectGroup8() {
		/*Map<String, List<Student>> map = new HashMap<>();
		
		map = list.stream().collect(Collectors.groupingBy(s -> s.getBan()));
		
		return map;*/
		
		return list.stream().collect(Collectors.groupingBy(s -> s.getBan()));
	}
	
	// 검색 -------------------------------------------------------------------------
	/**
	 * 이름으로 검색 
	 * @param name 검색할 이름
	 * @return 검색된 학생 정보
	 */
	public static Student searchName8(String name) {
		/*Optional<Student> op = list.stream().filter(s -> s.getName().equals(name)).findAny();
		Student s = op.get();
		return s;*/
		
		return list.stream().filter(s -> s.getName().equals(name)).findAny().get();
	}
	
	/**
	 * 주소로 검색 
	 * @param addr 검색할 주소
	 * @return 검색된 학생 정보
	 */
	public static Student searchAddr8(String addr) {
		/*Optional<Student> op = list.stream().filter(s -> s.getAddr().equals(addr)).findAny();
		Student s = op.get();
		return s;*/
		
		return list.stream().filter(s -> s.getAddr().equals(addr)).findAny().get();
	}
	
	/**
	 * 검색 
	 * @param predicate 필터링 조건 
	 * @return 검색된 학생 정보
	 */
	public static Student search8(Predicate<Student> predicate) {
		/*Optional<Student> op = list.stream().filter(predicate).findAny();
		Student s = op.get();
		return s;*/
		
		return list.stream().filter(predicate).findAny().get();
	}
	
	/**
	 * 검색 
	 * @param predicate 필터링 조건 
	 * @return 검색된 학생 리스트
	 */
	public static List<Student> search88(Predicate<Student> predicate) {
		/*List<Student> list = list.stream().filter(predicate).collect(Collectors.toList());
		return list;*/
		
		return list.stream().filter(predicate).collect(Collectors.toList());
	}
	

} // end of class
