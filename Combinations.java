package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Combinations {
	
	public static ArrayList<String> findCombinations(String station){

		ArrayList<String> combinations = new ArrayList<String>();
		String stationString = "";
		
		int i;
		int j;
		int k;
		int l;
		
		for(i = 0; i<4; ++i){
			for(j = 0; j<4; ++j){
				if(i!=j){
					for(k = 0; k<4; ++k){
						if(i!=k && j!=k){
							for(l = 0; l<4; ++l){
								if(i!=l && j!=l && k!=l){
									
									stationString = Character.toString(station.charAt(i))
											+ Character.toString(station.charAt(j))
											+ Character.toString(station.charAt(k))
											+ Character.toString(station.charAt(l));
									combinations.add(stationString);
									
								}
							}
						}
					}
				}
			}
		}
		HashSet<String> eraseDuplicates = new HashSet<String>();
		eraseDuplicates.addAll(combinations);
		combinations.clear();
		combinations.addAll(eraseDuplicates);
		Collections.sort(combinations);

		return combinations;
	}

}
