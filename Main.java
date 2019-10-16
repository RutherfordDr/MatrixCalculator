import java.util.Scanner();

public Main{
  private static void main(String args []){
    System.out.println("Input 1 for scientific calculator");
    System.out.println("Input 2 for matrix calculator");
    Scanner input = new Scanner(System.in);
    int input = input.nextInt();
    if (x == 1){
      System.out.println("scientific");
    } else if (x == 2){
      System.out.println("matrix");
    } else {
      System.out.println("Out of bounds input");
    }
  }
}
