package homework.console;

public class prakt1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 5, j = 10;//4)
		String str1 = "My first string";//5)
		System.out.println(str1);//6)
		System.out.println("Some text: "+str1);//7)
		int k = i+j;//8)
		System.out.println("Sum: "+k);//9)
		System.out.println("Sum: "+(i+j));//10)
		while(i < j){//11)
			System.out.println(str1);
			i++;
		} 
		if(i==j){ //12)
			System.out.println("i="+i+", j="+j+" они равны");
		} else {
			System.out.println("i="+i+", j="+j+" они не равны");
		}
		System.out.println(args[0]);//14)
	}

}
