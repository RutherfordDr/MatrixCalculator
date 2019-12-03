import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class MatrixTUI 




{

private boolean running;

private String filename = "matrixCalculatorSessionHistory";


public MatrixTUI() 
	
	{
	
		running = true;
		
		start();
	
	}

	public void start() 
	
	{
		
		while (running) 
		
			{
			
				System.out.println("Welcome to the Matrix Calculator.");
			
				displayOptions();
				
				Scanner scanner = new Scanner(System.in);
				
				int numin = scanner.nextInt();
				
				if ( numin == 1) 
				
				{
				
					Matrix A = new Matrix();
					
					Matrix B = new Matrix(A.transpose());	
				
					System.out.println("Result");
					
					System.out.println(B.toString());
				
				} else if ( numin == 2) {
					
					Matrix A = new Matrix();
					
					System.out.println("You will be prompted for the matrix to add...");
							
					Matrix B = new Matrix();

					Matrix C = new Matrix(A.addition(B));
					
					System.out.println("Result");
					
					
					System.out.println(C.toString()); 
						
					System.out.println("Something went wrong.");
					
					
				
				}else if ( numin == 3) {
					
					Matrix A = new Matrix();
					
					System.out.println("You will be prompted for the matrix to subtract from original...");
					
					Matrix B = new Matrix();
					
					Matrix C = new Matrix(A.subtraction(B));
					
					System.out.println("Result");
					
					System.out.println(C.toString());
						
				}else if ( numin == 4) {
					
					Matrix A = new Matrix();
					
					System.out.println("You will be prompted for the matrix to multiply by the original...");
					
					Matrix B = new Matrix();
					
					Matrix C = new Matrix(A.multiplication(B));
					
					if (A.multiplication(B) == null) 
					
						{
						
							System.out.println("These matrices are not the correct size");
						
						}else{
					
							System.out.println("Result");
							
							System.out.println(C.toString());
						
						}
					
				
				
				}else if ( numin == 5) {
					
					Matrix A = new Matrix();
					
					Scanner scannerScalar = new Scanner(System.in);
					
					System.out.println("Please enter the scalar");
					
					int scalar = scannerScalar.nextInt();
					
					Matrix B = new Matrix(A.multiplicationScalar(scalar));
					
					System.out.println("Result");
					
					System.out.println(B.toString());
					
				
				
				}else if ( numin == 6) {
					
					Matrix A = new Matrix();
					
					Matrix B = new Matrix(A.reducedRowEcheleon());	
				
					System.out.println("Result");
					
					System.out.println(B.toString());
					
				}
				
				

				else if ( numin == 7) {
					
				running = false;
					
				}
		
			
			
			
			}
	

	
	
	}


	public void displayOptions()
	
	{
	
		System.out.println("Matrix Operations:");
		System.out.println("	1. Transpose");
		System.out.println("	2. Matrix Addition ");
		System.out.println("	3. Matrix Subtraction -");
		System.out.println("	4. Matrix Multiplication *");
		System.out.println("	5. Matrix Scalar Multiplication");
		System.out.println("	6. RREF ");
		System.out.println("	7. QUIT");


	}
	





}
