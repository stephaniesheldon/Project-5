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
	
	//Prompt Text fields
	Text enterHamDist;
	TextField compareW;
	TextField d0;
	TextField d1;
	TextField d2;
	TextField d3;
	TextField d4;
	
	
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
			

			//initialize prompt textFields
			enterHamDist = new Text("Enter Hamming Distance");
			
			grid.add(enterHamDist,0,0);
			
			
			
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
