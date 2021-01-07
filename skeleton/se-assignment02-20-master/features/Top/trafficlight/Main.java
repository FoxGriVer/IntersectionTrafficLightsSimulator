package trafficlight;


public class Main {
	
	private static final String TOP = "top";
	
	public Road parseRoad(String roadString) {
		if (roadString.equals(TOP)) {
			return Road.TOP;
		}
		return original(roadString);
	}
}