package it.techgap.challenge.java.senior.beans.impl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;


import it.techgap.challenge.java.senior.beans.Employee;

public class CompanyEmployeeImpl implements Employee {

	List<Employee> wholeCompany = new  ArrayList<Employee>();
	Employee[] subordinates ;
	
	String name;
	double salary;


	public CompanyEmployeeImpl(String name, int salary) {

		super();
		this.name = name;
		this.salary = Double.valueOf(salary);

	}

	public CompanyEmployeeImpl(String name, int startingSalary, int monthlySales) {

		super();
		this.name = name;
		this.salary = Double.valueOf(startingSalary) + (monthlySales*0.1);

	}

	public CompanyEmployeeImpl(String name, int startingSalary, Employee... directSubordinates) {
		
		super();
		this.name = name;
		Double salaryOfManagerSubordinate = computeManagerSalary(this.name, directSubordinates);
		this.salary = salaryOfManagerSubordinate + startingSalary;
		WholeComapnySingelton.getInstance().addManagerToArray(name, ((salaryOfManagerSubordinate + startingSalary)*0.005 ) + salaryOfManagerSubordinate);
	
		
	}

	public void setName(String name) {
		this.name = name;

	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public double getSalary() {
	
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(Integer.MAX_VALUE);
		return Double.valueOf(salary);
	}

	@Override
	public String getName() {
		return name;
	}


	private Double computeManagerSalary(String name, Employee[] directSubordinates) {
		
		Double totalSubordinateSalary = 0.0;
		Double subSubordinate = 0.0;
	

		for(Employee employee : directSubordinates) {
			Double directSubordinate = employee.getSalary();
		
			if(WholeComapnySingelton.getInstance().getManagerList().containsKey(employee.getName())) {
				subSubordinate = WholeComapnySingelton.getInstance().getManagerList().get(employee.getName());
			}
			else {
				totalSubordinateSalary = totalSubordinateSalary + directSubordinate;
				
			}
		}		
		
		return Double.valueOf((totalSubordinateSalary*0.005) + subSubordinate);
	}
	
}
