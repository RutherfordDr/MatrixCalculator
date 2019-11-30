import java.util.ArrayList;

public class MatrixGUI extends Matrix{

    private Matrix matrix;
    private int rows;
    private int coloums;
    double [][] Matrix1;
    private double [][] Matrix2;
	
	public MatrixGUI() {
		this.matrix = new Matrix();
		start();
	}
	
	public void start() {
		
		
    }
    
    public void matrixRows(String rows){
        this.rows = Integer.parseInt(rows);
    }

    public void matrixColoums(String coloums){
        this.coloums = Integer.parseInt(coloums);
    }

    public String operation(String operation){
        if (operation.equals("+")){
            return result(matrix.addition(Matrix1, Matrix2));
        } else if (operation.equals("-")){
            return result(matrix.subtraction(Matrix1, Matrix2));
        } else if (operation.equals("*")){
            return result(matrix.multiplication(Matrix1, Matrix2));
        } else if (operation.equals("s")){
            return result(matrix.multiplicationScalar(Matrix1, Matrix2));
        } else if (operation.equals("RREF")){
            return result(matrix.reducedRowEcheleon(Matrix1));
        } else if (operation.equals("T")){
            return result(matrix.transpose(Matrix1));
        }
        else {
			return null;
		}
    }

    public String createMatrix(String Matrix){
    	String matrixValues = "";
    	int count =0;
        for (int k = 0; k < Matrix.length(); k ++){
            if(Matrix.substring(k, k + 1).equals(",")){
            	matrixValues+=Matrix.substring(0, Matrix.indexOf(","))+ ",";
                Matrix = Matrix.substring(Matrix.indexOf(",") + 1);
                k = 0;
                count++;
                if (count%coloums==0) {
                	matrixValues+="\n";
                }
            } else if (Matrix.indexOf(",") == -1){
            	matrixValues+=Matrix;
                k = Matrix.length();
            }
        }
        return matrixValues;
    }

    public void setMatrix(String Matrix){
        Matrix1 = new double [rows][coloums];
        for (int i = 0; i < Matrix1.length; i ++){
            for (int j = 0; j < Matrix1[0].length; j ++){
                for (int k = 0; k < Matrix.length(); k ++){
                    if(Matrix.substring(k, k + 1).equals(",")){
                        Matrix1[i][j] = Double.parseDouble(Matrix.substring(0, Matrix.indexOf(",")));
                        Matrix = Matrix.substring(Matrix.indexOf(",") + 1);
                        k = Matrix.length();
                    } else if (Matrix.indexOf(",") == -1){
                        Matrix1[i][j] = Double.parseDouble(Matrix);
                        k = Matrix.length();
                    }
                }
            }
        }

    }

    public void setMatrix2(String Matrix){
        Matrix2 = new double [rows][coloums];
        for (int i = 0; i < Matrix2.length; i ++){
            for (int j = 0; j < Matrix2[0].length; j ++){
                for (int k = 0; k < Matrix.length(); k ++){
                    if(Matrix.substring(k, k + 1).equals(",")){
                        Matrix2[i][j] = Double.parseDouble(Matrix.substring(0, Matrix.indexOf(",")));
                        Matrix = Matrix.substring(Matrix.indexOf(",") + 1);
                        k = Matrix.length();
                    } else if (Matrix.indexOf(",") == -1){
                        Matrix2[i][j] = Double.parseDouble(Matrix);
                        k = Matrix.length();
                    }
                }
            }
        }

    }

    public String result(double[][] result){
        String matrix = "";
        for (int i = 0; i < result.length; i ++){
            for (int j = 0; j < result[0].length; j ++){
                matrix += result[i][j] + ", ";
            }
            matrix += "\n";
        }
        return matrix;
    }

    public void setScalar(String Scalar){
        Matrix2 = new double [1][1];
        Matrix2[0][0] = Double.parseDouble(Scalar);
    }
    
    public String Matrix1() {
        String matrix = "";
        for (int i = 0; i < Matrix1.length; i ++){
            for (int j = 0; j < Matrix1[0].length; j ++){
                matrix += Matrix1[i][j] + ", ";
            }
            matrix += "\n";
        }
        return matrix;
    }
    
    public String Matrix2() {
        String matrix = "";
        for (int i = 0; i < Matrix2.length; i ++){
            for (int j = 0; j < Matrix2[0].length; j ++){
                matrix += Matrix2[i][j] + ", ";
            }
            matrix += "\n";
        }
        return matrix;
    }
}