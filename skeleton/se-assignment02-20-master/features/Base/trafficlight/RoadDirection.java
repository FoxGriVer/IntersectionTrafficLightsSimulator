package trafficlight;

/**
 * TODO description
 */
abstract class RoadDirection {
	protected Road roadDirection;
	protected TrafficLightColor trafficLightColor;
	protected int steps;
	protected int numberOfQueuedObjects;
	protected String fullRoadState;
	protected TrafficLightColor previousTrafficLightColor;

	public int getSteps() {
		return this.steps;
	}
	
	public void setSteps(int steps) {
		this.steps = steps;
	}
	
	public int getNumberOfQueuedObjects() {
		return this.numberOfQueuedObjects;
	}
	
	public void setNumberOfQueuedObjects(int numberOfQueuedObjects) {
		this.numberOfQueuedObjects = numberOfQueuedObjects;
	}
	
	public void decreaseNumberInQueueByOne() {
		if (this.numberOfQueuedObjects >= 1) {
			--this.numberOfQueuedObjects;
		}
	}
	
	public void increaseNumberInQueueByOne() {
		++this.numberOfQueuedObjects;
	}
	
	public TrafficLightColor getTrafficLightColor() {
		return this.trafficLightColor;
	}
	
	public void setTrafficLightColor(TrafficLightColor trafficLightColor) {
		this.trafficLightColor = trafficLightColor;
	}
	
	public TrafficLightColor getPreviousTrafficLightColor() {
		return this.previousTrafficLightColor;
	}
	
	public void setPreviousTrafficLightColor(TrafficLightColor trafficLightColor) {
		this.previousTrafficLightColor = trafficLightColor;
	}
	
	public Road getRoadDirection() {
		return this.roadDirection;
	}
	
	public void setRoadDirection(Road roadDirection) {
		this.roadDirection = roadDirection;
	}
	
	public RoadDirection() {
		this.steps = 0;
		this.roadDirection = Road.NONE;
		this.fullRoadState = "";
	}
	
	public void rememberCurrentTrafficLightColor() {
		this.previousTrafficLightColor = this.trafficLightColor;
	}
}