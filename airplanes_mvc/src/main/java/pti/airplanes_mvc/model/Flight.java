package pti.airplanes_mvc.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "flights")
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
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

	@Override
	public String toString() {
		return "Flight [id=" + id + ", departureCity=" + departureCity + ", departureTime=" + departureTime
				+ ", arrivalCity=" + arrivalCity + ", arrivalTime=" + arrivalTime + ", flightId=" + flightId
				+ ", captainName=" + captainName + "]";
	}
	
}
