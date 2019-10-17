import java.util.Scanner;
 
class MatrixSubtraction
{
   public static void main(String args[])
   {
      int a, b, i, n;
      Scanner sc = new Scanner(System.in);
     
      System.out.println("Number of row");
      a = sc.nextInt();
      System.out.println("Number of column");
      b  = sc.nextInt();
     
      int [][] first = new int[a][b];
      int [][] second = new int[a][b];
      int [][] subtraction = new int[a][b];
     
      System.out.println("Elements of first matrix");
     
      for (i = 0; i < a; i++)
         for (n = 0; n < b; n++)
            first[i][n] = sc.nextInt();
           
      System.out.println("Elements of second matrix");
     
      for (i = 0 ; i < a ; i++)
         for (n = 0 ; n < b ; n++)
            second[i][n] = sc.nextInt();
           
      for (i = 0; i < a; i++)
         for (n = 0; n < b; n++)
             subtraction[i][n] = first[i][n] - second[i][n];  
 
      System.out.println("Subtraction of the matrix:");
     
      for (i = 0; i < a; i++)
      {
         for (n = 0; n < b; n++)
            System.out.print(subtraction[i][n]+"\t");
         
         System.out.println();
      }
   }
}
