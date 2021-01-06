package trafficlight;

/**
 * TODO description
 */
public class RoadBehavior extends RoadDirection {
	
	private PedestrianRoadBehavior pedestranRoad;
	
	public PedestrianRoadBehavior getPedestrianRoad() {
		return this.pedestranRoad;
	}

	public RoadBehavior(Road roadDirectionName) {
		this.pedestranRoad = new PedestrianRoadBehavior(this);
	}
	
	public String getFullRoadState() {
		original();

		this.fullRoadState += "P";
		this.fullRoadState += this.pedestranRoad.getTrafficLightColor().
				toString().substring(0,1).toLowerCase();
		this.fullRoadState += this.pedestranRoad.getNumberOfQueuedObjects();
		
		return this.fullRoadState;
	}
}