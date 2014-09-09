package model.person;

import java.util.Date;

import exception.PersonException;
import exception.UnitException;

import model.unit.Department;
import model.unit.Faculty;


public class Employee extends Person {

	public enum FormOfWork{PERMANENT, CONTRACT};
	
	Date hireDate;
	Department department;
	Date firedDate=null;
	
	public Employee(String firstName, String lastName, Date dateOfBirth, Date hireDate, Department department){
		super(firstName, lastName, dateOfBirth);
		this.hireDate=hireDate;
		this.department=department;
	}
	Date getHireDate(){
		return hireDate;
	}
	public void setHireDate(Date hireDate){
		Date today=new Date();
		try {
			if (hireDate.after(today)){
				throw new PersonException("The person should be hired before today's date.");
			}
		} catch (PersonException m){
			System.out.println(m.getMessage());
		}
		this.hireDate=hireDate;
	}
	Department getDepartment(){
		return department;
	}
	public void setDepartment(Department department){
		this.department=department;
	}
	short getExperiance(){
		Date date=new Date();
		short experiance=(short) Math.abs((date.getTime()-hireDate.getTime()));
		experiance=(short) (experiance/1000/60/60/24/30/12);
		return experiance;	
	}
	Employee getBoss(){
		return department.head;
	}
	Faculty getFaculty(){
		return department.faculty;
	}
	public void fire(){
		firedDate=new Date();
	}

}
