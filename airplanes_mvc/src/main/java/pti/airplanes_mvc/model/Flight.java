package pti.airplanes_mvc.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "flights")
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "departure_city")
	private String departureCity;
	
	@Column(name = "departure_time")
	private LocalDateTime departureTime;
	
	@Column(name = "arrival_city")
	private String arrivalCity;
	
	@Column(name = "arrival_time")
	private LocalDateTime arrivalTime;
	
	@Column(name = "flight_id")
	private String flightId;
	
	@Column(name = "captain")
	private String captainName;
	
	@Transient
	private Long flightTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getCaptainName() {
		return captainName;
	}

	public void setCaptainName(String captainName) {
		this.captainName = captainName;
	}
	
	public void calcFlightTime() {
		
		this.flightTime = this.departureTime.until(this.arrivalTime, ChronoUnit.MINUTES);
	}

	public Long getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(Long flightTime) {
		this.flightTime = flightTime;
	}

	@Override
	public int hashCode() {
		
		int hashCode = id.hashCode() +
					   departureCity.hashCode() +
					   departureTime.hashCode() +
					   arrivalCity.hashCode() +
					   arrivalTime.hashCode() +
					   flightId.hashCode() +
					   captainName.hashCode();
		return hashCode;
	}

	public boolean equals(Object otherObject) {
		
		boolean isEqual = false;
		
		if(otherObject instanceof Flight) {
			
			Flight other = (Flight)otherObject;
			
			if(this.id == other.getId() &&
				this.departureCity.equals(other.getDepartureCity()) &&
				this.departureTime.equals(other.getDepartureTime()) &&
				this.arrivalCity.equals(other.getArrivalCity()) &&
				this.arrivalTime.equals(other.getArrivalTime()) &&
				this.flightId.equals(other.getFlightId()) &&
				this.captainName.equals(other.getCaptainName())) {
						
				isEqual = true;
			}
		}
		
		return isEqual;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", departureCity=" + departureCity + ", departureTime=" + departureTime
				+ ", arrivalCity=" + arrivalCity + ", arrivalTime=" + arrivalTime + ", flightId=" + flightId
				+ ", captainName=" + captainName + ", flightTime=" + flightTime + "]";
	}
	
}
