import java.util.Arrays;
import java.util.Scanner;


//This class represents a matrix of floating points numbers. The methods include basic matrix arithmetic and matrix operations.
//This class contains four constructors.
//The default constructor will ask the user for input via console



public class Matrix 

{

	private Scanner scanner;
		
	private double [][] aMatrix;
	
	private int column = 0;
	
	private int row = 0; 
	
	private int [] size;
		
	public Matrix()
	
		{

		}
	
	public Matrix(int inRow, int inColumn) 
		
		{
				
			setRow(inRow);
			
			setColumn(inColumn);
		
			aMatrix = new double [inRow][inColumn];
		
		}
	
	public Matrix(Matrix inMatrix)
	
		{
		
			setRow(inMatrix.getRow());	
			
			setColumn(inMatrix.getColumn());
			
			setMatrixWithArray(inMatrix.getMatrix());
			
		}
	
	public Matrix(double [][] inArray)
	
		{
		
			setMatrixWithArray(inArray);
	
		}
	
	
	
	
	
	public double[][] getMatrix()
	
		{
			
			double[][] temp = Arrays.stream(aMatrix).map(double[]::clone).toArray(double[][]::new);//FROM https://stackoverflow.com/questions/5617016/how-do-i-copy-a-2-dimensional-array-in-java 	
			
			return temp;
	
		}
	
	
	
	
	  public void setRow(int inRow)
	  
		  {
		  
			  row = inRow;
		  
		  }
	  
	  public void setColumn(int inColumn)
	  
		  {
		  
			  column = inColumn;
		  
		  
		  }
	 
	
	  public int getRow()
	  
	  { 
		 
		  int tempRow = row;
	  
		  return tempRow; 
	  
	  }
	 
	
	public int getColumn()
	
		{
		
			int tempColumn = column;
			
			return tempColumn; 
		
		
		}
	
	public void setMatrix(Matrix inMatrix)
	
		{
			
		/*
		 * size[0] = row;
		 * 
		 * size[1] = column;
		 */
			
			setMatrixWithArray(inMatrix.getMatrix()); 
		
		}
	
	public void setMatrixWithArray(double [][] inMatrix)
	
		{
			
		/*
		 * size[0] = row;
		 * 
		 * size[1] = column;
		 */
			
			aMatrix = inMatrix;
		
			row = inMatrix.length;
		
			column = inMatrix[0].length;
		
		}
	
	
	
	
	
	
	
	
	
		
	
	public void setSize(int aRow, int aColumn) 
		
		{
			size[0] = aRow;
			
			size[1] = aColumn; 
		
		}
	
	
	
	public void getMatrixFromUser()
	
		{
			

			int sizecol = 0;
			System.out.print("Insert Column size: ");
			scanner = new Scanner(System.in); 
			String sizeCol = scanner.nextLine();
			if (sizeCol.equals("")) {
				System.out.println("Empty input, Column = 1");
				sizecol = 1;}
			else
				sizecol = Integer.parseInt(sizeCol);
			
			setColumn(sizecol);
		
		
			int sizerow = 0;
			
			System.out.print("Insert Row size: ");
			
			scanner = new Scanner(System.in); 
			
			String sizeRow = scanner.nextLine();
			
			if (sizeRow.equals("")) {
				System.out.println("Empty input, row = 1");
				sizerow = 1;}
			else
				sizerow = Integer.parseInt(sizeRow);
			
			setRow(sizerow);
		
		
		
		double val = 0;
			
		aMatrix = new double [row][column];
		
		for (int i = 0; i < row; i++) 
			
			{
				for (int j = 0; j < column; j++) 
				
				{
					
					System.out.print("Insert value in row " + (i+1) + " and column " + (j+1) + " : ");
					
					scanner = new Scanner(System.in); 
					
					Double value = scanner.nextDouble();
					
					if (value.equals("")) 
					
					{
						System.out.println("Empty input, value equals 0");
						val = 0;
						
					}else{
					
						
						val = value;	
					
					
						System.out.println(val);
					
					}
					
					aMatrix[i][j] = val;
					
			}
			
		}
		
			setMatrixWithArray(aMatrix);
		
		
		
		}
	
	
	//Transposes the matrix object provided as an argument and returns the result as a 2D array
	
	public double[][] transpose(double [][] arrayFromInMatrix)// CODE FROM https://stackoverflow.com/questions/15449711/transpose-double-matrix-with-a-java-function
	
		{
			double[][] temp = new double[arrayFromInMatrix[0].length][arrayFromInMatrix.length];
	       
			for (int i = 0; i < arrayFromInMatrix.length; i++)
	            
				for (int j = 0; j < arrayFromInMatrix[0].length; j++)
	                
					temp[j][i] = arrayFromInMatrix[i][j];
	        
			//setResult(temp);
			
			return temp;
	
		}
	
	
	
