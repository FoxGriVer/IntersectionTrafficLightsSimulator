package trafficlight;

/**
 * TODO description
 */
public class RoadBehavior extends RoadDirection {
		
	public RoadBehavior(Road roadDirectionName) {
		super();
		
		this.roadDirection = roadDirectionName;
		
		if(this.roadDirection == Road.LEFT ||
				this.roadDirection == Road.RIGHT) {
			this.trafficLightColor = TrafficLightColor.GREEN;			
		} else {
			this.trafficLightColor = TrafficLightColor.RED;
		}
		
		this.previousTrafficLightColor = this.trafficLightColor;
	}
	
	public String getFullRoadState() {	
		this.fullRoadState = "";
		this.fullRoadState += this.roadDirection.toString().substring(0,1);
		this.fullRoadState += "V";
		this.fullRoadState += this.getTrafficLightColor().toString()
				.substring(0,1).toLowerCase();
		this.fullRoadState += this.getNumberOfQueuedObjects();

		return this.fullRoadState;
	}
}