public class BasicCalculatorGUI extends BasicCalculator{

	//This class links methods from Basic Calculator and the Calculator GUI
	
	private BasicCalculator BasicCalculator;
	public static String operation = "";
	public String temp;
	
	
	public BasicCalculatorGUI() {
		this.BasicCalculator = new BasicCalculator();
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
			String ops = BasicCalculator.BasicOperations(op);
			if (ops == "notvalid") {
				System.out.print("Last input errased. Enter a valid operation");
			}
			else {
				operation += ops;
			}
		}

	}
	
	public double equals() {
		computeResultGUI();
		return getResult();
		
	}
	
	public static String getOperationGUI() {
		return operation;
	}
	
}