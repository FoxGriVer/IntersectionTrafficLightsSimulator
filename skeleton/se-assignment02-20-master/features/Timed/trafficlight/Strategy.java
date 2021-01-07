package trafficlight;

/**
 * TODO description
 */
public class Strategy {
	
	private boolean changingPhase = false;
	
	public void advanceTime() {		
		
	    if (this.greenPhaseStep == this.trafficLightPeriod) {
	    	if (TrafficLightColor.contains("ORANGE")) {
		    	this.changingPhase = true;
	    	} else {
		    	this.changingPhase = false;
	    	}
	    	
	    	this.changeIntersectionsTrafficLight();
			this.greenPhaseStep = 0;
	    }
	    
		original();
	    
	    if (this.changingPhase == false) {	  
	    	this.decreaseNumberInQueueByOneForAutos();
	    	
	    	++this.greenPhaseStep;
	    }	    
	}	
	
	private void changeIntersectionsTrafficLight() {
		for (RoadBehavior road: this.roads) {
			this.changeRoadDirectionTrafficLight(road);	
		}
	}
}