package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import trafficlight.Road;
import trafficlight.RoadBehavior;
import trafficlight.Strategy;

/**
 * TODO description
 */
public class StrategyTests {
	Strategy testStrategy;

	@Test
	void testNotEmptyRoadsArray() {
		testStrategy = new Strategy();
		
		Assertions.assertNotEquals(0, this.testStrategy.getRoads().size());
	}
	
	@Test
	void testEnqueueAutoRoad() {
		testStrategy = new Strategy();
		testStrategy.enqueueVehicle(Road.LEFT);
		
		for (RoadBehavior road : testStrategy.getRoads()) {
	        if (road.getRoadDirection().equals(Road.LEFT)) {
	    		Assertions.assertEquals(1, road.getNumberOfQueuedObjects());
	    		return;
	        }
	    }
		
		Assertions.fail();
	}
}