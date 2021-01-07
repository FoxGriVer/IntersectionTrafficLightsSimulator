package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import trafficlight.PedestrianRoadBehavior;
import trafficlight.Road;
import trafficlight.RoadBehavior;
import trafficlight.TrafficLightColor;

/**
 * TODO description
 */
public class PedestrianRoadBehaviorTests {
	@Test
	void testEnqueuePedestrianRoad() {
		RoadBehavior testRoad = new RoadBehavior(Road.LEFT);
		PedestrianRoadBehavior testPedestrianRoad = new PedestrianRoadBehavior(testRoad);
		Assertions.assertEquals(0, testPedestrianRoad.getNumberOfQueuedObjects());

		testPedestrianRoad.increaseNumberInQueueByOne();		
		Assertions.assertEquals(1, testPedestrianRoad.getNumberOfQueuedObjects());
	}
	
	@Test
	void testConstructorPedestrianRoad() {
		RoadBehavior testRoad = new RoadBehavior(Road.LEFT);
		PedestrianRoadBehavior testPedestrianRoad = new PedestrianRoadBehavior(testRoad);

		Assertions.assertEquals(TrafficLightColor.RED, testPedestrianRoad.getTrafficLightColor());
	}
}