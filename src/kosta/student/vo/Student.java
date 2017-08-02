package kosta.student.vo;

import java.util.Comparator;

/** 학생 */
public class Student implements Comparator<Student>{
	private int num;
	private String name="";
	private String addr="";		// 서울/경기/충남
	private String ban="";
	private String gender="";
	private int age;
	private double height;
	private int score;
	private int year;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	
	public Student(int num, String name, String addr, String ban, String gender, int age, double height, int score,
			int year) {
		super();
		this.num = num;
		this.name = name;
		this.addr = addr;
		this.ban = ban;
		this.gender = gender;
		this.age = age;
		this.height = height;
		this.score = score;
		this.year = year;
	}


	public Student(int num, int score) {
		super();
		this.num = num;
		this.score = score;
	}
	public int getNum() {
		return num;
	}
	public String getName() {
		return name;
	}
	public String getAddr() {
		return addr;
	}
	public String getGender() {
		return gender;
	}
	public String getBan() {
		return ban;
	}
	public double getHeight() {
		return height;
	}
	public int getAge() {
		return age;
	}
	public int getScore() {
		return score;
	}
	public int getYear() {
		return year;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setBan(String ban) {
		this.ban = ban;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr == null) ? 0 : addr.hashCode());
		result = prime * result + age;
		result = prime * result + ((ban == null) ? 0 : ban.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + num;
		result = prime * result + score;
		result = prime * result + year;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (addr == null) {
			if (other.addr != null)
				return false;
		} else if (!addr.equals(other.addr))
			return false;
		if (age != other.age)
			return false;
		if (ban == null) {
			if (other.ban != null)
				return false;
		} else if (!ban.equals(other.ban))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (num != other.num)
			return false;
		if (score != other.score)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	public double gettotal()	{
		return score;
	}
	
	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", addr=" + addr + ", gender=" + gender + ", ban=" + ban
				+ ", height=" + height + ", age=" + age + ", score=" + score + ", year=" + year + "]";
	}
	public String getGrade() {
		return null;
	}
	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
