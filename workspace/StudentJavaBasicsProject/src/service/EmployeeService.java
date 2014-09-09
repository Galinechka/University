package service;

import java.util.Date;

import exception.PersonException;

import model.person.Employee;
import model.person.Student;
import model.unit.Department;
import model.unit.Group;

public interface EmployeeService {
	public Employee addEmployee(String firstName, String lastName, Date dateOfBirth, Date hireDate, Department department) throws PersonException;

	public Employee modifyEmployee(Employee employee, String firstName, String lastName, Date dateOfBirth, Date hireDate, Department department) throws PersonException;
	
	public void deleteEmployee(Employee employee);
	
	public Student transferEmployeeToStudent(Employee employee, Date enrollmentDate, Group group);
}
