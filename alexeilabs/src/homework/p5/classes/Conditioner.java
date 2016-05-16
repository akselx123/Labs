package homework.p5.classes;

public class Conditioner {
	
	public boolean on = false;
	
	
	public void condOnOff(Heating h, Thermo t, double temp){
		if(!h.heatingState()){
			if(t.tempState() > temp){
				on = true;
			}
			if(t.tempState() <= temp){
				on = false;
			}
		}
	}
	public void condOff(){
		on = false;
	}
	public boolean condState(){
		return on;
	}
	
	
}
