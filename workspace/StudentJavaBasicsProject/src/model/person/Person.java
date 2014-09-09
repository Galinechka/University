package model.person;
import java.util.Date;

import exception.PersonException;

import model.common.Fireable;
import model.common.Persistable;
import model.unit.Faculty;



public abstract class Person extends Persistable implements Fireable {

	public enum Sex{MALE, FEMALE};
	public enum Status{NEW, ACTIVE, FIRED, PENDING};
	
	
	String firstName;
	String lastName;
	Date birthDay;
	
	public Person(String firstName, String lastName, Date dateOfBirth) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.birthDay=dateOfBirth;
	}
	
	String getFirstName(){
		return firstName;
	}
	public void setFirstName(String firstName){
			try {
			if (firstName.length()<=1){
				throw new PersonException("The first name should be at least 2 symbols length.");
			}
		} catch (PersonException m){
			System.out.println(m.getMessage());
		}
		this.firstName=firstName;
	}
	String getLastName(){
		return lastName;
	}
	public void setLastName(String lastName){
		try {
			if (lastName.length()<=1){
				throw new PersonException("The last name should be at least 2 symbols length.");
			}
		} catch (PersonException m){
			System.out.println(m.getMessage());
		}
		this.lastName=lastName;
	}
	public Date getBirthDay(){
		return birthDay;
	}
	public void setBirthDay(Date birthDay){
		Date today=new Date();
		try {
			if (birthDay.after(today)){
				throw new PersonException("The person should be birth before today's date.");
			}
		} catch (PersonException m){
			System.out.println(m.getMessage());
		}
		this.birthDay=birthDay;
	}
		public String getFullName(){
		String fullName=firstName.concat(" ").concat(lastName);
		return fullName;
	}
	public short getAge(){
		Date date=new Date();
		long ageD=Math.abs((date.getTime()-birthDay.getTime()));
		ageD=ageD/1000/60/60/24/30/12;
		return (short) ageD;
		
	}
	abstract Faculty getFaculty();

}
