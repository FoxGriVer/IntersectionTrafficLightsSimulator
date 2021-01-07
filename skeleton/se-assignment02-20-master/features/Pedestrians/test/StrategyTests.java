package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import trafficlight.PedestrianRoadBehavior;
import trafficlight.RoadBehavior;
import trafficlight.Road;
import trafficlight.Strategy;
import trafficlight.TrafficLightColor;

/**
 * TODO description
 */
public class StrategyTests {
	Strategy testStrategy;

	@Test
	void testEnqueuePedestrianRoad() {
		testStrategy = new Strategy();
		RoadBehavior testRoad = new RoadBehavior(Road.LEFT);
		PedestrianRoadBehavior testPedestrianRoad = new PedestrianRoadBehavior(testRoad);
		Assertions.assertEquals(0, testPedestrianRoad.getNumberOfQueuedObjects());

		testPedestrianRoad.increaseNumberInQueueByOne();		
		Assertions.assertEquals(1, testPedestrianRoad.getNumberOfQueuedObjects());
	}
	
	@Test
	void testConstructorPedestrianRoad() {
		testStrategy = new Strategy();
		RoadBehavior testRoad = new RoadBehavior(Road.LEFT);
		PedestrianRoadBehavior testPedestrianRoad = new PedestrianRoadBehavior(testRoad);

		Assertions.assertEquals(TrafficLightColor.RED, testPedestrianRoad.getTrafficLightColor());
	}
}