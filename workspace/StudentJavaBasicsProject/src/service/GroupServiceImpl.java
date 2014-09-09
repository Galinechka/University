package service;

import model.person.Employee;
import model.person.Student;
import model.unit.Group;
import model.unit.Specialty;
import exception.UnitException;

public class GroupServiceImpl implements GroupService {

	@Override
	public Group addGroup(String title) throws UnitException {
		// check if group with this title already exist
		if (title.length() <= 2) {
			throw new UnitException(
					"The group title should be more than 3 symbols length.");
		}
		Group group = new Group(title);
		return group;
	}

	@Override
	public Group addGroup(String title, Specialty specialty, Employee curator)
			throws UnitException {
		// check if curator is a curator of some other group
		if (title.length() <= 2 || specialty == null) {
			throw new UnitException();
		}
		Group group = new Group(title, specialty, curator);
		return group;
	}

	@Override
	public void setCurator(Group group, Employee curator) throws UnitException {
		// check if curator is a curator of some other group
		group.setCurator(curator);
	}

	@Override
	public void setSpecialty(Group group, Specialty specialty)
			throws UnitException {
		if (specialty == null) {
			throw new UnitException("Specialty you try to set doesn't exist.");
		}
		group.setSpecialty(specialty);
	}

	@Override
	public void addStudent(Group group, Student student) throws UnitException {
		// check if student is in other group
		if (group.getStudent().contains(student)) {
			throw new UnitException("This group already containts the student "
					+ student);
		}
		group.addStudent(student);

	}

	@Override
	public void deleteStudent(Group group, Student student)
			throws UnitException {
		if (!group.getStudent().contains(student)) {
			throw new UnitException("This group doesn't containts the student "
					+ student + ".You can't delete it.");
		}
		group.removeStudent(student);

	}

	@Override
	public void changeSpecialty(Group group, Specialty newSpecialty)
			throws UnitException {
		if (group.getSpecialty() == newSpecialty || newSpecialty == null) {
			throw new UnitException();
		}
		group.getSpecialty().removeGroup(group);
		group.setSpecialty(newSpecialty);
		newSpecialty.addGroup(group);
	}

}
