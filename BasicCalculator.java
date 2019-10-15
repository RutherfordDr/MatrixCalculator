import java.util.Scanner;

public class BasicCalculator {

	private Scanner scanner;
	private double ans;
	
	
	public BasicCalculator() {
		
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
	
	public BasicCalculator(String epx, String op) {
		
	}
	
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
	
	public void Addition(double epx) {
		ans+=epx;
		
	}
	
	public void Substraction(double epx) {
		ans-=epx;
		
	}
	
	public void Multiplication(double epx) {
		ans*=epx;
		
	}
	
	public void Division(double epx) {
		ans/=epx;
		
	}
}
