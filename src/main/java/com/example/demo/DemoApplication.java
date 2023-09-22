package com.example.demo;

import java.util.List;
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
						System.out.println(ins + " Student added");
						System.out.println("***********************************************");
						System.out.println();
						break;
					case 2:
						// display All student
						List<Emp> allEmp = dao.getAllEmp();
						for(Emp e : allEmp)
						{
							System.out.println("Id : "+ e.getId());
							System.out.println("Name : "+e.getName());
							System.out.println("Salary : "+e.getSalary());
							System.out.println("_____________________________________");
						}
						break;
					case 3:
						//  get detail of single student
						System.out.println("Enter the Employee Id : ");
						int id1 = Integer.parseInt(sc.nextLine());
						Emp employee1 = dao.getEmp(id1);
						System.out.println("ID : "+ employee1.getId());
						System.out.println("Name : "+ employee1.getName());
						System.out.println("Salary : "+ employee1.getSalary());
						System.out.println("________________________________________");
						break;
					case 4:
						//  delete Student
						System.out.println("Enter the Employee Id : ");
						 id1 = Integer.parseInt(sc.nextLine());
						dao.deleteEmp(id1);
						System.out.println("Data Deleted");
						
						break;
					case 5:
						// update Student
						System.out.println("Enter the Student id to update: ");
		    			int updId =Integer.parseInt(sc.nextLine());
		    			Emp emp = dao.getEmp(updId);

		    			System.out.println("PRESS 1 to update Name");
		    			System.out.println("PRESS 2 to update salary");
		    			int nameOrsalary = Integer.parseInt(sc.nextLine());
		    			
		    			String updatedName = emp.getName();
		    			int updatedSalary = emp.getSalary();
		    			
		    			switch (nameOrsalary) {
		    				case 1:
		        				System.out.println("Enter the Name to be updated: ");
		        				updatedName =sc.nextLine();
		        				emp.setName(updatedName);
		        				break;
		    				case 2:
		        				System.out.println("Enter the Salary to be updated: ");
		        				updatedSalary = Integer.parseInt(sc.nextLine());
		        				emp.setSalary(updatedSalary);
		    					break;				
		    			}
		    			dao.updateEmployee(emp);
		    			System.out.println("Updated Employee Details Successfully!");
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

