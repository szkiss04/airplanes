package pti.airplanes_mvc.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import pti.airplanes_mvc.model.Flight;

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
		
		Query query = session.createQuery("FROM Flight f ORDER BY f.departureTime ASC", Flight.class);
		List<Flight> allFlight = query.getResultList();
		
		session.close();
		
		return allFlight;
	}

}
