import java.util.Scanner;

public class BasicCalculatorTUI extends BasicCalculator{

	private BasicCalculator BasicCalculator;
	private boolean running;
	private static String operation = "";
	private boolean equals = false;
	
	public BasicCalculatorTUI() {
		this.BasicCalculator = new BasicCalculator();
		running = true;
		start();
	}
	
	public void start() {
		while (running) {
			promptForNumber();
		}
		System.out.println("Would you like to do another operation Y/N");
		Scanner scanner = new Scanner(System.in);
		String procede = scanner.next();
		if (procede.equals("Y")){
			running = true;
			operation = "";
			equals = false;
			start();
		} 
		
		else if (procede.equals("N")) {
			running=false;
		}
		else {
			System.out.println("Invalid input. Program terminated.");
			running=false;
		}
	}
		
	public void promptForNumber() {	
		
		int i = 1;
		while (i!=0) {
		
		System.out.print("Enter a number:");
		Scanner scanner = new Scanner(System.in);
		String numin = scanner.nextLine();
		operation += numin;
		System.out.println(operation);
		
		displayOptions();
		optionInput();
		
			if (equals == true) {
				computeResult();
				System.out.println("Result is: " + getResult());
				i = 0;
				running = false;
			}
		}
	}
	
	public void displayOptions() {
		System.out.println("Arithmetic Operations:");
		System.out.println("	1. equals = ");
		System.out.println("	2. add + ");
		System.out.println("	3. substract -");
		System.out.println("	4. multiply *");
		System.out.println("	5. divide /");
		System.out.println("	6. brackets (");
		System.out.println("	7. brackets )");
	}
	
	public void optionInput() {
		System.out.println("Enter an arithmetic operation or equal: ");
		Scanner scannerop = new Scanner(System.in);
		String op = scannerop.nextLine();
		String ops = BasicCalculator.BasicOperations(op);
		if (ops == "notvalid") {
			System.out.print("Last input errased. Enter a valid operation");
			optionInput();
		}
		else if (ops == " = "){
			equals = true;
		}
		else {
			operation += ops;
			System.out.println(operation);
		}
		
	}
	
	public static String getOperation() {
		return operation;
	}
	
}
