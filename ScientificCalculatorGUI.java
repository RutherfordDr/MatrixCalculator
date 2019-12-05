import java.util.ArrayList;
import java.util.Arrays;

public class ScientificCalculatorGUI extends ScientificCalculator{

	private ScientificCalculator SciCalculator;
	private ArrayList<String> optosolve = new ArrayList<String>();
	public static String operation = "";
	public String temp;
	
	public ScientificCalculatorGUI() {
		this.SciCalculator = new ScientificCalculator();
		start();
	}
	
	public void start() {
		
		
	}
	
	
	public void addNumberToOp() {
		operation += temp;
	}
	
	public String getOperation() {
		return operation;
	}
	
	public void Operation(String op) {
		
		if (op == "CLEAR") {
			operation = "";
		}
		else {
				operation += op;
			}
		}
	
	public String equals() {
		optosolve=SciCalculator.parseEquation(operation);
		String resultS=SciCalculator.solve(optosolve);
		return resultS;
		
	}
	
	public static String getOperationGUI() {
		return operation;
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

	public String displayMode() {
		if (SciCalculator.getRadians()) {
			return "Radians";
		} else {
			return "Degrees";
		}
	}
	
	public void setMode() {
		if (SciCalculator.getRadians()) {
			SciCalculator.radians = false;
		}
		else{
			SciCalculator.radians = true;
		}
	}
	
}
