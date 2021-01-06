package trafficlight;

/**
 * TODO description
 */
public class IntersectionTrafficLights extends Intersection {
	
	private Strategy strategy;
		
	public IntersectionTrafficLights() {
		strategy = new Strategy();	
	}
	
	public void enqueueVehicle(Road roadDirection) {	
		this.strategy.enqueueVehicle(roadDirection);
	}
	
	public void advanceTime() {
		this.strategy.advanceTime();
	}

	public String getIntersectionState() {
		String fullIntersectionState = this.strategy.getIntersectionState();
		
		return fullIntersectionState;
	}
	
}