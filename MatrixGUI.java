import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class MatrixGUI extends Matrix{

    private Matrix matrix;
    private int rows;
    private int coloums;
    double [][] Matrix1;
    private double [][] Matrix2;
    double value;
	
    private String filename1 = "matrixCalculatorHistory1.txt";
   
       
    
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
            return result(matrix.multiplicationScalar(Matrix1, value));
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
        
    	int rows = Matrix1.length;
    	
    	int columns = Matrix1[0].length;
    	
    	String size = rows + "x" + columns;
    	
    	String line = "Matrix1: \n" + Matrix + "["+ size + "]\n";
    	
    	writeToHistory(line,filename1);
    	
    	
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
        
    	int rows = Matrix2.length;
    	
    	int columns = Matrix2[0].length;
    	
    	String size = rows + "x" + columns;
    	
    	String line = "Matrix2:\n" + Matrix + "["+ size + "]\n";
    	
    	writeToHistory(line,filename1);
    	
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

    
    
    
    
    public void writeToHistory(String inString,String filename) {
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileOutputStream(filename, true));
			outputStream.println(inString);
			outputStream.close();
			
		}
		catch(FileNotFoundException e) {
			System.out.println("Can't save to session history");
		}
	}

	
	
	/*
	 * Closes the history and write "Session Ended" into the history file.
	 */
	   
    
    public String result(double[][] result){
        String matrix = "";
        for (int i = 0; i < result.length; i ++){
            for (int j = 0; j < result[0].length; j ++){
                matrix += result[i][j] + ", ";
            }
            matrix += "\n";

        }
        
    	int rows = result.length;
    	
    	int columns = result[0].length;
    	
    	String size = rows + "x" + columns;
    	
    	String line = "Result: \n" + matrix + "["+ size + "] \n";
    	
    	writeToHistory(line,filename1);
        
        return matrix;
    }

    public void setScalar(String Scalar){
        value = Double.parseDouble(Scalar);
        String line = "Scalar: \n" + Scalar + "\n";
    	writeToHistory(line,filename1);
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
    public ArrayList<String> readHistory1() {
        Scanner inputStream = null;
        ArrayList<String> historyb = new ArrayList<String>();
        int Counter = 0;
        int count = 0;
        String line = "";
        try {
        inputStream = new Scanner(new File(filename1));
            while (inputStream.hasNext()) {
                line = inputStream.nextLine();
                historyb.add(Counter, line);
                Counter++;
            }
        }
        catch(FileNotFoundException e) {
            historyb.add(0, "History not Found");
        }
        return historyb;
    }
    
	public void deleteHistory() {
		
		try {	
			PrintWriter outputStream = new PrintWriter(new FileOutputStream(filename1));
			outputStream.println("");
			outputStream.close();
			}
		catch(FileNotFoundException e) {
			System.out.println("No history available.");
			}
}
}