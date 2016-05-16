package homework.p5.classes;

public class Signaling {
	
	public boolean on = false;
	public String pass = "1234";
	
	public String signOnOff(String p){
		if(!on){
			if(pass.equals(p)){
				on = true;
				return "Сигнализация включена";
			}
			else {
				return "Сигнализация не включена, неверный пароль";
			}
		}
		else {
			if(pass.equals(p)){
				on = false;
				return "Сигнализация выключена";
			}
			else {
				return "Сигнализация не выключена, неверный пароль";
			}
		}
	}
	public boolean signState(){
		return on;
	}
	
	
}
