package homework.p5.classes;

public class Heating {
	
	public boolean on = false;
	
	public void heatingOnOff(Thermo t, double temp){
		if(t.tempState() < temp){
			on = true;
		}
		if(t.tempState() >= temp){
			on = false;
		}
	}
	public void heatingOff(){
		on = false;
	}
	public boolean heatingState(){
		return on;
	}
	
}
