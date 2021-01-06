package trafficlight;

/**
 * This enum models the directions of the roads.
 * 
 * The base feature has no roads. Subfeatures define their respective direction.
 */
public enum Road {
	NONE;
	
	// Checks whether the enumeration contains the entered road direction.
	public static boolean contains(String inputString) {
		Road[] roads = Road.values();
		for (Road road : roads) {
			if (road.name().equalsIgnoreCase(inputString))
				return true;
		}			
		return false;
	}
}