import java.util.Scanner;

public class Main{
	static boolean scientific = false;
	
  public static void main(String args []){
    int variable = 1;
    while (variable != 4){
      System.out.println("Input 1 for basic calculator");
      System.out.println("Input 2 for scientific calculator");
      System.out.println("Input 3 for matrix calculator");
      System.out.println("Input 4 to exit");
      Scanner input = new Scanner(System.in);
      variable = input.nextInt();
      if (variable == 1){
        //Basic calculations
        BasicCalculator bc = new BasicCalculatorTUI();
      } else if (variable ==2) {
        //Scientific calculations (Incomplete)
    	  scientific = true;
        ScientificCalculatorTUI sc = new ScientificCalculatorTUI();
        //Matrix calculations (Incomplete) 
      } else if ( variable == 3) {
    	  Matrix m = new Matrix();
      } else if (variable != 4) {
    	  
      }
      System.out.print("\033[H\033[2J");  
    }
  }
}
