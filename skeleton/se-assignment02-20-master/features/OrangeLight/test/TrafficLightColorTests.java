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
		Assertions.assertEquals("ORANGE", TrafficLightColor.ORANGE.name());
	}
}