package pti.airplanes_mvc.model;

public class FlightTimeOfCaptain {
	
	private String captainName;
	private int flightTime;
	
	public FlightTimeOfCaptain(String captainName, int flightTime) {
		super();
		this.captainName = captainName;
		this.flightTime = flightTime;
	}

	public String getCaptainName() {
		return captainName;
	}

	public void setCaptainName(String captainName) {
		this.captainName = captainName;
	}

	public int getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(int flightTime) {
		this.flightTime = flightTime;
	}

	@Override
	public String toString() {
		return "FlightTimeOfCaptain [captainName=" + captainName + ", flightTime=" + flightTime + "]";
	}

}
