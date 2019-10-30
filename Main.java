import java.util.Scanner;
public class Main {

	public static void main(String[] args) 
	
	{
		
		Scanner scanner = new Scanner(System.in);
		
		double [][] temp = new double[1][1]; 
		
		Matrix A = new Matrix(temp);
		
		Matrix B = new Matrix (temp);
		
		Matrix C = new Matrix(temp);
		
		Matrix D = new Matrix(temp);
		
		Matrix E = new Matrix (temp);
		
		Matrix F = new Matrix(temp);
		
	
		
		A.getMatrixFromUser();
		
		System.out.println("1 - Transpose/n2 - Addition/n3-Subtraction/n4-Multiplication/n5-Multiply by Scalar");
		
		int choice = scanner.nextInt();
		
		if (choice == 1)
		
		{
			
			B.setMatrixWithArray(A.transpose());
				
			B.toString();
		
		
		
		}else if(choice == 2){
			
			C.getMatrixFromUser();
			
			D.setMatrixWithArray(A.addition(C));
			
			D.toString();
				
		
		}else if(choice == 3){
			
			C.getMatrixFromUser();
			
			D.setMatrixWithArray(A.addition(C));
			
			D.toString();
		
		
		
		
		
		}else if(choice == 4){
			
			
		
		
		
		
		
		}else if(choice == 5){
			
			
		
		
		
		
		
		}
