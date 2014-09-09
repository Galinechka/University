package service;

import model.unit.Department;
import model.unit.Faculty;
import model.unit.Group;
import model.unit.Specialty;
import exception.UnitException;

public class SpecialtyServiceImpl implements SpecialtyService{

	@Override
	public Specialty addSpecialty(String title) throws UnitException {
		//check if specialty with this name already exists
				if (title.length()<=2){
					throw new UnitException("Specialty name should be at least 3 symbols length.");
				}
				Specialty specialty=new Specialty(title);
				return specialty;
	}

	@Override
	public void changeDepartment(Specialty specialty, Department department)
			throws UnitException {
		if (specialty.getDepartment()==department){
			throw new UnitException("Current specialty already exist in this department.");
		}
		specialty.getDepartment().removeSpecialty(specialty);
		department.addSpecialty(specialty);
	}

	@Override
	public void addGroup(Specialty specialty, Group group) throws UnitException {
		if (specialty.getGroups().contains(group)){
			throw new UnitException("Current group already exist in this specialty.");
		}
		specialty.addGroup(group);
		
	}

	@Override
	public void deleteGroup(Specialty specialty, Group group)
			throws UnitException {
		if (!specialty.getGroups().contains(group)){
			throw new UnitException("Current group doesn't exist in this specialty, you can't remove it.");
		}
		specialty.removeGroup(group);
	}

}
