package trafficlight;

/**
 * TODO description
 */
public class Strategy {
	
	private boolean possibleToSwitch = false;
	
	public void advanceTime() {
		original();
		
		this.decreaseNumberInQueueByOneForAutos();
	}
}