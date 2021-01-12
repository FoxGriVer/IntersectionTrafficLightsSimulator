package trafficlight;

/**
 * TODO description
 */
public class Strategy {	
	
	public void advanceTime() {		
	    if (this.greenPhaseStep == this.trafficLightPeriod) {
	    	this.turnOnChangingPhase();
	    	
	    	this.changeIntersectionsTrafficLight();
			this.greenPhaseStep = 0;
	    }
	    
		original();
	    
	    if (this.changingPhase == false) {	 
	    	if(this.greenPhaseStep <= this.trafficLightPeriod) {
		    	this.decreaseNumberInQueueByOneForAutos();
	    	}
	    	
	    	++this.greenPhaseStep;
	    }	    
	}	
}