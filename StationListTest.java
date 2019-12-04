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

}
