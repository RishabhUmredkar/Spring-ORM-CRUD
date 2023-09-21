package com.example.demo.model;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import antlr.collections.List;

public class EmployeeDao {
	
	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	@Transactional
	public int saveEmployee(Emp e){  
		Integer i = (Integer)this.template.save(e);
	
		return i;  
	}  
	
	public Emp getEmp(int id)
	{
		return template.get(Emp.class, id);
	}
	
	public java.util.List<Emp> getAllEmp()
	{
		return template.loadAll(Emp.class);
	}
	

	public void deleteEmp(int id)
	{
		Emp emp = template.get(Emp.class, id);
		 template.delete(emp);
	}
	

	public void updateEmployee(Emp e){  
	    template.update(e);
	}  
	
}