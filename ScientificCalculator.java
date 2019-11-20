import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.lang.Math;

/*
 * TODO:
 * 		Add a mode method where you can change what mode the calculator is in.
 * 		Add functionality to the previousAnswer variable
 * 		Add a way for the calculator to write the history of the session to a csv.
 * 		Add a way to import equations from a csv.
 * 		Add a few more arithmetic options:
 * 			1) sin^-1()
 * 			2) cos^-1()
 * 			3) tan^-1()
 * 
 * 		Potentially add graphing.
 */

public class ScientificCalculator extends BasicCalculator{
	private boolean radians;
	private double previousAnswer;
	protected String equationString;
	private ArrayList<String> arithmeticOptions;
	private String previousEquation;
	private String filename = "scientificCalculatorHistory.txt";
	
	public ScientificCalculator() {
		radians = true;
		equationString = "";
		previousEquation = "";
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
		arithmeticOptions.add("previousEquation");
		arithmeticOptions.add("previousAnswer");
		
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
	
	
	
	/*
	 * The solve method takes in the equation as a list of strings. It goes through the equation
	 * following BEDMAS. The only change is after the brackets are done, it gets rid of the strings
	 * that aren't doubles. Ex: ln, log, cos, sin, tan, pi... etc.
	 * 
	 * It then solves the rest of the equation recursively until there is only 1 element left in the
	 * list. If the element is a double then the equation was valid, and there is a solution.
	 * 
	 * If the equation was not put in correctly (Ex: the brackets weren't balances) then it will
	 * return a string saying it is not valid.
	 * 
	 * Note: Right now some equations don't work, but there are work arounds. 
	 * Ex:
	 * 	if you want to do "ln( ln( 100) )" you will need to type it in as " ln( 0 + ln( 100))"
	 * 	This is because after some arithmetic options the program asks you for a number to enter
	 * 	and not another arithmetic option.
	 */
	
	public String solve(ArrayList<String> equationList) {
		if (equationList.contains("pi")) {
			ArrayList<String> equationListP = new ArrayList<String>();
			int iPi = equationList.indexOf("pi");
			double value = pi();
			for (int i=0; i < equationList.size(); i++) {
				if (i != iPi) {
					equationListP.add(equationList.get(i));
					
				} else {
					equationListP.add(Double.toString(value));
				}
			}
			
			return solve(equationListP);
			
		} else if (equationList.size() == 1) {
			String input = equationList.get(0);
			if (isNumeric(input)){
				setPreviousAns(input);
				setPreviousEquation(equationString);
				writeToHistory();
				return input;
			} else {
				System.out.println(equationList);
				return "Not valid equation.";
			}
			
		} else if (equationList.contains("(")) {
			
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
			
		} else if (equationList.contains("log")) {
			ArrayList<String> equationListP = new ArrayList<String>();
			int iLog = equationList.indexOf("log");
			int iLogPlus = iLog + 1;
			double value = log(Double.parseDouble(equationList.get(iLogPlus)));
			for (int i=0; i < equationList.size(); i++) {
				if (i != iLog && i != iLogPlus) {
					equationListP.add(equationList.get(i));
				} else if (i == iLog) {
					equationListP.add(Double.toString(value));
				}
			}
			return solve(equationListP);
			
		} else if (equationList.contains("ln")) {
			ArrayList<String> equationListP = new ArrayList<String>();
			int iLn = equationList.indexOf("ln");
			int iLnPlus = iLn + 1;
			double value = ln(Double.parseDouble(equationList.get(iLnPlus)));
			for (int i=0; i < equationList.size(); i++) {
				if (i != iLn && i != iLnPlus) {
					equationListP.add(equationList.get(i));
				} else if (i == iLn) {
					equationListP.add(Double.toString(value));
				}
			}
			return solve(equationListP);
			
		} else if (equationList.contains("^")) {
			ArrayList<String> equationListP = new ArrayList<String>();
			int iSquared = equationList.indexOf("^");
			int iPrevious = iSquared - 1;
			int iNext = iSquared + 1;
			double value = exponent(Double.parseDouble(equationList.get(iPrevious)), Double.parseDouble(equationList.get(iNext)));
			for (int i=0; i < equationList.size(); i++) {
				if (iPrevious > i || i > iNext) {
					equationListP.add(equationList.get(i));
				
				} else if (i==iSquared) {
					equationListP.add(Double.toString(value));
				}
			}	
			return solve(equationListP);
			
		} else if (equationList.contains("sqrt")) {
			ArrayList<String> equationListP = new ArrayList<String>();
			int iSqrt = equationList.indexOf("sqrt");
			int iSqrtPlus = iSqrt + 1;
			double value = squareRoot(Double.parseDouble(equationList.get(iSqrtPlus)));
			for (int i=0; i < equationList.size(); i++) {
				if (i != iSqrt && i != iSqrtPlus) {
					equationListP.add(equationList.get(i));
				} else if (i == iSqrt) {
					equationListP.add(Double.toString(value));
				}
			}
			return solve(equationListP);
			
		} else if (equationList.contains("sin")) {
			ArrayList<String> equationListP = new ArrayList<String>();
			int iSin = equationList.indexOf("sin");
			int iSinPlus = iSin + 1;
			double value = sin(Double.parseDouble(equationList.get(iSinPlus)));
			for (int i=0; i < equationList.size(); i++) {
				if (i != iSin && i != iSinPlus) {
					equationListP.add(equationList.get(i));
				} else if (i == iSin) {
					equationListP.add(Double.toString(value));
				}
			}
			return solve(equationListP);
			
		} else if (equationList.contains("cos")) {
			ArrayList<String> equationListP = new ArrayList<String>();
			int iCos = equationList.indexOf("cos");
			int iCosPlus = iCos + 1;
			double value = cos(Double.parseDouble(equationList.get(iCosPlus)));
			for (int i=0; i < equationList.size(); i++) {
				if (i != iCos && i != iCosPlus) {
					equationListP.add(equationList.get(i));
				} else if (i == iCos) {
					equationListP.add(Double.toString(value));
				}
			}
			return solve(equationListP);
			
		} else if (equationList.contains("tan")) {
			ArrayList<String> equationListP = new ArrayList<String>();
			int iTan = equationList.indexOf("tan");
			int iTanPlus = iTan + 1;
			double value = tan(Double.parseDouble(equationList.get(iTanPlus)));
			for (int i=0; i < equationList.size(); i++) {
				if (i != iTan && i != iTanPlus) {
					equationListP.add(equationList.get(i));
				} else if (i == iTan) {
					equationListP.add(Double.toString(value));
				}
			}
			return solve(equationListP);
			
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
				
			} else if (equationList.contains("-")) {
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
				
			} else if (equationList.contains("ln")) {
				ArrayList<String> equationListP = new ArrayList<String>();
				int iLn = equationList.indexOf("ln");
				int iLnPlus = iLn + 1;
				double value = ln(Double.parseDouble(equationList.get(iLnPlus)));
				for (int i=0; i < equationList.size(); i++) {
					if (i != iLn && i != iLnPlus) {
						equationListP.add(equationList.get(i));
					} else if (i == iLn) {
						equationListP.add(Double.toString(value));
					}
				}
				return solve(equationListP);
				
			} else {
				
				
			}
		
		return "Not valid equation.";
		}
				
	public void resetEquationString() {
		equationString = "";
		}
		
	public void writeToHistory() {
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileOutputStream(filename, true));
			outputStream.println(getPreviousEquation());
			outputStream.println(getPreviousAns());
			outputStream.close();
			
		}
		catch(FileNotFoundException e) {
			System.out.println("Can't save to session history");
		}
	}

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
	 * The following methods are arithmetic methods for the scientific calculator.
	 */
	
	public double pi() {
		return Math.PI;
	}
	
	public double squared(double input) {
		return input*input;
	}
	
	public double squareRoot(double input) {
		return Math.sqrt(input);
	}
	
	public double exponent(double input, double exponent) {
		return Math.pow(input, exponent);
	}
	
	public double log(double input) {
		return Math.log10(input);
	}
	
	public double ln(double input) {
		return Math.log(input);
	}
	
	/*
	 * For trig function it rounds to 2 digits after the decimal. It also takes in angles
	 * in radians and degrees. You need to specify which by putting the calculator in that 
	 * mode.
	 */
	public double sin(double input) {
		if (radians) {
			return Math.round(Math.sin(input) * 100.00) / 100.00;
		} else {
			return Math.round(Math.sin(Math.toRadians(input) * 100.00)) / 100.00;
		}
	}
	
	public double cos(double input) {
		if (radians) {
			return Math.round(Math.cos(input) * 100.00) / 100.00;
		} else {
			return Math.round(Math.cos(Math.toRadians(input) * 100.00)) / 100.00;
		}
	}
	
	public double tan(double input) {
		if (radians) {
			return Math.round(Math.tan(input) * 100.00) / 100.00;
		} else {
			return Math.round(Math.tan(Math.toRadians(input) * 100.00)) / 100.00;
		}
	}
	
}
