package trafficlight;

/**
 * TODO description
 */
public class PedestrianRoadBehavior extends RoadDirection {
	
	private RoadBehavior road;
	
	@Override
	public void increaseNumberInQueueByOne() {
		++this.numberOfQueuedObjects;
	}
	
	@Override
	public void decreaseNumberInQueueByOne() {
		if (this.numberOfQueuedObjects >= 1) {
			--this.numberOfQueuedObjects;
		}
	}

	public PedestrianRoadBehavior(RoadBehavior road) {
		super();
		
		this.road = road;
		this.roadDirection = road.roadDirection;
		
		if(this.road.roadDirection == Road.LEFT ||
				this.road.roadDirection == Road.RIGHT) {
			this.trafficLightColor = TrafficLightColor.RED;
		} else {
			this.trafficLightColor = TrafficLightColor.GREEN;
		}
	}
}