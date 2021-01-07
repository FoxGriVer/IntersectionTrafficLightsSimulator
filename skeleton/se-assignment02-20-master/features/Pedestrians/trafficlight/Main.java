package trafficlight;


public class Main {
	
	private static final String PEDESTRIAN = "pedestrian";

	/*
	 * Handle input commands.
	 * 
	 * Additional commands:
	 * - pedestrian $road -> enqueue pedestrian on road
	 */
	private void handleInput(String input, Intersection intersection) {
		if (input.startsWith(PEDESTRIAN)) {
			String roadDirection = input.substring(PEDESTRIAN.length()).trim();

			if (Road.contains(roadDirection)) {
				Road road = parseRoad(roadDirection);
				intersection.enqueuePedestrian(road);
			} else {
				System.out.println("The wrong pedestrian crossing name. Try again enter the correct pedestrian crossing name or another command.");
				continuousInput(intersection);
			}
			
			return;
		}
		original(input, intersection);
	}
}