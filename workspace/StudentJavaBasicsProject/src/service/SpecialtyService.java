package service;

import exception.UnitException;
import model.unit.Department;
import model.unit.Group;
import model.unit.Specialty;

public interface SpecialtyService {
	public Specialty addSpecialty(String title) throws UnitException;
	
	public void changeDepartment(Specialty specialty, Department department) throws UnitException;
	
	public void addGroup(Specialty specialty, Group group)throws UnitException;
	
	public void deleteGroup(Specialty specialty, Group group)throws UnitException;
	
}
