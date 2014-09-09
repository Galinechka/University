package model.unit;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import model.person.Employee;
import model.person.Student;

public class Department extends StructuralUnit {

	Set specialties;
	public ArrayList members;
	public Employee head;
	public Faculty faculty;
	
	public Department(String title, Employee employee, Faculty faculty){
		super(title);
		this.head=employee;
		this.faculty=faculty;
	}
	Employee getHead(){
		return head;
	}
	void setHead(Employee head){
		this.head=head;
	}
	Faculty getFaculty(){
		return faculty;
	}
	void setFaculty(Faculty faculty){
		this.faculty=faculty;
	}
	public Set getSpecialties(){
		return specialties;
	}
	
	public void addSpecialty (Specialty specialty){
		specialties.add(specialty);
	}
	public void removeSpecialty(Specialty specialty){
		boolean specialtyRemoved=false;
		for (Object value:specialties){
			if (value.equals(specialty)){
				specialties.remove(value);
				specialtyRemoved=true;
			}
		}
		if (specialtyRemoved=false) throw new IllegalArgumentException ("Specialty you want to remove is not find in this department!");
	}
	
	ArrayList getEmployees(){
		return members;
	}
	
	void addEmployee (Employee employee){
		members.add(employee);
	}
	void removeEmployee(Employee employee){
		boolean employeeRemoved=false;
		for (Object value:members){
			if (value.equals(employee)){
				value=null;
				employeeRemoved=true;
			}
		}
		if (employeeRemoved=false) throw new IllegalArgumentException ("Employee you want to remove is not find in this department!");
	}
	
	int getStudentsNumber(){
		int numberOfStudents=0;
		Specialty spec;
		Group group;
		for (Object value:specialties){
			spec=(Specialty) value;
			for (Object value1:spec.groups){
				group=(Group)value1;
				for (Object value2:group.getStudent()){
					numberOfStudents++;
				}
			}
		}
		return numberOfStudents;
	}
	byte getSize(){
		byte size=(byte)(members.size());
		return size;	
	}
	
//	Group[] getGroups(){
//		int numberOfGroups=0;
//		for (Specialty value:specialties){
//			for (Group value1:value.groups){
//				numberOfGroups++;
//			}
//		}
//		Group[] groups=new Group[numberOfGroups];
//		int count=0;
//		for (Specialty value:specialties){
//			for (Group value1:value.groups){
//				groups[count]=value1;
//				count++;
//			}
//		}
//		return groups;
//	}

}
