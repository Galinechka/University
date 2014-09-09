package model.person;

import java.util.Date;

import model.unit.Department;
import model.unit.Faculty;
import model.unit.Group;
import model.unit.Specialty;


public class Student extends Person{

	public enum FormOfEducation{
		EXTRAMURAL(4) , 
		INTRAMURAL(6), 
		ONLINE(8);
		
		int yearsToStudy;
		
		FormOfEducation(int yearsToStudy){
			this.yearsToStudy=yearsToStudy;
		}
		@Override 
		public String toString(){
			return this.ordinal()+":"+this.name()+"("+this.yearsToStudy+")";
		}
		};
		
		
	Date enrollmentDate;
	Group group;
	Date firedDate=null;
	
	public Student (String firstName, String lastName, Date dateOfBirth, Date enrollmentDate, Group group){
		super(firstName, lastName, dateOfBirth);
		this.enrollmentDate=enrollmentDate;
		this.group=group;
	}
	public Date getEnrollmentDate(){
		return enrollmentDate;
	}
	public void setEnrollmentDate(Date enrollmentDate){
		this.enrollmentDate=enrollmentDate;
	}
	Group getGroup(){
		return group;
	}
	public void setGroup(Group group){
		this.group=group;
	}
	
	
	Specialty getSpeciality(){
		return group.specialty;
	}
	Faculty getFaculty(){
		return group.getFaculty();
	}
	Employee getCurator(){
		return group.curator;
	}
	public void fire(){
		firedDate=new Date();
		
	}

}
