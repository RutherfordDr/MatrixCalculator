import java.util.Arrays;
import java.util.Scanner;

public class Matrix 

{

	private Scanner scanner;
		
	private double [][] aMatrix;
	
	private int column = 0;
	
	int row = 0;
	
	int size;
	
	private double [][] result;
	
	public Matrix()
	
		{
		
			getMatrixFromUser();
		
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
			
			setMatrix(inMatrix.getMatrix());
			
		}
	
	public Matrix(double [][] inArray)
	
		{
		
		setMatrix(inArray);
	
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
	
	public void setMatrix(double [][] inMatrix)
	
		{
			
			row = inMatrix.length;
			
			column = inMatrix[0].length;
			
			aMatrix = inMatrix; 
		
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
		
			setMatrix(aMatrix);
		
		
		
		}
	
	
	
	
	public double[][] transpose(Matrix inMatrix)// CODE FROM https://stackoverflow.com/questions/15449711/transpose-double-matrix-with-a-java-function
	
		{
		
			double [][] arrayFromInMatrix = inMatrix.getMatrix();
		
			double[][] temp = new double[arrayFromInMatrix[0].length][arrayFromInMatrix.length];
	       
			for (int i = 0; i < arrayFromInMatrix.length; i++)
	            
				for (int j = 0; j < arrayFromInMatrix[0].length; j++)
	                
					temp[j][i] = arrayFromInMatrix[i][j];
	        
			return temp;
	
		}
	
	
	/*
	 * public double [][] addition(Matrix inMatrix)
	 * 
	 * {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	
	
	/*
	 * public double [][] subtraction(Matrix inMatrix)
	 * 
	 * {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	
	/*
	 * public double [][] multiplication(Matrix inMatrix)
	 * 
	 * {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	
	
	public double [][] multiplicationScalar(int scalar)
	
		{
			
		double [][] array = getMatrix();
		
		double[][] temp = new double[array.length][array[0].length];
		
		for (int i = 0; i < array.length; i++)
            
			for (int j = 0; j < array[0].length; j++)
                
				temp[i][j] = array[i][j*scalar];
		
		return temp; 
		
		
		}
	
	/*
	 * public double [][] inverse(Matrix inMatrix)
	 * 
	 * {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	
	//Taken from https://stackoverflow.com/questions/19940740/gaussian-elimination-java (change later)
	public double [][] reducedRowEcheleon(Matrix inMatrix){
        int rows = aMatrix.length;
        int cols = rows + 1;
        // 1. set c[row][row] equal to 1
        double factor = aMatrix[row][row];
        for (int col=0; col<cols; col++){
            aMatrix[row][col] /= factor;
	}
        // 2. set c[row][row2] equal to 0
        for (int row2=0; row2<rows; row2++){
            if (row2 != row) {
                factor = -aMatrix[row2][row];
                for (int col=0; col<cols; col++){
                    aMatrix[row2][col] += factor * aMatrix[row][col];
		}
            }
	}
	}
					
	
	public void resetArray()
	
		{
			
		
			double [][] tempArray = new double[row][column];
			
			setMatrix(tempArray);
		
		
		}
	
	
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
	
	public void setResult(double[][] aMatrix){
		result = new double [aMatrix.length][aMatrix[0].length];
		double val = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
                		result[i][j] = aMatrix[i][j];
			}
		}
		return result;
	}
}
























