import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
		            	textOP.setText("= " + result);
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
		            	bc.temp = text.getText();
		            	bc.addNumberToOp();
		            	text.setText("");
		            	textOP.setText(bc.getOperation());
		            }
		        }); 
		        
		        
		        
	      
	    //--SCENE 3-- (Scientific Calculator)
	      BorderPane root3= new BorderPane();
	      scene3 = new Scene(root3, 400, 400);
	      
	    //--SCENE 4-- (Matrix Calculator)
	      BorderPane root4= new BorderPane();
	      scene4 = new Scene(root4, 400, 400);

	   }
}

	  