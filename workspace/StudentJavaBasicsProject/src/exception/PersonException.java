package exception;

public class PersonException extends UniversityException{

	public PersonException() {
		super("Ivalid person data.");
	}
	
	public PersonException(String message) {
		super(message);
	}

}
