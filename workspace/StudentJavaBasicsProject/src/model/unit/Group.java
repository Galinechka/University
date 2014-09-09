package model.unit;

import java.util.ArrayList;
import java.util.Date;

import model.person.Employee;
import model.person.Student;

public class Group extends StructuralUnit{

	
	private Date dateOfCreation;
	private ArrayList students;
	private Specialty specialty;
	private Employee curator;
	
	public Group(String title){
		super(title);
		this.dateOfCreation=new Date();
		this.specialty=specialty;
		this.curator=curator;
	}
	public Group(String title, Specialty specialty, Employee curator){
		super(title);
		this.specialty=specialty;
		this.curator=curator;
	}
	Date getDateOfCation(){
		return dateOfCreation;
	}
	void setDateOfCreation(Date date){
		this.dateOfCreation=date;
	}
	
	public Specialty getSpecialty(){
		return specialty;
	}
	public void setSpecialty(Specialty specialty){
		this.specialty=specialty;
	}
	Employee getCurator(){
		return curator;
	}
	public void setCurator(Employee curator){
		this.curator=curator;
	}
	public ArrayList getStudent(){
		return students;
	}
	
	public void addStudent (Student student){
		students.add(student);
	}
	public void removeStudent(Student student){
		
		for (Object value:students){
			if (value.equals(student)){
				students.remove(value);
			}
		}
	}
	
	short getYear(){
			Date date=new Date();
			short years=(short) Math.abs((date.getTime()-dateOfCreation.getTime()));
			years=(short) (years/1000/60/60/24/30/12);
			return years;	
		}
	byte getSize(){
		byte size=(byte)(students.size());
		return size;	
	}
	Department getDepartment(){
		return specialty.department;
	}
	public Faculty getFaculty(){
		return specialty.getFaculty();
	}

}
