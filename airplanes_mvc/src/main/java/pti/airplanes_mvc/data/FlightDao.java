package pti.airplanes_mvc.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import pti.airplanes_mvc.model.Flight;
import pti.airplanes_mvc.model.FlightTimeOfCaptain;

@Repository
public class FlightDao {
	
	private final SessionFactory factory;
	
	public FlightDao() {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		
		this.factory = cfg.buildSessionFactory();
	}
	
	public List<Flight> getAllFlights() {
		
		Session session = factory.openSession();
		
		Query<Flight> query = session.createQuery("FROM Flight f ORDER BY f.departureTime ASC", Flight.class);
		List<Flight> allFlight = query.getResultList();
		
		session.close();
		
		return allFlight;
	}
	
	public List<Flight> getFlightsByDepartureCity(String departureCity) {
		
		Session session = factory.openSession();
		
		Query<Flight> query = session.createQuery("FROM Flight f WHERE f.departureCity = ?1", Flight.class);
		query.setParameter(1, departureCity);
		List<Flight> result = query.getResultList();
		
		session.close();
		
		return result;
	}
	
	public List<FlightTimeOfCaptain> getTotalFlightTimesOfCaptains() {
		
		List<FlightTimeOfCaptain> flightTimes = new ArrayList<>();
		
		Session session = factory.openSession();
		
		Query<Object[]> q = session.createNativeQuery("SELECT captain, "
										  + "SUM(TIMESTAMPDIFF(MINUTE, departure_time, arrival_time)) AS flight_time "
										  + "FROM flights "
										  + "GROUP BY captain", Object[].class);
		List<Object[]> resultList = q.getResultList();
		
		for(Object[] result : resultList) {
			
			String captainName = result[0].toString();
			int flightTime = Integer.parseInt(result[1].toString());
			
			flightTimes.add(
						new FlightTimeOfCaptain(
									captainName,
									flightTime
								)
					);
		}
		
		session.close();
		
		return flightTimes;
	}
	
}
