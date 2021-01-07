package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import trafficlight.Main;
import trafficlight.Road;

/**
 * TODO description
 */
public class MainTests {
	@Test
	void testParseRoadRight() {		
		Assertions.assertEquals(Road.RIGHT, new Main().parseRoad("right"));
	}
}