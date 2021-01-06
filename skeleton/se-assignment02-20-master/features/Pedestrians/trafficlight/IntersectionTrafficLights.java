package trafficlight;

/**
 * TODO description
 */
public class IntersectionTrafficLights extends Intersection {
	
	public void enqueuePedestrian(Road roadDirection) {
		this.strategy.enqueuePedestrian(roadDirection);
	}
	
	public void advanceTime() {
		original();
	}
}