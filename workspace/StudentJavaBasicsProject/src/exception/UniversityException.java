package exception;

public class UniversityException extends Exception{

	public UniversityException(){
		super("Something is going wrong in University application!");
	}
	
	public UniversityException(String message){
	super(message);	
	}
	
	
}
