package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	//Buttons
	Button showStation;
	Button calcHD;
	Button addStation;

	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Hamming Distance");
			
			//initialize buttons
			showStation = new Button("Show Station");
			calcHD = new Button("Calculate HD");
			addStation = new Button("Add Station");
			
			
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
