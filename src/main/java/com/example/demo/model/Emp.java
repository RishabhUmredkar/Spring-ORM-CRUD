package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Emp_tbl")
public class Emp {
	
	@Id
	private int id;  
	private String name;  
	private int salary;
	
	
	public Emp(int id) {
		super();
		this.id = id;
	}
	public Emp() {
		// TODO Auto-generated constructor stub
	}
	public Emp(int updId, String updatedName, int updatedSalary) {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}  
	
	
}