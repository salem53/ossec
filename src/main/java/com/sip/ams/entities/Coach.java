package com.sip.ams.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coach {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String nom;
	private String email;
	private int age;
	
	public Coach(int id, String nom, String email, int age) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.age = age;
	}
	public Coach() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Coach [id=" + id + ", nom=" + nom + ", email=" + email + ", age=" + age + "]";
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
