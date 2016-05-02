package homework.p4;

import java.util.Scanner;

public class prgsite {

	public static String description = "This is a simple program.";
	public static String descriptionCommand = "-d";
	
	public static String youName = "What is your name? ";
	public static String youNameCommand = "-hello";
	public static String youNameSPS = "Thank you";
	
	public static String webCommand = "-web";
	public static String web = "Our website is http://site.ru";
	
	public static String allCommand = "-?";
	public static String all = "Commands: \n";
	public static String allText = "All commands";
	
	public static String models = "This a spisok of model.\n1) "
			+ "R/Y model s DVS RTA4 S28 4WD SHORT COURSE TRUCK "
			+ "\n2) OFF-ROAD BUGGY VRX-2 4WD, GO.21, RTR, 2.4G"
			+ " \n3) 1/9 GP 4WD R/S DRX DEMON";
	public static String modelCommand = "-m";
	public static String modelsText = "Show spisok of model (command: -m [#modeli])";
	
	public static String raschet = "Rasschitat (comand: -r [par1] [par2]) podrobnee v -?";
	public static String raschetCommand = "-r";
	public static String raschetText = "Raschitat class or engime (command: -r obem) Raschitat time of work (command: -r emkost_akb tok_potreb)";
	
	public static String[] modelMass;
	public static String name;
	public static String[][] commands;
	public static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double par1, par2;
		
		createAllCommands();
		createModelMass();
		
		if(args.length != 0){
			
			if(args[0].equals(descriptionCommand)){
				getDescription();
			}
			else if (args[0].equals(youNameCommand)){
				sayYouName();
			}
			else if (args[0].equals(webCommand)){
				webFunc();
			}
			else if (args[0].equals(allCommand)){
				allFunc();
			}
			else if (args[0].equals(raschetCommand)){
				if(args.length == 2){
					par1 = Double.parseDouble(args[1]);
					int engClass = (int)((par1/16.387064)*100);
					System.out.println("Class engine - "+engClass);
				}
				else if(args.length == 3){
					par1 = Double.parseDouble(args[1]);
					par2 = Double.parseDouble(args[2]);
					System.out.println("Time of work ot battary: "+((par1)/(par2*1.3))+" hour.");
				}
				else if(args.length == 1){
					getRaschet();
				}
				else{
					System.out.println("You are wrong, try another combination of parametrs");
				}
			}
			else if (args[0].equals(modelCommand)){
				if(args.length == 2){
					if(args[1].equals("1")){
						System.out.println(modelMass[0]);
					}
					else if(args[1].equals("2")){
						System.out.println(modelMass[1]);
					}
					else if(args[1].equals("3")){
						System.out.println(modelMass[2]);
					}
					else{
						System.out.println("You are wrong, try another combination of parametrs");
					}
				}
				else if(args.length == 1){
					getModels();
				}
				else{
					System.out.println("You are wrong, try another combination of parametrs");
				}
			}
			
						
		}		
	}
	
	private static void getRaschet() {
		// TODO Auto-generated method stub
		System.out.println(raschet);
	}

	private static void createModelMass() {
		// TODO Auto-generated method stub
		modelMass = new String[3];
		
		modelMass[0] = "SPETSIFICATION:\n"
				+"Kolesnaya baza: 368mm\n"
				+"Ves: 5000gr\n"
				+"Dlina: 610mm \n"
				+"Width: 335mm\n"
				+"Height:240mm\n"
				+"Klirens: 60mm";
		modelMass[1] = "SPETSIFICATION:\n"
				+"Mashtab: 1/8\n"
				+"Dlina: 505 mm\n"
				+"Width: 305 mm\n"
				+"Height: 175 mm\n"
				+"Privod: full\n"
				+"Klirens: 35 mm\n"
				+"Kolesnaya baza: 330 mm\n"
				+"Peredatochnoe chislo: 11.85:1\n"
				+"Kolesa: 115 mm/ 42 mm\n"
				+"Toplivniy bak: 125 kyb. sm.\n"
				+"Peredathik: 2-kanalniy (2,4 GHz)";
		modelMass[2] = "SPETSIFICATION\n"
				+"Mashtab: 1:9 \n"
				+"Width: 260mm\n"
				+"Dlina: 560mm \n"
				+"Height: 187mm\n"
				+"Kolesnaya baza: 316mm\n"
				+"Ves: 2600 g\n"
				+"Main peredacha: 8.86:1";
		
		
	}

	private static void getModels() {
		// TODO Auto-generated method stub
		System.out.println(models);
	}

	private static void createAllCommands() {
		// TODO Auto-generated method stub
		commands = new String[6][2];
		
		commands[0][0] = descriptionCommand;
		commands[0][1] = description;
		
		commands[1][0] = youNameCommand;
		commands[1][1] = youName;
		
		commands[2][0] = webCommand;
		commands[2][1] = web;
		
		commands[3][0] = allCommand;
		commands[3][1] = allText;
		
		commands[4][0] = modelCommand;
		commands[4][1] = modelsText;
		
		commands[5][0] = raschetCommand;
		commands[5][1] = raschetText;
	}

	private static void allFunc() {
		// TODO Auto-generated method stub
		System.out.println(all);
		for(String[] s:commands){//foreach Эквивалент обычному привычному циклу вывода
			System.out.println(s[0]+": "+s[1]);
		}
	}
	private static void webFunc() {
		// TODO Auto-generated method stub
		System.out.print("Website: "+web);
	}
	private static void sayYouName() {
		// TODO Auto-generated method stub
		
		System.out.print(youName);
		name = in.next();
		System.out.println(youNameSPS+", "+name+"!=)");
	}
	private static void getDescription() {
		// TODO Auto-generated method stub
		System.out.print("Description: "+description);
	}

}
