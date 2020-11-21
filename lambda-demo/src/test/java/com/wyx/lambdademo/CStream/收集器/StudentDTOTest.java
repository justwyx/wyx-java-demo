package com.wyx.lambdademo.CStream.收集器;

/**
 * @author : Just wyx
 * @Date : 2020/11/21
 */
public class StudentDTOTest {
	private String name;
	private String school;
	private String gender;
	private int age;
	private double score;

	public StudentDTOTest(String name, String school, String gender, int age, double score) {
		this.name = name;
		this.school = school;
		this.gender = gender;
		this.age = age;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}


	@Override
	public String toString() {
		return "StudentDTOTest{" +
				"name='" + name + '\'' +
				", school='" + school + '\'' +
				", gender='" + gender + '\'' +
				", age=" + age +
				", score=" + score +
				'}';
	}
}
