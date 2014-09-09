package model.unit;

import java.util.Set;

import model.person.Employee;
import model.person.Student;

public class Specialty extends StructuralUnit{

	public enum Degree{
		BACHELOR (4, 3000), 
		MASTER(2, 4000), 
		PHD(1, 5000);
	
		int yearsForLearning;
		int moneyToPayForLiving;
		
		Degree(int years, int money){
			this.yearsForLearning=years;
			this.moneyToPayForLiving=money;
		}
	};
	
		Set groups;
		Department department;
		
		public Specialty(String title){
			super(title);
		}
		
		public Specialty(String title, Department department){
			super(title);
			this.department=department;
		}
		
		public Department getDepartment(){
			return department;
		}
		public void setDepartment(Department department){
			this.department=department;
			department.addSpecialty(this);
		}
		public Set getGroups(){
			return groups;
		}
		
		public void addGroup (Group group){
			groups.add(group);
		}
		public void removeGroup(Group group){
			for (Object value:groups){
				if (value.equals(group)){
					groups.remove(value);
				}
			}
		}
		int getStudentsNumber(){
			int numberOfStudents=0;
			Group group;
			for (Object value:groups){
				group=(Group)value;
					for (Object value1:group.students){
						numberOfStudents++;
					}
			}
			return numberOfStudents;
		}
		Faculty getFaculty(){
			return department.faculty;
		}
			
//		Employee[] getCurators(){
//			int numberOfCurators=0;
//			for (Group value1:groups){
//					numberOfCurators++;
//			}
//			Employee[] curators=new Employee[numberOfCurators];
//			int count=0;
//			for (Group value1:groups){
//				curators[count]=value1.curator;
//					count++;
//			}
//			return curators;
//
//	}

}
