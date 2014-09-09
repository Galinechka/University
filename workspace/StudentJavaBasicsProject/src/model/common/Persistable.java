package model.common;

public class Persistable {

	static long counter;
	long id;
	
	public Persistable(){
		
	}
	static long getTotalNumber(){
		return counter;
	}
	long getId(){
		return id;
	}
}
