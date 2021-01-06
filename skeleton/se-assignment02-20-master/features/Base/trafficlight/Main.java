package trafficlight;

import java.lang.IllegalArgumentException;
import java.util.Scanner;


/**
 * The main class for the project.
 * 
 * The main function simply calls {@code Main#simulate().}
 */
public class Main {
	
	private static final String STEP = "step";
	private static final String STATE = "state";
	private static final String VEHICLE = "vehicle";
	
	/*
	 * Run simulation on intersection.
	 * 
	 * Read commands from stdin and print intersection state after each command.
	 */
	private void simulate() {
		Intersection intersection = Intersection.createIntersection();

		continuousInput(intersection);
	}
	
	private void continuousInput(Intersection intersection) {
		Scanner scanner = new Scanner(System.in);
		try {
		    while (scanner.hasNextLine()) {
			    handleInput(scanner.nextLine(), intersection);
		    }
		} finally {
			scanner.close();
		}
	}
	
	/*
	 * Handle input commands.
	 * 
	 * Commands:
	 * - step             -> advance simulation by one step
	 * - state            -> print the current intersection state
	 * - vehicle $road    -> enqueue vehicle on road
	 * 
	 * Note that the feature Pedestrian adds another command.
	 */
	private void handleInput(String input, Intersection intersection) {
		if (input.startsWith(VEHICLE)) {	
			String roadDirection = input.substring(VEHICLE.length()).trim();

			if (Road.contains(roadDirection)) {
				Road road = parseRoad(roadDirection);
				intersection.enqueueVehicle(road);
			} else {
				System.out.println("The wrong road name. Try again enter the correct road name or another command.");
				continuousInput(intersection);
			}
			
			return;
		}
		if (input.equals(STEP)) {
			intersection.advanceTime();

			return;
		}
		if (input.equals(STATE)) {
		    System.out.println(intersection.getIntersectionState());
			return;
		}
		
		System.out.println("Unknown command. Try again.");
		continuousInput(intersection);
	}
	
	private Road parseRoad(String roadString) {
		throw new IllegalArgumentException("Cannot parse road: " + roadString);
	}
	
	public static void main(String[] args) {
		new Main().simulate();
	}
}