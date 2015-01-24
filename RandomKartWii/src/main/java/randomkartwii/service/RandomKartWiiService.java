package randomkartwii.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import randomkartwii.dao.RacerDAO;
import randomkartwii.dao.TrackDAO;
import randomkartwii.dao.VehicleDAO;
import randomkartwii.data.Racer;
import randomkartwii.data.Size;
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
	public Map<String,Object> getVehicles(@DefaultValue("") @QueryParam("size") String size) {
		Map<String,Object> result = new HashMap<String,Object>();
		
		VehicleDAO dao = VehicleDAO.getInstance();
		Vehicle[] vehicles = null;
		
		try {
			vehicles = dao.getVehiclesBySize(Size.valueOf(size.toUpperCase()));
		} catch (IllegalArgumentException e) {
			System.out.println("failure");
			vehicles = dao.getAllVehicles();
		}
		result.put("vehicles",vehicles);
		return result;
	}
	
	@GET
	@Path("/randomize")
	@Produces("application/json")
	public Map<String,Object> generateChoices(@DefaultValue("4") @QueryParam("players") int players) {
		return null;
	}
	
}
