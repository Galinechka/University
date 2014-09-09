package service;

import exception.UnitException;

import model.person.Employee;
import model.unit.Department;
import model.unit.Faculty;

public class FacultyServiceImpl implements FacultyService {

	@Override
	public Faculty addFaculty(String title) throws UnitException {
		//check is department with this name already exists
		if (title.length()<=2){
			throw new UnitException("Faculty name should be at least 3 symbols length.");
		}
		Faculty faculty=new Faculty(title);
		return faculty;
	}

	@Override
	public Faculty changeFacultyName(Faculty faculty, String title) throws UnitException {
		//check is department with this name already exists
		if (title.length()<=2){
			throw new UnitException("Faculty name should be at least 3 symbols length.");
		}
		Faculty modifyedFaculty=faculty;
		modifyedFaculty.setTitle(title);
		return modifyedFaculty;
	}

	@Override
	public void setDean(Faculty faculty, Employee dean) {
		//check if dean is a dean of some other faculty
		Faculty modifyedFaculty=faculty;
		modifyedFaculty.setDean(dean);
	}

	@Override
	public void addDepartment(Faculty faculty, Department department) throws UnitException {
		if (faculty.getDepartments().contains(department)){
			throw new UnitException(department + " already exists in faculty " + faculty);
		}
		faculty.addDepartment(department);
	}

	@Override
	public Department removeDepartment(Faculty faculty, Department department) throws UnitException {
		if (!faculty.getDepartments().contains(department)){
			throw new UnitException(department + " doesn't exists in faculty " + faculty + "you can not delete it.");
		}
		faculty.removeDepartment(department);
		return null;
	}

}
