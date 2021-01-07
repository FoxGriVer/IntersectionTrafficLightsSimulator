package trafficlight;

/**
 * TODO description
 */
public class Strategy {
	
	public void enqueuePedestrian(Road roadDirection) {
		RoadBehavior road = this.getRoad(roadDirection, roads);
		
		if(road != null) {
			road.getPedestrianRoad().increaseNumberInQueueByOne();
			road.getPedestrianRoad().getNumberOfQueuedObjects();
		}
	}
	
	public void advanceTime() {		
		this.decreaseNumberInQueueByOneForPedestrians();
		
		original();
	}
	
	private void decreaseNumberInQueueByOneForPedestrians() {
		for (RoadBehavior road: this.roads) {
			TrafficLightColor pedestrianTrafficLightColor = road.getPedestrianRoad().getTrafficLightColor();
			
			if (this.greenPhaseStep <= this.trafficLightPeriod) {
				if (pedestrianTrafficLightColor == TrafficLightColor.GREEN) {
					road.getPedestrianRoad().decreaseNumberInQueueByOne();
				}
			}
		}	
	}
	
	private void changeRoadDirectionTrafficLight(RoadBehavior road) {	
		original(road);
		
		changeIntersectionsTrafficLightForPedestrian(road);
	}
	
	private void changeIntersectionsTrafficLightForPedestrian(RoadBehavior road) {
	    if (road.getTrafficLightColor() == TrafficLightColor.RED) {
	    	this.changePedestrianTrafficLightFromRedToGreen(road);
			return;
	    }
	    if (road.getTrafficLightColor() == TrafficLightColor.GREEN) {
	    	this.changePedestrianTrafficLightFromGreenToRed(road);
			return;
	    } else {
	    	this.changePedestrianTrafficLightFromGreenToRed(road);
	    	return;
	    }
	}
	
	private void changePedestrianTrafficLightFromGreenToRed(RoadBehavior road) {
		road.getPedestrianRoad().setTrafficLightColor(TrafficLightColor.RED);
	}
	
	private void changePedestrianTrafficLightFromRedToGreen(RoadBehavior road) {
		road.getPedestrianRoad().setTrafficLightColor(TrafficLightColor.GREEN);
	}
	
}