import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BasicCalculator {
	
	String operation = "";
	double result;
	private double previousAns=0;
	
	public BasicCalculator() {
		
		
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
		default:
			System.out.println("Operation not valid.");
			return "notvalid";
		}
	}
	
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
	
	public String solve(ArrayList<String> equationList) {
		if (equationList.size() == 1) {
			String input = equationList.get(0);
			if (isNumeric(input)){
				return input;
			} else if (input.equals("pi")){
				return Double.toString(pi());
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
	
	public double pi() {
		return Math.PI;
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
}
