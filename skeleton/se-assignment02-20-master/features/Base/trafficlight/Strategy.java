package trafficlight;

import java.util.ArrayList;

/**
 * TODO description
 */
public class Strategy {
	private int greenPhaseStep;
	private ArrayList<RoadBehavior> roads;
	private int trafficLightPeriod;
	private boolean changingPhase;
	private boolean possibleToSwitchTrafficLights;

	public Strategy() {
		this.roads = new ArrayList<RoadBehavior>();
		this.greenPhaseStep = 1;
		this.trafficLightPeriod = 10;
		this.changingPhase = false;
		this.possibleToSwitchTrafficLights = false;
		
		Road[] roads = Road.values();
		for (Road road: roads) {
			if (road != Road.NONE) {
				this.roads.add(new RoadBehavior(road));
			}
		}		
	}
	
	public ArrayList<RoadBehavior> getRoads() {
		return this.roads;
	}
	
	public void enqueueVehicle(Road roadDirection) {
		RoadBehavior road = this.getRoad(roadDirection, roads);
		
		if(road != null) {
			road.increaseNumberInQueueByOne();
		}
	}
	
	public void advanceTime() {

	}
	
	private void decreaseNumberInQueueByOneForAutos() {
		for (RoadBehavior road: this.roads) {
			TrafficLightColor trafficLightColor = road.getTrafficLightColor();
			
			if (trafficLightColor == TrafficLightColor.GREEN) {
				road.decreaseNumberInQueueByOne();
			}
		}	
	}
	
	public String getIntersectionState() {
		String fullIntersectionState = "";
		
		ArrayList<RoadBehavior> sortedArrayOfRoads = this.sortArrayForIntersectionState(this.roads);
		
		for (RoadBehavior road: sortedArrayOfRoads) {
			fullIntersectionState += road.getFullRoadState() + " ";
		}
				
		return fullIntersectionState.trim();
	}
	
	private RoadBehavior getRoad(Road roadDirection, ArrayList<RoadBehavior> roads) {		
		for (RoadBehavior road: roads) {
			if(road.getRoadDirection() == roadDirection) {
				return road;				
			}
		}
		
		return null;
	}

	private ArrayList<RoadBehavior> sortArrayForIntersectionState(ArrayList<RoadBehavior> roads) {
		String sortingOrder = "LEFT RIGHT BOTTOM TOP";
		ArrayList<RoadBehavior> sortedArrayOfRoads = new ArrayList<RoadBehavior>();
		
		String[] sortedDirections = sortingOrder.split("\\s");
		for (String direction: sortedDirections) {
			if (Road.contains(direction)) {
				RoadBehavior foundedRoad = this.getRoad(Road.valueOf(direction), roads);
				sortedArrayOfRoads.add(foundedRoad);
			}
		}
		
		return sortedArrayOfRoads;
	}
	
	private void changeIntersectionsTrafficLight() {
		for (RoadBehavior road: this.roads) {
			this.changeRoadDirectionTrafficLight(road);	
		}
	}
	
	private void changeRoadDirectionTrafficLight(RoadBehavior road) {	
		road.rememberCurrentTrafficLightColor();
		this.changeIntersectionsTrafficLightForAuto(road);
	}
	
	private void changeIntersectionsTrafficLightForAuto(RoadBehavior road) {
		if (road.getTrafficLightColor() == TrafficLightColor.GREEN) {
			this.changeTrafficLightFromGreenToRed(road);
			return;
		}
		if (road.getTrafficLightColor() == TrafficLightColor.RED) {
			this.changeTrafficLightFromRedToGreen(road);
			return;
		}
	}
	
	private void changeTrafficLightFromGreenToRed(RoadBehavior road) {
		if (road.getTrafficLightColor() == TrafficLightColor.GREEN) {
			road.setTrafficLightColor(TrafficLightColor.RED);
		}
	}
	
	private void changeTrafficLightFromRedToGreen(RoadBehavior road) {
		if (road.getTrafficLightColor() == TrafficLightColor.RED) {
			road.setTrafficLightColor(TrafficLightColor.GREEN);
		}
	}
	
	/**
	 * Turn on the changing phase.
	 * This feature enable when there is "orange" color light presented,
	 * because in the oposite way it changes immediately 
	 */
	private void turnOnChangingPhase() {
		if (TrafficLightColor.contains("ORANGE")) {
	    	this.changingPhase = true;
    	} 
	}
}