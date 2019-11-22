import java.util.Scanner;

public class ScientificCalculatorTUI {
	private ScientificCalculator scientificCalculator;
	private boolean running;
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
	
	//Starting the TUI
	public ScientificCalculatorTUI() {
		this.scientificCalculator = new ScientificCalculator();
		running = true;
		writingEquation = true;
	}
	
	/*Displaying the arithmetric operations. This repeats until equals is entered
	*Then prompts the user whether another operation would like to be done.
	*/
	
	public void start() {
		displayOptions();
		while (running) {
			promptForEquation();
		}
		System.out.println("Would you like to enter another equation Y/N");
		Scanner scanner = new Scanner(System.in);
		String procede = scanner.next();
		if (procede.equals("Y")){
			scientificCalculator.resetEquationString();
			running = true;
			writingEquation = true;
			start();
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
	
	//Displays the equation
	public void displayEquation() {
		System.out.println(scientificCalculator.getEquationString());
	}
	
	//Displays teh answer to the equation
	public void displaySolve(String solution) {
		System.out.println(solution.toString());
	}
	
	//Prompts the user for a number or an arithmetric operation then updates the equation to contain that number/operation 
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
				scientificCalculator.updateEquationString(" log(");
				promptForNumber();
				displayEquation();
				break;
			case "ln":
				scientificCalculator.updateEquationString(" ln(");
				promptForNumber();
				displayEquation();
				break;
			case "^2":
				scientificCalculator.updateEquationString(" ^(2) ");
				displayEquation();
				break;
			case "^":
				scientificCalculator.updateEquationString(" ^(");
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
				scientificCalculator.updateEquationString(" sin(");
				promptForNumber();
				displayEquation();
				break;
			case "cos":
				scientificCalculator.updateEquationString(" cos(");
				promptForNumber();
				displayEquation();
				break;
			case "tan":
				scientificCalculator.updateEquationString(" tan(");
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
	
	//Prompts the user for a number after sin, cos, tan, log, ln, and ^
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
