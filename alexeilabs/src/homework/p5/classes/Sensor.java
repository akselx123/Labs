package homework.p5.classes;

public class Sensor {
	
	public boolean on = false;
	
	public void sensorOn(Light l){// Пока не используется
		on = true;
		//l.lightScanSens(this);
	}
	public void sensorOff(Light l){// Пока не используется
		on = false;
		//l.lightScanSens(this);
	}
	public void sensorOn(){
		on = true;
	}
	public void sensorOff(){
		on = false;
	}
	public boolean sensorState(){
		return on;
	}
	public void tempSensorOff(Thermo t, double term){// Пока не используется
		if(t.tempState() >= term){
			on = true;
		} else {
			on = false;
		}
	}
	
}
