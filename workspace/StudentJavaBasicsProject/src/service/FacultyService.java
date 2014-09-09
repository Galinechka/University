package service;

import java.util.Date;

import exception.PersonException;
import exception.UnitException;

import model.person.Employee;
import model.unit.Department;
import model.unit.Faculty;

public interface FacultyService {
	public Faculty addFaculty(String title) throws UnitException;
	
	public Faculty changeFacultyName(Faculty faculty, String title) throws UnitException;
	
	public void setDean(Faculty faculty, Employee dean);
	
	public void addDepartment(Faculty faculty, Department department) throws UnitException;
	
	public Department removeDepartment(Faculty faculty, Department department) throws UnitException;
}
