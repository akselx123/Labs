package homework.p5exception.exceptions;

public class TextExcep extends Exception{
	
	public TextExcep(){
		super("���������� � ��������� ����");
	}
	
	public TextExcep(String str){
		super(str);
	}
}
