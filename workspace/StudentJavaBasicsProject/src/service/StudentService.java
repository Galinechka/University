package service;

import java.util.Date;

import exception.PersonException;

import model.person.Employee;
import model.person.Student;
import model.unit.Department;
import model.unit.Group;

public interface StudentService {
	public Student addStudent(String firstName, String lastName, Date dateOfBirth, Date enrollmentDate, Group group) throws PersonException;

	public Student modifyStudent(Student student, String firstName, String lastName, Date dateOfBirth, Date enrollmentDate, Group group) throws PersonException;
	
	public void deleteStudent(Student student);
	
	public Employee transferStudentToEmployee(Student student, Date hireDate, Department department);
	
}
