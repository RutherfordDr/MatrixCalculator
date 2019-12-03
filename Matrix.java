import java.util.Arrays;
import java.util.Scanner;

public class Matrix 

{

	private Scanner scanner;
		
	private double [][] aMatrix;
	
	private int column = 0;
	
	private int row = 0; 
	
	private int [] size;
		
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
	
	
	
	
	public double[][] transpose()// CODE FROM https://stackoverflow.com/questions/15449711/transpose-double-matrix-with-a-java-function
	
		{
		
			double [][] arrayFromInMatrix = getMatrix();
		
			double[][] temp = new double[arrayFromInMatrix[0].length][arrayFromInMatrix.length];
	       
			for (int i = 0; i < arrayFromInMatrix.length; i++)
	            
				for (int j = 0; j < arrayFromInMatrix[0].length; j++)
	                
					temp[j][i] = arrayFromInMatrix[i][j];
	        
			//setResult(temp);
			
			return temp;
	
		}
	
	
	
	  public double [][] addition(Matrix inMatrix)
	  
	  {
	  
		  if ((row == inMatrix.getRow()) && (column == inMatrix.getColumn()))
			  
			  
		  {
			  double [][] thisArray = getMatrix();
			  
			  double [][] inArray = inMatrix.getMatrix(); 
			  
			  for (int i = 0; i < thisArray.length; i++)
		            
					for (int j = 0; j < thisArray[0].length; j++)
					
						{
							
							thisArray[i][j] = thisArray[i][j] + inArray[i][j];
						
						}
		  
			  
			  //setResult(thisArray);
		  
		  
		  
		  
			  return thisArray;
		  }else {
			  
			  
			  return null;
		  
		  
		  }
	  
	  
	  }
	 
	
	
	
	  public double [][] subtraction(Matrix inMatrix)
	  
	  {
		  
		  if ((row == inMatrix.getRow()) && (column == inMatrix.getColumn()))
		  
		  
		  {
			  double [][] thisArray = getMatrix();
			  
			  double [][] inArray = inMatrix.getMatrix(); 
			  
			  for (int i = 0; i < thisArray.length; i++)
		            
					for (int j = 0; j < thisArray[0].length; j++)
					
						{
							
							thisArray[i][j] = thisArray[i][j] - inArray[i][j];
						
						}
		  
			  
			  //setResult(thisArray);
		  
		  
		  
		  
			  return thisArray;
		  }else {
			  
			  
			  return null;
		  
		  
		  }
		  
	  
	  
		  
	  }
	 
	
	
	
	  public double [][] multiplication(Matrix inMatrix)
	  
	  {
		  if (column == inMatrix.getRow())
				  
		  		{
			  
					double [][] tempArray = new double [row][inMatrix.getColumn()];
				  	
			/*
			 * System.out.println(column); System.out.println(inMatrix.getRow());
			 */
					
					double[][] thisArray = getMatrix(); 
					
					double[][] thatArray = inMatrix.getMatrix(); 
					
					
					////FROM  https://stackoverflow.com/questions/17623876/matrix-multiplication-using-arrays
					for (int i = 0; i < getRow(); i++)
						for (int j = 0; j < inMatrix.getColumn(); j++)
							for (int k = 0; k < getColumn() ; k++)
								tempArray[i][j] += thisArray[i][k] * thatArray[k][j];
								

					return tempArray;

		  		
		  		
		  		}else {
		  			
		  			return null;
		  		}
	  
		  
	  
	  
	  
	  }
	 
	 
	
	
	public double [][] multiplicationScalar(int scalar)
	
		{
			
		double [][] array = getMatrix();
		
		double[][] temp = new double[array.length][array[0].length];
		
		for (int i = 0; i < array.length; i++)
            
			for (int j = 0; j < array[0].length; j++)
                
				temp[i][j] = array[i][j*scalar];
		
		//setResult(temp);
		
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
	
	
	public double [][] reducedRowEcheleon(){
		int REF = 0;
        int row = 0;
    	int coloum = 0;
    	double count = 0;

    	while (row < aMatrix.length && REF < aMatrix.length && REF < aMatrix[0].length){
		   double division = aMatrix[REF][REF];
			while (coloum < aMatrix[0].length){
				
				if (aMatrix[REF][REF] == 0 && (REF + 1) < aMatrix[0].length){
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
	
	
	
	
	
	
	
	
	public void resetArray()
	
		{
			
		
			double [][] tempArray = new double[row][column];
			
			setMatrixWithArray(tempArray);
		
		
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





