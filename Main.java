package application;
	
import java.util.ArrayList;
import java.util.HashMap;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
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
	//Stations
	StationList stations;
	
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
	
	//Slider
	Slider slider;
	
	//Drop down
	ComboBox dropDown;

	public void start(Stage primaryStage) {
		stations = new StationList();
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
			grid.setHalignment(calcHD,HPos.CENTER);
			addStation = new Button("Add Station");
			grid.setHalignment(addStation,HPos.CENTER);
			

			//initialize prompt texts
			enterHamDist = new Text("Enter Hamming Distance");
			compareW = new Text("Compare with:    ");
			d0 = new Text("Distance 0");
			grid.setHalignment(d0,HPos.CENTER);
			d1 = new Text("Distance 1");
			grid.setHalignment(d1,HPos.CENTER);
			d2 = new Text("Distance 2");
			grid.setHalignment(d2,HPos.CENTER);
			d3 = new Text("Distance 3");
			grid.setHalignment(d3,HPos.CENTER);
			d4 = new Text("Distance 4");
			grid.setHalignment(d4,HPos.CENTER);
			
			
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
			
			answerD4 = new TextField();
			answerD4.setEditable(false);
			answerD4.setBackground(bg);
			answerD4.setBorder(border);
			
			userStation = new TextField();
			userStation.setEditable(true);
			
			
			
			//initialize Text area
			showStationArea = new TextArea();
			showStationArea.setPrefColumnCount(2);
			
			
			//initialize slider
			slider = new Slider(1,4,1);
			slider.setShowTickMarks(true);
			slider.setShowTickLabels(true);
			slider.setMajorTickUnit(1);
			slider.setMinorTickCount(0);
			slider.setSnapToTicks(true);
			
			
			//initialize comboBox
			dropDown = new ComboBox(FXCollections 
                    .observableArrayList(stations.getSetToList()).sorted());
			dropDown.getSelectionModel().select(0);
			
			
			//place in grid
			grid.add(enterHamDist,0,1);
			grid.add(userHam,1,1);
			grid.add(slider,0,2,2,1);
			grid.add(showStation,0,3);
			grid.add(showStationArea,0,4,2,1);
			grid.add(compareW,0,6);
			grid.add(dropDown,1,6);
			grid.add(calcHD,0,7);
			grid.add(d0,0,8);
			grid.add(answerD0,1,8);
			grid.add(d1,0,9);
			grid.add(answerD1,1,9);
			grid.add(d2,0,10);
			grid.add(answerD2,1,10);
			grid.add(d3,0,11);
			grid.add(answerD3,1,11);
			grid.add(d4,0,12);
			grid.add(answerD4,1,12);
			grid.add(addStation,0,13);
			grid.add(userStation,1,13);
		
			
			Scene scene = new Scene(grid,600,650);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			//button action events
			showStation.setOnAction(new EventHandler<ActionEvent>() {
			    @Override public void handle(ActionEvent e) {
			       showStationsPress();
			    }
			});
			calcHD.setOnAction(new EventHandler<ActionEvent>() {
			    @Override public void handle(ActionEvent e) {
			       calcHDPress();
			    }
			});
			addStation.setOnAction(new EventHandler<ActionEvent>() {
			    @Override public void handle(ActionEvent e) {
			       addStationPress();
			    }
			});
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Updates text area
	public void showStationsPress(){
		int sliderVal = (int) slider.getValue();
		Object chosenStation = dropDown.getValue();
		String chosenStationString = chosenStation.toString();
		ArrayList<String> stationsSame = stations.HDStationList(sliderVal,chosenStationString);
		String stationListString = "";
		for(String s: stationsSame){
			stationListString += s + "\n";
		}
		showStationArea.setText(stationListString);
	}
	
	//calculates hamming distances
	public void calcHDPress(){
		Object chosenStation = dropDown.getValue();
		String chosenStationString = chosenStation.toString();
		
		HashMap<Integer,Integer> answers = 
				stations.checkNumberDistances(chosenStationString);
		
		answerD0.setText(Integer.toString(answers.get(0)));
		answerD1.setText(Integer.toString(answers.get(1)));
		answerD2.setText(Integer.toString(answers.get(2)));
		answerD3.setText(Integer.toString(answers.get(3)));
		answerD4.setText(Integer.toString(answers.get(4)));
	}
	
	public void addStationPress(){
		userStation.setText("works");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
