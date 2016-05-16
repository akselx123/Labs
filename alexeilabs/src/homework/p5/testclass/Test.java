package homework.p5.testclass;
import homework.p5.classes.*;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		//Sensor moveSens1 = new Sensor(),
				//moveSens2 = new Sensor(),
				//temperatureSens = new Sensor();
		Heating otoplenieK1 = new Heating(),
		otoplenieK2 = new Heating();
		Light svetK1 = new Light(), svetK2 = new Light();
		Thermo temperatureK1 = new Thermo(),
				temperatureK2 = new Thermo();
		Conditioner condK1 = new Conditioner(),
				condK2 = new Conditioner();
		Signaling sign = new Signaling();
		Sirena sirena = new Sirena();
		double temperK1 = 0.0, temperK2 = 0.0, otv;
		String q;
				
		System.out.print("1) Включение датчика движения в комнате 1\n"
				+ "2) Включение датчика движения в комнате 2 \n"
				+ "3) Задать температуру в комнате 1 \n"
				+ "4) Задать температуру в комнате 2 \n"
				+ "5) Поднять показаель термометра в комнате 1 \n"
				+ "6) Поднять показатель термометра в комнате 2 \n"
				+ "7) Понизить показания термометра в комнате 1\n"
				+ "8) Понизить показания термометра в комнате 2\n"
				+ "9) Выключение датчика движения в комнате 1\n"
				+ "10) Выключение датчика движения в комнате 2\n"
				+ "11) Включение/выключение сигнализации \n"
				+ "12) Получить логи по сигнализации \n"
				+ "13) Вывод состояния \n"
				+ "Введите команду: ");
		while(in.hasNext()){
			
			String s = in.next();
			if(s.equals("exit")){
				break;
			}
			int s1 = Integer.parseInt(s);
			switch (s1) {
				case 1: svetK1.sen.sensorOn(); break;
				case 2: svetK2.sen.sensorOn(); break;
				case 3: System.out.print("Введите желаемую температуру ");
						q = in.next();
						temperK1 = Double.parseDouble(q);
					break;
				case 4: System.out.print("Введите желаемую температуру ");
						q = in.next();
						temperK2 = Double.parseDouble(q);
				break;
				case 5: temperatureK1.tempVverh(); break;
				case 6: temperatureK2.tempVverh(); break;
				case 7: temperatureK1.tempVniz(); break;
				case 8: temperatureK2.tempVniz(); break;
				case 9: svetK1.sen.sensorOff(); break;
				case 10: svetK2.sen.sensorOff(); break;
				case 11:System.out.print("Введите пароль: ");
						q = in.next(); 
						System.out.println(sign.signOnOff(q));
						if(sign.signState()){ 
							sirena.sirenaClearLogs();}
						break;
				case 12: System.out.print(sirena.sirenaGetLogs()); break;
				case 13: System.out.print("Свет в комнате 1: "+svetK1.lightState()
						+ "\nСвет в комнате 2: "+svetK2.lightState()
						+ "\nОтопление в комнате 1: "+otoplenieK1.heatingState()
						+ "\nОтопление в комнате 2: "+otoplenieK2.heatingState()
						+ "\nКондиционер в комнате 1: "+condK1.condState()
						+ "\nКондиционер в комнате 2: "+condK2.condState()
						+ "\nТемпература в комнате 1: "+ temperatureK1.tempState()
						+ "\nТемпература в комнате 2: "+ temperatureK2.tempState()+"\n"
						+ "Сигнализация: "+sign.signState()+"\n"
						+ "Сирена: "+sirena.sirenaState()+"\n"); 
						break;
			}
			
			sirena.sirenaOnOff(sirena.sirenaScan(sign, svetK1.sen) || sirena.sirenaScan(sign, svetK2.sen));
			//sirena.sirenaScan(sign, moveSens1);
			//sirena.sirenaScan(sign, moveSens2);
			
			svetK1.lightScanSens();
			svetK2.lightScanSens();
			
			otv = temperatureK1.tempState();
			if(otv > temperK1){
				otoplenieK1.heatingOff();
				condK1.condOnOff(otoplenieK1, temperatureK1, temperK1);
			}
			else if(otv < temperK1){
				condK1.condOff();
				otoplenieK1.heatingOnOff(temperatureK1, temperK1);
			}
			
			otv = temperatureK2.tempState();
			if(otv > temperK2){
				otoplenieK2.heatingOff();
				condK2.condOnOff(otoplenieK2, temperatureK2, temperK2);
			}
			else if(otv < temperK2){
				condK2.condOff();
				otoplenieK2.heatingOnOff(temperatureK2, temperK2);
			}
			
			if(sign.signState()){
				svetK1.lightOff();
				svetK2.lightOff();
				otoplenieK1.heatingOff();
				otoplenieK2.heatingOff();
				condK1.condOff();
				condK2.condOff();
			}
			
			/*System.out.print("Свет в комнате 1: "+svetK1.lightState()
					+ "\nСвет в комнате 2"+svetK2.lightState()
					+ "\nОтопление в комнате 1"+otoplenieK1.heatingState()
					+ "\nОтопление в комнате 2"+otoplenieK2.heatingState()
					+ "\nКондиционер в комнате 1"+condK1.condState()
					+ "\nКондиционер в комнате 2"+condK2.condState()
					+ "\nТемпература в комнате 1"+ temperatureK1.tempState()
					+ "\nТемпература в комнате 2"+ temperatureK2.tempState()+"\n");*/
			
			
			
			
			System.out.print("Введите номер команды: ");
		}
		System.out.print("Программа завершена!");
		in.close();
	}

}
