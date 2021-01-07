package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import trafficlight.TrafficLightColor;

/**
 * TODO description
 */
public class TrafficLightColorTests {
	@Test
	void testEnumHasGreenValue() {
		Assertions.assertEquals("GREEN", TrafficLightColor.GREEN.name());
	}
	
	@Test
	void testEnumHasRedValue() {
		Assertions.assertEquals("RED", TrafficLightColor.RED.name());
	}
	
	@Test
	void testMethodContains() {		
		Assertions.assertTrue(TrafficLightColor.contains("RED"));
	}
}