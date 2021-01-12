package trafficlight;

/**
 * TODO description
 */
public class Strategy {
	
	private boolean autoStandInQueue = false;
	
	public void advanceTime() {
		this.checkAutosOnTheRedRoadDirections();
		
	    if (this.possibleToSwitchTrafficLights && this.autoStandInQueue) {
	    	this.turnOnChangingPhase();	    	
	    	this.changeIntersectionsTrafficLight();
	    	
			this.greenPhaseStep = 1;
			this.autoStandInQueue = false;
			this.possibleToSwitchTrafficLights = false;
	    }
	    
		original();
		
	    if(this.greenPhaseStep == this.trafficLightPeriod) {
	    	this.possibleToSwitchTrafficLights = true;
	    }
	    if (this.changingPhase == false) {	  
	    	this.decreaseNumberInQueueByOneForAutos();
	    	
	    	++this.greenPhaseStep;
	    }
	}
	
	private void checkAutosOnTheRedRoadDirections() {
		for (RoadBehavior road: this.roads) {
			if(road.getTrafficLightColor() == TrafficLightColor.RED) {
				int currentNumberOfQueuedAutos = road.getNumberOfQueuedObjects();
				
				if (currentNumberOfQueuedAutos >= 1) {					
					this.autoStandInQueue = true;
				}
			}
		}
	}
}