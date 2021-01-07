package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import trafficlight.Strategy;

/**
 * TODO description
 */
public class IntersectionTrafficLightsTests {
	
	@Test
	void gettingIntersectionStateNotEmpty() {
		Strategy strategy = new Strategy();
		
		Assertions.assertNotEquals("", strategy.getIntersectionState());
	}
}