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
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		String stationName = br.readLine();

		while(stationName != null){
			stationName = stationName.trim();
			stationList.add(stationName);
			stationName = br.readLine();
		}
		br.close();
		
		Collections.sort(stationList);
		stationSet.addAll(stationList);
	}
	
	
	public ArrayList<String> getStationList(){
		return stationList;
	}
	
	public HashSet<String> getStationSet(){
		return stationSet;
	}

	
}
