package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
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
			
			
			//transparent background
			BackgroundFill fill = new BackgroundFill(Color.TRANSPARENT,CornerRadii.EMPTY, Insets.EMPTY);
			Background bg = new Background(fill);
			
			//blue border
			BorderStroke borderStroke = new BorderStroke(Color.BLUE, 
					BorderStrokeStyle.SOLID,CornerRadii.EMPTY, new BorderWidths(1));
			Border border = new Border(borderStroke);
			
			
			//initialize TextFields
			userHam = new TextField();
			userHam.setEditable(false);
			userHam.setBackground(bg);
			userHam.setBorder(border);
			
			answerD0 = new TextField();
			answerD0.setEditable(false);
			answerD0.setBackground(bg);
			answerD0.setBorder(border);
			
			answerD1 = new TextField();
			answerD1.setEditable(false);
			answerD1.setBackground(bg);
			answerD1.setBorder(border);
			
			answerD2 = new TextField();
			answerD2.setEditable(false);
			answerD2.setBackground(bg);
			answerD2.setBorder(border);
			
			answerD3 = new TextField();
			answerD3.setEditable(false);
			answerD3.setBackground(bg);
			answerD3.setBorder(border);
			
			answerD4 = new TextField("This is The Text");
			answerD4.setEditable(false);
			answerD4.setBackground(bg);
			answerD4.setBorder(border);
			
			userStation = new TextField();
			userStation.setEditable(true);
			userStation.setBackground(bg);
			userStation.setBorder(border);
			
			
			//initialize Text area
			showStationArea = new TextArea();
			showStationArea.setPrefColumnCount(2);
			
		
			grid.add(answerD4,0,0);
			grid.add(userStation,1,0);
			grid.add(showStationArea,0,1,2,1);
			
			
			Scene scene = new Scene(grid,600,800);
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
