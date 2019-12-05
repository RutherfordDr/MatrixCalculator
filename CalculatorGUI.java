import java.util.ArrayList;
import java.util.PrimitiveIterator.OfDouble;

import com.sun.corba.se.spi.orb.Operation;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import jdk.internal.org.objectweb.asm.tree.IntInsnNode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.event.ActionEvent;


public class CalculatorGUI extends Application{
	Scene scene;
	Scene scene2;
	Scene scene3;
	Scene scene4;
	Scene scene5;
	Scene scene6;
	Stage window;
	Stage window2;
	int position;
	ArrayList<String> historyb = new ArrayList<String>();
	 
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
	      scene2 = new Scene(root2, 550, 400);
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
		            	bc.writeToHistoryGUI(bc.operation);
		            	double result = bc.equals();
		            	textOP.setText(bc.operation + " = " + result);
		            	bc.writeToHistoryGUI(Double.toString(result));
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
		        Button bt9 = new Button();
		        bt9.setText("  History  ");
		        bt9.setOnAction(new EventHandler<ActionEvent>() {
		        	 @Override public void handle(ActionEvent e) {
		        	 // History
				    	  window2 = new Stage();
			    	      BorderPane root5= new BorderPane();
			    	      scene5 = new Scene(root5, 450, 700);
			    	      HBox buttonsH = new HBox();
			    	      window2.setTitle("Java Calculator - History");
			    	      window2.setScene(scene5);
			    	      window2.show();
			    	      root5.setBottom(buttonsH);
			    	      root5.setPadding(new Insets(70, 25, 30, 30));
			    	      GridPane gridH = new GridPane();
					      gridH.setVgap(3);
					      gridH.setAlignment(Pos.CENTER);
					       root5.setTop(gridH);
					      historyb = bc.readHistoryGUI();
					      position = 0;
					      
					      if (historyb.size() == 0) {
					    	  historyb.add(0, "History is empty.");
					      }
					      
					       
						   Text textH1 = new Text((String) historyb.get(0));
						   textH1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
						   
						   gridH.add(textH1, 0, 2);
						   ListView<String> listView = new ListView<String>();
						   gridH.add(listView, 0, 1);
						   for (int i=0; i<historyb.size()-1; i++) {
							   listView.getItems().add(historyb.get(i));
						   }
						   
					        Button btH1 = new Button();
					        btH1.setText("   <   ");
					        btH1.setOnAction(new EventHandler<ActionEvent>() {
					            @Override public void handle(ActionEvent e) {
					            	if (position==0) {
						            	textH1.setText((String) historyb.get(position));
					            }
					            	else {
					            		position-=1;
						            	textH1.setText((String) historyb.get(position));
					            	}
					            }
					        });
					        
					        Button btH2 = new Button();
					        btH2.setText("  Select  ");
					        btH2.setOnAction(new EventHandler<ActionEvent>() {
					            @Override public void handle(ActionEvent e) {
					            	String temp = textH1.getText();
					            	bc.operation=temp;
					            	textOP.setText(temp);
					            	
					            }
					        });
					        Button btH3 = new Button();
					        btH3.setText("   >   ");
					        btH3.setOnAction(new EventHandler<ActionEvent>() {
					            @Override public void handle(ActionEvent e) {
					            	if (position>=historyb.size()-1) {
						            	textH1.setText((String) historyb.get(historyb.size()-1));
					            }
					            	else {
					            		position+=1;
						            	textH1.setText((String) historyb.get(position));
					            	}
					            }
					        });
					        Button btH4 = new Button();
					        btH4.setText("   Delete History   ");
					        btH4.setOnAction(new EventHandler<ActionEvent>() {
					            @Override public void handle(ActionEvent e) {
					            	bc.deleteHistory();
					            	textH1.setText("History is empty.");
					            	historyb = bc.readHistoryGUI();
					            	listView.getItems().clear();
									   for (int i=0; i<historyb.size()-1; i++) {
										   listView.getItems().add(historyb.get(i));
									   }
					            	
					            }
					        });
					        Button btH5 = new Button();
					        btH5.setText("   Update History   ");
					        btH5.setOnAction(new EventHandler<ActionEvent>() {
					            @Override public void handle(ActionEvent e) {
					            	historyb = bc.readHistoryGUI();
					            	listView.getItems().clear();
								      if (historyb.size() == 0) {
								    	  historyb.add(0, "History is empty.");
								      }
								      else {
									   for (int i=0; i<historyb.size()-1; i++) {
										   listView.getItems().add(historyb.get(i));
									   }
								      }
					            	
					            }
					        });
					        
					        buttonsH.getChildren().add(btH1);
					        buttonsH.getChildren().add(btH2);
					        buttonsH.getChildren().add(btH3);
					        buttonsH.getChildren().add(btH4);
					        buttonsH.getChildren().add(btH5);
			    	      
			            }
			        });
		        Button bt110 = new Button();
		        bt110.setText(" BACK ");
		        bt110.setOnAction(e -> window.setScene(scene)); 

		        
		      //adding buttons
		        buttonsB.getChildren().add(bt1);
		        buttonsB.getChildren().add(bt2);
		        buttonsB.getChildren().add(bt3);
		        buttonsB.getChildren().add(bt4);
		        buttonsB.getChildren().add(bt5);
		        buttonsB.getChildren().add(bt6);
		        buttonsB.getChildren().add(bt7);
		        buttonsB.getChildren().add(bt8);
		        buttonsB.getChildren().add(bt9);
		        buttonsB.getChildren().add(bt110);
		        
		        
		        
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
	            	sc.writeToHistoryGUI(sc.operation);
	            	String result = sc.equals();
	            	textSOP.setText(sc.operation + " = " + result);
	            	sc.writeToHistoryGUI(result);
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
	            	sc.Operation("log ( ");
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
	        Button bt40 = new Button();
	        bt40.setText("  History  ");
	        bt40.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
		        	 // History
				    	  window2 = new Stage();
			    	      BorderPane root5= new BorderPane();
			    	      scene5 = new Scene(root5, 450, 700);
			    	      HBox buttonsH = new HBox();
			    	      window2.setTitle("Java Calculator - History");
			    	      window2.setScene(scene5);
			    	      window2.show();
			    	      root5.setBottom(buttonsH);
			    	      root5.setPadding(new Insets(70, 25, 30, 30));
			    	      GridPane gridH = new GridPane();
					      gridH.setVgap(3);
					      gridH.setAlignment(Pos.CENTER);
					       root5.setTop(gridH);
					      historyb = sc.readHistoryGUI();
					      position = 0;
					      
