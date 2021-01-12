package trafficlight;

/**
 * TODO description
 */
public enum StrategyType {
	None;

	// Checks whether the enumeration contains the entered strategy type.
	public static boolean contains(String inputString) {
		StrategyType[] strategyTypes = StrategyType.values();
		for (StrategyType strategyType : strategyTypes) {
			if (strategyType.name().equalsIgnoreCase(inputString))
				return true;
		}			
		return false;
	}
	
	// Get strategy type.
	public static StrategyType getStrategyType() {
		StrategyType[] strategyTypes = StrategyType.values();
		for (StrategyType strategyType : strategyTypes) {
			if (strategyType.name() != "None")
				return strategyType;
		}			
		return null;
	}
}