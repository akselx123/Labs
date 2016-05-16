package homework.p5exception.exceptions;

public class EmailExcep extends Exception{
	
	public EmailExcep(){
		super("Исключение в email");
	}
	
	public EmailExcep(String str){
		super(str);
	}
	
}
