import java.util.Scanner;

public class BasicCalculator {

	private Scanner scanner;
	private double ans;
	private ArrayList<String> sessionHistory = new ArrayList<String>();
	private String operation = "";
	private double result;
	private String previousAns= "0";
	private String previousEquation = "";
	private String filename = "basicCalculatorHistory.txt";
	
	//Displays the operations options and prompts the user to input numeric values for the basic equation
	public BasicCalculator() {
		
		if (Main.scientific == false){
		System.out.print("Insert number (type double):");
		scanner = new Scanner(System.in); 
		String numin = scanner.nextLine();
		ans = Double.parseDouble(numin);
		
		int i = 0;
		while (i==0) {
		
		System.out.print("Addition=1, Substaction=2, Multiplication=3, Division=4, Equals=5: ");
		scanner = new Scanner(System.in); 
		String op = scanner.nextLine();
		int operation = Integer.parseInt(op);
		
		if (operation==5){
			OpType(0, 5);
			i=1; break;}
		
		System.out.print("Insert number (type double):");
		scanner = new Scanner(System.in); 
		String num = scanner.nextLine();
		double numb = Double.parseDouble(num);
		
		OpType(numb, operation);
		}
		}
		
	}
	
	public void BasicCalc(){
		
	}
	
	//Calls certain methods depending on what the operation input value is corresponding to each operation
	public void OpType(double epx, int op) {
		
		switch (op) {
		case 1:
			Addition(epx); break;
		case 2:
			Substraction(epx); break;
		case 3:
			Multiplication(epx); break;
		case 4:
			Division(epx); break;
		case 5:
			System.out.println("Result is:" + ans); break;
		default:
			System.out.println("Operation not valid"); 
			break;
		}
	}
	
	//Does addition between the input value and the current value
	public void Addition(double epx) {
		ans+=epx;
		
	}
	
	//Does subtraction between the input value and the current answer value
	public void Substraction(double epx) {
		ans-=epx;
		
	}
	
	//Does multiplication between the input value and the current answer value
	public void Multiplication(double epx) {
		ans*=epx;
		
	}
	
	//Does division between the input value and the current answer value
	public void Division(double epx) {
		ans/=epx;
		
	}
}
