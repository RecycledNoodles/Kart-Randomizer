package randomkartwii.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import randomkartwii.dao.RacerDAO;
import randomkartwii.dao.TrackDAO;
import randomkartwii.dao.VehicleDAO;
import randomkartwii.data.Racer;
import randomkartwii.data.Track;
import randomkartwii.data.Vehicle;

@Path("/")
public class RandomKartWiiService {
	
	public String randomize() {
		return null;
	}
	
	@GET
	@Path("/racers")
	@Produces("application/json")
	public Map<String,Object> getRacers() {
		Map<String,Object> result = new HashMap<String,Object>();
		
		RacerDAO dao = RacerDAO.getInstance();
		Racer[] racers = dao.getAllRacers();
		
		result.put("racers",racers);
		return result;
	}
	
	@GET
	@Path("/tracks")
	@Produces("application/json")
	public Map<String,Object> getTracks() {
		Map<String,Object> result = new HashMap<String,Object>();
		
		TrackDAO dao = TrackDAO.getInstance();
		Track[] tracks = dao.getAllTracks(); 
		result.put("tracks",tracks);
		return result;
	}
	
	@GET
	@Path("/vehicles")
	@Produces("application/json")
	public Map<String,Object> getVehicles() {
		Map<String,Object> result = new HashMap<String,Object>();
		
		VehicleDAO dao = VehicleDAO.getInstance();
		Vehicle[] vehicles = dao.getAllVehicles(); 
		result.put("vehicles",vehicles);
		return result;
	}
	
}
