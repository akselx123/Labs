package homework.p5.classes;

public class Sirena {
	
	public boolean on = false;
	public String logs = "";
	
	public boolean sirenaScan(Signaling s, Sensor sen){
		if(s.signState() && sen.sensorState()){
			if(!on) {
				logs += "Сработала сигнализация. \n";}
			return true;
		}
		else{
			return false;
		}
	}
	public void sirenaOnOff(boolean b){
		on = b;
	}
	public boolean sirenaState(){
		return on;
	}
	public String sirenaGetLogs(){
		return logs;
	}
	public void sirenaClearLogs(){
		logs = "";
	}
	
}
