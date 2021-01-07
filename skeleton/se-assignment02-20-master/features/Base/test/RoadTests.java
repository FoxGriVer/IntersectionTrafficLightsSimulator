package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import trafficlight.Road;

/**
 * TODO description
 */
public class RoadTests {

	@Test
	void testEnumHasNoneValue() {
		Assertions.assertEquals("NONE", Road.NONE.name());
	}
	
	@Test
	void testMethodContains() {		
		Assertions.assertTrue(Road.contains("NONE"));
	}
	
}