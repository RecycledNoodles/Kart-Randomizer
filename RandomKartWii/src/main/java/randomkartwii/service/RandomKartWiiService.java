package randomkartwii.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import randomkartwii.dao.CallAccessLogDAO;
import randomkartwii.dao.RacerDAO;
import randomkartwii.dao.TrackDAO;
import randomkartwii.dao.VehicleDAO;
import randomkartwii.data.Racer;
import randomkartwii.data.Size;
import randomkartwii.data.Track;
import randomkartwii.data.Vehicle;
import randomkartwii.util.Sack;

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
			vehicles = dao.getAllVehicles();
		}
		result.put("vehicles",vehicles);
		return result;
	}
	
	@GET
	@Path("/randomize")
	@Produces("application/json")
	public Map<String,Object> generateChoices(
			@DefaultValue("4") @QueryParam("players") int players,
			@DefaultValue("2") @QueryParam("tracks") int tracks,
			@DefaultValue(",") @QueryParam("lasttrack") String trackIDList) {
		
		CallAccessLogDAO callAccessLogDAO = new CallAccessLogDAO();
		callAccessLogDAO.addEntry("randomize");
		callAccessLogDAO = null;
		
		String[] ids = new String[0];
		if (trackIDList.length() > 0) {
			ids = trackIDList.split(",");
		}
		
		int[] idArray = new int[ids.length];
		for (int i=0; i<ids.length; i++) {
			idArray[i] = Integer.parseInt(ids[i]);
		}
		System.out.println(Arrays.toString(idArray));
		System.out.println("array length: "+idArray.length);
		
		Map<String,Object> result = new HashMap<String,Object>();
		
		RacerDAO racerDAO = RacerDAO.getInstance();
		VehicleDAO vehicleDAO = VehicleDAO.getInstance();
		TrackDAO trackDAO = TrackDAO.getInstance();
		
		Sack<Racer> racerSack = new Sack<Racer>(racerDAO.getAllRacers());
		
		List<Map<String,Object>> playerChoices = new LinkedList<Map<String,Object>>();
		
		for (int i=1; i<= players; i++) {
			Map<String,Object> choice = new HashMap<String,Object>();
			
			Racer racer = racerSack.pick();
			choice.put("racer", racer);
			
			Sack<Vehicle> vehicleSack = new Sack<Vehicle>(vehicleDAO.getVehiclesBySize(racer.getWeight()));
			
			choice.put("vehicle", vehicleSack.pick());
			
			playerChoices.add(choice);
		}
		
		result.put("players", playerChoices);
		
		Sack<Track> trackSack;
		
		if (idArray.length > 0) {
			System.out.println("exclusion");
			trackSack = new Sack<Track>(trackDAO.getTracksExcludingIDS(idArray));
		}

		else
			trackSack = new Sack<Track>(trackDAO.getAllTracks());
		
		List<Track> trackList = new LinkedList<Track>();
		
		for (int i=0; i<tracks-idArray.length; i++) {
			trackList.add(trackSack.pick());
		}
		if (idArray.length > 0) {
			Track[] lastTracks = trackDAO.getTracksByIDS(idArray);
			
			for (int i=0; i<lastTracks.length; i++) {
				trackList.add(lastTracks[i]);
			}			
		}

		
		result.put("tracks", trackList);
		
		return result;
	}
	
	
	@GET
	@Path("/callaccesslog/{date}")
	@Produces("application/json")
	public Map<String,Object> getCallAccessEntries(
			@DefaultValue("today") @PathParam("date") String date) {
		Map<String,Object> result = new HashMap<String,Object>();
		
		CallAccessLogDAO dao = new CallAccessLogDAO();
		
		if (date.equals("all")) {
			result.put("entries", dao.getEntries());
		} else if (date.equals("today")) {
			result.put("entries", dao.getEntriesToday());
		} else {
			result.put("entries", dao.getEntriesByDate(date));
		}
		return result;
	}
}
