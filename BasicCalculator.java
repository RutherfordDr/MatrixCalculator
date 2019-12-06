import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.w3c.dom.css.Counter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BasicCalculator {
	// This class contains all the components necessary for Basic Calculator.
	
	private ArrayList<String> sessionHistory = new ArrayList<String>();
	private String operation = "";
	private double result;
	private String previousAns= "0";
	private String previousEquation = "";
	private String filename = "basicCalculatorHistory.txt";
	
	public BasicCalculator() {
		
	}
	
	public String getFilename() {
		return filename;
	}
	
	public void setOperation(String equation) {
		operation = equation;
	}
	public void setPreviousAns(String ans) {
		if (isNumeric(ans)) {
			previousAns = ans;
		}
	}
	
	public String getPreviousAns() {
		return previousAns;
	}
	
	public void setPreviousEquation(String equation) {
		previousEquation = equation;
	}
	
	public String getPreviousEquation() {
		return previousEquation;
	}
	
	
	public String BasicOperations(String ops) {
		//Contains the different operations for Basic Calculator
		switch (ops) {
		case "=":
			return " = ";
		case "+":
			return " + ";
		case "-":
			return " - ";
		case "*":
			return " * ";
		case "/":
			return " / ";
		case "(":
			return "( ";
		case ")":
			return " )";
		case "previousAns":
			return getPreviousAns();
		case "previousEquation":
			return getPreviousEquation();
		case "getEquation":
			System.out.println("History:");
			readHistory();
			System.out.println("Type the line number you would like. (Starts with line 0, Session Ended lines don't count.)");
			Scanner scanner = new Scanner(System.in);
			while (!scanner.hasNextInt()) {
			      System.out.println("Input is not a number.");
			      scanner.nextLine();
			    }
			String lineNumber = Integer.toString(scanner.nextInt());
			return getSpecificLineFromHistory(lineNumber, getFilename());
		case "backspace":
		    return "backspace";
		default:
			System.out.println("Operation not valid.");
			return "notvalid";
		}
	}
	
	/*
	 * Turns the string equation to solve into an arraylist and removes unnesessary spacing.
	 */
	public ArrayList<String> parseEquation(String equationToSolve) {
		ArrayList<String> splitEquation = new ArrayList<String>(Arrays.asList(equationToSolve.split("\\s+")));
		ArrayList<String> cleanedUpEquation = new ArrayList<String>();
		for (String i: splitEquation) {
			if (!i.contentEquals("")) {
				cleanedUpEquation.add(i);
			}
		}
		return cleanedUpEquation;
	}
	
	/*
	 * Takes in the equation to solve in a list form, and solves it recursively following the BEDMAS rules.
	 */
	public String solve(ArrayList<String> equationList) {
		if (equationList.size() == 1) {
			String input = equationList.get(0);
			if (isNumeric(input)){
				setPreviousAns(input);
				writeToHistory();
				return input;
			} else {
				System.out.println(equationList);
				return "Not valid equation.";
			}
		}else if (equationList.contains("(")) {
			
			ArrayList<String> equationListP = new ArrayList<String>();
			int iBeginning = equationList.lastIndexOf("(");
			int iEnd = -1;
			ArrayList<String> temporary = new ArrayList<String>();
			for (int i = iBeginning + 1; i < equationList.size(); i++) {
				temporary.add(equationList.get(i));
				
			}
			
			if (!temporary.contains(")")) {
				return "Not valid equation.";
			} else {
				iEnd = temporary.indexOf(")") + iBeginning + 1;
				ArrayList<String> parenthesisList = new ArrayList<String>();
				for (int i = iBeginning + 1; i < iEnd; i++) {
					parenthesisList.add(equationList.get(i));
					
				}
				double value = Double.parseDouble(solve(parenthesisList));
				for (int i=0; i < equationList.size(); i++) {
					if (iBeginning > i || i > iEnd) {
						equationListP.add(equationList.get(i));
						
					} else if (i==iBeginning) {
						equationListP.add(Double.toString(value));
					}
				}
				return solve(equationListP);
			}
			
		} else if (equationList.contains("*")) {
			ArrayList<String> equationListP = new ArrayList<String>();
			int iplus = equationList.indexOf("*");
			int iprevious = iplus - 1;
			int inext = iplus + 1;
			double value = Double.parseDouble(equationList.get(iprevious)) * Double.parseDouble(equationList.get(inext));
			for (int i=0; i < equationList.size(); i++) {
				if (iprevious > i || i > inext) {
					equationListP.add(equationList.get(i));
					
				} else if (i==iplus) {
					equationListP.add(Double.toString(value));
				}
			}
			
			return solve(equationListP);
			
		   } else if (equationList.contains("/")) {
				ArrayList<String> equationListP = new ArrayList<String>();
				int iplus = equationList.indexOf("/");
				int iprevious = iplus - 1;
				int inext = iplus + 1;
				double value = Double.parseDouble(equationList.get(iprevious)) / Double.parseDouble(equationList.get(inext));
				for (int i=0; i < equationList.size(); i++) {
					if (iprevious > i || i > inext) {
						equationListP.add(equationList.get(i));
						
					} else if (i==iplus) {
						equationListP.add(Double.toString(value));
					}
				}
				
				return solve(equationListP);
				
			} else if (equationList.contains("+")) {
				ArrayList<String> equationListP = new ArrayList<String>();
				int iplus = equationList.indexOf("+");
				int iprevious = iplus - 1;
				int inext = iplus + 1;
				double value = Double.parseDouble(equationList.get(iprevious)) + Double.parseDouble(equationList.get(inext));
				for (int i=0; i < equationList.size(); i++) {
					if (iprevious > i || i > inext) {
						equationListP.add(equationList.get(i));
						
					} else if (i==iplus) {
						equationListP.add(Double.toString(value));
					}
				}
				
				return solve(equationListP);
				
			} else {
				if (equationList.contains("-")) {
					ArrayList<String> equationListP = new ArrayList<String>();
					int iplus = equationList.indexOf("-");
					int iprevious = iplus - 1;
					int inext = iplus + 1;
					double value = Double.parseDouble(equationList.get(iprevious)) - Double.parseDouble(equationList.get(inext));
					for (int i=0; i < equationList.size(); i++) {
						if (iprevious > i || i > inext) {
							equationListP.add(equationList.get(i));
							
						} else if (i==iplus) {
							equationListP.add(Double.toString(value));
						}
					}
					
					return solve(equationListP);
				}
				
			}
		return "Not valid equation.";
		}

	public static boolean isNumeric(String strNum) {
		//Verifies if the string is numeric or not.Returns true if numeric.
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public void computeResult() {
		//Calls the appropiate methods to compute result.
		operation = BasicCalculatorTUI.getOperation();
		ArrayList<String> ops= new ArrayList<String>();
		ops = parseEquation(operation);
		String resString = solve(ops);
		result = Double.parseDouble(resString);
	}
	
	public void computeResultGUI() {
		//Calls the appropiate methods to compute result - Just for the GUI.
		operation = BasicCalculatorGUI.getOperationGUI();
		ArrayList<String> ops= new ArrayList<String>();
		ops = parseEquation(operation);
		String resString = solve(ops);
		
		result = Double.parseDouble(resString);
	}
		
	public double getResult() {
		return result;
	}
	
	/*
	 * Once the equation is solved this method is called which writes the equation and the answer into the 
	 * history text file on separate lines.
	 * 
	 */
	public void writeToHistory() {
		//Writes operation to history
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileOutputStream(filename, true));
			outputStream.println(operation);
			outputStream.println(previousAns);
			outputStream.close();
			
		}
		catch(FileNotFoundException e) {
			System.out.println("Can't save to session history");
		}
	}

	public void writeToHistoryGUI(String input) {
		//Writes operation to history - Only for GUI
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileOutputStream(filename, true));
			outputStream.println(input);
			outputStream.close();
			
		}
		catch(FileNotFoundException e) {
			System.out.println("Can't save to session history");
		}
	}
	/*
	 * Closes the history and write "Session Ended" into the history file.
	 */
	public void closeHistory() {
		//Closes the history - only on TUI
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileOutputStream(filename, true));
			outputStream.println("Session Ended");
			outputStream.close();
			
		}
		catch(FileNotFoundException e) {
			System.out.println("Can't save to session history");
		}
	}
	/*
	 * Prints the history into the console.
	 */
	public void readHistory() {
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new File(filename));
			while (inputStream.hasNext()) {
				String line = inputStream.nextLine();
				System.out.println(line);
				}
			}
		catch(FileNotFoundException e) {
			System.out.println("No history available.");
			}
		}
	
	public ArrayList<String> readHistoryGUI() {
		//Reads the history - Only for GUI
		Scanner inputStream = null;
		ArrayList<String> historyb = new ArrayList<String>();
		int Counter = 0;
		try {
			inputStream = new Scanner(new File(filename));
			while (inputStream.hasNext()) {
				String line = inputStream.nextLine();
				historyb.add(Counter, line);
				Counter++;
				}
			}
		catch(FileNotFoundException e) {
			historyb.add(0, "History not Found");
			}
		return historyb;
		}
	
	/*
	 * 
	 */
	public String getSpecificLineFromHistory(String lineNumber, String filename) {
		//Gets the line inputed by the user from the history - Only on TUI
		String specificLine = "";
		
		try {
			specificLine = Files.readAllLines(Paths.get(filename)).get(Integer.parseInt(lineNumber));
			if (specificLine.equals("Session Ended")) {
				specificLine = Files.readAllLines(Paths.get(filename)).get(Integer.parseInt(lineNumber + 1));
			}
			return specificLine;
		}
		catch(IOException e) {
			System.out.println("No history available.");
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Not a valid input.");
		}
		
		return specificLine;
		}
		
	public void deleteHistory() {
		//Deletes contets of the text file containing the history
			
			try {	
				PrintWriter outputStream = new PrintWriter(new FileOutputStream(getFilename()));
				outputStream.println("");
				outputStream.close();
				}
			catch(FileNotFoundException e) {
				System.out.println("No history available.");
				}
	}
		
	
}
