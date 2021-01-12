package trafficlight;

/**
 * TODO description
 */
public class Strategy {
	private boolean pedestrianStandInQueue = false;
	
	public void enqueuePedestrian(Road roadDirection) {
		RoadBehavior road = this.getRoad(roadDirection, roads);
		
		if(road != null) {
			road.getPedestrianRoad().increaseNumberInQueueByOne();
		}
	}
	
	public void advanceTime() {		
		this.decreaseNumberInQueueByOneForPedestrians();
		
		original();
	}
	
	private void decreaseNumberInQueueByOneForPedestrians() {
		if(StrategyType.getStrategyType().name() == "Timed") {
			this.decreaseNumberInQueueByOneForPedestriansTimedStrategy();
			return;
		}
		if(StrategyType.getStrategyType().name() == "OnDemand") {
			this.checkPedestriansOnTheGreenRoadDirections();
			
			if(this.possibleToSwitchTrafficLights && this.pedestrianStandInQueue) {
				this.turnOnChangingPhase();
				
		    	this.changeIntersectionsTrafficLight();
			}
			
			this.decreaseNumberInQueueByOneForPedestriansOnDemandStrategy();
			return;
		}
	}
	
	private void decreaseNumberInQueueByOneForPedestriansTimedStrategy() {
		for (RoadBehavior road: this.roads) {
			TrafficLightColor pedestrianTrafficLightColor = road.getPedestrianRoad().getTrafficLightColor();
			
			if (this.greenPhaseStep <= this.trafficLightPeriod) {
				if (pedestrianTrafficLightColor == TrafficLightColor.GREEN) {
					road.getPedestrianRoad().decreaseNumberInQueueByOne();
				}
			}
		}	
	}
	
	private void decreaseNumberInQueueByOneForPedestriansOnDemandStrategy() {
		for (RoadBehavior road: this.roads) {
			TrafficLightColor pedestrianTrafficLightColor = road.getPedestrianRoad().getTrafficLightColor();
			
			if (pedestrianTrafficLightColor == TrafficLightColor.GREEN) {
				road.getPedestrianRoad().decreaseNumberInQueueByOne();
			}
		}	
	}
	
	private void checkPedestriansOnTheGreenRoadDirections() {
		for (RoadBehavior road: this.roads) {
			TrafficLightColor pedestrianTrafficLightColor = road.getPedestrianRoad().getTrafficLightColor();
			
			if (pedestrianTrafficLightColor == TrafficLightColor.RED) {
				int currentNumberOfQueuedPedestrians = road.getPedestrianRoad().getNumberOfQueuedObjects();
				
				if (currentNumberOfQueuedPedestrians >= 1) {
					System.out.println("There is an pedestrian in the queue on a grean road direction");
					
					this.pedestrianStandInQueue = true;
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