					      if (historyb.size() == 0) {
					    	  historyb.add(0, "History is empty.");
					      }
					      
					       
						   Text textH1 = new Text((String) historyb.get(0));
						   textH1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
						   
						   gridH.add(textH1, 0, 2);
						   ListView<String> listView = new ListView<String>();
						   gridH.add(listView, 0, 1);
						   for (int i=0; i<historyb.size()-1; i++) {
							   listView.getItems().add(historyb.get(i));
						   }
						   
					        Button btH1 = new Button();
					        btH1.setText("   <   ");
					        btH1.setOnAction(new EventHandler<ActionEvent>() {
					            @Override public void handle(ActionEvent e) {
					            	if (position==0) {
						            	textH1.setText((String) historyb.get(position));
					            }
					            	else {
					            		position-=1;
						            	textH1.setText((String) historyb.get(position));
					            	}
					            }
					        });
					        
					        Button btH2 = new Button();
					        btH2.setText("  Select  ");
					        btH2.setOnAction(new EventHandler<ActionEvent>() {
					            @Override public void handle(ActionEvent e) {
					            	String temp = textH1.getText();
					            	sc.operation=temp;
					            	textSOP.setText(temp);
					            	
					            }
					        });
					        Button btH3 = new Button();
					        btH3.setText("   >   ");
					        btH3.setOnAction(new EventHandler<ActionEvent>() {
					            @Override public void handle(ActionEvent e) {
					            	if (position>=historyb.size()-1) {
						            	textH1.setText((String) historyb.get(historyb.size()-1));
					            }
					            	else {
					            		position+=1;
						            	textH1.setText((String) historyb.get(position));
					            	}
					            }
					        });
					        Button btH4 = new Button();
					        btH4.setText("   Delete History   ");
					        btH4.setOnAction(new EventHandler<ActionEvent>() {
					            @Override public void handle(ActionEvent e) {
					            	sc.deleteHistory();
					            	textH1.setText("History is empty.");
					            	historyb = sc.readHistoryGUI();
					            	listView.getItems().clear();
									   for (int i=0; i<historyb.size()-1; i++) {
										   listView.getItems().add(historyb.get(i));
									   }
					            	
					            }
					        });
					        Button btH5 = new Button();
					        btH5.setText("   Update History   ");
					        btH5.setOnAction(new EventHandler<ActionEvent>() {
					            @Override public void handle(ActionEvent e) {
					            	historyb = sc.readHistoryGUI();
					            	listView.getItems().clear();
								      if (historyb.size() == 0) {
								    	  historyb.add(0, "History is empty.");
								      }
								      else {
									   for (int i=0; i<historyb.size()-1; i++) {
										   listView.getItems().add(historyb.get(i));
									   }
								      }
					            	
					            }
					        });
					        
