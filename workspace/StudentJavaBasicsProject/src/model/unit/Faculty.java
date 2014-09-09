package model.unit;

import java.util.ArrayList;
import java.util.Date;

import model.person.Employee;

public class Faculty extends StructuralUnit {

	Date dateOfCreation=new Date();
	ArrayList departments;
	//decan
	Employee dean;
	
	public Faculty(String title){
		super(title);
		}
	
	public Faculty(String title, Employee dean){
		super(title);
		this.dean=dean;
		}
	Date getDateOfCreation(){
		return dateOfCreation;
	}
	void setDateOfCreation(Date date){
		this.dateOfCreation=date;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title=title;
	}
	Employee getDean(){
		return dean;
	}
	public void setDean(Employee dean){
		this.dean=dean;
	}
	
	public ArrayList getDepartments(){
		return departments;
	}
	
	public void addDepartment (Department department){
		departments.add(department);
	}
	public void removeDepartment(Department department){
		for (Object value:departments){
			if (value.equals(department)){
				departments.remove(value);
			}
		}
	}
	
	int getStudentsNumber(){
		int numberOfStudents=0;
		for (Object value:departments){
				numberOfStudents+=getStudentsNumber();
		}
		return numberOfStudents;
	}
	int getEmployeesNumber(){
		int numberOfEmployee=0;
		Department dep;
		for (Object value:departments){
			dep=(Department) value;
			for (Object value1:dep.members){
				numberOfEmployee++;
			}
		}
		return numberOfEmployee;
	}
//	Specialty[] getSpecialties(){
//		int numberOfSpecialities=0;
//		for (Department value:departments){
//			for (Specialty value1:value.specialties){
//				numberOfSpecialities++;
//			}
//		}
//		Specialty[] specialties=new Specialty[numberOfSpecialities];
//		int count=0;
//		for (Department value:departments){
//			for (Specialty value1:value.specialties){
//				specialties[count]=value1;
//				count++;
//			}
//		}
//		return specialties;
//	}
//
//	Group[] getGroups(){
//		int numberOfGroups=0;
//		for (Department value:departments){
//			for (Specialty value1:value.specialties){
//				for (Group value2:value1.groups){
//				numberOfGroups++;
//				}
//			}
//		}
//		Group[] groups=new Group[numberOfGroups];
//		int count=0;
//		for (Department value:departments){
//			for (Specialty value1:value.specialties){
//				for (Group value2:value1.groups){
//				groups[count]=value2;
//				count++;
//				}
//			}
//		}
//		return groups;
//	}
}
