package com.sip.ams.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student extends Object{
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + ", name=" + name + "]";
	}

	public Student(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public Student() {

	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Id
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	private int age;
	private String name;

}