					        buttonsH.getChildren().add(btH1);
					        buttonsH.getChildren().add(btH2);
					        buttonsH.getChildren().add(btH3);
					        buttonsH.getChildren().add(btH4);
					        buttonsH.getChildren().add(btH5);
			    	      
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
	        Button bt39 = new Button();
	        bt39.setText("  Backspace  ");
	        bt39.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	               if (sc.operation.length()>0) {
	            	   		sc.operation = sc.operation.substring(0, sc.operation.length() - 1);
	            		   }
	               textSOP.setText(sc.getOperation());
	            }
	        });
	        Button bt111 = new Button();
	        bt111.setText(" BACK ");
	        bt111.setOnAction(e -> window.setScene(scene)); 
	        
	        buttonsMODE.getChildren().add(bt38);
	        buttonsMODE.getChildren().add(bt39);
	        buttonsMODE.getChildren().add(bt40);
	        buttonsMODE.getChildren().add(bt111);
	        
	        //--SCENE 4-- (Matrix Calculator)
	          MatrixGUI m = new MatrixGUI();
		      BorderPane root4= new BorderPane();
	          scene4 = new Scene(root4, 800, 600);
	          HBox buttonsM = new HBox();
	          root4.setBottom(buttonsM);
	          root4.setPadding(new Insets(70, 25, 30, 30));
	          Text textM = new Text();
	          root4.setCenter(textM);
			  textM.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
			  Text textM1 = new Text();
			  root4.setLeft(textM1);
			textM1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
			Text textM2 = new Text();
			  root4.setRight(textM2);
			textM2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

	          	// Creating Buttons for GUI
	          	Button btM1 = new Button();
			        btM1.setText("   +   ");
			        btM1.setOnAction(new EventHandler<ActionEvent>() {
			            @Override public void handle(ActionEvent e) {
							m.setMatrix(textM1.getText());
							m.setMatrix2(textM2.getText());
							textM.setText(" + ");
							if (m.operation("+") == null){
								BorderPane root5 = new BorderPane();
								scene5 = new Scene(root5, 400, 400);
								Text textE = new Text();
			  					root5.setCenter(textE);
								textE.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
								textE.setText("Invalid Operation");
							} else {
								textM1.setText(m.operation("+"));
								textM2.setText("");
							}
			            }
					});
				Button btM2 = new Button();
			        btM2.setText("   -   ");
			        btM2.setOnAction(new EventHandler<ActionEvent>() {
			            @Override public void handle(ActionEvent e) {
			            	m.setMatrix(textM1.getText());
							m.setMatrix2(textM2.getText());
							textM.setText(" - ");
							if (m.operation("-") == null){
								BorderPane root5 = new BorderPane();
								scene5 = new Scene(root5, 400, 400);
								Text textE = new Text();
			  					root5.setCenter(textE);
								textE.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
								textE.setText("Invalid Operation");
							} else {
								textM1.setText(m.operation("-"));
								textM2.setText("");
							}
			            }
					});
				Button btM3 = new Button();
			        btM3.setText("   *   ");
			        btM3.setOnAction(new EventHandler<ActionEvent>() {
			            @Override public void handle(ActionEvent e) {
			            	m.setMatrix(textM1.getText());
							m.setMatrix2(textM2.getText());
							textM.setText(" * ");
							if (m.operation("*") == null){
								BorderPane root5 = new BorderPane();
								scene5 = new Scene(root5, 400, 400);
								Text textE = new Text();
			  					root5.setCenter(textE);
								textE.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
								textE.setText("Invalid Operation");
							} else {
								textM1.setText(m.operation("*"));
								textM2.setText("");
							}
			            }
					});
				Button btM4 = new Button();
			        btM4.setText("   T   ");
			        btM4.setOnAction(new EventHandler<ActionEvent>() {
			            @Override public void handle(ActionEvent e) {
			            	m.setMatrix(textM1.getText());
							textM.setText(" T ");
							textM2.setText(m.operation("T"));
			            }
					});
				Button btM5 = new Button();
			        btM5.setText("   RREF   ");
			        btM5.setOnAction(new EventHandler<ActionEvent>() {
			            @Override public void handle(ActionEvent e) {
			            	m.setMatrix(textM1.getText());
							textM.setText(" RREF ");
							textM2.setText(m.operation("RREF"));
			            }
					});
				Button btM6 = new Button();
			        btM6.setText("   Scalar Multiplication   ");
			        btM6.setOnAction(new EventHandler<ActionEvent>() {
			            @Override public void handle(ActionEvent e) {
			            	m.setMatrix(textM1.getText());
							m.setScalar(textM2.getText());
							textM.setText(" s ");
							textM1.setText(m.operation("s"));
							textM2.setText("");
			            }
					});
					Button btM7 = new Button();
			        btM7.setText("  Clr Matrix 1  ");
			        btM7.setOnAction(new EventHandler<ActionEvent>() {
			            @Override public void handle(ActionEvent e) {
							textM1.setText("");
			            }
					});
					Button btM8 = new Button();
			        btM8.setText("  Clr Matrix 2  ");
			        btM8.setOnAction(new EventHandler<ActionEvent>() {
			            @Override public void handle(ActionEvent e) {
							textM2.setText("");
			            }
					});
					Button btM9 = new Button();
			        btM9.setText("  Clr All  ");
			        btM9.setOnAction(new EventHandler<ActionEvent>() {
			            @Override public void handle(ActionEvent e) {
							textM2.setText("");
							textM1.setText("");
							textM.setText("");
			            }
					});
					Button btM10 = new Button();
			        btM10.setText("  History  ");
			        btM10.setOnAction(new EventHandler<ActionEvent>() {
			            @Override public void handle(ActionEvent e) {
			            	
			            }
					});
			        Button bt112 = new Button();
			        bt112.setText(" BACK ");
			        bt112.setOnAction(e -> window.setScene(scene)); 
				//Adding Buttons to GUI
				buttonsM.getChildren().add(btM1);
				buttonsM.getChildren().add(btM2);
				buttonsM.getChildren().add(btM3);
				buttonsM.getChildren().add(btM4);
				buttonsM.getChildren().add(btM5);
				buttonsM.getChildren().add(btM6);
				buttonsM.getChildren().add(btM7);
				buttonsM.getChildren().add(btM8);
				buttonsM.getChildren().add(btM9);
				buttonsM.getChildren().add(btM10);
				buttonsM.getChildren().add(bt112);
				
				//Inserting Matrix Values
				HBox textM11 = new HBox();
					GridPane gridM = new GridPane();
			        gridM.setVgap(3);
			        gridM.setAlignment(Pos.CENTER);
			        root4.setTop(gridM);
				   TextField textMatrix = new TextField("Insert ALL numbers for matrix 1 (Comma + Space Separated) and press ENTER");
				   TextField textMatrix2 = new TextField("Insert ALL numbers for matrix 2 (Comma + Space Separated) and press ENTER");
				   TextField textRows = new TextField("Insert number of columns in matrix and press ENTER");
				   TextField textColoums = new TextField("Insert number of rows in matrix and press ENTER");
				   gridM.add(textRows, 0, 0);
				   gridM.add(textColoums, 0, 1);
				   gridM.add(textMatrix, 0, 2);
				   gridM.add(textMatrix2, 0, 3);
				   ColumnConstraints col1 = new ColumnConstraints();
			       col1.setPercentWidth(100);
			       gridM.getColumnConstraints().addAll(col1);
			        textMatrix.setOnAction(new EventHandler<ActionEvent>() {
			            @Override public void handle(ActionEvent e) {
			            	String temp = textMatrix.getText();
								textM1.setText(m.createMatrix(temp));
								}
					}); 
			        textMatrix2.setOnAction(new EventHandler<ActionEvent>() {
			            @Override public void handle(ActionEvent e) {
			            	String temp1 = textMatrix2.getText();
								textM2.setText(m.createMatrix(temp1));
								}
					}); 
					textRows.setOnAction(new EventHandler<ActionEvent>() {
			            @Override public void handle(ActionEvent e) {
			            	String temp = textRows.getText();
							m.matrixRows(temp);
							String temp1 = textRows.getText();
							m.matrixRows(temp1);
			            }
					}); 
					textColoums.setOnAction(new EventHandler<ActionEvent>() {
			            @Override public void handle(ActionEvent e) {
			            	String temp = textColoums.getText();
							m.matrixColoums(temp);
							String temp1 = textColoums.getText();
							m.matrixColoums(temp1);
			            }
					}); 
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

	  