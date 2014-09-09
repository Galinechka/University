package service;

import model.person.Employee;
import model.unit.Department;
import model.unit.Faculty;

public class DepartmentServiceImpl implements DepartmentService {

	@Override
	public Department addDepartment(String title, Employee employee,
			Faculty faculty) {
		Department dep=new Department(title, employee, faculty);
		return dep;
	}

	@Override
	public void deleteDepartment(Department department) {
		Department dep=department;
		dep=null;
		
	}

	@Override
	public void addEmployeeToDepartment(Employee employee, Department department) {
		
		
	}

	@Override
	public void deleteEmployeeFromDepartment(Employee employee,
			Department department) {
		// TODO Auto-generated method stub
		
	}

}
