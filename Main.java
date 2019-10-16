import java.util.Scanner();

public Main{
  private static void main(String args []){
    System.out.println("Input 1 for scientific calculator");
    System.out.println("Input 2 for matrix calculator");
    Scanner input = new Scanner(System.in);
    int input = input.nextInt();
    if (x == 1){
      //Basic calculations
      BasicCalculator bc = new BasicCalculator();
      //Scientific calculations (Incomplete)
      System.out.println("scientific");
    } else if (x == 2){
      //Matrix calculations (Incomplete)
      Matrix m = new Matrix();
    } else {
      System.out.println("Out of bounds input");
    }
  }
}
