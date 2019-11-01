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


			String operation = "base";
			Scanner scanner = new Scanner(System.in);
			String equation = "Y";
			while (!(operation.equals("=")) && equation.equals("Y")){
				System.out.println("Type '+' for addition");
				System.out.println("Type '-' for subtraction");
				System.out.println("Type 's' for scalar multiplication");
				System.out.println("Type 'T' for transpose");
				System.out.println("Type 'RREF' for reduced row echelon form");
				System.out.println("Type '=' for solution");
				operation = scanner.nextLine();
				if(operation.equals("+")){
					aMatrix = setResult(addition());
				} else if(operation.equals("-")){
					aMatrix = setResult(subtraction());
				}else if(operation.equals("s")){
					System.out.println("Input number to multiply matrix with");
					int input = scanner.nextInt();
					aMatrix = setResult(multiplicationScalar(input));
				}else if(operation.equals("T")){
					aMatrix = setResult(transpose());
				}else if(operation.equals("RREF")){
					aMatrix = setResult(reducedRowEcheleon());
				}else if(operation.equals("=")){
					System.out.println(toString());
					System.out.println("Would you like to do another operation on current matrix Y/N");
					equation = (scanner.nextLine()).toUpperCase();
					operation = "base";
					if (!(equation.equals("Y"))){
						System.out.println("Would you like to do another operation on a different matrix Y/N");
						equation = (scanner.nextLine()).toUpperCase();
						if (equation.equals("Y")){
							getMatrixFromUser();
						}
					}
				}else {
					System.out.println("error invalid option");
				}
				System.out.print("\033[H\033[2J");  
			}
		
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
	
	
	
	
	public double[][] transpose()// CODE FROM https://stackoverflow.com/questions/15449711/transpose-double-matrix-with-a-java-function
	
		{
		
			double [][] arrayFromInMatrix = getMatrix();
		
			double[][] temp = new double[arrayFromInMatrix[0].length][arrayFromInMatrix.length];
	       
			for (int i = 0; i < arrayFromInMatrix.length; i++)
	            
				for (int j = 0; j < arrayFromInMatrix[0].length; j++)
	                
					temp[j][i] = arrayFromInMatrix[i][j];
	        
			return temp;
	
		}
	
	public double [][] addition(){
		double [][] second = new double[row][column];
        double val = 0;
		for (int i = 0; i < row; i ++) {
			for (int j = 0; j < column; j++) {
				System.out.print("Insert value in row " + (i+1) + " and column " + (j+1) + " : ");
				Scanner scanner = new Scanner(System.in); 
				String value = scanner.nextLine();
				if (value.equals("")) {
					System.out.println("Empty input, value equals 0");
					val = 0;}
				else {
					val = Double.parseDouble(value);}
				second[i][j] = val;
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				second[i][j] += aMatrix[i][j];
			}
		}
		return second;
	}
	
	public double [][] subtraction(){
		double [][] second = new double[row][column];
        double val = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print("Insert value in row " + (i+1) + " and column " + (j+1) + " : ");
				Scanner scanner = new Scanner(System.in); 
				String value = scanner.nextLine();
				if (value.equals("")) {
					System.out.println("Empty input, value equals 0");
					val = 0;}
				else {
					val = Double.parseDouble(value);}
				second[i][j] = val;
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				second[i][j] = aMatrix[i][j] - second[i][j];
			}
		}
		return second;
	}
	
	/*
	   public double [][] multiplication() {
	   	double[][] first = new double[row][column];
	   	double[][] second = new double[row][column];
		double[][] multiply = new multiply[row][column];
		Scanner sc = new Scanner(System.in);
		
	double val = 0;
		for (int i = 0; i < row; i++) 
			for (int j = 0; j < column; j++) 
				first[i][j] = scanner.nextInt();
				
		for (int i = 0; i < row; i++) 
			for (int j = 0; j < column; j++) 
				second[i][j] = scanner.nextInt();
				
	   	for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				for (int k = 0; k < row; k++) {
				
				val = val + aMatrix[i][k] * second[k][j];
				}
			multiply[i][j] = val;
			}
		}
		return multiply;
	}
			
	
	 */
	
	
	public double [][] multiplicationScalar(int scalar)
	
		{
			
		double [][] array = getMatrix();
		
		double[][] temp = new double[array.length][array[0].length];
		
		for (int i = 0; i < array.length; i++)
            
			for (int j = 0; j < array[0].length; j++)
                 
				temp[i][j] = scalar * array[i][j];
		
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


	// Currently works perfectly for most test cases
	public double [][] reducedRowEcheleon(){
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
			//Creating zero's above the leading one	
			if (row - 1 > -1){
				for(int i = row - 1; i > -1; i --){
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
	
	public double[][] setResult(double[][] aMatrix){
		result = new double [aMatrix.length][aMatrix[0].length];
		double val = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
                		result[i][j] = aMatrix[i][j];
			}
		}
		return result;
	}
}
























