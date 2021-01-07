package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import trafficlight.RoadBehavior;
import trafficlight.Road;

/**
 * TODO description
 */
public class RoadBehaviorTests {
	RoadBehavior testRoadBehavior;
	
	@Test
	void testFullRoadStateNotEmptyLine() {
		testRoadBehavior = new RoadBehavior(Road.LEFT);
		
		Assertions.assertNotEquals("", this.testRoadBehavior.getFullRoadState());
	}
}