	  public double [][] addition(double [][] matrix1, double [][] matrix2){
		  if(matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length){
			double[][] temp = new double [matrix1.length][matrix1[0].length];
			for (int i = 0; i < matrix1.length; i ++){
				for (int j = 0; j < matrix1[0].length; j ++){
					temp[i][j] = matrix1[i][j] + matrix2[i][j];
				}
			}
			return temp;
		  } else {
			  return null;
		  }
	  }
	 
	
	
	
	  public double [][] subtraction(double [][] matrix1, double [][] matrix2){
		if(matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length){
			double[][] temp = new double [matrix1.length][matrix1[0].length];
			for (int i = 0; i < matrix1.length; i ++){
				for (int j = 0; j < matrix1[0].length; j ++){
					temp[i][j] = matrix1[i][j] - matrix2[i][j];
				}
			}
			return temp;
		  } else {
			  return null;
		  }
	  }
	 
	
	// Multiples "this" matrix object by the matrix object provided as an arugument and returns the result as a 2D array
	//IF the matrices are not able to be multiplied, then a null object will be returned
	
	  public double [][] multiplication(double [][] matrix1, double [][] matrix2){
		if(matrix1[0].length == matrix2.length){
			double[][] temp = new double [matrix1.length][matrix2[0].length];
			for (int i = 0; i < matrix1.length; i ++){
				for (int j = 0; j < matrix2[0].length; j ++){
					double t= 0;
					for (int k = 0; k <matrix1[0].length; k ++){
						t = matrix1[i][k] * matrix2[k][j] + t;
					}
				}
			}
			return temp;
		} else {
			return null;
		}
	  }
	 
	 
	
	
	public double [][] multiplicationScalar(double [][] matrix1, double [][] matrix2){
		double[][] temp = new double [matrix1.length][matrix1[0].length];
		for (int i = 0; i < matrix1.length; i ++){
			for (int j = 0; j < matrix1[0].length; j ++){
				temp[i][j] = matrix1[i][j] * matrix2[0][0];
			}
		}
		return temp;
	}

public double [][] reducedRowEcheleon(double [][] aMatrix){
		int REF = 0;
        	int row = 0;
        	int coloum = 0;
        	double count = 0;

        	while (row < aMatrix.length && REF < aMatrix.length && REF < aMatrix[0].length){
            		double division = aMatrix[REF][REF];
            		while (coloum < aMatrix[0].length){
				//Making the leading one
                		if(aMatrix[REF][REF] != 0){
                    			aMatrix[REF][coloum] /= division;
                    			coloum ++;
                		}
				//Switching places if placement is zero
				else if (aMatrix[REF][REF] == 0 && (REF + 1) < aMatrix[0].length){
                    			for (int i = coloum; i < aMatrix[0].length; i ++){
                        		double temp = aMatrix[REF][i];
                        		aMatrix[REF][i] = aMatrix[REF+1][i];
                        		aMatrix[REF + 1][i] = temp;
                        		division = aMatrix[REF][REF];
                    			}
                		}
			}
			//Creating zero's under the leading one
            		if (row + 1 < aMatrix.length){
                		for(int i = row + 1; i < aMatrix.length; i ++){
                    			double multiplier = aMatrix[i][REF];
                    			for(int j = REF; j < aMatrix[0].length; j ++){
                        			aMatrix[i][j] -= (multiplier * aMatrix[row][REF]);
                    			} 
                		}
            		}
			//To get it to repeat for each row
            		coloum = 0;
            		row ++;
           		REF ++;
        	}
		return aMatrix;
	}	
	
	
	
	
	
	
	//resets the 2D Array of this matrix object to a matrix of all zeros
	
	public void resetArray()
	
		{
			
		
			double [][] tempArray = new double[row][column];
			
			setMatrixWithArray(tempArray);
		
		
		}
	
	
	//Converts the 2D Array of this matrix object to a string
	
	public String toString(){    //FROM https://www.dreamincode.net/forums/topic/379950-making-a-tostring-method-for-2d-integer-array/
		
		double[][] r = getMatrix(); 
		
		String s = "";
		
		
		for(int i=0; i< r.length; i++)
		{
			for(int j=0; j<r[i].length; j++)
			
			{
				
				
				if (j == (r[i].length - 1))
				{
				
					s +=  r[i][j];
				}else
					
					s +=  (r[i][j] + ", ");
			
				}
			
			s += "\n";
			
		}
		
		return s;
	} 
	
	
	
	/*
	 * public int determinant(Matrix aMatrix)
	 * 
	 * {
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	
	/*
	 * public void setResult(double[][] aMatrix)
	 * 
	 * {
	 * 
	 * result = aMatrix;
	 * 
	 * }
	 */



	/*
	 * public double [][] getResult()
	 * 
	 * {
	 * 
	 * double [][] temp = result;
	 * 
	 * return temp;
	 * 
	 * }
	 */
	
	
	
	
//	public static void main(String [] args) 
//	
//	{
//	
//		Matrix A = new Matrix();
//		
//		Matrix B = new Matrix ();
//		
//		Matrix C = new Matrix(A.multiplication(B));
//		
//		System.out.println(C.toString());
//		
//	}




}
