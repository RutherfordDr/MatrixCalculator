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
	
	
	public double [][] reducedRowEcheleon(Matrix inMatrix){
		int x = inMatrix.length();
		int topColoum = 0;
		int testing = 0;
		double top = 0;
		double valueToMultiply = 0;
		double[][] aMatrix = new double[5][5];
		while (x != 0){
			for (int i = 0; i < aMatrix.length; i ++){
				for (int j = topColoum + 1; j < aMatrix[0].length; j ++){
					if(aMatrix[i][j] != 0){
						if(testing = 0){
							testing ++;
							topColoum = j;
							top = aMatrix[i][j];
						}
						aMatrix[i][j] = aMatrix[i][j] / top;
					} else if (aMatrix[i][topColoum + 1] == 0){
						/* Switching leading 1's position */
						while (aMatrix[i][j] == 0 || i == inMatrix.length()){
							int position = i;
							i ++;
							if(aMatrix[i][j] != 0){
								ArrayList<Double> list = new ArrayList<Double>();
								for (int t = 0; t != aMatrix.length; t ++){
									list.add(aMatrix[i][t]);
									aMatrix[i][t] = inMatirx[position][t];
									aMatrix[position][t] = list.get(t);
								}
								i = position;
								aMatrix[i][j] /= aMatrix[i][j];
							}
						}
					}
					testing --;
				}
				/* Creating RREF */
				for (int t = 0; i < aMatrix.length; i ++){
					for (int j = 0; j != aMatrix[0].length; j ++){
						if(t != i && aMatrix[t][topColoum] != 0){
							if(valueToMultiply == 0){
								valueToMultiply = aMatrix[t][topColoum];
							}
							aMatrix[t][j] = aMatrix[t][j] - inMatraMatrixix[i][j] * valueToMultiply;
						}
					}
				}
			}
			x --;
		}
		double[][] RREF = new double[aMatrix.length][aMatrix[0].length];
		for (int i = 0; i < aMatrix.length; i ++){
			for (int j = 0; j < aMatrix[0].length; j ++){
				RREF[i][j] = aMatrix[i][j];
			}
        	}
		return RREF;
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
























