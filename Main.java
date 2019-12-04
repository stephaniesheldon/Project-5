package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


public class Main extends Application {
	
	//Buttons
	Button showStation;
	Button calcHD;
	Button addStation;
	
	//Prompt Texts
	Text enterHamDist;
	Text compareW;
	Text d0;
	Text d1;
	Text d2;
	Text d3;
	Text d4;
	
	//Text Fields
	//not editable
	TextField userHam;
	TextField answerD0;
	TextField answerD1;
	TextField answerD2;
	TextField answerD3;
	TextField answerD4;
	//editable
	TextField userStation;
	
	
	//Text Area
	TextArea showStationArea;

	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Hamming Distance");
			
			
			
			//create grid pane
			GridPane grid = new GridPane();
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(0,10,0,10));
			
			
			
			//initialize buttons
			showStation = new Button("Show Station");
			calcHD = new Button("Calculate HD");
			addStation = new Button("Add Station");
			

			//initialize prompt texts
			enterHamDist = new Text("Enter Hamming Distance");
			compareW = new Text("Compare with:    ");
			d0 = new Text("Distance 0");
			d1 = new Text("Distance 1");
			d2 = new Text("Distance 2");
			d3 = new Text("Distance 3");
			d4 = new Text("Distance 4");
			
			
			//initialize TextFields
			userHam = new TextField();
			userHam.setEditable(false);
			answerD0 = new TextField();
			answerD0.setEditable(false);
			answerD1 = new TextField();
			answerD1.setEditable(false);
			answerD2 = new TextField();
			answerD2.setEditable(false);
			answerD3 = new TextField();
			answerD3.setEditable(false);
			answerD4 = new TextField();
			answerD4.setEditable(false);
			
			grid.add(userHam,2,5);
			
			
			
			Scene scene = new Scene(grid,400,800);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
