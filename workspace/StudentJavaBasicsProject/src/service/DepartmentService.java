package service;

import model.person.Employee;
import model.unit.Department;
import model.unit.Faculty;

public interface DepartmentService {
	public Department addDepartment(String title, Employee employee, Faculty faculty);

	public void deleteDepartment(Department department);
	
	public void addEmployeeToDepartment(Employee employee, Department department);
	
	public void deleteEmployeeFromDepartment(Employee employee, Department department);
	
}
