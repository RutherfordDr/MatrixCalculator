import java.util.ArrayList;

public class MatrixGUI extends Matrix{

    private Matrix matrix;
    private int rows;
    private int coloums;
	
	public BasicCalculatorGUI() {
		this.Matrix = new Matrix();
		start();
	}
	
	public void start() {
		
		
    }
    
    public void matrixRows(String rows){
        this.rows = Int.parseInt(rows);
    }

    public void matrixColoums(String coloums){
        this.coloums = Int.parseInt(coloums);
    }

    public void operation(String operation){
        if (operation.equals("+")){
            matrix.addition();
        } else if (operation.equals("-")){
            matrix.subtraction();
        } else if (operation.equals("*")){
            matrix.multiplication();
        } else if (operation.equals("s")){
            matrix.scalarMultiplication();
        } else if (operation.equals("RREF")){
            matrix.RREF();
        } else if (operation.equals("T")){
            matrix.transpose();
        } else if (operation.equals("=")){
            matrix.equals();
        }
    }

    public String createMatrix(String Matrix){
        ArrayList<String> values = new ArrayList<String>();
        for (int i = 1; i < Matrix.length(); i ++){
            if (Matrix.substring(i - 1, i).equals(",")){
                values.add(Matrix.substring(0, i));
                Matrix = Matrix.substring(i + 1);
            }
        }
        values.add(Matrix);
        String matrixValues = "";
        for (int i = 0; i < coloums; i ++){
            for (int j = 0; j < rows; j ++){
                matrixValues += values.get(i + j) + ", ";
            }
            matrixValues = matrixValues /ln;
        }
        return matrixValues;
    }
}