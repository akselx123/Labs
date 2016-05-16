package homework.p5exception.exceptions;

public class TextExcep extends Exception{
	
	public TextExcep(){
		super("Исключение в текстовом поле");
	}
	
	public TextExcep(String str){
		super(str);
	}
}
