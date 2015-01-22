package kart_randomizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import kart_randomizer.model.Racer;
import kart_randomizer.model.Vehicle;
import kart_randomizer.util.Sack;

public class KartRandomizer {
	
	private Sack<Racer> racerSack;

	private Sack<String> trackSack;
	private Sack<String> trackWithLCSack;
	
	public KartRandomizer() {
		racerSack = new Sack<Racer>(Arrays.asList(Resources.racers));
		trackSack = new Sack<String>(Arrays.asList(Resources.tracks));
		List<String> tracks = new ArrayList<String>(Arrays.asList(Resources.tracks));
		tracks.add("Luigi Circuit");
		trackWithLCSack = new Sack<String>(tracks);
		
		
	}
	
	public Map<String,Object>[] pickPlayerSelections(int players) {
		Random random = new Random();
		@SuppressWarnings("unchecked")
		Map<String,Object>[] results = new Map[players];
		for (int i=0; i<players; i++) {
			Map<String,Object> selection = new HashMap<String,Object>();
			selection.put("racer",racerSack.pick());
			
			// filter out vehicles
			List<Vehicle> filteredVehicles = new LinkedList<Vehicle>();
			for (Vehicle vehicle : Resources.vehicles) {
				if (vehicle.getWeight() == ((Racer)(selection.get("racer"))).getWeight())
					filteredVehicles.add(vehicle);
			}
			
			selection.put("vehicle", filteredVehicles.get(random.nextInt(filteredVehicles.size())));
			
			
			
			results[i] = selection;
		}
		return results;
	}
	
	
	public String[] pickTracks(boolean includeLuigisCircuit, int numTracks) {
		String[] tracks = new String[numTracks];
		
		int randomTracks;
		Sack<String> sack;
		if (includeLuigisCircuit) {
			randomTracks = numTracks -1;
			sack = trackSack;
		} else {
			randomTracks = numTracks;
			sack = trackWithLCSack;
		}
		
		for (int i=0; i<randomTracks; i++) {
			tracks[i] = sack.pick();
		}
		
		if (includeLuigisCircuit)
			tracks[numTracks-1] = "Luigi Circuit";
		
		return tracks;
	}


	public void shuffleTracks() {
		// TODO Auto-generated method stub
		trackSack.shuffle();
	}
	
	

}
