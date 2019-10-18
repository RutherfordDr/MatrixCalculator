import java.util.Arrays;
import java.util.Scanner;


// CURRENT PROBLEMS (Weds 09/10/2019)
// - Input is row by row, column by column -> Will be changed by inputs by row (setValues)
// - Create toString (to print matrix on the command window)

public class Matrix {
	private Scanner scanner;
	int row=0;
    int col=0;
    double[][] aMatrix;
    double[][] result;

	public Matrix() {
		col = setSizeCol();
		row = setSizeRow();
		aMatrix = createEmptyMatrix(row, col);
		aMatrix = setValues(aMatrix);
        String operation = "base";
        Scanner scanner = new Scanner(System.in);
		while (!(operation.equals("="))){
			System.out.println("Type '+' for addition");
			System.out.println("Type '-' for subtraction");
			System.out.println("Type 'x' for multiplication");
			System.out.println("Type 's' for scalar multiplication");
			System.out.println("Type 'T' for transpose");
			System.out.println("Type 'I' for inverse");
			System.out.println("Type 'Va' for eigenvalue");
			System.out.println("Type 'Ve' for eigenvector");
			System.out.println("Type '=' for solution");
			operation = scanner.nextLine();
			if(operation.equals("+")){
				setResult(addition());
			} else if(operation.equals("-")){
				setResult(subtraction());
			} else if(operation.equals("x")){
				setResult(multiplication());
			}else if(operation.equals("s")){
				setResult(mulitplicationByScalar());
			}else if(operation.equals("I")){
				setResult(inverse());
			}else if(operation.equals("T")){
				setResult(transpose());
			}else if(operation.equals("Va")){
				setResult(eigenValues());
			}else if(operation.equals("Ve")){
				setResult(eigenVectors());
			}else if(operation.equals("=")){
				System.out.println(toString());
			}else {
				System.out.println("error invalid option");
			}
		}
		//System.out.println(Arrays.toString(aMatrix));
	}
    
    public double[][] multiplication(){
        Scanner input = new Scanner(System.in);
        System.out.print("Insert Column size: ");
		int a = input.nextInt();
		System.out.print("Insert Row size: ");
		int b = input.nextInt();
        double [][] second = new double[a][b];
        return second;
    }

    public double[][] mulitplicationByScalar(){
        Scanner input = new Scanner(System.in);
        System.out.print("Insert Column size: ");
		int a = input.nextInt();
		System.out.print("Insert Row size: ");
		int b = input.nextInt();
        double [][] second = new double[a][b];
        return second;
    }

    public double[][] inverse(){
        Scanner input = new Scanner(System.in);
        System.out.print("Insert Column size: ");
		int a = input.nextInt();
		System.out.print("Insert Row size: ");
		int b = input.nextInt();
        double [][] second = new double[a][b];
        return second;
    }

    public double[][] transpose(){
        Scanner input = new Scanner(System.in);
        System.out.print("Insert Column size: ");
		int a = input.nextInt();
		System.out.print("Insert Row size: ");
		int b = input.nextInt();
        double [][] second = new double[a][b];
        return second;
    }

    public double[][] eigenValues(){
        Scanner input = new Scanner(System.in);
        System.out.print("Insert Column size: ");
		int a = input.nextInt();
		System.out.print("Insert Row size: ");
		int b = input.nextInt();
        double [][] second = new double[a][b];
        return second;
    }

    public double[][] eigenVectors(){
        Scanner input = new Scanner(System.in);
        System.out.print("Insert Column size: ");
		int a = input.nextInt();
		System.out.print("Insert Row size: ");
		int b = input.nextInt();
        double [][] second = new double[a][b];
        return second;
    }

    public String toString(){
        String s = "";
        for(int i=0; i< aMatrix.length; i++){
            for(int j=0; j<aMatrix[0].length; j++){
                s +=  result[i][j] + ", ";
            }
            s += "\n";
        }
        return s;
    }

	public double[][] addition(){
        Scanner input = new Scanner(System.in);
		System.out.print("Insert Column size: ");
		int a = input.nextInt();
		System.out.print("Insert Row size: ");
		int b = input.nextInt();
		double [][] second = new double[a][b];
        int [][] result = new int[a][b];
        double val = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
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
			for (int j = 0; j < col; j++) {
				second[i][j] += aMatrix[i][j];
			}
		}
		return second;
	}
				 
	public double[][] subtraction(){
        Scanner input = new Scanner(System.in);
		System.out.print("Insert Column size: ");
		int a = input.nextInt();
		System.out.print("Insert Row size: ");
		int b = input.nextInt();
		double [][] second = new double[a][b];
        int [][] result = new int[a][b];
        double val = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
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
			for (int j = 0; j < col; j++) {
				second[i][j] = aMatrix[i][j] - second[i][j];
			}
		}
		return second;
	}
	
	public Matrix(int row, int col) {
		this.row=row;
		this.col=col;
		double[][] aMatrix = createEmptyMatrix(this.row, this.col);
		aMatrix = setValues(aMatrix);
		//System.out.println(Arrays.toString(aMatrix));
		
	}
	
	public int setSizeCol() {
		int sizecol = 0;
		System.out.print("Insert Column size: ");
		Scanner scanner = new Scanner(System.in); 
		String sizeCol = scanner.nextLine();
		if (sizeCol.equals("")) {
			System.out.println("Empty input, Column = 1");
			sizecol = 1;}
		else
			sizecol = Integer.parseInt(sizeCol);
		return sizecol;
	}
	
	public int setSizeRow() {
		int sizerow = 0;
		System.out.print("Insert Row size: ");
		Scanner scanner = new Scanner(System.in); 
		String sizeRow = scanner.nextLine();
		if (sizeRow.equals("")) {
			System.out.println("Empty input, row = 1");
			sizerow = 1;}
		else
			sizerow = Integer.parseInt(sizeRow);
		return sizerow;
	}
	
	public double[][] setValues(double[][] aMatrix) {
		double val = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				
				System.out.print("Insert value in row " + (i+1) + " and column " + (j+1) + " : ");
				Scanner scanner = new Scanner(System.in); 
				String value = scanner.nextLine();
				if (value.equals("")) {
					System.out.println("Empty input, value equals 0");
					val = 0;}
				else {
					val = Double.parseDouble(value);}
				aMatrix[i][j] = val;
				
			}
			
		}
		return aMatrix;
		
    }
    
    public double[][] setResult(double[][] aMatrix) {
        result = new double [aMatrix.length][aMatrix[0].length];
		double val = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
                result[i][j] = aMatrix[i][j];
			}
		}
		return result;
	}
	
	public double[][] createEmptyMatrix(int row, int col) {
		if (row<0 || col<0) {
			System.out.println("ERROR: Size has to be greater than 0. 3x3 Matrix Created. ");
			double[][] aMatrix = new double[2][2];
			return aMatrix;
		}
		else {
		double[][] aMatrix = new double[row][col];
		return aMatrix;
		}
	}
		
}