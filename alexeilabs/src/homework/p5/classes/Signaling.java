package homework.p5.classes;

public class Signaling {
	
	public boolean on = false;
	public String pass = "1234";
	
	public String signOnOff(String p){
		if(!on){
			if(pass.equals(p)){
				on = true;
				return "������������ ��������";
			}
			else {
				return "������������ �� ��������, �������� ������";
			}
		}
		else {
			if(pass.equals(p)){
				on = false;
				return "������������ ���������";
			}
			else {
				return "������������ �� ���������, �������� ������";
			}
		}
	}
	public boolean signState(){
		return on;
	}
	
	
}
