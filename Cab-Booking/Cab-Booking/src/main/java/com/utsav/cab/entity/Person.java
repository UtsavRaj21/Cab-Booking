package com.utsav.cab.entity;

public class Person {
	private String name;
	private Character gender;
	private int age;
	

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, Character gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
}
