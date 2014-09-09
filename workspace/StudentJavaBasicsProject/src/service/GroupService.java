package service;

import exception.UnitException;
import model.person.Employee;
import model.person.Student;
import model.unit.Group;
import model.unit.Specialty;

public interface GroupService {
	public Group addGroup(String title)throws UnitException;
	
	public Group addGroup(String title,Specialty specialty, Employee curator)throws UnitException;
	
	public void setCurator(Group group, Employee curator)throws UnitException;
	
	public void setSpecialty(Group group, Specialty specialty)throws UnitException;
	
	public void changeSpecialty(Group group, Specialty newSpecialty)throws UnitException;
	
	public void addStudent(Group group, Student student)throws UnitException;
	
	public void deleteStudent(Group group, Student student)throws UnitException;
}
