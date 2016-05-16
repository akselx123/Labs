package homework.p5.classes;

public class Light {
	
	public boolean on = false;
	public Sensor sen = new Sensor();
	
	public void lightScanSens(){
		if(sen.sensorState()){
			on = true;
		}
		if(!sen.sensorState()){
			on = false;
		}
	}
	public void lightOff(){
		on = false;
	}
	public boolean lightState(){
		return on;
	}
	
}
