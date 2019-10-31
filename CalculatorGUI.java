import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	      BorderPane root2 = new BorderPane();
	      scene2 = new Scene(root2, 400, 400);
	      
	    //--SCENE 3-- (Scientific Calculator)
	      BorderPane root3= new BorderPane();
	      scene3 = new Scene(root3, 400, 400);
	      
	    //--SCENE 4-- (Matrix Calculator)
	      BorderPane root4= new BorderPane();
	      scene4 = new Scene(root4, 400, 400);

	   }
}
