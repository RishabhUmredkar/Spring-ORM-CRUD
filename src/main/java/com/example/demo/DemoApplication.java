package com.example.demo;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.example.demo.model.Emp;
import com.example.demo.model.EmployeeDao;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		 Resource r=new ClassPathResource("applicationContext.xml");  
		    BeanFactory factory=new XmlBeanFactory(r);  
		      
		    EmployeeDao dao=(EmployeeDao)factory.getBean("d");  
		      
//		    Emp e=new Emp();  
//		    e.setId(114);  
//		    e.setName("varun");  
//		    e.setSalary(50000);  
//		      
//		    dao.saveEmployee(e);  
//		    
		    
		    Scanner sc = new Scanner(System.in);
		 boolean go =true;
		    while(go)
		    {
		        
			    System.out.println("Enter 1 for add new Student");
			    System.out.println("Press 2 display All student");
			    System.out.println("Press 3 for get detail of single student");
			    System.out.println("Press 4 For delete Student");
			    System.out.println("Press 5 for update Student");
			    System.out.println("Press 0 for Exit."); 
			    
		    	try {
					int input = Integer.parseInt(sc.nextLine());
					System.out.println(input);
					
					switch (input) {
					case 1:
						// add a new student
						
						System.out.println("Enter the Employee id");
						int id = Integer.parseInt(sc.nextLine());
						
						System.out.println("Enter the Employee Name");
						String name = sc.nextLine();
						
						System.out.println("Enter the salary");
						int salary = Integer.parseInt(sc.nextLine());
						
						Emp employee = new Emp();
						employee.setId(id);
						employee.setName(name);
						employee.setSalary(salary);
						
						int ins = dao.saveEmployee(employee);
						
						break;
					case 2:
						// display All student
						break;
					case 3:
						//  get detail of single student
						break;
					case 4:
						//  delete Student
						break;
					case 5:
						// update Student
						break;
					case 0:
						// Exit
						go = false;
						break;

					}	
				} catch (Exception e) {
					System.out.println("Invalid input Try another one");
				}
		    }}
	}

