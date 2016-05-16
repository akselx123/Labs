package homework.p5.classes;

public class Thermo {
	
	public double temperature = 0.0;
	
	public void tempVverh(){
		temperature += 5.5;
	}
	public void tempVniz(){
		temperature -= 5.5;
	}
	public double tempState(){
		return temperature;
	}
	
}
