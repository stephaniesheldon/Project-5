package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class StationList {
	private ArrayList<String> stationList;
	private HashSet<String> stationSet;
	private ArrayList<String> setToList;


	public StationList(){
		try {
			read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void read() throws IOException
	{
		stationList = new ArrayList<String>();
		stationSet = new HashSet<String>();
		setToList = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		String stationName = br.readLine();

		while(stationName != null){
			stationName = stationName.trim();
			stationList.add(stationName);
			stationName = br.readLine();
		}
		br.close();
		
		stationSet.addAll(stationList);
		setToList.addAll(stationSet);
		Collections.sort(setToList);
		
	}
	
	
	//Returns the list of stations that have the specified hamming distance to the station
	public ArrayList<String> HDStationList(int hd, String id){
		ArrayList<String> hdList = new ArrayList<String>();
		
		for(String station: setToList)
			if(sameHD(hd, station, id))
				hdList.add(station);
			
		return hdList;
	}
	
	//checks if the hamming distance between the two stations is the same as what's specified
	public Boolean sameHD(int hd, String station, String userStation){
		int trueHD = 0;
		char letter1;
		char letter2;
		for(int i = 0; i<4; ++i){
			letter1 = station.charAt(i);
			letter2 = userStation.charAt(i);
			if(letter1 != letter2){
				++trueHD;
			}
		}
		if(hd==trueHD){
			return true;
		}
		else{
			return false;
		}
	}
	
	//returns hashmap of number of stations at each hamming distance
	public HashMap<Integer,Integer> checkNumberDistances(String id){
		HashMap<Integer,Integer> distances = new HashMap<Integer,Integer>();
		distances.put(0,NumOfStations(0,id));
		distances.put(1,NumOfStations(1,id));
		distances.put(2,NumOfStations(2,id));
		distances.put(3,NumOfStations(3,id));
		distances.put(4,NumOfStations(4,id));
		
		return distances;
		
	}
	
	//returns the total number of stations with the hamming distance
	public int NumOfStations(int distance, String id){
		int numStations = 0;
		for(String s: stationList)
			if(sameHD(distance,id,s))
				++numStations;
		return numStations;
	}
	
	
	public ArrayList<String> getStationList(){
		return stationList;
	}
	
	public HashSet<String> getStationSet(){
		return stationSet;
	}
	
	public ArrayList<String> getSetToList(){
		return setToList;
	}


	public void addStation(String newStation) {
		
		stationSet.add(newStation);
		setToList.clear();
		setToList.addAll(stationSet);
		Collections.sort(setToList);
		
	}
	

	
}
