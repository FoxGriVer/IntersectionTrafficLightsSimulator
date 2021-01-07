package trafficlight;


public class Main {
	
	private static final String LEFT = "left";
	
	public Road parseRoad(String roadString) {
		if (roadString.equals(LEFT)) {
			return Road.LEFT;
		}
		return original(roadString);
	}
}