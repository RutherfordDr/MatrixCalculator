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
		displayOptions();
		while (running) {
			promptForNumber();
		}
		System.out.println("Would you like to do another operation Y/N");
		Scanner scanner = new Scanner(System.in);
		String procede = scanner.next();
		while (!procede.equals("Y") && !procede.equals("N")) {
			System.out.println("Would you like to do another operation Y/N");
			procede = scanner.next();
		}
		if (procede.equals("Y")){
			running = true;
			BasicCalculator.setPreviousEquation(operation);
			operation = "";
			equals = false;
			start();
		} 
		
		else  {
			closeHistory();
			operation = "";
			equals = false;
			System.out.println("Would you like to view the session history? Y/N");
			String viewHistory = scanner.next();
			while (!viewHistory.equals("Y") && !viewHistory.equals("N")){
				System.out.println("Would you like to view the session history? Y/N");
				viewHistory = scanner.next();
			}
			if (viewHistory.equals("Y")) {
				readHistory();
				running = false;
			} else {
				running = false;
			}	
		
		}
		
	}
		
	public void promptForNumber() {	
		
		int i = 1;
		while (i!=0) {
		
			
			// OPERATION OR NUMBER
		//displayOptions();
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
				try {
				computeResult();
				System.out.println("Result is: " + getResult());
				BasicCalculator.setPreviousAns(Double.toString(getResult()));
				i = 0;
				running = false;
				} catch (Exception e) {
				System.out.println("Invalid equation.");
				i = 0;
				running = false;
				}
				
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
		System.out.println("	8. previousEquation ");
		System.out.println("	9. previousAns ");
		System.out.println("	10. getEquation ");
		System.out.println("	10. backspace ");
	}
	
	public void optionInput() {
		String ops = BasicCalculator.BasicOperations(op);
		if (ops == "notvalid") {
			System.out.println("Last input erased. Enter a valid operation. ");
			op ="";
			displayOptions();
			promptForNumber();
		}
		else if (ops == " = "){
			equals = true;
		}else if (ops.equals("backspace")) {
			if (operation.length() > 1) {
		        operation = operation.substring(0, operation.length() - 1);
			}
		}else {
			operation += ops;
		}
		
	}
	
	public static String getOperation() {
		return operation;
	}
	
}
