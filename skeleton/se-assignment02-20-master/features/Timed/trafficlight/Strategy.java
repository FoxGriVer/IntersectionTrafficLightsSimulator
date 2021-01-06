package trafficlight;

/**
 * TODO description
 */
public class Strategy {
	
	private boolean changingPhase = false;
	
	public void advanceTime() {		
		
	    if (this.globalStep == this.trafficLightPeriod) {
	    	if (TrafficLightColor.contains("ORANGE")) {
		    	this.changingPhase = true;
	    	} else {
		    	this.changingPhase = false;
	    	}
	    	
	    	this.changeIntersectionsTrafficLight();
			this.globalStep = 0;
	    }
	    
		original();
	    
	    if (this.changingPhase == false) {	  
	    	this.decreaseNumberInQueueByOneForAutos();
	    	
	    	++this.globalStep;
	    }	    
	}
	
	private void decreaseNumberInQueueByOneForAutos() {
		for (RoadBehavior road: this.roads) {
			TrafficLightColor trafficLightColor = road.getTrafficLightColor();
			
			if (this.globalStep <= this.trafficLightPeriod) {
				if (trafficLightColor == TrafficLightColor.GREEN) {
					road.decreaseNumberInQueueByOne();
				}
			}			
		}	
	}
	
	private void changeIntersectionsTrafficLight() {
		for (RoadBehavior road: this.roads) {
			this.changeRoadDirectionTrafficLight(road);	
		}
	}
}