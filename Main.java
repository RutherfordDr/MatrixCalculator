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
      ScientificCalculator sc = new ScientificCalculator();
      System.out.println("Input value for log and ln");
      int value = input.nextInt();
      System.out.println(sc.log(value));
      System.out.println(sc.ln(value));
      System.out.println("Input value for sin,cos,tan");
      value = input.nextInt();
      System.out.println(sc.Sin(value));
      System.out.println(sc.Cos(value));
      System.out.println(sc.Tan(value));
      value = input.nextInt();
      System.out.println(sc.squared(value));
      System.out.println(sc.squareRoot(value));
      System.out.println("Input value for exponent of previous value");
      int exponent = input.nextInt();
      System.out.println(sc.exponent(value, exponent);
    } else if (x == 2){
      //Matrix calculations (Incomplete)
      Matrix m = new Matrix();
    } else {
      System.out.println("Out of bounds input");
    }
  }
}
