package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
		
		//Collections.sort(stationList);
		stationSet.addAll(stationList);
		setToList.addAll(stationSet);
		
	}
	
	
	public ArrayList<String> HDStationList(int hd, String id){
		ArrayList<String> hdList = new ArrayList<String>();
		
		for(String station: stationList)
			if(sameHD(hd, station, id))
				hdList.add(station);
			
		return hdList;
	}
	
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
	
	
	public ArrayList<String> getStationList(){
		return stationList;
	}
	
	public HashSet<String> getStationSet(){
		return stationSet;
	}
	
	public ArrayList<String> getSetToList(){
		return setToList;
	}
	

	
}
