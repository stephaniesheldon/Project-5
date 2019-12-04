package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	
	//Buttons
	Button showStation;
	Button calcHD;
	Button addStation;

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
			
			
			grid.add(calcHD,0,0);
			grid.add(addStation,1,1,2,2);
			
			Scene scene = new Scene(grid,400,800);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			/*
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			*/
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
