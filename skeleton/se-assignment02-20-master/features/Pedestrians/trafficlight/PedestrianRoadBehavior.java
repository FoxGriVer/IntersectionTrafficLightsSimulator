package trafficlight;

/**
 * TODO description
 */
public class PedestrianRoadBehavior extends RoadDirection {
	
	private RoadBehavior road;
	
//	@Override
//	public int getNumberOfQueuedObjects() {
//		System.out.printf("The number of pedestrians is in the queue on the %s road: %s\n", 
//				this.roadDirection,
//				this.numberOfQueuedObjects);
//
//		return this.numberOfQueuedObjects;
//	}
	
	@Override
	public void increaseNumberInQueueByOne() {
//		System.out.printf("A pedestrian gots in the queue on the road: %s \n", this.roadDirection);

		++this.numberOfQueuedObjects;
	}
	
	@Override
	public void decreaseNumberInQueueByOne() {
		if (this.numberOfQueuedObjects >= 1) {
//			System.out.printf("A pedestrian is unqueue on the road: %s \n", this.roadDirection);

			--this.numberOfQueuedObjects;
		} else {
//			System.out.printf("The pedestrian queue on the %s road is empty\n", this.roadDirection);
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