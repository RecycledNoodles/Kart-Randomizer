package randomkartwii.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import randomkartwii.dao.RacerDAO;
import randomkartwii.data.Racer;

@Path("/randomizer")
public class RandomKartWiiService {
	
	public String randomize() {
		return null;
	}
	
	@GET
	@Path("/racers")
	@Produces("application/json")
	public Racer[] getRacers() {
		RacerDAO dao = RacerDAO.getInstance();
		Racer[] racers = dao.getRacers();
		return racers;
	}
	
}
