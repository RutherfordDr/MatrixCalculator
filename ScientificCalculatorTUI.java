import java.util.Scanner;

public class ScientificCalculatorTUI {
	private ScientificCalculator scientificCalculator;
	private boolean running;
	private boolean TUIrunning;
	private boolean writingEquation;
	
	/*public static void main(String[] args) {
		
		 * To get the ScientificCalculator running do the following:
		 * 
		 * 		ScientificCalculatorTUI calc = new ScientificCalculatorTUI();
		 *		calc.start();
		 *
		 *
		 * ScientificCalculatorTUI calc = new ScientificCalculatorTUI();
		 * calc.start();
		 *
		}
	*/
	public ScientificCalculatorTUI() {
		this.scientificCalculator = new ScientificCalculator();
		running = true;
		TUIrunning = true;
		writingEquation = true;
		
		start();
		
	}
	
	public void start() {
		while (TUIrunning) {
			displayOptions();
			while (running) {
				promptForEquation();
			}
			promptToQuit();}

	}
	
	public void promptToQuit() {
		 System.out.println("Would you like to enter another equation Y/N");
		 Scanner scanner = new Scanner(System.in);
		 String procede = scanner.next();
		 if (procede.equals("N")){
			TUIrunning = false;
		} else if (procede.equals("Y") ) {
				scientificCalculator.resetEquationString();
				running = true;
				writingEquation = true;
				start();
		} else {
				promptToQuit();
			}
	 }
	/*
	 * Displays the arithmetic options in a list.
	 * 	Ex:
	 * 		Arithmetic Options:
	 * 			1. log
	 * 			2. ln
	 * 			3. exponent
	 */
	public void displayOptions() {
		String formattedOptions = "Arithmetic Options: ";
		int number = 1;
		for (String i: scientificCalculator.getArithmeticOptions()) {
			formattedOptions += "\r\n\t" + number + ". " + i;
			number += 1;
		}
		System.out.println(formattedOptions);
	}
	
	/*
	 * Prints out the mode/settings your Scientific Calculator is in. 
	 *  	Radians: if radians is true that means that you're inputting angles in as radians. If false
	 *  			 then you're inputting them as degrees.
	 */
	public void displayMode() {
		if (scientificCalculator.getRadians()) {
			System.out.println("Radians");
		} else {
			System.out.println("Degrees");
		}
	}
	
	public void displayEquation() {
		System.out.println(scientificCalculator.getEquationString());
	}
	
	public void displaySolve(String solution) {
		System.out.println(solution.toString());
	}
	
	public void promptForEquation() {
		System.out.println("Enter the corresponding arithmetic option or number.");
		Scanner scanner = new Scanner(System.in);
		
		
		if (scanner.hasNextDouble()) {
			String input = scanner.next();
			scientificCalculator.updateEquationString(input);
			displayEquation();
		} else {
		String input = scanner.next();	
		switch (input) {
			case "=":
				displaySolve(scientificCalculator.solve(scientificCalculator.parseEquation(scientificCalculator.getEquationString())));
				writingEquation = false;
				running = false;
				break;
			case "+":
				scientificCalculator.updateEquationString(" + ");
				displayEquation();
				break;
			case "-":
				scientificCalculator.updateEquationString(" - ");
				displayEquation();
				break;
			case "*":
				scientificCalculator.updateEquationString(" * ");
				displayEquation();
				break;
			case "/":
				scientificCalculator.updateEquationString(" / ");
				displayEquation();
				break;
			case "log":
				scientificCalculator.updateEquationString("log (");
				promptForNumber();
				displayEquation();
				break;
			case "ln":
				scientificCalculator.updateEquationString("ln (");
				promptForNumber();
				displayEquation();
				break;
			case "^2":
				scientificCalculator.updateEquationString(" ^ ( 2 ) ");
				displayEquation();
				break;
			case "sqrt":
				scientificCalculator.updateEquationString("sqrt ( ");
				promptForNumber();
				displayEquation();
				break;
			case "^":
				scientificCalculator.updateEquationString(" ^ ( ");
				promptForNumber();
				displayEquation();
				break;
			case "pi":
				scientificCalculator.updateEquationString("pi");
				displayEquation();
				break;
			case "(":
				scientificCalculator.updateEquationString(" (");
				promptForNumber();
				displayEquation();
				break;
			case ")":
				scientificCalculator.updateEquationString(" ) ");
				displayEquation();
				break;
			case "sin":
				scientificCalculator.updateEquationString(" sin ( ");
				promptForNumber();
				displayEquation();
				break;
			case "cos":
				scientificCalculator.updateEquationString(" cos ( ");
				promptForNumber();
				displayEquation();
				break;
			case "tan":
				scientificCalculator.updateEquationString(" tan ( ");
				promptForNumber();
				displayEquation();
				break;
			default:
				System.out.println("Not an option.");
				displayOptions();
				promptForEquation();
			}
		}
	}

	public void promptForNumber() {
		System.out.println("Enter a number.");
		Scanner scanner = new Scanner(System.in);
		if (scanner.hasNextDouble()) {
			String number = scanner.next();
			scientificCalculator.updateEquationString(" " + number);
		} else {
			String pi = scanner.next();
			if (pi.equals("pi")) {
				scientificCalculator.updateEquationString(pi);
			} else {
				promptForNumber();
			}
		}
		
	}
	
	
	
	
}
