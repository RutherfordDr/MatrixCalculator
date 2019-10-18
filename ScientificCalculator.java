import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;


import java.lang.Math;


public class ScientificCalculator extends BasicCalculator{
	private boolean radians;
	private double previousAnswer;
	private String equationString;
	private ArrayList<String> arithmeticOptions;
	
	
	public ScientificCalculator() {
		radians = true;
		equationString = "";
		previousAnswer = 0.0;
		arithmeticOptions = new ArrayList<String>();
		arithmeticOptions.add("equals \"=\"");
		arithmeticOptions.add("add  \"+\"");
		arithmeticOptions.add("subtract \"-\"");
		arithmeticOptions.add("multiply \"*\"");
		arithmeticOptions.add("divide \"/\"");
		arithmeticOptions.add("log \"log\"");
		arithmeticOptions.add("ln \"ln\"");
		arithmeticOptions.add("squared \"^2\"");
		arithmeticOptions.add("square root \"sqrt\"");
		arithmeticOptions.add("exponent \"^\" ");
		arithmeticOptions.add("pi \"pi\"");
		arithmeticOptions.add("sin \"sin\"");
		arithmeticOptions.add("cos \"cos\" ");
		arithmeticOptions.add("tan \"tan\" ");
		arithmeticOptions.add("( \"(\" ");
		arithmeticOptions.add(") \")\" ");
		
	}
	
	public boolean getRadians() {
		return radians;
	}
	
	public String getEquationString() {
		return equationString;
	}
	
	public ArrayList<String> getArithmeticOptions() {
		return arithmeticOptions;
	}
	
	public void updateEquationString(String update) {
		equationString = equationString + update;
	}
	
	public void resetEquationString() {
		equationString = "";
	}
	
	//public void displayEquation() {
	//	System.out.println(equationString);
	//}
	
	public double pi() {
		return Math.PI;
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
	
	/*
	 * TODO: The solve method so far only works for +, -, *, /. It is a huge mess and 
	 * 		 will need to be redone to incorporate all methods for the scientific
	 * 		 calculator. For demo 1 this will have to suffice.
	 */
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
			
	public static boolean isNumeric(String strNum) {
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}
	
	/*
	 * The following methods are arithmetic methods for the scientific calculator.
	 */
	
	public double squared(double input) {
		return input*input;
	}
	
	public double squareRoot(double input) {
		return Math.sqrt(input);
	}
	
	public double exponent(double input, double exponent) {
		if (input == 0) {
			return 1.0;
		} else {
		for (int i = 0; i < exponent; i++) {
			input *=input;
			}
		return input;
		}
	}
	
	public double log(double input) {
		return Math.log10(input);
	}
	
	public double ln(double input) {
		return Math.log(input);
	}
	
	public double sin(double input) {
		if (radians) {
			return Math.sin(input);
		} else {
			return Math.toDegrees(Math.sin(Math.toRadians(input)));
		}
	}
	
	public double cos(double input) {
		if (radians) {
			return Math.cos(input);
		} else {
			return Math.toDegrees(Math.cos(Math.toRadians(input)));
		}
	}
	
	public double tan(double input) {
		if (radians) {
			return Math.tan(input);
		} else {
			return (Math.tan(Math.toRadians(input)));
		}
	}
	
}
