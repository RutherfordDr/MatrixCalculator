import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BasicCalculator {
	private ArrayList<String> sessionHistory = new ArrayList<String>();
	private String operation = "";
	private double result;
	private String previousAns= "0";
	private String previousEquation = "";
	private String filename = "basicCalculatorHistory.txt";
	
	public BasicCalculator() {
		
		
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
			System.out.println("Type the line number you would like. (Starts with line 0)");
			Scanner scanner = new Scanner(System.in);
			String lineNumber = scanner.nextLine();
			return getSpecificLineFromHistory(lineNumber);
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
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public void computeResult() {
		operation = BasicCalculatorTUI.getOperation();
		ArrayList<String> ops= new ArrayList<String>();
		ops = parseEquation(operation);
		String resString = solve(ops);
		result = Double.parseDouble(resString);
	}
	
	public void computeResultGUI() {
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

	/*
	 * Closes the history and write "Session Ended" into the history file.
	 */
	public void closeHistory() {
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
	
	/*
	 * TODO: This is proof of concept.
	 */
	public String getSpecificLineFromHistory(String lineNumber) {
		String specificLine = "";
		try {
			specificLine = Files.readAllLines(Paths.get(filename)).get(Integer.parseInt(lineNumber));
			
		}
		catch(IOException e) {
			System.out.println("No history available.");
			}
		return specificLine;
		
	}
}
