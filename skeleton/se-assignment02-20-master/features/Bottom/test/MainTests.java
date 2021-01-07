package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import trafficlight.Road;
import trafficlight.Main;

/**
 * TODO description
 */
public class MainTests {
	
	@Test
	void testParseRoadBottom() {		
		Assertions.assertEquals(Road.BOTTOM, new Main().parseRoad("bottom"));
	}
}