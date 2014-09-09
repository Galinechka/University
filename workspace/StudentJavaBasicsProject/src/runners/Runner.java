package runners;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import exception.PersonException;

import model.person.Employee;
import model.unit.Department;
import service.EmployeeServiceImpl;

public class Runner {

	static EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
	static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) throws PersonException,
			ParseException {
		Employee empl1 = employeeService.addEmployee("Galina", "Saik",
				dateFormat.parse("1989-02-23"), dateFormat.parse("2012-09-01"),
				null);

	}

}
