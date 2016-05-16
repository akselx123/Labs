package homework.p5exception.exceptions;

public class NumberExcep extends Exception{
	
	public NumberExcep(){
		super("Исключение в проверке на число");
	}
	
	public NumberExcep(String str){
		super(str);
	}
	
}
