package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import trafficlight.Main;
import trafficlight.Road;
import org.junit.jupiter.api.function.Executable;

/**
 * TODO description
 */
public class MainTests {

	@Test
	void shouldThrowsExceptionNoRoad() {
		Throwable testException = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
		
			@Override
			public void execute() throws Throwable {
				new Main().parseRoad("wrongRoad");
			}
		});
		Assertions.assertEquals(testException.getMessage(), "Cannot parse road: wrongRoad");
	}
}