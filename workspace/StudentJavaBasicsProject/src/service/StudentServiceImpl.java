package service;

import java.util.Date;

import exception.PersonException;

import model.person.Employee;
import model.person.Student;
import model.unit.Department;
import model.unit.Group;

public class StudentServiceImpl implements StudentService {
	
	Date today=new Date();

	@Override
	public Student addStudent(String firstName, String lastName, Date dateOfBirth,
			Date enrollmentDate, Group group) throws PersonException {
		if (firstName.length()<3 || lastName.length()<3 || dateOfBirth.after(today) 
				|| enrollmentDate.after(today)){
			throw new PersonException("Wrong data when adding a student.");
		}
			Student student=new Student(firstName, lastName, dateOfBirth, enrollmentDate, group);
		return student;
	}
	
	@Override
	public Student modifyStudent(Student student, String firstName, String lastName,
			Date dateOfBirth, Date enrollmentDate, Group group) throws PersonException {
		if (firstName.length()<3 || lastName.length()<3 || dateOfBirth.after(today) 
				|| enrollmentDate.after(today)){
			throw new PersonException("Wrong data when adding a student.");
		}
		Student modifiedStudent=student;
		modifiedStudent.setFirstName(firstName);
		modifiedStudent.setLastName(lastName);
		modifiedStudent.setBirthDay(dateOfBirth);
		modifiedStudent.setEnrollmentDate(enrollmentDate);
		modifiedStudent.setGroup(group);
		
		return modifiedStudent;
		
	}

	@Override
	public void deleteStudent(Student student) {
		Student deletedStudent=student;
		deletedStudent.setFirstName(null);
		deletedStudent.setLastName(null);
		deletedStudent.setBirthDay(null);
		deletedStudent.setEnrollmentDate(null);
		deletedStudent.setGroup(null);
		deletedStudent=null;
	}

	@Override
	public Employee transferStudentToEmployee(Student student, Date hireDate,
			Department department) {
		String[] employeeName=student.getFullName().split(" ");
		Employee newEmployee= new Employee(employeeName[0], employeeName[1],student.getBirthDay(),hireDate,department);
		return newEmployee;
	}

}
