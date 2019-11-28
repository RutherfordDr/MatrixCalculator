import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.event.ActionEvent;


public class CalculatorGUI extends Application{
	Scene scene;
	Scene scene2;
	Scene scene3;
	Scene scene4;
	Stage window;
	 
	public static void main(String[] args)
	   {
	      launch(args);
	   }

	   @SuppressWarnings("static-access")
	@Override
	   public void start(Stage primaryStage) throws Exception
	   {
		 window = primaryStage;
		 //--SCENE 1--
		   BorderPane root = new BorderPane();
		   HBox centerPane = new HBox();
		   
		   //creating buttons
	        Button btn = new Button();
	        btn.setText("Basic Calculator");
	        btn.setOnAction(e -> window.setScene(scene2));
	        
	        Button btn1 = new Button();
	        btn1.setText("Scientific Calculator");
	        btn1.setOnAction(e -> window.setScene(scene3));
	        
	        Button btn2 = new Button();
	        btn2.setText("Matrix Calculator");
	        btn2.setOnAction(e -> window.setScene(scene4));
	        
	        //adding buttons
			 centerPane.getChildren().add(btn);
			 centerPane.getChildren().add(btn1);
			 centerPane.getChildren().add(btn2);
			 
		root.setCenter(centerPane);
		  scene = new Scene(root, 400, 50);
	      window.setTitle("Java Calculator");
	      window.setScene(scene);
	      window.show();
	      
	     //--SCENE 2-- (Basic Calculator)
	      BasicCalculatorGUI bc = new BasicCalculatorGUI();
	      BorderPane root2 = new BorderPane();
	      scene2 = new Scene(root2, 400, 400);
	      HBox buttonsB = new HBox();
	      root2.setBottom(buttonsB);
	      root2.setPadding(new Insets(70, 25, 30, 30));
	      
	        Text textOP = new Text();
	        root2.setCenter(textOP);
	        textOP.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
	        
		    //creating buttons
		        Button bt1 = new Button();
		        bt1.setText("   +   ");
		        bt1.setOnAction(new EventHandler<ActionEvent>() {
		            @Override public void handle(ActionEvent e) {
		            	bc.Operation("+");
		            	textOP.setText(bc.getOperation());
		            }
		        });
		        Button bt2 = new Button();
		        bt2.setText("   -   ");
		        bt2.setOnAction(new EventHandler<ActionEvent>() {
		            @Override public void handle(ActionEvent e) {
		            	bc.Operation("-");
		            	textOP.setText(bc.getOperation());
		            }
		        });
		        Button bt3 = new Button();
		        bt3.setText("   *   ");
		        bt3.setOnAction(new EventHandler<ActionEvent>() {
		            @Override public void handle(ActionEvent e) {
		            	bc.Operation("*");
		            	textOP.setText(bc.getOperation());
		            }
		        });
		        Button bt4 = new Button();
		        bt4.setText("   /   ");
		        bt4.setOnAction(new EventHandler<ActionEvent>() {
		            @Override public void handle(ActionEvent e) {
		            	bc.Operation("/");
		            	textOP.setText(bc.getOperation());
		            }
		        });
		        Button bt5 = new Button();
		        bt5.setText("   (   ");
		        bt5.setOnAction(new EventHandler<ActionEvent>() {
		            @Override public void handle(ActionEvent e) {
		            	bc.Operation("(");
		            	textOP.setText(bc.getOperation());
		            }
		        });
		        Button bt6 = new Button();
		        bt6.setText("   )   ");
		        bt6.setOnAction(new EventHandler<ActionEvent>() {
		            @Override public void handle(ActionEvent e) {
		            	bc.Operation(")");
		            	textOP.setText(bc.getOperation());
		            }
		        });
		        Button bt7 = new Button();
		        bt7.setText("   =   ");
		        bt7.setOnAction(new EventHandler<ActionEvent>() {
		            @Override public void handle(ActionEvent e) {
		            	double result = bc.equals();
		            	textOP.setText(bc.operation + " = " + result);
		            	bc.operation="";
		            }
		        });
		        Button bt8 = new Button();
		        bt8.setText("CLEAR");
		        bt8.setOnAction(new EventHandler<ActionEvent>() {
		            @Override public void handle(ActionEvent e) {
		            	bc.Operation("CLEAR");
		            	textOP.setText(bc.getOperation());
		            }
		        });
		        
		      //adding buttons
		        buttonsB.getChildren().add(bt1);
		        buttonsB.getChildren().add(bt2);
		        buttonsB.getChildren().add(bt3);
		        buttonsB.getChildren().add(bt4);
		        buttonsB.getChildren().add(bt5);
		        buttonsB.getChildren().add(bt6);
		        buttonsB.getChildren().add(bt7);
		        buttonsB.getChildren().add(bt8);
		        
		        
		        
			      //text field 
		        TextField text = new TextField("Insert number and press enter");
		        root2.setTop(text);
		        text.setOnAction(new EventHandler<ActionEvent>() {
		            @Override public void handle(ActionEvent e) {
		            	String tem = text.getText();
		            	if (isNumeric(tem) == true) {
		            	bc.temp = tem;
		            	bc.addNumberToOp();
		            	text.setText("");
		            	textOP.setText(bc.getOperation());}
		            }
		        }); 
		        
		        
		        
	      
	    //--SCENE 3-- (Scientific Calculator)
	      ScientificCalculatorGUI sc = new ScientificCalculatorGUI();
	      BorderPane root3= new BorderPane();
	      scene3 = new Scene(root3, 600, 400);
	      HBox buttonsS = new HBox();
	      root3.setPadding(new Insets(70, 25, 30, 30));
	      
	        Text textSOP = new Text();
	        root3.setCenter(textSOP);
	        textSOP.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
	        GridPane gridSC = new GridPane();
	        gridSC.setVgap(3);
	        gridSC.setAlignment(Pos.CENTER);
	        gridSC.setMinSize(400, 200);
	        root3.setBottom(gridSC);
	        gridSC.add(buttonsS, 0, 0);
	        
	        

	      //creating buttons
	        Button bt21 = new Button();
	        bt21.setText("   +   ");
	        bt21.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	            	sc.Operation(" + ");
	            	textSOP.setText(sc.getOperation());
	            }
	        });
	        Button bt22 = new Button();
	        bt22.setText("   -   ");
	        bt22.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	            	sc.Operation(" - ");
	            	textSOP.setText(sc.getOperation());
	            }
	        });
	        Button bt23 = new Button();
	        bt23.setText("   *   ");
	        bt23.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	            	sc.Operation(" * ");
	            	textSOP.setText(sc.getOperation());
	            }
	        });
	        Button bt24 = new Button();
	        bt24.setText("   /   ");
	        bt24.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	            	sc.Operation(" / ");
	            	textSOP.setText(sc.getOperation());
	            }
	        });
	        Button bt25 = new Button();
	        bt25.setText("   (   ");
	        bt25.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	            	sc.Operation(" (");
	            	textSOP.setText(sc.getOperation());
	            }
	        });
	        Button bt26 = new Button();
	        bt26.setText("   )   ");
	        bt26.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	            	sc.Operation(" ) ");
	            	textSOP.setText(sc.getOperation());
	            }
	        });
	        Button bt27 = new Button();
	        bt27.setText("           =           ");
	        bt27.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	            	String result = sc.equals();
	            	textSOP.setText(sc.operation + " = " + result);
	            	sc.operation="";
	            }
	        });
	        Button bt28 = new Button();
	        bt28.setText("   CLEAR   ");
	        bt28.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	            	sc.Operation("CLEAR");
	            	textSOP.setText(sc.getOperation());
	            }
	        });
	        
	      //adding buttons
	        buttonsS.getChildren().add(bt21);
	        buttonsS.getChildren().add(bt22);
	        buttonsS.getChildren().add(bt23);
	        buttonsS.getChildren().add(bt24);
	        buttonsS.getChildren().add(bt25);
	        buttonsS.getChildren().add(bt26);
	        buttonsS.getChildren().add(bt27);
	        buttonsS.getChildren().add(bt28);
	        
	      //text field 
	        TextField textS = new TextField("Insert number and press enter");
	        root3.setTop(textS);
	        textS.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	            	String temp = textS.getText();
	            	if (isNumeric(temp) == true) {
	            	sc.temp = temp;
	            	sc.addNumberToOp();
	            	textS.setText("");
	            	textSOP.setText(sc.getOperation());}
	            }
	        }); 
	        
	        //buttons2
	        HBox buttonsS1 = new HBox();
	        gridSC.add(buttonsS1, 0, 1);
		    Button bt29 = new Button();
	        bt29.setText("   log   ");
	        bt29.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	            	sc.Operation("log (");
	            	textSOP.setText(sc.getOperation());
	            }
	        });
		    Button bt30 = new Button();
	        bt30.setText("   ln   ");
	        bt30.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	            	sc.Operation("ln ( ");
	            	textSOP.setText(sc.getOperation());
	            }
	        });
	        Button bt31 = new Button();
	        bt31.setText("   ^2   ");
	        bt31.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	            	sc.Operation(" ^ ( 2 ) ");
	            	textSOP.setText(sc.getOperation());
	            }
	        });
	        Button bt32 = new Button();
	        bt32.setText("  sqrt  ");
	        bt32.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	            	sc.Operation("sqrt ( ");
	            	textSOP.setText(sc.getOperation());
	            }
	        });
	        Button bt33 = new Button();
	        bt33.setText("  ^  ");
	        bt33.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	            	sc.Operation(" ^ ( ");
	            	textSOP.setText(sc.getOperation());
	            }
	        });
	        Button bt34 = new Button();
	        bt34.setText("  pi  ");
	        bt34.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	            	sc.Operation("pi");
	            	textSOP.setText(sc.getOperation());
	            }
	        });
	        Button bt35 = new Button();
	        bt35.setText("  sin  ");
	        bt35.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	            	sc.Operation(" sin ( ");
	            	textSOP.setText(sc.getOperation());
	            }
	        });
	        Button bt36 = new Button();
	        bt36.setText("  cos  ");
	        bt36.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	            	sc.Operation(" cos ( ");
	            	textSOP.setText(sc.getOperation());
	            }
	        });
	        Button bt37 = new Button();
	        bt37.setText("  tan  ");
	        bt37.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	            	sc.Operation(" tan ( ");
	            	textSOP.setText(sc.getOperation());
	            }
	        });
	        
	      //adding buttons
	        buttonsS1.getChildren().add(bt29);
	        buttonsS1.getChildren().add(bt30);
	        buttonsS1.getChildren().add(bt31);
	        buttonsS1.getChildren().add(bt32);
	        buttonsS1.getChildren().add(bt33);
	        buttonsS1.getChildren().add(bt34);
	        buttonsS1.getChildren().add(bt35);
	        buttonsS1.getChildren().add(bt36);
	        buttonsS1.getChildren().add(bt37);
	        
	      //button 3
	        
	      // TODO: SWITCH MODE NOT WORKING
	        HBox buttonsMODE = new HBox();
	        gridSC.add(buttonsMODE, 0, 2);
	        Text textmode = new Text();
	        root3.setLeft(textmode);
	        textmode.setText(sc.displayMode());
	        textmode.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
	        Button bt38 = new Button();
	        bt38.setText("  Switch Mode  ");
	        bt38.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	            	sc.setMode();
	            	textmode.setText(sc.displayMode());
	            }
	        });
	        buttonsMODE.getChildren().add(bt38);
	      
	   //--SCENE 4-- (Matrix Calculator)
	         // MatrixGUI m = new MatrixGUI();
		      BorderPane root4= new BorderPane();
	          scene4 = new Scene(root4, 600, 400);
	        /*  HBox buttonsM = new HBox();
	          root4.setTop(buttonsM);
	          root4.setPadding(new Insets(70, 25, 30, 30));
	          Text textM = new Text();
	          root4.setCenter(textM);
	          textM.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

	          	// Creating Buttons for GUI
	          	Button btM1 = new Button();
			        btM1.setText("   +   ");
			        btM1.setOnAction(new EventHandler<ActionEvent>() {
			            @Override public void handle(ActionEvent e) {
			            	m.operation("+");
			            	textM.setText(" + ");
			            }
					});
				Button btM2 = new Button();
			        btM2.setText("   -   ");
			        btM2.setOnAction(new EventHandler<ActionEvent>() {
			            @Override public void handle(ActionEvent e) {
			            	m.operation("-");
			            	textM.setText(" - ");
			            }
					});
				Button btM3 = new Button();
			        btM3.setText("   *   ");
			        btM3.setOnAction(new EventHandler<ActionEvent>() {
			            @Override public void handle(ActionEvent e) {
			            	m.operation("*");
			            	textM.setText(" * ");
			            }
					});
				Button btM4 = new Button();
			        btM4.setText("   T   ");
			        btM4.setOnAction(new EventHandler<ActionEvent>() {
			            @Override public void handle(ActionEvent e) {
			            	m.operation("T");
			            	textM.setText(" T ");
			            }
					});
				Button btM5 = new Button();
			        btM5.setText("   RREF   ");
			        btM5.setOnAction(new EventHandler<ActionEvent>() {
			            @Override public void handle(ActionEvent e) {
			            	m.operation("RREF");
			            	textM.setText(" RREF ");
			            }
					});
				Button btM6 = new Button();
			        btM6.setText("   Scalar Multiplication   ");
			        btM6.setOnAction(new EventHandler<ActionEvent>() {
			            @Override public void handle(ActionEvent e) {
			            	m.operation("S");
			            	textM.setText(" S ");
			            }
					});
				Button btM7 = new Button();
			        btM7.setText("   =   ");
			        btM7.setOnAction(new EventHandler<ActionEvent>() {
			            @Override public void handle(ActionEvent e) {
			            	m.operation("=");
			            	textM.setText(" = ");
			            }
					});
				//Adding Buttons to GUI
				buttonsM.getChildren().add(btM1);
				buttonsM.getChildren().add(btM2);
				buttonsM.getChildren().add(btM3);
				buttonsM.getChildren().add(btM4);
				buttonsM.getChildren().add(btM5);
				buttonsM.getChildren().add(btM6);
				buttonsM.getChildren().add(btM7);
				
				//Inserting Matrix Values
				Text textM1 = new Text();
	          	root4.setLeft(textM1);
				textM1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
				Text textM2 = new Text();
	          	root4.setRight(textM2);
				textM2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
				HBox textM3 = new HBox();
				   TextField textMatrix = new TextField("Insert ALL numbers for matrix");
				   TextField textRows = new TextField("Insert number of coloums in matrix");
				   TextField textColoums = new TextField("Insert number of rows in matrix");
			    root4.setTop(textM3);
			        textMatrix.setOnAction(new EventHandler<ActionEvent>() {
			            @Override public void handle(ActionEvent e) {
			            	String temp = textMatrix.getText();
							if(textM1.getText() == null){
								textM1.setText(m.createMatrix(temp));
							} else {
								textM2.setText(m.createMatrix(temp));
							}
			            }
					}); 
					textRows.setOnAction(new EventHandler<ActionEvent>() {
			            @Override public void handle(ActionEvent e) {
			            	String temp = textRows.getText();
							m.matrixRows(temp);
			            }
					}); 
					textColoums.setOnAction(new EventHandler<ActionEvent>() {
			            @Override public void handle(ActionEvent e) {
			            	String temp = textColoums.getText();
							m.matrixColoums(temp);
			            }
					}); */
		   } 

	   
	   public static boolean isNumeric(String str) { 
		   try {  
		     Double.parseDouble(str);  
		     return true;
		   } catch(NumberFormatException e){  
		     return false;  
		   }  
		 }
}

	  