import java.util.Scanner;

public class Main{
	static boolean scientific = false;
	
  public static void main(String args []){
    System.out.println("Input 1 for basic calculator");
    System.out.println("Input 2 for scientific calculator");
    System.out.println("Input 3 for matrix calculator");
    Scanner input = new Scanner(System.in);
    int variable = input.nextInt();
    if (variable == 1){
      //Basic calculations
      BasicCalculator bc = new BasicCalculatorTUI();
    } else if (variable ==2) {
      //Scientific calculations (Incomplete)
    	scientific = true;
      ScientificCalculatorTUI sc = new ScientificCalculatorTUI();
      sc.start();
      //Matrix calculations (Incomplete)
     
    } else if ( variable == 3) {
    	 Matrix m = new Matrix();
      
    } else {
    	System.out.println("Out of bounds input");
    }
    
  }
}
