package trafficlight;


public class Main {
	
	private static final String RIGHT = "right";
	
	public Road parseRoad(String roadString) {
		if (roadString.equals(RIGHT)) {
			return Road.RIGHT;
		}
		return original(roadString);
	}
}