package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import trafficlight.Road;

/**
 * TODO description
 */
public class RoadTests {
	
	@Test
	void testEnumHasLeftValue() {
		Assertions.assertEquals("LEFT", Road.LEFT.name());
	}
}