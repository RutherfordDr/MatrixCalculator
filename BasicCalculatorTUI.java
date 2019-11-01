import java.util.Scanner;

public class BasicCalculatorTUI extends BasicCalculator{

	private BasicCalculator BasicCalculator;
	private boolean running;
	private static String operation = "";
	private boolean equals = false;
	private String op ="";
	
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
		
			
			// OPERATION OR NUMBER
		displayOptions();
		System.out.print("Enter an operation or number: ");
		Scanner scanner = new Scanner(System.in);
		String numin = scanner.nextLine();
		
		if (isNumeric(numin) == true) {
			operation+=numin;
			System.out.println(operation);
			continue;
		}
		else {
			op = numin;
			optionInput();
			System.out.println(operation);
		}
		
			if (equals == true) {
				computeResult();
				System.out.println("Result is: " + getResult());
				i = 0;
				running = false;
			}
		System.out.println("\033[H\033[2J");
		System.out.println(operation);
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
		String ops = BasicCalculator.BasicOperations(op);
		if (ops == "notvalid") {
			System.out.print("Last input errased. Enter a valid operation. ");
			optionInput();
		}
		else if (ops == " = "){
			equals = true;
		}
		else {
			operation += ops;
		}
		
	}
	
	public static String getOperation() {
		return operation;
	}
	
}
