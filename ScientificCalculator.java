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
	
	//Operations Display
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
	
	//Returns whether the calculator is in radians or not
	public boolean getRadians() {
		return radians;
	}
	
	//Returns the equation as a string
	public String getEquationString() {
		return equationString;
	}
	
	//Returns an array list containing all of the arithmetric operations
	public ArrayList<String> getArithmeticOptions() {
		return arithmeticOptions;
	}
	
	//Updates the string of eqiations to include the most recent operation and value
	public void updateEquationString(String update) {
		equationString = equationString + update;
	}
	
	//Resets the equations to be empty
	public void resetEquationString() {
		equationString = "";
	}
	
	//Returns the value of pi
	public double pi() {
		return Math.PI;
	}
	
	//Returns a cleaned up version of the equation that does not contain spaces and null values
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
	
	//Solves the equation
	public String solve(ArrayList<String> equationList) {
		/*Checks if the equation contains only one value or operation then it doews the operations in 
		* PEMDAS operder from multiplication, to division, to addition, then subtraction
		*/
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
	
	//Squaring the input value
	public double squared(double input) {
		return input*input;
	}
	
	//Square rooting the input value
	public double squareRoot(double input) {
		return Math.sqrt(input);
	}
	
	//Doing the input value to the power of the input exponent
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
	
	//Logging the input value
	public double log(double input) {
		return Math.log10(input);
	}
	
	//Doing the natural log of the input value
	public double ln(double input) {
		return Math.log(input);
	}
	
	//Finding the sin value of the input value in both radians and degrees
	public double sin(double input) {
		if (radians) {
			return Math.sin(input);
		} else {
			return Math.toDegrees(Math.sin(Math.toRadians(input)));
		}
	}
	
	//Finding the cos value of the input value in both radians and degrees
	public double cos(double input) {
		if (radians) {
			return Math.cos(input);
		} else {
			return Math.toDegrees(Math.cos(Math.toRadians(input)));
		}
	}
	
	//Finding the tan value of the input value in both radians and degrees
	public double tan(double input) {
		if (radians) {
			return Math.tan(input);
		} else {
			return (Math.tan(Math.toRadians(input)));
		}
	}
	
}
