package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import trafficlight.Road;
import trafficlight.RoadBehavior;
import trafficlight.TrafficLightColor;

/**
 * TODO description
 */
public class RoadDirectionTests {
	RoadBehavior testRoadBehavior;
	
	@Test
	void testGetAndSetStepsProps() {
		testRoadBehavior = new RoadBehavior(Road.LEFT);
		this.testRoadBehavior.setSteps(5);
		
		Assertions.assertEquals(5, this.testRoadBehavior.getSteps());
	}
	
	@Test
	void testGetAndSetNumberOfQueuedObjectsProps() {
		testRoadBehavior = new RoadBehavior(Road.LEFT);
		this.testRoadBehavior.setNumberOfQueuedObjects(5);
		
		Assertions.assertEquals(5, this.testRoadBehavior.getNumberOfQueuedObjects());
	}
	
	@Test
	void testGetAndSetPreviousTrafficLightColorProps() {
		testRoadBehavior = new RoadBehavior(Road.LEFT);
		this.testRoadBehavior.rememberCurrentTrafficLightColor();
		this.testRoadBehavior.setPreviousTrafficLightColor(TrafficLightColor.RED);
		
		Assertions.assertEquals(TrafficLightColor.RED, this.testRoadBehavior.getPreviousTrafficLightColor());
	}
	
	@Test
	void testGetAndSetTrafficLightColorProps() {
		testRoadBehavior = new RoadBehavior(Road.LEFT);
		this.testRoadBehavior.setTrafficLightColor(TrafficLightColor.RED);
		
		Assertions.assertEquals(TrafficLightColor.RED, this.testRoadBehavior.getTrafficLightColor());
	}
	
	@Test
	void testDecreaseNumberInQueueByOne() {
		testRoadBehavior = new RoadBehavior(Road.LEFT);
		this.testRoadBehavior.setNumberOfQueuedObjects(5);
		this.testRoadBehavior.decreaseNumberInQueueByOne();
		
		Assertions.assertEquals(4, this.testRoadBehavior.getNumberOfQueuedObjects());
	}
	
	@Test
	void testIncreaseNumberInQueueByOne() {
		testRoadBehavior = new RoadBehavior(Road.LEFT);
		this.testRoadBehavior.setNumberOfQueuedObjects(5);
		this.testRoadBehavior.increaseNumberInQueueByOne();
		
		Assertions.assertEquals(6, this.testRoadBehavior.getNumberOfQueuedObjects());
	}
	
	@Test
	void testGreenLightAfterInitForLeftAndRight() {
		testRoadBehavior = new RoadBehavior(Road.LEFT);
		
		Assertions.assertEquals(TrafficLightColor.GREEN, this.testRoadBehavior.getTrafficLightColor());
	}
	
	@Test
	void testGreenLightAfterInitForNotLeftAndRight() {
		testRoadBehavior = new RoadBehavior(Road.NONE);
		
		Assertions.assertNotEquals(TrafficLightColor.GREEN, this.testRoadBehavior.getTrafficLightColor());
	}
	
	@Test
	void testRememberCurrentTrafficLightColor() {
		testRoadBehavior = new RoadBehavior(Road.LEFT);
		this.testRoadBehavior.rememberCurrentTrafficLightColor();
		this.testRoadBehavior.setTrafficLightColor(TrafficLightColor.RED);
		
		Assertions.assertEquals(TrafficLightColor.GREEN, this.testRoadBehavior.getPreviousTrafficLightColor());
	}
}