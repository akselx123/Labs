package homework.p5exception.exceptions;

public class PassExcep extends Exception{
	
	public PassExcep(){
		super("Исключение в пароле");
	}
	
	public PassExcep(String str){
		super(str);
	}
	
}
