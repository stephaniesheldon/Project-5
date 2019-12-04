package application;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

public class StationListTest {

	@Test
	public void test() {
		StationList stationList = new StationList();
		
		ArrayList<String> list = stationList.getStationList();
		String actual = list.get(5);
		String expected = "APAC";
		assertEquals(actual,expected);
		
		
		HashSet<String> set = stationList.getStationSet();
		Boolean actl = set.contains("WATO");
		Boolean exptd = true;
		assertEquals(actual,expected);
	}
	
	@Test
	public void sameHDTest(){
		StationList sl = new StationList();
		int hd = 2;
		String station1 = "HAWK";
		String station2 = "HEWT";
		
		Boolean expected = true;
		Boolean actual = sl.sameHD(hd,station1,station2);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void HDStationListTest(){
		// TALA TALI
		StationList sl = new StationList();
		ArrayList<String> expected = new ArrayList<>();
		expected.add("TALI");
		ArrayList<String> actual;
		actual = sl.HDStationList(1,"TALA");
		
		assertEquals(expected,actual);
	}

}
