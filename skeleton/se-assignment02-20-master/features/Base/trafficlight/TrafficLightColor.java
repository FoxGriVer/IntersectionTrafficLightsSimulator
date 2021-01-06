package trafficlight;

/**
 * TODO description
 */
public enum TrafficLightColor {
	RED,
	GREEN;
	
	// Checks whether the enumeration contains the entered road direction.
	public static boolean contains(String inputString) {
		TrafficLightColor[] trafficLightColors = TrafficLightColor.values();
		for (TrafficLightColor trafficLightColor : trafficLightColors) {
			if (trafficLightColor.name().equalsIgnoreCase(inputString))
				return true;
		}			
		return false;
	}
}