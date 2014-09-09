package exception;

public class UnitException extends UniversityException{

	public UnitException() {
		super("Invalid unit data!");
	}
	
	public UnitException(String message) {
		super(message);
	}

}
