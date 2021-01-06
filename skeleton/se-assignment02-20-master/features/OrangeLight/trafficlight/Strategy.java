package trafficlight;

/**
 * TODO description
 */
public class Strategy {
	private int orangeSteps = 0;
	private int orangePeriodSteps = 2;
	
	public void advanceTime() {		
		original();
		
		if(this.changingPhase) {
			++this.orangeSteps;
			
			if(this.orangeSteps <= (this.orangePeriodSteps * 2) + 1) {	
				this.changeIntersectionsTrafficLight();
				
				if (this.orangeSteps == (this.orangePeriodSteps * 2) + 1) {
					this.orangeSteps = 0;
					this.changingPhase = false;
					
					return;
				}
			}
			
		}		
	}
	
	private void changeRoadDirectionTrafficLight(RoadBehavior road) {
		if(!this.changingPhase) {
			original(road);
		}
		
		if (this.orangeSteps == 0) {
			if (road.getTrafficLightColor() == TrafficLightColor.GREEN) {
				road.rememberCurrentTrafficLightColor();
				this.changeRoadDirectionTrafficLightAccordingOrange(road);
			}
		} 
		if (this.orangeSteps == this.orangePeriodSteps + 1) {
			if (road.getTrafficLightColor() == TrafficLightColor.RED 
					|| road.getTrafficLightColor() == TrafficLightColor.ORANGE) {
				this.changeRoadDirectionTrafficLightAccordingOrange(road);
			}
		} 
		if (this.orangeSteps == (this.orangePeriodSteps * 2) + 1) {
			if (road.getTrafficLightColor() == TrafficLightColor.ORANGE) {
				this.changeRoadDirectionTrafficLightAccordingOrange(road);
			}	
			road.rememberCurrentTrafficLightColor();
		}				
	}
	
	private void changeRoadDirectionTrafficLightAccordingOrange(RoadBehavior road) {	
		if (road.getTrafficLightColor() == TrafficLightColor.GREEN) {
			this.changeTrafficLightFromGreenToOrange(road);
			return;
		}
		if (road.getTrafficLightColor() == TrafficLightColor.RED) {
			this.changeTrafficLightFromRedToOrange(road);
			return;
		}
		if (road.getTrafficLightColor() == TrafficLightColor.ORANGE) {
			if(road.getPreviousTrafficLightColor() == TrafficLightColor.GREEN) {
				this.changeTrafficLightFromOrangeToRed(road);
				return;
			}
			if(road.getPreviousTrafficLightColor() == TrafficLightColor.RED) {
				this.changeTrafficLightFromOrangeToGreen(road);
				return;
			}
		}
		
	}
	
	private void changeTrafficLightFromGreenToOrange(RoadBehavior road) {
		if (road.getTrafficLightColor() == TrafficLightColor.GREEN) {
			road.setTrafficLightColor(TrafficLightColor.ORANGE);
		}
	}
	
	private void changeTrafficLightFromRedToOrange(RoadBehavior road) {
		if (road.getTrafficLightColor() == TrafficLightColor.RED) {
			road.setTrafficLightColor(TrafficLightColor.ORANGE);
		}
	}
	
	private void changeTrafficLightFromOrangeToGreen(RoadBehavior road) {
		if (road.getTrafficLightColor() == TrafficLightColor.ORANGE) {
			road.setTrafficLightColor(TrafficLightColor.GREEN);
		}
	}
	
	private void changeTrafficLightFromOrangeToRed(RoadBehavior road) {
		if (road.getTrafficLightColor() == TrafficLightColor.ORANGE) {
			road.setTrafficLightColor(TrafficLightColor.RED);
		}
	}
}