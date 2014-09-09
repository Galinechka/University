package service;

import java.util.Date;

import exception.PersonException;

import model.person.Employee;
import model.person.Student;
import model.unit.Department;
import model.unit.Group;

public class EmployeeServiceImpl implements EmployeeService {
	
	Date today=new Date();

	@Override
	public Employee addEmployee(String firstName, String lastName,
			Date dateOfBirth, Date hireDate, Department department) throws PersonException {
		if (firstName.length()<3 || lastName.length()<3 || dateOfBirth.after(today) 
				|| hireDate.after(today)){
			throw new PersonException("Wrong data when adding an employee.");
		}
		Employee newEmployee=new Employee(firstName, lastName, dateOfBirth, hireDate, department);
		DepartmentServiceImpl ds= new DepartmentServiceImpl();
		ds.addEmployeeToDepartment(newEmployee, department);
		return newEmployee;
	}

	@Override
	public Employee modifyEmployee(Employee employee, String firstName,
			String lastName, Date dateOfBirth, Date hireDate,
			Department department) throws PersonException {
		if (firstName.length()<3 || lastName.length()<3 || dateOfBirth.after(today) 
				|| hireDate.after(today)){
			throw new PersonException("Wrong data when adding an employee.");
		}
		Employee modifiedEmployee=employee;
		modifiedEmployee.setFirstName(firstName);
		modifiedEmployee.setLastName(lastName);
		modifiedEmployee.setBirthDay(dateOfBirth);
		modifiedEmployee.setHireDate(hireDate);
		modifiedEmployee.setDepartment(department);
		return modifiedEmployee;
	}

	@Override
	public void deleteEmployee(Employee employee) {
		Employee deletedEmployee=employee;
		deletedEmployee=null;
	}

	@Override
	public Student transferEmployeeToStudent(Employee employee, Date enrollmentDate, Group group) {
		String[] studentFullName=employee.getFullName().split(" ");
		Student student=new Student(studentFullName[0], studentFullName[1], employee.getBirthDay(), enrollmentDate, group);
		return student;
	}

}
