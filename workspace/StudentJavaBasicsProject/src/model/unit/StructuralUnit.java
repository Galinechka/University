package model.unit;

import exception.PersonException;
import exception.UnitException;
import model.common.Persistable;

public class StructuralUnit extends Persistable {

	String title;
	
	public StructuralUnit(String title){
		this.title=title;
	}
	
	String getTitle(){
		return title;
	}
	void setTitle(String title){
		try {
			if (title.length()<=5){
				throw new UnitException("The title of the unit should be at least 6 symbols length.");
			}
		} catch (UnitException m){
			System.out.println(m.getMessage());
		}
		this.title=title;
	}
}
